/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Comision;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.EstadoLiquidacion;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.LiquidacionEstado;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Estrategias.EstrategiaCalculoComision;
import sistemapagoimpuestos.Fabricas.FabricaEstrategias;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Gabriel
 */
public class ExpertoCalcularLiquidaciones {
    
    public void iniciar() {

        //varaiables globales
        Liquidacion liquidacionAnulada = new Liquidacion();
        String nombreEstadoRecalculada = "Recalculado";
        String nombreEstadoAnulado = "ARecalcular";
        String nombreEstadoPendiente = "Pendiente";
        String nombreEstadoCreada = "Pendiente";
        List<DTOCriterio> criterios = new ArrayList();

        //buscar "EstadoLiquidacion","nombreEstadoLiquidacion=Anulada"
        DTOCriterio criterio = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoAnulado);
        criterios.add(criterio);
        EstadoLiquidacion estadoLiquidacion = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
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
                //buscar "Liquidacion","LiquidacionEstado="+liquidacionEstado.toString()

                /*         DTOCriterio criterio2 = new DTOCriterio("liquidacionEstado", "contains", liquidacionEstado);
                criterios.clear();
                criterios.add(criterio2);
                 */
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
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("No existen operaciones");
                }
                // loop por cada operacion

                //INCOMPLETO FALTA IMPLEMENTAR LOS METODOS DE LAS ESTRATEGIAS Y SETEAR MAS RELACIONES
                for (Object op : listOperacion) {
                    Operacion operacion = (Operacion) op;
                    Double valorComision;
                    EstrategiaCalculoComision estrategia = FabricaEstrategias.getInstancia().obtenerEstrategia((Operacion) operacion);
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
                List<LiquidacionEstado> listLiqEstados = liquidacionAnulada.getLiquidacionEstadoList();
                //Agrego el nuevo estado
                listLiqEstados.add(liqEstado);
                liquidacionAnulada.setLiquidacionEstadoList(listLiqEstados);
                //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(liquidacionAnulada);
            }
            
        }
        /*
        ---------------------------------------
        INICIO CALCULO PARA LIQUIDACIONES NUEVAS
        ----------------------------------------
         */
        
        
        List<Object> listOperacion = new ArrayList();
        //busca empresaTipoImpuesto
        List<Object> EmpresaTipoImpuestoList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
        //loop por cada EmpresatipoImpuesto
        for (Object eTI : EmpresaTipoImpuestoList) {
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eTI;
         //buscar "Liquidacion", "empresaTipoImpuesto = "empresaTipoImpuesto.toString()"" 
            DTOCriterio criterio9 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
            criterios.clear();
            criterios.add(criterio9);
            List<Object> liquidaciones = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);

           
            //Metodo Vandenbosch para tener una fecha 0 a la que comprara el 1ero
            Date date0 = new Date();
            date0.setYear(1992);
            Liquidacion ultimaLiquidacion = new Liquidacion();
            ultimaLiquidacion.setFechaHoraLiquidacion(date0);
            // fin metodo vandenbosch
            
             //Si tiene Liquidaciones generadas
            if (liquidaciones != null) {
                for (Object liquidacion : liquidaciones) {
                    //Buscar la ultima liquidacion con la fechaHoraHasta mas reciente
                    Liquidacion liq = (Liquidacion) liquidacion;
                    liq.getFechaHoraHastaLiquidacion();
                    if (liq.getFechaHoraLiquidacion().after(ultimaLiquidacion.getFechaHoraLiquidacion())) {
                        ultimaLiquidacion = liq;
                    }
                    
                }

                //get frecuencia
                int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
                
                Date fechaLiquidacion = ultimaLiquidacion.getFechaHoraLiquidacion();
                //fecha de la condicion
                fechaLiquidacion.setDate(fechaLiquidacion.getDate() + frecuencia);
                Date fechaALiquidar = fechaLiquidacion;
                
                Date d = new Date();
                if (fechaALiquidar.after(d)) {
                    //  buscar Operacion
                    
                    DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", ultimaLiquidacion.getFechaHoraLiquidacion());
                    DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", new Date());
                    DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
                    criterios.clear();
                    criterios.add(criterio3);
                    criterios.add(criterio4);
                    criterios.add(criterio5);
                    
                    try {
                        listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("No existen operaciones");
                    }
                    
                }
            } else {
                //No tiene Liquidaciones generardas
                Date d = new Date();
                int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
                Date fechaLiquidacion = empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto();
                fechaLiquidacion.setDate(fechaLiquidacion.getDate() + frecuencia);
                if (fechaLiquidacion.after(d)) {
                    // buscar Operacion
                    
                    DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                    DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", new Date());
                    DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
                    criterios.clear();
                    criterios.add(criterio3);
                    criterios.add(criterio4);
                    criterios.add(criterio5);
                    
                    try {
                        listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("No existen operaciones");
                    }
                    
                }
            }
            //new liquidacion
            Liquidacion nuevaLiquidacion = new Liquidacion();

            //por cada Operacion
            for (Object lo : listOperacion) {
                Operacion operacion = (Operacion) lo;
                
                Double valorComision;
                EstrategiaCalculoComision estrategia = FabricaEstrategias.getInstancia().obtenerEstrategia((Operacion) operacion);
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
                
                FachadaPersistencia.getInstance().guardar(operacion);
                FachadaPersistencia.getInstance().guardar(comision);

                //fin loop por cada operacion
            }
            
            DTOCriterio criterio8 = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoCreada);
            criterios.clear();
            criterios.add(criterio8);
            EstadoLiquidacion estadoLiquidacionPendiente = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
            
            LiquidacionEstado liqEstado = new LiquidacionEstado();
            liqEstado.setFechaHoraDesdeLiquidacionEstado(new Date());
            liqEstado.setEstadoLiquidacion(estadoLiquidacionPendiente);
            //Guardo nuevo estado
            FachadaPersistencia.getInstance().guardar(liqEstado);
            nuevaLiquidacion.getLiquidacionEstadoList().add(liqEstado);
            //ver como genearar el numero
            nuevaLiquidacion.setNumeroLiquidacion(ultimaLiquidacion.getNumeroLiquidacion() + 1);
            nuevaLiquidacion.setFechaHoraLiquidacion(new Date());
            //creo q asi, quiza explote en la 1era tengo miedo
            nuevaLiquidacion.setFechaHoraDesdeLiquidacion(ultimaLiquidacion.getFechaHoraHastaLiquidacion());
            nuevaLiquidacion.setFechaHoraHastaLiquidacion(new Date());
            nuevaLiquidacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);

            //Guardo la liquidacion
            FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);

            //Por cada tipo impuesto fin
        }
        
    }
}
