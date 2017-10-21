/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.TransactionException;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.FachadaInterna;
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
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
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
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
            return null;
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "No se pudieron encontrar tipos de impuesto");
            return null;
        }
    }

    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto) {
        try {
            return experto.buscarEmpresas(nombreTipoImpuesto);
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
            return null;
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "No se pudieron encontrar Empresas");
            return null;
        }
    }

    public List<DTOComprobantePantalla> seleccionarEmpresa(String nombreEmpresaIng, String codigoPagoElectronicoIngres) {
        try {
            return experto.seleccionarEmpresa(nombreEmpresaIng, codigoPagoElectronicoIngres);
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
            return null;
        } catch (NumberFormatException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "Solo se deben ingresar numeros.");
            return null;
        } catch (Exception e) {
            validadarUsuario();
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "No se encontró comprobantes de pago.");
            return null;
        }
    }

    public void mostrarPantallaComprobantes(List<DTOComprobantePantalla> listaComprobantePantalla, boolean esEditable) {
        IUPagarImpuestoComprobantes pantallaComprobantes = new IUPagarImpuestoComprobantes(listaComprobantePantalla, esEditable);
        pantallaComprobantes.setVisible(true);
    }

    public boolean isMontoEditable() {
        return experto.isMontoEditable();
    }

    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente) {
        try {
            return experto.obtenerCuentas(cuilCliente);
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
            return null;
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "Error al conectar el sistema");
            return null;
        }
    }

    // Pagar impuesto
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String CodigoPago) {
        try {
            return experto.pagarImpuesto(cbuCuentaSeleccionada, montoAbonado, nroFactura, CodigoPago);
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
            return null;
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", e.getMessage());
            return null;
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Pagar Impuesto", "Error al conectar el sistema");
            return null;
        }
    }
}
