/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

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
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Gabriel
 */
public class ExpertoCalcularLiquidaciones {
    
    public ArrayList<DTOAccionesSistema> iniciar(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {
     
        
        //varaiables globales
        Liquidacion liquidacionAnulada = new Liquidacion();
        String nombreEstadoRecalculada = "Recalculada";
        String nombreEstadoAnulado = "Anulada";
        String nombreEstadoPendiente = "Calculada";
        List<DTOCriterio> criterios = new ArrayList();
        Date fechaALiquidar;
        int cantidadAnuladas = 0;
        int cantidadLiquidacionesGeneradas=0;
        
        dtosAccionesSistema.add(new DTOAccionesSistema("Comprobar Recalculos pendientes...","",new Date()));
        
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
                cantidadAnuladas++;
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
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("No existen operaciones");
                }
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
                liquidacionAnulada.setFechaHoraLiquidacion(new Date());
                //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(liquidacionAnulada);
                dtosAccionesSistema.add(new DTOAccionesSistema("Recalculando Liquidacion...","Empresa: "+liquidacionAnulada.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa()+" Tipo Impuesto :"+liquidacionAnulada.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto(),new Date()));
            }
            
        }
        dtosAccionesSistema.add(new DTOAccionesSistema("Fin comprobacion recalculos pendientes...",cantidadAnuladas+" Liquidaciones recalculadas",new Date()));
        /*
        ---------------------------------------
        INICIO CALCULO PARA LIQUIDACIONES NUEVAS
        ----------------------------------------
         */
        
         dtosAccionesSistema.add(new DTOAccionesSistema("Comprobacion Operaciones pendientes...","",new Date()));
         
        List<Object> listOperacion = new ArrayList();
        //busca empresaTipoImpuesto
        List<Object> EmpresaTipoImpuestoList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
        //loop por cada EmpresatipoImpuesto
        for (Object eTI : EmpresaTipoImpuestoList) {
            // crear una lista para las operaciones para poder buscar despues por rango de fechas
            List<Operacion> operacionesEnRangoDeFechas = new ArrayList();
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eTI;
            System.out.println("fecha: "+empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa()+empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
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
                Calendar calfechaLiquidacion = Calendar.getInstance();
                 //fecha de la condicion
                calfechaLiquidacion.setTime(ultimaLiquidacion.getFechaHoraHastaLiquidacion());
                 //sumo dias + frecuencia y eso lo asigno a fechaALiquidar
                calfechaLiquidacion.set(calfechaLiquidacion.get(Calendar.YEAR), calfechaLiquidacion.get(Calendar.MONTH), calfechaLiquidacion.get(Calendar.DAY_OF_MONTH)+frecuencia);
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
                        System.out.println("No existen operaciones");
                    }
                        for(Object op:listOperacion){
                   Operacion operacion = (Operacion)op;
                       System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
                       System.out.println(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
                       System.out.println(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                       System.out.println(operacion.getFechaHoraOperacion()+">"+ ultimaLiquidacion.getFechaHoraHastaLiquidacion()+" y "+operacion.getFechaHoraOperacion()+"<"+new Date());
                  if (operacion.getFechaHoraOperacion().after(ultimaLiquidacion.getFechaHoraHastaLiquidacion()) 
                          && operacion.getFechaHoraOperacion().before(new Date())) {
                      operacionesEnRangoDeFechas.add(operacion);
                    }
                   }
                }
            } else {
                //si NO tiene Liquidaciones generardas
                
                int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
                 Calendar calfechaLiquidacion = Calendar.getInstance();
                 calfechaLiquidacion.setTime(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                 calfechaLiquidacion.set(calfechaLiquidacion.get(Calendar.YEAR), calfechaLiquidacion.get(Calendar.MONTH), calfechaLiquidacion.get(Calendar.DAY_OF_MONTH)+frecuencia);
                 Date fechaLiquidacion =  calfechaLiquidacion.getTime();
                
                EmpresaTipoImpuesto emptia = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null).get(0);
                 fechaALiquidar = fechaLiquidacion;
                if (fechaALiquidar.before(new Date())) {
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
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("No existen operaciones");
                    }
                   for(Object op:listOperacion){
                   Operacion operacion = (Operacion)op;
                       System.out.println(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
                       System.out.println(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
                       System.out.println(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
                       System.out.println(operacion.getFechaHoraOperacion()+">"+ empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto()+"y"+operacion.getFechaHoraOperacion()+"<"+new Date());
                  if (operacion.getFechaHoraOperacion().after(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto()) 
                          && operacion.getFechaHoraOperacion().before(new Date())) {
                      operacionesEnRangoDeFechas.add(operacion);
                    }
                   }
                }
            }
            
               //buscar numero liquidacion
            List<Object> liquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion",null);
              int numeroLiquidacion  = 0;
            for (Object l:liquidacion) {
                     Liquidacion liq = (Liquidacion)l;
                     if (liq.getNumeroLiquidacion()>numeroLiquidacion){
                     numeroLiquidacion = liq.getNumeroLiquidacion();
                     }
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
                
                FachadaPersistencia.getInstance().guardar(operacion);
                FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
                FachadaPersistencia.getInstance().guardar(comision);
                
                dtosAccionesSistema.add(new DTOAccionesSistema("Calculando comision","Empresa: "+operacion.getEmpresa().getNombreEmpresa()+" Tipo Impuesto: "+operacion.getTipoImpuesto().getNombreTipoImpuesto(),new Date()));

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
            nuevaLiquidacion.getLiquidacionEstadoList().add(liqEstado);
            //setnumeroLiquidacion(numeroLiquidacion)
            
         
            
            
        
            //setNumeroLiquidacion
            nuevaLiquidacion.setNumeroLiquidacion(numeroLiquidacion+1);
            //setFechaHoraLiquidacion(fechaActual)
            nuevaLiquidacion.setFechaHoraLiquidacion(new Date());
           //setfechaHoraDesdeLiquidacion(fechahoraDesdeLiquidacion)
            nuevaLiquidacion.setFechaHoraDesdeLiquidacion(ultimaLiquidacion.getFechaHoraHastaLiquidacion()); //creo q asi, quiza explote en la 1era tengo miedo
            //setFechaHoraHastaLiquidacion
            nuevaLiquidacion.setFechaHoraHastaLiquidacion(new Date());
            //setEmpresaTipoImpuesto
            nuevaLiquidacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);
            nuevaLiquidacion.setFechaHoraLiquidacion(new Date());

            
            //Guardo nuevo LiquidacionEstado
            FachadaPersistencia.getInstance().guardar(liqEstado);
            //Guardo la liquidacion
            FachadaPersistencia.getInstance().guardar(nuevaLiquidacion);
            cantidadLiquidacionesGeneradas++;
             }
            //Por cada tipo impuesto fin
           // }  //{del liquidada por si no hay q crearlas
        }
        
       dtosAccionesSistema.add(new DTOAccionesSistema("Calculo Finalizado","Se generaron "+cantidadLiquidacionesGeneradas+" Liquidaciones",new Date()));
       return dtosAccionesSistema;
    }
}
