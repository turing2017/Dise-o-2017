/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.User.IUPagarImpuestoComprobantes;
import sistemapagoimpuestos.View.User.IUPagarImpuestoCuentas;

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
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuestoSelec){
        return experto.buscarEmpresas(nombreTipoImpuestoSelec);
    }
    
    // Método para buscar las cuentas y saldos
    public void obtenerCuentas(String cuilCliente, IUPagarImpuestoComprobantes pantallaComprobantes){
        IUPagarImpuestoCuentas pantallaCuentas = new IUPagarImpuestoCuentas(experto.obtenerCuentas(cuilCliente), pantallaComprobantes);
        pantallaCuentas.setVisible(true);
    }
    
    public void seleccionarEmpresa(String nombreEmpresaIngres, String codigoPagoElectronicoIngres, String nombreTipoImpuestoIngres){
        IUPagarImpuestoComprobantes pantallaComprobantes = new IUPagarImpuestoComprobantes(experto.seleccionarEmpresa(nombreEmpresaIngres, codigoPagoElectronicoIngres), codigoPagoElectronicoIngres, nombreEmpresaIngres, nombreTipoImpuestoIngres);
        // Si es editable se debe mostrar para que edite, falta esta funcionalidad
        if (empresaTipoImpuestoEsEditable()) {
            pantallaComprobantes.setearEditable();
        }
        pantallaComprobantes.setVisible(true);
    }
    
    // Verifico si la empresa tipoImpuesto es editable
    public boolean empresaTipoImpuestoEsEditable(){
        return experto.getTipoImpuesto().isEsMontoEditableTipoImpuesto();
    }
    
    // Pagar impuesto
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, DTOComprobante dtoComprobante, String codigoPagoIngres, String empresaSelec, String tipoImpuestoSelec){
        return experto.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, dtoComprobante, codigoPagoIngres, empresaSelec, tipoImpuestoSelec);
    }
    
    public boolean tipoImpuestoEditable(String nombreTipoImpuesto){
        return experto.tipoImpuestoEditable(nombreTipoImpuesto);
    }
}
