/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Estrategias;

import java.util.List;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.ParametroCalculoEditable;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author ggiorgi
 */
public class EstrategiaEditable implements EstrategiaCalculoComision {

    @Override
    public Double obtenerValorComision(Operacion operacion) {
      
        Double porcentajeComision = 0.0;
        boolean isMontoEditable = operacion.getTipoImpuesto().isEsMontoEditableTipoImpuesto();
        //Traemos los parametros de calculo Editable
        ParametroCalculoEditable parametrosCalculoEditable;
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoEditable", null);
        parametrosCalculoEditable = (ParametroCalculoEditable) parametros.get(0);

        if (isMontoEditable) {
            porcentajeComision = parametrosCalculoEditable.getSiEditablePCEditable();
        } else {
            porcentajeComision = parametrosCalculoEditable.getNoEditablePCEditable();
        }
        return operacion.getImportePagadoOperacion() * porcentajeComision;
    }
    
}
