/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
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
    public List<DTOComprobante> consultarComprobantes(String tipoImpuesto, String nombreEmpresa, String codigoPagoElectronicoIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOComprobante> listadoDTOComprobante = super.consultarComprobantes(tipoImpuesto,nombreEmpresa,codigoPagoElectronicoIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDTOComprobante;
    }

    @Override
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOCuentaBancaria> listaCuentasBancarias = super.obtenerCuentas(cuilCliente);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listaCuentasBancarias;
    }
    
    
}
