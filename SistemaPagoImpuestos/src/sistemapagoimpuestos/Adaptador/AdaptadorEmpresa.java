/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;

/**
 *
 * @author Maximiliano
 */
public interface AdaptadorEmpresa {
    public List<DTOComprobante> consultarComprobantes(EmpresaTipoImpuesto empresaTipoImpuesto, String codigoPagoElectronicoIngres);
    public boolean confirmarPago(String nroFactura, Integer codigoCP, double monto);
}
