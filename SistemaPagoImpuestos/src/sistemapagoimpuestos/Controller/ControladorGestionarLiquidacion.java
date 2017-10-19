/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Dto.DTOLiquidacionEstado;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Expert.ExpertoGestionarLiquidacion;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUGestionarLiquidacion;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUMostrar;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUMostrarHistorialEstados;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuesto;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;

/**
 *
 * @author facun
 */
public class ControladorGestionarLiquidacion {

    private ExpertoGestionarLiquidacion experto = (ExpertoGestionarLiquidacion) FabricaExpertos.getInstancia().crearExperto("CU21");

    public void validarUsuario() {
        try {
            experto.validarUsuario();
            IUGestionarLiquidacion UIGestionaLiquidacion = new IUGestionarLiquidacion();
            UIGestionaLiquidacion.setVisible(true);

        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es Administrador");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }

    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos() {
        return experto.obtenerTipoImpuestos();
    }

    public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(String nombreTipoImpuesto) {
        return experto.obtenerEmpresarelacionadaATipoImpuesto(nombreTipoImpuesto);
    }

    public List<DTOEmpresa> buscarEmpresas() {
        List<DTOEmpresa> listado = experto.buscarEmpresas();
        return listado;
    }

    public ArrayList<DTOLiquidacion> buscarLiquidacion() {
        return experto.obtenerLiquidacion();
    }

    public void AprobarLiquidacion(String numeroLiquidacion) {
        experto.AprobarLiquidacion(numeroLiquidacion);

    }

    public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta) {
        return experto.buscarLiquidacionConFiltro(nombreTipoImpuesto, nombreEmpresa, fechaDesde, fechaHasta);
    }

    public ArrayList<DTOOperacion> buscarOperaciones(String numeroLiquidacion) {
        return experto.buscarOperaciones(numeroLiquidacion);
    }

    public DTOLiquidacion mostrar(String numeroLiquidacion, Date fechaDesde, Date fechaHasta, String estado) {
        return experto.mostrar(numeroLiquidacion, fechaDesde, fechaHasta, estado);
    }

    public void AnularLiquidacion(String nroLiquidacion) {
        experto.AnularLiquidacion(nroLiquidacion);
    }

    public List<DTOLiquidacionEstado> buscarLiquidacionEstado(String numeroLiquidacion) {

        return experto.buscarLiquidacionEstado(numeroLiquidacion);
    }

    public void pantallaIUmostrarHistorialEstados(String nliquidacion, String fechaliquidacion) {
        IUMostrarHistorialEstados mostrarHistorico = new IUMostrarHistorialEstados(nliquidacion, fechaliquidacion);
    }

    public void pantallaIUmostrar(String nliquidacion, Date fechaDesde, Date fechaHasta, String estado) {
        IUMostrar mostrar = new IUMostrar(nliquidacion, fechaDesde, fechaHasta, estado);
    }

}
