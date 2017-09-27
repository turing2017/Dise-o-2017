/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

/**
 *
 * @author Gabriel
 */
public class ExpertoCalcularLiquidaciones {
    
    public void iniciar() {/*
    //     FachadaInterna.getInstance().iniciarTransaccion();
        //varaiables globales
        String nombreEstadoAnulado = "ARecalcular";
         List<DTOCriterio> criterios = new ArrayList();
        
        //buscar "EstadoLiquidacion","nombreEstadoLiquidacion=Anulada"
        DTOCriterio criterio = new DTOCriterio("nombreEstadoLiquidacion","=",nombreEstadoAnulado);
        criterios.add(criterio);
        EstadoLiquidacion estadoLiquidacion =(EstadoLiquidacion)FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
        //buscar "LiquidacionEstado","EstadoLiquidacion="+estadoLiquidacion.toString()
        DTOCriterio criterio1 = new DTOCriterio("estadoLiquidacion","=",estadoLiquidacion);
        criterios.clear();
        criterios.add(criterio1);
        List <Object> listLiquidacionEstado = FachadaPersistencia.getInstance().buscar("LiquidacionEstado", criterios);
        
        //por cada liquidacion Estado
        for (Object objlistLiquidacion: listLiquidacionEstado) {
            LiquidacionEstado liquidacionEstado = (LiquidacionEstado) objlistLiquidacion;
        //getfechaHoraHastaLiquidacion    
           Date fechaHasta = liquidacionEstado.getFechaHoraHastaLiquidacionEstado();
        // alt si fechaHoraHastaLiquidacion is null
            if (fechaHasta == null) {
                
        //buscar "Liquidacion","LiquidacionEstado="+liquidacionEstado.toString()
        DTOCriterio criterio2 = new DTOCriterio("iquidacionEstado","=",liquidacionEstado); 
        criterios.clear();
        criterios.add(criterio2);
         Liquidacion liquidacion = (Liquidacion)FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);
        //getfechaHoradesdeLiquidacion
       Date fechaDesdeLiquidacion = liquidacion.getFechaHoraDesdeLiquidacion();
        //getfechaHoraHastaLiquidacion
       Date fechaHastaLiquidacion =liquidacion.getFechaHoraHastaLiquidacion();
        //getEmpresaTipoImpuesto
       EmpresaTipoImpuesto empresaTipoImpuesto = liquidacion.getEmpresaTipoImpuesto();
        //buscar "Operacion", "fechaHoraOperacion >= fechaHoraDesdeLiquidacion AND fechaOperacion <= fechaHoraHastaLiquidacion AND EmpresaTipoImpuesto="+empresaTipoImpuesto.toString()
        DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion",">=",fechaDesdeLiquidacion); 
        DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion","<=",fechaHastaLiquidacion); 
        DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto","<=",empresaTipoImpuesto); 
        criterios.clear();
        criterios.add(criterio3);
        criterios.add(criterio4);
        criterios.add(criterio5);
         List<Object> listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
         // loop por cada operacion
         for (Object objlistOperacion : listOperacion) {
                Operacion operacion = (Operacion) objlistOperacion;
                
                
                
           //fin loop por cada operacion     
            }
            //fin si la fecha es nulla
            }
//fin loop por cada liquidacion
        }
    //    FachadaInterna.getInstance().finalizarTransaccion();
  //fin metodo iniciar      
    }
*/
}
