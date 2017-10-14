/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import exceptions.ExcepcionGenerica;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
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
    public void validarUsuario() throws ExcepcionGenerica {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.validarUsuario(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    

    @Override
    public List<DTOTipoImpuesto> buscarTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoImpuesto> listaDTOTipoImpuesto = super.buscarTipoImpuestos();
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaDTOTipoImpuesto;
    }

    @Override
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresa> listaDTOEmpresa = super.buscarEmpresas(nombreTipoImpuesto);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaDTOEmpresa;
    }

    @Override
    public List<DTOComprobantePantalla> seleccionarEmpresa( String nombreEmpresa, String codigoPagoElectronicoIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOComprobantePantalla> listadoDTOComprobantepantalla = super.seleccionarEmpresa(nombreEmpresa,codigoPagoElectronicoIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDTOComprobantepantalla;
    }

    @Override
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOCuentaBancaria> listaCuentasBancarias = super.obtenerCuentas(cuilCliente);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaCuentasBancarias;
    }

    @Override
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String codigoPago) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOOperacion dtoOperacion = super.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, nroFactura, codigoPago);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoOperacion;
    }

    @Override
    public boolean MontoEditable() {
        return  super.MontoEditable();
    }
    
    
}
