/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.User.IUPagarImpuestoComprobantes;

/**
 *
 * @author mvissio
 */
public class ControladorPagarImpuestos {
    
    private ExpertoPagarImpuestos experto = (ExpertoPagarImpuestos) FabricaExpertos.getInstancia().crearExperto("CU02");

    public ControladorPagarImpuestos() {
    }

    // Método para recuperar los Tipo de Impuestos
    public List<DTOTipoImpuesto> buscarTipoImpuestos(){
        List<DTOTipoImpuesto> listado = experto.buscarTipoImpuestos();
        return listado;
    }
    
    // Método para recuperar las Empresas
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto){
        return experto.buscarEmpresas(nombreTipoImpuesto);
    }
    

    
    // Método para buscar las cuentas y saldos
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente){
        return experto.obtenerCuentas(cuilCliente);
    }
    
    public void seleccionarEmpresa(String nombreEmpresaIng, String codigoPagoElectronicoIngres){
        IUPagarImpuestoComprobantes pantallaComprobantes = new IUPagarImpuestoComprobantes(experto.seleccionarEmpresa(nombreEmpresaIng, codigoPagoElectronicoIngres));
        pantallaComprobantes.setVisible(true);
    }
}
