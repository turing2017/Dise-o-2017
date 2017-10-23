/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Comision;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
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

    //variables globales
    String nombreEstadoRecalculada = "Recalculada";
    String nombreEstadoAnulado = "Anulada";
    String nombreEstadoPendiente = "Calculada";
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

        dtosAccionesSistema.add(new DTOAccionesSistema(1, "INICIO RECÁLCULO DE LIQUIDACIONES ANULADAS", "", new Date()));

        cantidadLiquidacionesRecalculadas = recalcularLiquidacionesAnuladas(dtosAccionesSistema);

        if (cantidadLiquidacionesRecalculadas == 0) {
            dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN RECÁLCULO DE LIQUIDACIONES ANULADAS", "No existen liquidaciones a recalcular.", new Date()));
        } else {
            dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN RECÁLCULO DE LIQUIDACIONES ANULADAS", "Se generaron un total de " + cantidadLiquidacionesRecalculadas + " liquidaciones en estado Recalculada.", new Date()));
        }

        dtosAccionesSistema.add(new DTOAccionesSistema(1, "INICIO CÁLCULO DE LIQUIDACIONES A GENERAR", "", new Date()));

        cantidadLiquidacionesCalculadas = calcularLiquidacionesActuales(dtosAccionesSistema);

        if (cantidadLiquidacionesCalculadas == 0) {
            dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN CÁLCULO DE LIQUIDACIONES A GENERAR", "No se generaron liquidaciones en estado Calculada.", new Date()));
        } else {
            dtosAccionesSistema.add(new DTOAccionesSistema(1, "FIN CÁLCULO DE LIQUIDACIONES A GENERAR", "Se generaron un total de " + cantidadLiquidacionesCalculadas + " liquidaciones en estado Calculada.", new Date()));
        }

        dtosAccionesSistema.add(new DTOAccionesSistema(0, "FIN DEL PROCESO PARA EL CÁLCULO DE LIQUIDACIONES", "", new Date()));

        return dtosAccionesSistema;

    }

    /**
     * Función que realiza el recálculo de liquidaciones anuladas
     *
     */
    private int recalcularLiquidacionesAnuladas(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {

        int cantidadAnuladas = 0;

        //buscar "EstadoLiquidacion","nombreEstadoLiquidacion=Anulada"
        DTOCriterio criterio = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoAnulado);
        criterios.add(criterio);

        EstadoLiquidacion estadoLiquidacion = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);

        if (estadoLiquidacion == null) {
            dtosAccionesSistema.add(new DTOAccionesSistema(2, "Estado liquidación no existente", "Verifique que este cargado el estado " + nombreEstadoPendiente + " en los estados de liquidación y vuelva a ejecutar el proceso.", new Date()));
            return cantidadAnuladas;
        }

        //buscar "LiquidacionEstado","EstadoLiquidacion="+estadoLiquidacion.toString()
        DTOCriterio criterio1 = new DTOCriterio("estadoLiquidacion", "=", estadoLiquidacion);
        criterios.clear();
        criterios.add(criterio1);

        List<Object> listLiquidacionEstado = FachadaPersistencia.getInstance().buscar("LiquidacionEstado", criterios);

        //por cada liquidacion Estado
        for (Object objlistLiquidacion : listLiquidacionEstado) {
            LiquidacionEstado liquidacionEstado = (LiquidacionEstado) objlistLiquidacion;

            //getfechaHoraHastaLiquidacion    
            Date fechaHasta = liquidacionEstado.getFechaHoraHastaLiquidacionEstado();

            // alt si fechaHoraHastaLiquidacion is null
            if (fechaHasta == null) {

                Liquidacion liquidacionARecalcular = new Liquidacion();

                //Busco la liquidacion que tenga esa LiquidacionEstado
                List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", null);

                for (Object objLiquidaciones : liquidaciones) {

                    Liquidacion liquidacionlist = (Liquidacion) objLiquidaciones;
                    for (int i = 0; i < liquidacionlist.getLiquidacionEstadoList().size(); i++) {
                        if (liquidacionlist.getLiquidacionEstadoList().get(i).equals(liquidacionEstado)) {
                            // liquidacionesAnuladas.add(liquidacionlist);
                            liquidacionARecalcular = liquidacionlist;
                            break;
                        }
                    }
                }

                //getfechaHoradesdeLiquidacion       
                Date fechaDesdeLiquidacion = liquidacionARecalcular.getFechaHoraDesdeLiquidacion();
                //getfechaHoraHastaLiquidacion      
                Date fechaHastaLiquidacion = liquidacionARecalcular.getFechaHoraHastaLiquidacion();
                //getEmpresaTipoImpuesto     
                EmpresaTipoImpuesto empresaTipoImpuesto = liquidacionARecalcular.getEmpresaTipoImpuesto();

                //buscar "Operacion", "fechaHoraOperacion >= fechaHoraDesdeLiquidacion AND fechaOperacion <= fechaHoraHastaLiquidacion AND EmpresaTipoImpuesto="+empresaTipoImpuesto.toString()
                DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", fechaDesdeLiquidacion);
                DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", fechaHastaLiquidacion);
                DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
                criterios.clear();
                criterios.add(criterio3);
                criterios.add(criterio4);
                criterios.add(criterio5);

                List<Object> listOperacion = new ArrayList();
                try {
                    listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                } catch (Exception e) {
                    e.printStackTrace();
                    //System.out.println("No existen operaciones");
                }

                dtosAccionesSistema.add(new DTOAccionesSistema(3, "INICIANDO RECÁLCULO DE LA LIQUIDACIÓN", "Empresa: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n" + "Tipo Impuesto: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Cantidad de operaciones: " + listOperacion.size(), new Date()));

                // loop por cada operacion
                for (Object op : listOperacion) {
                    Operacion operacion = (Operacion) op;
                    Double valorComision;
                    EstrategiaCalculoComision estrategia = FabricaEstrategias.getInstancia().obtenerEstrategia(operacion);
                    valorComision = estrategia.obtenerValorComision(operacion);

                    //  Creamos la comision correspondiente para la operacion y la seteamos 
                    Comision comision = new Comision();
                    comision.setFechaCalculoComision(new Date());
                    comision.setValorComision(valorComision);
                    comision.setOperacion(operacion);

                    operacion.setValorComisionOperacion(valorComision);
                    operacion.setLiquidadaOperacion(true);

                    List<Comision> listComision = liquidacionARecalcular.getComisionList();
                    listComision.add(comision);
                    liquidacionARecalcular.setComisionList(listComision);

                    dtosAccionesSistema.add(new DTOAccionesSistema(4, "COMISIÓN CALCULADA", "Operación número: " + operacion.getNumeroOperacion() + "\n" + "Generada el día: " + operacion.getFechaHoraOperacion() + "\n" + "Importe pagado: $ " + operacion.getImportePagadoOperacion() + "\n" + "Comisión calculada: $ " + valorComision, new Date()));

                    FachadaPersistencia.getInstance().guardar(operacion);
                    FachadaPersistencia.getInstance().guardar(comision);

                }

                liquidacionEstado.setFechaHoraHastaLiquidacionEstado(new Date());
                FachadaPersistencia.getInstance().guardar(liquidacionEstado);

                // Busco el estado recalculada
                DTOCriterio criterio8 = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoRecalculada);
                criterios.clear();
                criterios.add(criterio8);

                EstadoLiquidacion estadoLiquidacionRecalculada = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);

                LiquidacionEstado liqEstado = new LiquidacionEstado();

                liqEstado.setFechaHoraDesdeLiquidacionEstado(new Date());
                liqEstado.setEstadoLiquidacion(estadoLiquidacionRecalculada);

                //Guardo nuevo estado
                FachadaPersistencia.getInstance().guardar(liqEstado);

                List<LiquidacionEstado> listLiqEstados = liquidacionARecalcular.getLiquidacionEstadoList();

                //Agrego el nuevo estado
                listLiqEstados.add(liqEstado);
                liquidacionARecalcular.setLiquidacionEstadoList(listLiqEstados);
                liquidacionARecalcular.setFechaHoraLiquidacion(new Date());

                //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(liquidacionARecalcular);

                dtosAccionesSistema.add(new DTOAccionesSistema(3, "FIN DE RECÁLCULO DE LA LIQUIDACIÓN", "Empresa: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n" + "Tipo Impuesto: " + liquidacionARecalcular.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Número de liquidación: " + liquidacionARecalcular.getNumeroLiquidacion() + "\n" + "Fecha desde: " + liquidacionARecalcular.getFechaHoraDesdeLiquidacion() + "\n" + "Fecha hasta: " + liquidacionARecalcular.getFechaHoraHastaLiquidacion(), new Date()));

                //Contar la cantidad de Liquidaciones con nombreEstadoLiquidacion = Anulada y fechaHoraHastaLiquidacionEstado = null
                cantidadAnuladas++;

            }

        }

        return cantidadAnuladas;

    }

    /**
     * Función que realiza el cálculo de liquidaciones nuevas
     */
    private int calcularLiquidacionesActuales(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {

        cantidadLiquidacionesCalculadas = 0;
        Date fechaALiquidarDesde;

        List<Object> listOperacion = new ArrayList();

        //busca empresaTipoImpuesto
        List<Object> EmpresaTipoImpuestoList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);

        if (EmpresaTipoImpuestoList == null || EmpresaTipoImpuestoList.isEmpty()) {
            dtosAccionesSistema.add(new DTOAccionesSistema(2, "Empresa Tipo Impuesto no existente", "No existen Empresas Tipo Impuestos cargadas en el sistema." + "\n" + "Verifique los datos cargados en el sistema y vuelva a ejecutar el proceso.", new Date()));
            return cantidadLiquidacionesCalculadas;
        }

        //loop por cada EmpresatipoImpuesto
        for (Object eTI : EmpresaTipoImpuestoList) {
           // crear una lista para las operaciones para poder buscar despues por rango de fechas
            List<Operacion> operacionesEnRangoDeFechas = new ArrayList();
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eTI;

            //get frecuencia
            int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
           
            //System.out.println("fecha: " + empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            //System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
            //buscar "Liquidacion", "empresaTipoImpuesto = "empresaTipoImpuesto.toString()"" 
            DTOCriterio criterio9 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
            criterios.clear();
            criterios.add(criterio9);

            List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);

            Calendar calfechaLiquidacion = Calendar.getInstance();

            if (liquidaciones == null || liquidaciones.isEmpty()) {
                //Si NO tiene Liquidaciones generadas

                //fecha de la condicion
                calfechaLiquidacion.setTime(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());

//                ultimaLiquidacion.setFechaHoraLiquidacion(new Date());
//                ultimaLiquidacion.setFechaHoraHastaLiquidacion(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            } else {

                Liquidacion liquid = (Liquidacion) liquidaciones.get(0);

                calfechaLiquidacion.setTime(liquid.getFechaHoraHastaLiquidacion());

                for (Object liquidacion : liquidaciones) {
                    //Buscar la ultima liquidacion con la fechaHoraHasta mas reciente
                    Liquidacion liq = (Liquidacion) liquidacion;

                    if (liq.getFechaHoraHastaLiquidacion().after(calfechaLiquidacion.getTime())) {
                        calfechaLiquidacion.setTime(liq.getFechaHoraHastaLiquidacion());
                    }

                }

            }

            fechaALiquidarDesde = calfechaLiquidacion.getTime();
            
            //sumo dias + frecuencia y eso lo asigno a fechaALiquidar
            calfechaLiquidacion.add(Calendar.DATE, frecuencia);
            fechaALiquidar = calfechaLiquidacion.getTime();

            //si fechaHoraLiquidacion+frecuencia >= fecha actual
            if (fechaALiquidar.before(new Date())) {
                //  buscar  "Operacion", "fechaHoraOperacion >= fechaHoraLiquidacion AND fechaHoraOperacion <= fechaActual " ysea del empresaTipoImpuesto

                //  DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", ultimaLiquidacion.getFechaHoraHastaLiquidacion());
                //  DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", new Date());
                DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
                criterios.clear();
                // criterios.add(criterio3);
                // criterios.add(criterio4);
                criterios.add(criterio5);

                try {
                    listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                } catch (Exception e) {
                    e.printStackTrace();
                  //  System.out.println("No existen operaciones");
                }

                for (Object op : listOperacion) {
                    Operacion operacion = (Operacion) op;
//                        System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
//                        System.out.println(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
//                        System.out.println(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
//                        System.out.println(operacion.getFechaHoraOperacion() + ">" + ultimaLiquidacion.getFechaHoraHastaLiquidacion() + " y " + operacion.getFechaHoraOperacion() + "<" + new Date());
                    if (operacion.getFechaHoraOperacion().after(fechaALiquidar)
                            && operacion.getFechaHoraOperacion().before(new Date())) {
                        operacionesEnRangoDeFechas.add(operacion);
                    }
                }
                
                if (operacionesEnRangoDeFechas.isEmpty()) {
                    dtosAccionesSistema.add(new DTOAccionesSistema(3, "VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n" + "Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Liquidar con una Frecuencia de: " + frecuencia + " días." + "\n" + "Debe liquidar a partir del día: " + fechaALiquidar + "\n" + "Se genera liquidación pero no tiene operaciones.", new Date()));
                } else {
                    dtosAccionesSistema.add(new DTOAccionesSistema(3, "VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n" + "Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Liquidar con una Frecuencia de: " + frecuencia + " días." + "\n" + "Debe liquidar a partir del día: " + fechaALiquidar + "\n" + "Se genera liquidación con " + operacionesEnRangoDeFechas.size() + " operaciones.", new Date()));
                }
                
                
                //new liquidacion
                Liquidacion nuevaLiquidacion = new Liquidacion();

                //por cada Operacion
                for (Operacion lo : operacionesEnRangoDeFechas) {
                    Operacion operacion = (Operacion) lo;

                    Double valorComision;
                    EstrategiaCalculoComision estrategia = FabricaEstrategias.getInstancia().obtenerEstrategia(operacion);
                    valorComision = estrategia.obtenerValorComision(operacion);
                    
                    //  Creamos la comision correspondiente para la operacion y la seteamos 
                    Comision comision = new Comision();
                    comision.setFechaCalculoComision(new Date());
                    comision.setValorComision(valorComision);
                    comision.setOperacion(operacion);
                    operacion.setValorComisionOperacion(valorComision);
                    operacion.setLiquidadaOperacion(true);
                    nuevaLiquidacion.getComisionList().add(comision);
                    nuevaLiquidacion.getOperacionList().add(operacion);

                    dtosAccionesSistema.add(new DTOAccionesSistema(4, "COMISIÓN CALCULADA", "Operación número: " + operacion.getNumeroOperacion() + "\n" + "Generada el día: " + operacion.getFechaHoraOperacion() + "\n" + "Importe pagado: $ " + operacion.getImportePagadoOperacion() + "\n" + "Comisión calculada: $ " + valorComision, new Date()));

                    FachadaPersistencia.getInstance().guardar(operacion);
                    FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
                    FachadaPersistencia.getInstance().guardar(comision);

                    //fin loop por cada operacion
                }

                //busco "EstadoLiquidacion", nombreEstadoLiquidacion= Creada"
                DTOCriterio criterio8 = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoPendiente);
                criterios.clear();
                criterios.add(criterio8);

                EstadoLiquidacion estadoLiquidacionPendiente = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
                
                LiquidacionEstado liqEstado = new LiquidacionEstado();
                //setEstadoLiquidacion(estadoLiquidacion)
                liqEstado.setEstadoLiquidacion(estadoLiquidacionPendiente);
                //setFechaHoraDesdeLiquidacionEstado(fechaActual)
                liqEstado.setFechaHoraDesdeLiquidacionEstado(new Date());

                //setLiquidacionEstado(LiquidacionEstado)
                nuevaLiquidacion.getLiquidacionEstadoList().add(liqEstado);
                

                //setnumeroLiquidacion(numeroLiquidacion)
                //buscar numero liquidacion
                List<Object> liquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null);
                int numeroLiquidacion = 0;
                for (Object l : liquidacion) {
                    Liquidacion liq = (Liquidacion) l;
                    if (liq.getNumeroLiquidacion() > numeroLiquidacion) {
                        numeroLiquidacion = liq.getNumeroLiquidacion();
                    }
                }
                //setNumeroLiquidacion
                nuevaLiquidacion.setNumeroLiquidacion(numeroLiquidacion + 1);
               
                //setFechaHoraLiquidacion(fechaActual)
                nuevaLiquidacion.setFechaHoraLiquidacion(new Date());
                //setfechaHoraDesdeLiquidacion(fechahoraDesdeLiquidacion)
                nuevaLiquidacion.setFechaHoraDesdeLiquidacion(fechaALiquidarDesde); 
                //setFechaHoraHastaLiquidacion
                nuevaLiquidacion.setFechaHoraHastaLiquidacion(new Date());
                //setEmpresaTipoImpuesto
                nuevaLiquidacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);

                //Guardo nuevo LiquidacionEstado
                FachadaPersistencia.getInstance().guardar(liqEstado);
                //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
                
                dtosAccionesSistema.add(new DTOAccionesSistema(3, "DATOS DE LA LIQUIDACIÓN GENERADA", "Empresa: " + nuevaLiquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n" + "Tipo Impuesto: " + nuevaLiquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Número de liquidación: " + nuevaLiquidacion.getNumeroLiquidacion() + "\n" + "Fecha desde: " + nuevaLiquidacion.getFechaHoraDesdeLiquidacion() + "\n" + "Fecha hasta: " + nuevaLiquidacion.getFechaHoraHastaLiquidacion() + "\n" + "Cantidad de operaciones liquidadas: " + nuevaLiquidacion.getOperacionList().size(), new Date()));
                
                //Contar la cantidad de Liquidaciones calculadas en el proceso
                cantidadLiquidacionesCalculadas++;

            } else {
                dtosAccionesSistema.add(new DTOAccionesSistema(3, "VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n" + "Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n" + "Liquidar con una Frecuencia de: " + frecuencia + " días." + "\n" + "No se genera liquidación porque corresponde liquidar a partir del día " + fechaALiquidar, new Date()));
            }

        }

        return cantidadLiquidacionesCalculadas;

    }

}
