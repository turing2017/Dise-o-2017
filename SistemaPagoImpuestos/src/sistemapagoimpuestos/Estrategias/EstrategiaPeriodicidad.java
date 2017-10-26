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
public class EstrategiaPeriodicidad implements EstrategiaCalculoComision {

    @Override
    public Double obtenerValorComision(Operacion operacion) {

        String tipoPeriodicidad = "";
        Double porcentajeComision = 0.0;
        Double comisionCalculada = 0.0;
        Double importeOperacionPagado;

        if (!FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null).isEmpty()) {

            List<DetalleOperacion> listDetallesOp = operacion.getDetalleOperacionList();
            for (DetalleOperacion detalleOp : listDetallesOp) {

                if (detalleOp.getItemEmpresaTipoImpuesto().getItem().getNombreItem().equals("Periodicidad")) {
                    tipoPeriodicidad = detalleOp.getValorDetalleOperacion().toLowerCase();
                }
            }

            List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null);
            ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
            parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
            switch (tipoPeriodicidad) {
                case "mensual":
                    porcentajeComision = parametrosCalculoPeriodicidad.getMensualPCPeriodicidad();
                    break;
                case "bimestral":
                    porcentajeComision = parametrosCalculoPeriodicidad.getBimestralPCPeriodicidad();
                    break;
                case "trimestral":
                    porcentajeComision = parametrosCalculoPeriodicidad.getTrimestralPCPeriodicidad();
                    break;
                case "cuatrimestral":
                    porcentajeComision = parametrosCalculoPeriodicidad.getCuatrimestralPCPeriodicidad();
                    break;
                case "semestral":
                    porcentajeComision = parametrosCalculoPeriodicidad.getSemestralPCPeriodicidad();
                    break;
                case "anual":
                    porcentajeComision = parametrosCalculoPeriodicidad.getAnualPCPeriodicidad();
                    break;
                case "quincenal":
                    porcentajeComision = parametrosCalculoPeriodicidad.getQuincenalPCPeriodicidad();
                    break;
                default:
                    porcentajeComision = parametrosCalculoPeriodicidad.getMensualPCPeriodicidad();

            }
            importeOperacionPagado = operacion.getImportePagadoOperacion();
            comisionCalculada = importeOperacionPagado * porcentajeComision;

        } else {
            comisionCalculada = -1.0;
        }

        return comisionCalculada;
    }


}
