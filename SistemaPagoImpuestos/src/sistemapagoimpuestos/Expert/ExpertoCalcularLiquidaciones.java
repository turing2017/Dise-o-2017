package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.CalculoComision;
import sistemapagoimpuestos.Entity.CalculoComisionEstado;
import sistemapagoimpuestos.Entity.Comision;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.EstadoCalculoComision;
import sistemapagoimpuestos.Entity.EstadoLiquidacion;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.LiquidacionEstado;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Estrategias.EstrategiaCalculoComision;
import sistemapagoimpuestos.Fabricas.FabricaEstrategias;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Gabriel
 */
public class ExpertoCalcularLiquidaciones {
    Date fechaActual = new Date();
    String nombreEstadoAnuladaComision = "Anulada";
    String nombreEstadoCalculadaComision = "Calculada";
    String nombreEstadoRecalculadaComision ="Recalculada";
    
    String nombreEstadoRecalculada = "Pendiente";
    String nombreEstadoAnulado = "Anulada";
    String nombreEstadoPendiente = "Pendiente";
    List<DTOCriterio> criterios = new ArrayList();
    Date fechaALiquidar;
    int cantidadLiquidacionesRecalculadas = 0;
    int cantidadLiquidacionesCalculadas = 0;

    public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }

    public ArrayList<DTOAccionesSistema> iniciar(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {

        dtosAccionesSistema.add(new DTOAccionesSistema(0, "INICIO DEL PROCESO PARA EL CÁLCULO DE LIQUIDACIONES", "", new Date()));

        if (FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", null).isEmpty()) {

            dtosAccionesSistema.add(new DTOAccionesSistema(1, "ERROR: Estados de liquidación no existentes", "Verifique que tenga cargados en la base de datos los estados de liquidación: Pendiente, Aprobada, Anulada.", new Date()));

        } else if (FachadaPersistencia.getInstance().buscar("EstadoCalculoComision", null).isEmpty()) {

            dtosAccionesSistema.add(new DTOAccionesSistema(1, "ERROR: Estados de cálculo de comisión no existentes", "Verifique que tenga cargados en la base de datos los estados de cálculo de comisión: Calculada, Recalculada, Aprobada, Anulada.", new Date()));

        } else if (FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null).isEmpty()) {

            dtosAccionesSistema.add(new DTOAccionesSistema(1, "Empresa Tipo Impuesto no existentes", "No se sigue con la ejecución del proceso de cálculo de liquidaciones porque no existen Empresas Tipo Impuestos definidas.", new Date()));

        } else {

            dtosAccionesSistema.add(new DTOAccionesSistema(1, "INICIO RECÁLCULO DE LIQUIDACIONES ANULADAS", "", new Date()));

            cantidadLiquidacionesRecalculadas = recalcularLiquidacionesAnuladas(dtosAccionesSistema);

            if (cantidadLiquidacionesRecalculadas == 0) {
                dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN RECÁLCULO DE LIQUIDACIONES ANULADAS", "No existen liquidaciones a recalcular.", new Date()));
            } else {
                dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN RECÁLCULO DE LIQUIDACIONES ANULADAS", "Se generaron un total de " + cantidadLiquidacionesRecalculadas + " liquidaciones recalculadas en estado Pendiente.", new Date()));
            }

            dtosAccionesSistema.add(new DTOAccionesSistema(1, "INICIO CÁLCULO DE LIQUIDACIONES A GENERAR", "", new Date()));

            cantidadLiquidacionesCalculadas = calcularLiquidacionesActuales(dtosAccionesSistema);

            if (cantidadLiquidacionesCalculadas == 0) {
                dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN CÁLCULO DE LIQUIDACIONES A GENERAR", "No se generaron nuevas liquidaciones en estado Pendiente.", new Date()));
            } else {
                dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN CÁLCULO DE LIQUIDACIONES A GENERAR", "Se generaron un total de " + cantidadLiquidacionesCalculadas + " liquidaciones en estado Pendiente.", new Date()));
            }

        }

        dtosAccionesSistema.add(new DTOAccionesSistema(0, "FIN DEL PROCESO PARA EL CÁLCULO DE LIQUIDACIONES", "", new Date()));

        return dtosAccionesSistema;
    }

    private int recalcularLiquidacionesAnuladas(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {

        int cantidadAnuladas = 0;

        //buscar "EstadoLiquidacion","nombreEstadoLiquidacion=Anulada"
        criterios.add(new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoAnulado));

        EstadoLiquidacion estadoLiquidacion = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);

        if (estadoLiquidacion == null) {
            dtosAccionesSistema.add(new DTOAccionesSistema(2, "Estado liquidación no existente", "Verifique que este cargado el estado " + nombreEstadoPendiente + " en los estados de liquidación y vuelva a ejecutar el proceso.", new Date()));
            return cantidadAnuladas;
        }
        //buscar "LiquidacionEstado","EstadoLiquidacion="+estadoLiquidacion.toString()
        criterios.clear();
        criterios.add(new DTOCriterio("estadoLiquidacion", "=", estadoLiquidacion));
        List<Object> listLiquidacionEstado = FachadaPersistencia.getInstance().buscar("LiquidacionEstado", criterios);
        // por cada Liquidacion Estado
        for (Object objlistLiquidacion : listLiquidacionEstado) {
            LiquidacionEstado liquidacionEstado = (LiquidacionEstado) objlistLiquidacion;
            Date fechaHasta = liquidacionEstado.getFechaHoraHastaLiquidacionEstado();
            if (fechaHasta == null) {
                
                //Busco la liquidacion que tenga esa LiquidacionEstado
//                criterios.clear();
//                criterios.add(new DTOCriterio("liquidacionEstado", "=", liquidacionARecalcular.getLiquidacionEstadoList().get(0)));
                List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", null);
                List<Liquidacion> liquidacionARecalcular2 = new ArrayList();
                for (Object objLiquidaciones : liquidaciones) {
                    Liquidacion liquidacionlist = (Liquidacion) objLiquidaciones;
                    for (int i = 0; i < liquidacionlist.getLiquidacionEstadoList().size(); i++) {
                        if (liquidacionlist.getLiquidacionEstadoList().get(i).equals(liquidacionEstado)) {
                            liquidacionARecalcular2.add(liquidacionlist);
                            break;
                        }
                    }
                }
                
                for (int n = 0; n < liquidacionARecalcular2.size(); n++) {
                   Liquidacion liquidacionARecalcular = liquidacionARecalcular2.get(n);
                
                Date fechaDesdeLiquidacion = liquidacionARecalcular.getFechaHoraDesdeLiquidacion();
                Date fechaHastaLiquidacion = liquidacionARecalcular.getFechaHoraHastaLiquidacion();
                EmpresaTipoImpuesto empresaTipoImpuesto = liquidacionARecalcular.getEmpresaTipoImpuesto();
                //buscar "Operacion", "fechaHoraOperacion >= fechaHoraDesdeLiquidacion AND fechaOperacion <= fechaHoraHastaLiquidacion AND EmpresaTipoImpuesto="+empresaTipoImpuesto.toString()
                DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", fechaDesdeLiquidacion);
                DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", fechaHastaLiquidacion);
                DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
                criterios.clear();
                criterios.add(criterio3);
                criterios.add(criterio4);
                criterios.add(criterio5);
                List<Object> listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                dtosAccionesSistema.add(new DTOAccionesSistema(3, "INICIANDO RECÁLCULO DE LA LIQUIDACIÓN", "Empresa: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n" + "Tipo Impuesto: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Cantidad de operaciones: " + listOperacion.size(), new Date()));
                
                CalculoComision calculoComision = new CalculoComision();
                calculoComision.setComisionList(new ArrayList());
                calculoComision.setCalculoComisionEstadoList(new ArrayList());
                for (Object op : listOperacion) {
                    Operacion operacion = (Operacion) op;
                    Double valorComision;

                    EstrategiaCalculoComision estrategia = FabricaEstrategias.getInstancia().obtenerEstrategia(operacion);

                    valorComision = estrategia.obtenerValorComision(operacion);

                    if (valorComision == -1.0) {
                        dtosAccionesSistema.add(new DTOAccionesSistema(4, "ERROR: No se pudo recalcular la comisión.", "Porque NO se encuentran cargados los parámetros de cálculo de comisión.", new Date()));
                        return cantidadAnuladas;

                    } else {
                        Comision comision = new Comision();
                        
                        comision.setValorComision(valorComision);
                        operacion.setLiquidadaOperacion(true);
                        FachadaPersistencia.getInstance().guardar(operacion);
                        comision.setOperacion(operacion);
                        
                        calculoComision.getComisionList().add(comision);
                        calculoComision.setValorTotalCalculoComision(calculoComision.getValorTotalCalculoComision()+valorComision);
                        
//                        List<Comision> listComision = liquidacionARecalcular.getComisionList();
//                        listComision.add(comision);
//                        liquidacionARecalcular.setComisionList(listComision);
                        FachadaPersistencia.getInstance().guardar(comision);
                        dtosAccionesSistema.add(new DTOAccionesSistema(4, "COMISIÓN RECALCULADA", "Operación número: " + operacion.getNumeroOperacion() + "\n" + "Generada el día: " + operacion.getFechaHoraOperacion() + "\n" + "Importe pagado: $ " + operacion.getImportePagadoOperacion() + "\n" + "Comisión calculada: $ " + valorComision, new Date()));
                       
                    }
                }
                //setear fecha hasta del calculoComisionEstado anterior
                for (int i = 0; i < liquidacionARecalcular.getCalculoComisionList().size(); i++) {
                    for (int j = 0; j < liquidacionARecalcular.getCalculoComisionList().get(i).getCalculoComisionEstadoList().size(); j++) {
                        if (liquidacionARecalcular.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraHastaCalculoComisionEstado()==(null) ){
                          liquidacionARecalcular.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).setFechaHoraHastaCalculoComisionEstado(fechaActual);
                            FachadaPersistencia.getInstance().guardar(liquidacionARecalcular.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j));
                        }
                    }
                }
                //setear fehca hasta de la liquidacionEstado anterior
                for (int i = 0; i < liquidacionARecalcular.getLiquidacionEstadoList().size(); i++) {
                    if (liquidacionARecalcular.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado()==(null)) {
                        liquidacionARecalcular.getLiquidacionEstadoList().get(i).setFechaHoraHastaLiquidacionEstado(fechaActual);
                        FachadaPersistencia.getInstance().guardar(liquidacionARecalcular.getLiquidacionEstadoList().get(i));
                    }
                }
                CalculoComisionEstado nuevoCalculoComisionEstado = new CalculoComisionEstado();
                nuevoCalculoComisionEstado.setFechaHoraDesdeCalculoComisionEstado(fechaActual);
                criterios.clear();
                criterios.add(new DTOCriterio("nombreEstadoCalculoComision","=",nombreEstadoRecalculadaComision));
                EstadoCalculoComision estado = (EstadoCalculoComision)FachadaPersistencia.getInstance().buscar("EstadoCalculoComision", criterios).get(0);
                nuevoCalculoComisionEstado.setEstadoCalculoComision(estado);
                FachadaPersistencia.getInstance().guardar(nuevoCalculoComisionEstado);
                calculoComision.getCalculoComisionEstadoList().add(nuevoCalculoComisionEstado);
                calculoComision.setFechaCalculoComision(fechaActual);
                FachadaPersistencia.getInstance().guardar(calculoComision);
                liquidacionEstado.setFechaHoraHastaLiquidacionEstado(fechaActual);
                FachadaPersistencia.getInstance().guardar(liquidacionEstado);
                //NUEVO
                liquidacionARecalcular.getCalculoComisionList().add(calculoComision);
                
               
                criterios.clear();
                criterios.add(new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoRecalculada));
                EstadoLiquidacion estadoLiquidacionRecalculada = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
                LiquidacionEstado liquidacionEstadoNueva = new LiquidacionEstado();
                liquidacionEstadoNueva.setFechaHoraDesdeLiquidacionEstado(fechaActual);
                liquidacionEstadoNueva.setEstadoLiquidacion(estadoLiquidacionRecalculada);
                FachadaPersistencia.getInstance().guardar(liquidacionEstadoNueva);
