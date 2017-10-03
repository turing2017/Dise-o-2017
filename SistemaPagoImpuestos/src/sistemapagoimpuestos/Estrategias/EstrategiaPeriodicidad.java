/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Estrategias;

import java.util.List;
import sistemapagoimpuestos.Entity.DetalleOperacion;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.ParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author ggiorgi
 */
public class EstrategiaPeriodicidad implements EstrategiaCalculoComision{
    
    @Override
    public Double obtenerValorComision(Operacion operacion) {
       
       String tipoPeriodicidad = "";
       Double porcentajeComision = 0.0;
       Double comisionCalculada;
       Double importeOperacionPagado;
      
       List<DetalleOperacion> listDetallesOp = operacion.getDetalleOperacionList() ;
       for (DetalleOperacion detalleOp : listDetallesOp){
          if (detalleOp.getItemEmpresaTipoImpuesto().isIndicaPeriodicidadItemEmpresaTipoImpuesto()){
              tipoPeriodicidad = detalleOp.getValorDetalleOperacion().toLowerCase();
          }
       }
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null);
        ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
        parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
        switch (tipoPeriodicidad) {
            case "mensual":
            case "30":
                porcentajeComision = parametrosCalculoPeriodicidad.getMensualPCPeriodicidad();
                break;
            case "bimestral":
            case "60":
                porcentajeComision = parametrosCalculoPeriodicidad.getBimestralPCPeriodicidad();
                break;
            case "trimestral":
            case "90":
                porcentajeComision = parametrosCalculoPeriodicidad.getTrimestralPCPeriodicidad();
                break;
            case "cuatrimestral":
            case "120":
                porcentajeComision = parametrosCalculoPeriodicidad.getCuatrimestralPCPeriodicidad();
                break;
            case "semestral":
            case "180":
                porcentajeComision = parametrosCalculoPeriodicidad.getSemestralPCPeriodicidad();
                break;
            case "anual":
            case "360":
                porcentajeComision = parametrosCalculoPeriodicidad.getAnualPCPeriodicidad();
                break;
            case "quincenal":
            case "15":
                porcentajeComision = parametrosCalculoPeriodicidad.getQuincenalPCPeriodicidad();
                break;
                default: porcentajeComision = parametrosCalculoPeriodicidad.getMensualPCPeriodicidad();

        }
        importeOperacionPagado = operacion.getImportePagadoOperacion();
        comisionCalculada = importeOperacionPagado * porcentajeComision;
        return comisionCalculada;
    }
}
