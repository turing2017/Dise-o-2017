/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;
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

    public void validadarUsuario() {
        try {
            experto.validarUsuario();
            IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
            iUPagarImpuesto.setVisible(true);
            
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es cliente");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }

    public List<DTOTipoImpuesto> buscarTipoImpuestos() {
        try {
            List<DTOTipoImpuesto> listado = experto.buscarTipoImpuestos();
            return listado;
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "No se pudieron encontrar tipos de impuesto");
            return null;
        }
    }

    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto) {
        try {
            return experto.buscarEmpresas(nombreTipoImpuesto);
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "No se pudieron encontrar Empresas");
            return null;
        }
    }

    public void seleccionarEmpresa(String nombreEmpresaIng, String codigoPagoElectronicoIngres) {
        try {
            IUPagarImpuestoComprobantes pantallaComprobantes = new IUPagarImpuestoComprobantes(
                    experto.seleccionarEmpresa(
                            nombreEmpresaIng,
                            codigoPagoElectronicoIngres));
            if (experto.isMontoEditable()) {
                pantallaComprobantes.setearEditable();
            } else {

            }
            pantallaComprobantes.setVisible(true);
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", e.getMessage());
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "No se encontró comprobantes de pago.");
            validadarUsuario();
        }
    }
    
    public boolean isMontoEditable() throws Exception {
        return experto.isMontoEditable();
    }

    public void obtenerCuentas(String cuilCliente, IUPagarImpuestoComprobantes pantallaComprobantes) {
        try {
            IUPagarImpuestoCuentas pantallaCuentas = new IUPagarImpuestoCuentas(experto.obtenerCuentas(cuilCliente), pantallaComprobantes);
            pantallaCuentas.setVisible(true);
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", e.getMessage());
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "Error al conectar el sistema");
        }
    }

    // Pagar impuesto
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String CodigoPago) {
        try {
            return experto.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, nroFactura, CodigoPago);
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", e.getMessage());
            return null;
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "Error al conectar el sistema");
            return null;
        }
    }
}
