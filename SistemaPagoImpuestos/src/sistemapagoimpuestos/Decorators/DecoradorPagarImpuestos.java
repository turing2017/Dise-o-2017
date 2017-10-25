/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresaIUPagar;
import sistemapagoimpuestos.Dto.DTOOperacionActual;
import sistemapagoimpuestos.Dto.DTOTipoImpuestoIUPagar;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorPagarImpuestos extends ExpertoPagarImpuestos{

    public DecoradorPagarImpuestos() {
    }

    @Override
    public void validarUsuario()  throws Exception {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.validarUsuario(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DTOOperacionActual pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String codigoPago)  throws Exception{
        DTOOperacionActual dtoOperacion = super.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, nroFactura, codigoPago);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoOperacion;
    }


    
    
}