//                List<LiquidacionEstado> listLiqEstados = liquidacionARecalcular.getLiquidacionEstadoList();
//                listLiqEstados.add(liquidacionEstadoNueva);
//                liquidacionARecalcular.setLiquidacionEstadoList(listLiqEstados);
                liquidacionARecalcular.getLiquidacionEstadoList().add(liquidacionEstadoNueva);
                liquidacionARecalcular.setFechaHoraLiquidacion(fechaActual);
                FachadaPersistencia.getInstance().guardar(liquidacionARecalcular);
                dtosAccionesSistema.add(new DTOAccionesSistema(3, "FIN DE RECÁLCULO DE LA LIQUIDACIÓN", "Empresa: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n" + "Tipo Impuesto: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Número de liquidación: " + liquidacionARecalcular.getNumeroLiquidacion() + "\n" + "Fecha desde: " + liquidacionARecalcular.getFechaHoraDesdeLiquidacion() + "\n" + "Fecha hasta: " + liquidacionARecalcular.getFechaHoraHastaLiquidacion(), new Date()));
                cantidadAnuladas++;
            }
        }
        }
        return cantidadAnuladas;
    }

    private int calcularLiquidacionesActuales(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {
        cantidadLiquidacionesCalculadas = 0;
        Date fechaHoraDesdeAUtilizar;
        List<Object> listOperacion = new ArrayList();
        List<Object> EmpresaTipoImpuestoList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
        if (EmpresaTipoImpuestoList == null || EmpresaTipoImpuestoList.isEmpty()) {
            dtosAccionesSistema.add(new DTOAccionesSistema(2, "Empresa Tipo Impuesto no existente", "No existen Empresas Tipo Impuestos cargadas en el sistema." + "\n" + "Verifique los datos cargados en el sistema y vuelva a ejecutar el proceso.", new Date()));
            return cantidadLiquidacionesCalculadas;
        }
        for (Object eTI : EmpresaTipoImpuestoList) {
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eTI;
            int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
            
            criterios.clear();
            criterios.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
            
            List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
            Calendar calfechaLiquidacion = Calendar.getInstance();
           
            if (liquidaciones == null || liquidaciones.isEmpty()) {
                
                if (empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto() == null){
                    dtosAccionesSistema.add(new DTOAccionesSistema(2, "ERROR: No se puede determinar la Fecha a liquidar.", "Para EMPRESA: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + ", " + "TIPO IMPUESTO: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\nVerifique que tenga asignada una fecha hora de alta en el sistema. Asigne esa fecha y vuelva a ejecutar el proceso.", new Date()));
                    continue;
                }
                calfechaLiquidacion.setTime(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            } else {
                Liquidacion liquid = (Liquidacion) liquidaciones.get(0);
                calfechaLiquidacion.setTime(liquid.getFechaHoraHastaLiquidacion());
                for (Object liquidacion : liquidaciones) {
                    Liquidacion liq = (Liquidacion) liquidacion;
                    if (liq.getFechaHoraHastaLiquidacion().after(calfechaLiquidacion.getTime())) {
                        calfechaLiquidacion.setTime(liq.getFechaHoraHastaLiquidacion());
                    }
                }
            }
            fechaHoraDesdeAUtilizar = calfechaLiquidacion.getTime();
            
            //sumo dias + frecuencia y eso lo asigno a fechaALiquidar
            calfechaLiquidacion.add(Calendar.DATE, frecuencia);
            fechaALiquidar = calfechaLiquidacion.getTime();
            
            //si fechaHoraLiquidacion+frecuencia >= fecha actual
            if (fechaALiquidar.before(fechaActual)) {
                //buscar "Operacion", "fechaHoraOperacion >= fechaHoraDesdeLiquidacion AND fechaOperacion <= fechaHoraHastaLiquidacion AND EmpresaTipoImpuesto="+empresaTipoImpuesto.toString()
                criterios.clear();
                criterios.add(new DTOCriterio("fechaHoraOperacion", ">=", fechaHoraDesdeAUtilizar));
                criterios.add(new DTOCriterio("fechaHoraOperacion", "<=", fechaALiquidar));
                criterios.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
                listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                if (listOperacion == null || listOperacion.isEmpty()) {  //if (operacionesEnRangoDeFechas.isEmpty()) {
                    dtosAccionesSistema.add(new DTOAccionesSistema(3, "VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n" + "Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Liquidar con una Frecuencia de: " + frecuencia + " días." + "\n" + "Debe liquidar a partir del día: " + fechaALiquidar + "\n" + "Se genera liquidación pero no tiene operaciones.", new Date()));
                } else {
                    dtosAccionesSistema.add(new DTOAccionesSistema(3, "VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n" + "Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Liquidar con una Frecuencia de: " + frecuencia + " días." + "\n" + "Debe liquidar a partir del día: " + fechaALiquidar + "\n" + "Se genera liquidación con " + listOperacion.size() + " operaciones.", new Date()));
                }
                Liquidacion nuevaLiquidacion = new Liquidacion();
                CalculoComision calculoComision = new CalculoComision();
                for (Object lo : listOperacion) { //for (Operacion lo : operacionesEnRangoDeFechas) {
                    Operacion operacion = (Operacion) lo;
                    Double valorComision;
                    EstrategiaCalculoComision estrategia = FabricaEstrategias.getInstancia().obtenerEstrategia(operacion);
                    valorComision = estrategia.obtenerValorComision(operacion);
                   
                    if (valorComision == -1.0) {
                        dtosAccionesSistema.add(new DTOAccionesSistema(4, "ERROR: No se pudo calcular la comisión.", "Porque NO se encuentran cargados los parámetros de cálculo de comisión.", new Date()));
                        return cantidadLiquidacionesCalculadas;

                    } else {
                    Comision comision = new Comision();
                    operacion.setLiquidadaOperacion(true);
                    FachadaPersistencia.getInstance().guardar(operacion);
                    comision.setValorComision(valorComision);
                    comision.setOperacion(operacion);
                    FachadaPersistencia.getInstance().guardar(comision);
                     
                    calculoComision.setComisionList(new ArrayList());
                    
                    calculoComision.getComisionList().add(comision);
                    calculoComision.setValorTotalCalculoComision(calculoComision.getValorTotalCalculoComision()+valorComision);
//                    nuevaLiquidacion.getComisionList().add(comision);
//                    nuevaLiquidacion.getOperacionList().add(operacion);
                    dtosAccionesSistema.add(new DTOAccionesSistema(4, "COMISIÓN CALCULADA", "Operación número: " + operacion.getNumeroOperacion() + "\n" + "Generada el día: " + operacion.getFechaHoraOperacion() + "\n" + "Importe pagado: $ " + operacion.getImportePagadoOperacion() + "\n" + "Comisión calculada: $ " + valorComision, new Date()));
                  
            //        FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
                    
                    }
                }
                criterios.clear();
                criterios.add(new DTOCriterio("nombreEstadoCalculoComision", "=", nombreEstadoCalculadaComision));
                EstadoCalculoComision estadoCalculoComision = (EstadoCalculoComision) FachadaPersistencia.getInstance().buscar("EstadoCalculoComision", criterios).get(0);
                CalculoComisionEstado nuevaCalculoComisionEstado = new CalculoComisionEstado();
                nuevaCalculoComisionEstado.setEstadoCalculoComision(estadoCalculoComision);
                nuevaCalculoComisionEstado.setFechaHoraDesdeCalculoComisionEstado(fechaActual);
                FachadaPersistencia.getInstance().guardar(nuevaCalculoComisionEstado);
                
                    calculoComision.setCalculoComisionEstadoList(new ArrayList());
                
                calculoComision.getCalculoComisionEstadoList().add(nuevaCalculoComisionEstado);
                calculoComision.setFechaCalculoComision(fechaActual);
                FachadaPersistencia.getInstance().guardar(calculoComision);
                
                
                nuevaLiquidacion.getCalculoComisionList().add(calculoComision);
                nuevaLiquidacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);
                nuevaLiquidacion.setNumeroLiquidacion(Generar_numeroLiquidacionNueva());
                nuevaLiquidacion.setFechaHoraLiquidacion(fechaActual);
                nuevaLiquidacion.setFechaHoraDesdeLiquidacion(fechaHoraDesdeAUtilizar);
                nuevaLiquidacion.setFechaHoraHastaLiquidacion(fechaActual);
                 
                criterios.clear();
                criterios.add(new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoPendiente));
                EstadoLiquidacion estadoLiquidacionPendiente = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
                LiquidacionEstado nuevaLiquidacoinEstado = new LiquidacionEstado();
                nuevaLiquidacoinEstado.setEstadoLiquidacion(estadoLiquidacionPendiente);
          //      nuevaLiquidacion.getLiquidacionEstadoList().add(nuevaLiquidacoinEstado);
                nuevaLiquidacoinEstado.setFechaHoraDesdeLiquidacionEstado(fechaActual);
                FachadaPersistencia.getInstance().guardar(nuevaLiquidacoinEstado);
               nuevaLiquidacion.getLiquidacionEstadoList().add(nuevaLiquidacoinEstado);
                FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
                int cantidad = 0;
                try {
                    cantidad = nuevaLiquidacion.getCalculoComisionList().get(0).getComisionList().size();
                } catch (Exception e) {cantidad = 0;
                }
                
                dtosAccionesSistema.add(new DTOAccionesSistema(4, "DATOS DE LA LIQUIDACIÓN GENERADA", "Empresa: " + nuevaLiquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n" + "Tipo Impuesto: " + nuevaLiquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Número de liquidación: " + nuevaLiquidacion.getNumeroLiquidacion() + "\n" + "Fecha desde: " + nuevaLiquidacion.getFechaHoraDesdeLiquidacion() + "\n" + "Fecha hasta: " + nuevaLiquidacion.getFechaHoraHastaLiquidacion() + "\n" + "Cantidad de operaciones liquidadas: " + cantidad, new Date()));
                cantidadLiquidacionesCalculadas++;

            } else {
                dtosAccionesSistema.add(new DTOAccionesSistema(3, "VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n" + "Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Liquidar con una Frecuencia de: " + frecuencia + " días." + "\n" + "No se genera liquidación porque corresponde liquidar a partir del día " + fechaALiquidar, new Date()));
            }
        }
        return cantidadLiquidacionesCalculadas;
    }

    private int Generar_numeroLiquidacionNueva() {
        int numeroLiquidacion = 0;

        try {
            if (FachadaPersistencia.getInstance().buscar("Liquidacion", null).isEmpty()) {

                numeroLiquidacion = 1;

            } else {
                numeroLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null).size() + 1;
            }

        } catch (Exception e) {
            return numeroLiquidacion;
        }

        return numeroLiquidacion;

    }
}
