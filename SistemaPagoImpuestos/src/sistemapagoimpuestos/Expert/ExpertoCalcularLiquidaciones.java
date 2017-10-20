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

    public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }

    public ArrayList<DTOAccionesSistema> iniciar(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {

        //varaiables globales
        Liquidacion liquidacionAnulada = new Liquidacion();
        String nombreEstadoRecalculada = "Recalculada";
        String nombreEstadoAnulado = "Anulada";
        String nombreEstadoPendiente = "Calculada";
        List<DTOCriterio> criterios = new ArrayList();
        Date fechaALiquidar;
        int cantidadAnuladas = 0;
        int cantidadLiquidacionesGeneradas = 0;

        dtosAccionesSistema.add(new DTOAccionesSistema("INICIO RECÁLCULO DE LIQUIDACIONES", "Se comprueba si existen liquidaciones a recalcular...", new Date()));

        //buscar "EstadoLiquidacion","nombreEstadoLiquidacion=Anulada"
        DTOCriterio criterio = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoAnulado);
        criterios.add(criterio);
        EstadoLiquidacion estadoLiquidacion = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
        //buscar "LiquidacionEstado","EstadoLiquidacion="+estadoLiquidacion.toString()
        DTOCriterio criterio1 = new DTOCriterio("estadoLiquidacion", "=", estadoLiquidacion);
        criterios.clear();
        criterios.add(criterio1);
        List<Object> listLiquidacionEstado = FachadaPersistencia.getInstance().buscar("LiquidacionEstado", criterios);

        for (Object objlistLiquidacion : listLiquidacionEstado) {
            LiquidacionEstado liquidacionEstado = (LiquidacionEstado) objlistLiquidacion;
            Date fechaHasta = liquidacionEstado.getFechaHoraHastaLiquidacionEstado();
            if (fechaHasta == null) {
                cantidadAnuladas++;
            }
        }

        dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI EXISTEN LIQUIDACIONES EN ESTADO ANULADA", "Existen " + cantidadAnuladas + " liquidaciones a recalcular.", new Date()));

        //por cada liquidacion Estado
        for (Object objlistLiquidacion : listLiquidacionEstado) {
            LiquidacionEstado liquidacionEstado = (LiquidacionEstado) objlistLiquidacion;
            //getfechaHoraHastaLiquidacion    
            Date fechaHasta = liquidacionEstado.getFechaHoraHastaLiquidacionEstado();
            // alt si fechaHoraHastaLiquidacion is null
            if (fechaHasta == null) {

                //Busco la liquidacion que tenga ese LiquidacionEstado
                List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", null);

                for (Object objLiquidaciones : liquidaciones) {

                    Liquidacion liquidacionlist = (Liquidacion) objLiquidaciones;
                    for (int i = 0; i < liquidacionlist.getLiquidacionEstadoList().size(); i++) {
                        if (liquidacionlist.getLiquidacionEstadoList().get(i).equals(liquidacionEstado)) {
                            // liquidacionesAnuladas.add(liquidacionlist);
                            liquidacionAnulada = liquidacionlist;
                            break;
                        }
                    }
                }

                //getfechaHoradesdeLiquidacion       
                Date fechaDesdeLiquidacion = liquidacionAnulada.getFechaHoraDesdeLiquidacion();
                //getfechaHoraHastaLiquidacion      
                Date fechaHastaLiquidacion = liquidacionAnulada.getFechaHoraHastaLiquidacion();
                //getEmpresaTipoImpuesto     
                EmpresaTipoImpuesto empresaTipoImpuesto = liquidacionAnulada.getEmpresaTipoImpuesto();

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
                    dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI EXISTEN OPERACIONES A RECALCULAR", "Existen " + listOperacion.size() + "operaciones a liquidar.", new Date()));
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                // loop por cada operacion

                dtosAccionesSistema.add(new DTOAccionesSistema("INICIANDO RECÁLCULO DE LA LIQUIDACIÓN...", "Empresa: " + liquidacionAnulada.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n Tipo Impuesto: " + liquidacionAnulada.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto(), new Date()));

                for (Object op : listOperacion) {
                    Operacion operacion = (Operacion) op;
                    dtosAccionesSistema.add(new DTOAccionesSistema("CALCULANDO COMISIÓN...", "Operación número " + operacion.getNumeroOperacion() + " generada el día " + operacion.getFechaHoraOperacion() + " con importe pagado de $ " + operacion.getImportePagadoOperacion(), new Date()));
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
                    List<Comision> listComision = liquidacionAnulada.getComisionList();
                    listComision.add(comision);
                    liquidacionAnulada.setComisionList(listComision);
                    dtosAccionesSistema.add(new DTOAccionesSistema("COMISIÓN CALCULADA", "Comisión calculada = $ " + valorComision, new Date()));
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
                dtosAccionesSistema.add(new DTOAccionesSistema("ESTABLECIENDO ESTADO DE LIQUIDACIÓN...", "Se colocó la liquidación en estado " + liqEstado.getEstadoLiquidacion().getNombreEstadoLiquidacion(), new Date()));
                List<LiquidacionEstado> listLiqEstados = liquidacionAnulada.getLiquidacionEstadoList();
                //Agrego el nuevo estado
                listLiqEstados.add(liqEstado);
                liquidacionAnulada.setLiquidacionEstadoList(listLiqEstados);
                liquidacionAnulada.setFechaHoraLiquidacion(new Date());
                //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(liquidacionAnulada);
                dtosAccionesSistema.add(new DTOAccionesSistema("FIN DE RECÁLCULO DE LA LIQUIDACIÓN...", "Empresa: " + liquidacionAnulada.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa() + "\n Tipo Impuesto: " + liquidacionAnulada.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto() + "\n Número de liquidación: " + liquidacionAnulada.getNumeroLiquidacion() + "\n Fecha desde: " + liquidacionAnulada.getFechaHoraDesdeLiquidacion() + "\n Fecha hasta: " + liquidacionAnulada.getFechaHoraHastaLiquidacion(), new Date()));
            }

        }

        if (cantidadAnuladas == 0) {
            dtosAccionesSistema.add(new DTOAccionesSistema("FIN DE RECÁLCULOS PENDIENTES...", "No se generaron liquidaciones recalculadas.", new Date()));
        } else {
            dtosAccionesSistema.add(new DTOAccionesSistema("FIN DE RECÁLCULOS PENDIENTES...", "Se generaron un total de " + cantidadAnuladas + " liquidaciones recalculadas.", new Date()));
        }

        /*
        ---------------------------------------
        INICIO CALCULO PARA LIQUIDACIONES NUEVAS
        ----------------------------------------
         */
        dtosAccionesSistema.add(new DTOAccionesSistema("INICIO DE CÁLCULO DE LIQUIDACIONES", "Se comprueba si existen operaciones a liquidar...", new Date()));

        List<Object> listOperacion = new ArrayList();
        //busca empresaTipoImpuesto
        List<Object> EmpresaTipoImpuestoList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
        //loop por cada EmpresatipoImpuesto
        for (Object eTI : EmpresaTipoImpuestoList) {
            // crear una lista para las operaciones para poder buscar despues por rango de fechas
            List<Operacion> operacionesEnRangoDeFechas = new ArrayList();
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eTI;
            dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI DEBE LIQUIDAR A EMPRESA TIPO IMPUESTO", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n Tipo de impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto(), new Date()));

            System.out.println("fecha: " + empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
            //buscar "Liquidacion", "empresaTipoImpuesto = "empresaTipoImpuesto.toString()"" 
            DTOCriterio criterio9 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
            criterios.clear();
            criterios.add(criterio9);
            List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);

            //Metodo Vandenbosch para tener una fecha 0 a la que comprara el 1ero
            Calendar vandenbosch = Calendar.getInstance();
            vandenbosch.set(1992, 4, 18);
            Liquidacion ultimaLiquidacion = new Liquidacion();
            ultimaLiquidacion.setFechaHoraLiquidacion(vandenbosch.getTime());
            ultimaLiquidacion.setFechaHoraHastaLiquidacion(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            // fin metodo vandenbosch

            //Si tiene Liquidaciones generadas
            if (liquidaciones.size() != 0) {

                for (Object liquidacion : liquidaciones) {
                    //Buscar la ultima liquidacion con la fechaHoraHasta mas reciente
                    Liquidacion liq = (Liquidacion) liquidacion;

                    if (liq.getFechaHoraHastaLiquidacion().after(ultimaLiquidacion.getFechaHoraHastaLiquidacion())) {
                        ultimaLiquidacion = liq;
                    }

                }

                //get frecuencia
                int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
                dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA FRECUENCIA DE LIQUIDACIÓN", "Frecuencia de liquidación: " + frecuencia + " días.", new Date()));
                Calendar calfechaLiquidacion = Calendar.getInstance();
                //fecha de la condicion
                calfechaLiquidacion.setTime(ultimaLiquidacion.getFechaHoraHastaLiquidacion());
                //sumo dias + frecuencia y eso lo asigno a fechaALiquidar
                calfechaLiquidacion.set(calfechaLiquidacion.get(Calendar.YEAR), calfechaLiquidacion.get(Calendar.MONTH), calfechaLiquidacion.get(Calendar.DAY_OF_MONTH) + frecuencia);
                fechaALiquidar = calfechaLiquidacion.getTime();

                //si fechaHoraLiquidacion+frecuencia >= fecha actual
                if (fechaALiquidar.before(new Date())) {
                    dtosAccionesSistema.add(new DTOAccionesSistema("Se procede a generar la liquidación...", "Corresponde liquidar desde el día " + fechaALiquidar, new Date()));
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
                        dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI EXISTEN OPERACIONES A LIQUIDAR", "Existen " + listOperacion.size() + " operaciones a liquidar.", new Date()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI EXISTEN OPERACIONES A LIQUIDAR", "No existen operaciones a liquidar.", new Date()));
                        System.out.println("No existen operaciones");
                    }
                    for (Object op : listOperacion) {
                        Operacion operacion = (Operacion) op;
                        System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
                        System.out.println(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
                        System.out.println(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                        System.out.println(operacion.getFechaHoraOperacion() + ">" + ultimaLiquidacion.getFechaHoraHastaLiquidacion() + " y " + operacion.getFechaHoraOperacion() + "<" + new Date());
                        if (operacion.getFechaHoraOperacion().after(ultimaLiquidacion.getFechaHoraHastaLiquidacion())
                                && operacion.getFechaHoraOperacion().before(new Date())) {
                            operacionesEnRangoDeFechas.add(operacion);
                        }
                    }
                } else {
                    dtosAccionesSistema.add(new DTOAccionesSistema("No se genera liquidación...", "Corresponde liquidar el día " + fechaALiquidar, new Date()));
                }
            } else {
                //si NO tiene Liquidaciones generardas

                int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
                dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA FRECUENCIA DE LIQUIDACIÓN", "Frecuencia de liquidación: " + frecuencia + " días.", new Date()));
                Calendar calfechaLiquidacion = Calendar.getInstance();
                calfechaLiquidacion.setTime(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                calfechaLiquidacion.set(calfechaLiquidacion.get(Calendar.YEAR), calfechaLiquidacion.get(Calendar.MONTH), calfechaLiquidacion.get(Calendar.DAY_OF_MONTH) + frecuencia);
                Date fechaLiquidacion = calfechaLiquidacion.getTime();

                EmpresaTipoImpuesto emptia = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null).get(0);
                fechaALiquidar = fechaLiquidacion;
                if (fechaALiquidar.before(new Date())) {
                    dtosAccionesSistema.add(new DTOAccionesSistema("Se procede a generar la liquidación...", "Corresponde liquidar desde el día " + fechaALiquidar, new Date()));
                    // buscar Operacion

                    //   DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                    //   DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", new Date());
                    DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
                    criterios.clear();
                    //  criterios.add(criterio3);
                    //  criterios.add(criterio4);
                    criterios.add(criterio5);

                    try {
                        listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                        dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI EXISTEN OPERACIONES A LIQUIDAR", "Existen " + listOperacion.size() + " operaciones a liquidar.", new Date()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        dtosAccionesSistema.add(new DTOAccionesSistema("VERIFICA SI EXISTEN OPERACIONES A LIQUIDAR", "No existen operaciones a liquidar.", new Date()));
                        System.out.println("No existen operaciones");
                    }
                    for (Object op : listOperacion) {
                        Operacion operacion = (Operacion) op;
                        System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
                        System.out.println(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
                        System.out.println(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                        System.out.println(operacion.getFechaHoraOperacion() + ">" + empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto() + "y" + operacion.getFechaHoraOperacion() + "<" + new Date());
                        if (operacion.getFechaHoraOperacion().after(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto())
                                && operacion.getFechaHoraOperacion().before(new Date())) {
                            operacionesEnRangoDeFechas.add(operacion);
                        }
                    }
                }
            }

            //buscar numero liquidacion
            List<Object> liquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null);
            int numeroLiquidacion = 0;
            for (Object l : liquidacion) {
                Liquidacion liq = (Liquidacion) l;
                if (liq.getNumeroLiquidacion() > numeroLiquidacion) {
                    numeroLiquidacion = liq.getNumeroLiquidacion();
                }
            }
            //new liquidacion
            Liquidacion nuevaLiquidacion = new Liquidacion();

            //por cada Operacion
            for (Operacion lo : operacionesEnRangoDeFechas) {
                Operacion operacion = (Operacion) lo;
                dtosAccionesSistema.add(new DTOAccionesSistema("CALCULANDO COMISIÓN...", "Operación número " + operacion.getNumeroOperacion() + " generada el día " + operacion.getFechaHoraOperacion() + " con importe pagado de $ " + operacion.getImportePagadoOperacion(), new Date()));
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
                dtosAccionesSistema.add(new DTOAccionesSistema("COMISIÓN CALCULADA", "Comisión calculada = $" + valorComision, new Date()));

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
            //if(!operacionesEnRangoDeFechas.isEmpty()){   // en caso de que no tengamos q crear liquidaciones vacias
            // newLiquidacionEstado
            if (fechaALiquidar.before(new Date())) {
                LiquidacionEstado liqEstado = new LiquidacionEstado();
                //setEstadoLiquidacion(estadoLiquidacion)
                liqEstado.setEstadoLiquidacion(estadoLiquidacionPendiente);
                //setFechaHoraDesdeLiquidacionEstado(fechaActual)
                liqEstado.setFechaHoraDesdeLiquidacionEstado(new Date());

                //setLiquidacionEstado(LiquidacionEstado)
                dtosAccionesSistema.add(new DTOAccionesSistema("ESTABLECIENDO ESTADO DE LIQUIDACIÓN...", "Se colocó la liquidación en estado " + liqEstado.getEstadoLiquidacion().getNombreEstadoLiquidacion(), new Date()));
                nuevaLiquidacion.getLiquidacionEstadoList().add(liqEstado);
                //setnumeroLiquidacion(numeroLiquidacion)

                //setNumeroLiquidacion
                nuevaLiquidacion.setNumeroLiquidacion(numeroLiquidacion + 1);
                //setFechaHoraLiquidacion(fechaActual)
                nuevaLiquidacion.setFechaHoraLiquidacion(new Date());
                //setfechaHoraDesdeLiquidacion(fechahoraDesdeLiquidacion)
                nuevaLiquidacion.setFechaHoraDesdeLiquidacion(ultimaLiquidacion.getFechaHoraHastaLiquidacion()); //creo q asi, quiza explote en la 1era tengo miedo
                //setFechaHoraHastaLiquidacion
                nuevaLiquidacion.setFechaHoraHastaLiquidacion(new Date());
                //setEmpresaTipoImpuesto
                nuevaLiquidacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);

                dtosAccionesSistema.add(new DTOAccionesSistema("FIN DE CÁLCULO DE LA LIQUIDACIÓN", "Empresa: " + empresaTipoImpuesto.getEmpresa().getNombreEmpresa() + "\n Tipo Impuesto: " + empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto() + "\n Número de liquidación: " + nuevaLiquidacion.getNumeroLiquidacion() + "\n Fecha desde: " + nuevaLiquidacion.getFechaHoraDesdeLiquidacion() + "\n Fecha hasta: " + nuevaLiquidacion.getFechaHoraHastaLiquidacion(), new Date()));
                //Guardo nuevo LiquidacionEstado
                FachadaPersistencia.getInstance().guardar(liqEstado);
                //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
                cantidadLiquidacionesGeneradas++;
            }
            //Por cada tipo impuesto fin
            // }  //{del liquidada por si no hay q crearlas
        }

        if (cantidadLiquidacionesGeneradas == 0) {
            dtosAccionesSistema.add(new DTOAccionesSistema("FIN DE CÁLCULO DE LIQUIDACIONES", "No se generaron liquidaciones en estado Calculada.", new Date()));
        } else {
            dtosAccionesSistema.add(new DTOAccionesSistema("FIN DE CÁLCULO DE LIQUIDACIONES", "Se generaron un total de " + cantidadLiquidacionesGeneradas + " liquidaciones en estado Calculada.", new Date()));
        }

        return dtosAccionesSistema;
    }

}
