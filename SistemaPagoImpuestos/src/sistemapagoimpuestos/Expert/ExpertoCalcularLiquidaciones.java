/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Comision;
import sistemapagoimpuestos.Entity.DetalleOperacion;
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
        String nombreEstadoAnulado = "ARecalcular";
        String nombreEstadoRecalcular = "Recalculada";
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
                DTOCriterio criterio2 = new DTOCriterio("liquidacionEstado", "=", liquidacionEstado);
                criterios.clear();
                criterios.add(criterio2);
                Liquidacion liquidacion = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);
                //getfechaHoradesdeLiquidacion
                Date fechaDesdeLiquidacion = liquidacion.getFechaHoraDesdeLiquidacion();
                //getfechaHoraHastaLiquidacion
                Date fechaHastaLiquidacion = liquidacion.getFechaHoraHastaLiquidacion();
                //getEmpresaTipoImpuesto
                EmpresaTipoImpuesto empresaTipoImpuesto = liquidacion.getEmpresaTipoImpuesto();
                //buscar "Operacion", "fechaHoraOperacion >= fechaHoraDesdeLiquidacion AND fechaOperacion <= fechaHoraHastaLiquidacion AND EmpresaTipoImpuesto="+empresaTipoImpuesto.toString()
                DTOCriterio criterio3 = new DTOCriterio("fechaHoraOperacion", ">=", fechaDesdeLiquidacion);
                DTOCriterio criterio4 = new DTOCriterio("fechaHoraOperacion", "<=", fechaHastaLiquidacion);
                DTOCriterio criterio5 = new DTOCriterio("empresaTipoImpuesto", "<=", empresaTipoImpuesto);
                criterios.clear();
                criterios.add(criterio3);
                criterios.add(criterio4);
                criterios.add(criterio5);
                List<Object> listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
                // loop por cada operacion

                
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
                    List<Comision> listComision = liquidacion.getComisionList();
                    listComision.add(comision);
                    liquidacion.setComisionList(listComision);
                    FachadaPersistencia.getInstance().guardar(operacion);
                    FachadaPersistencia.getInstance().guardar(comision);
                 
                   
                }
                liquidacionEstado.setFechaHoraHastaLiquidacionEstado(new Date());
                FachadaPersistencia.getInstance().guardar(liquidacionEstado);
                // Busco el estado recalculada
                DTOCriterio criterio8 = new DTOCriterio("nombreEstadoLiquidacion", "=", nombreEstadoRecalcular);
                criterios.clear();
                criterios.add(criterio8);
                EstadoLiquidacion estadoLiquidacionRecalculada= (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);
                LiquidacionEstado liqEstado = new LiquidacionEstado();
                liqEstado.setFechaHoraDesdeLiquidacionEstado(new Date());
                liqEstado.setEstadoLiquidacion(estadoLiquidacionRecalculada);
                //Guardo nuevo estado
                FachadaPersistencia.getInstance().guardar(liqEstado);
                List<LiquidacionEstado> listLiqEstados = liquidacion.getLiquidacionEstadoList();
                //Agrego el nuevo estado
                listLiqEstados.add(liqEstado);
                liquidacion.setLiquidacionEstadoList(listLiqEstados);
                 //Guardo la liquidacion
                FachadaPersistencia.getInstance().guardar(liquidacion);
            }

        }
    }
}
