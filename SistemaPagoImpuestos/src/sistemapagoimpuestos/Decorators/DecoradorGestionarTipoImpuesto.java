/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarTipoImpuesto extends ExpertoGestionarTipoImpuesto {

    public DecoradorGestionarTipoImpuesto() {
    }

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }

    @Override
    public DTOEmpresa buscarEmpresa(String cuitEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresa dtoEmpresa = super.buscarEmpresa(cuitEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEmpresa;
    }

    @Override
    public List<DTOTipoImpuesto> buscarTipoImpuesto() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoImpuesto> listdto =  super.buscarTipoImpuesto(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listdto;
    }

    @Override
    public List<DTOTipoEmpresa> buscarTipoEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresa> listdtoTI = super.buscarTipoEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listdtoTI;
    }

    @Override
    public int setearFrecuencia(String nombreTipoImpuesto, String cuitEmpresa, String nombreTipoEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        int frecuencia = super.setearFrecuencia(nombreTipoImpuesto, cuitEmpresa, nombreTipoEmpresa); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return frecuencia;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarETI(String nombreTE, String nombreTI, String cuit, String nuevoTE, String nuevoTI, int frec, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.ModificarETI(nombreTE, nombreTI, cuit, nuevoTE, nuevoTI, frec, habilitada);
        FachadaInterna.getInstance().finalizarTransaccion();
        //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public void modificarEmpresa(String cuit, String nombre, String nuevoTipoImpuesto, String nuevoTipoEmpresa, int frecuenciaLiquidacion) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre, nuevoTipoImpuesto, nuevoTipoEmpresa, frecuenciaLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres); 
        FachadaInterna.getInstance().finalizarTransaccion(); 
    }
    
    
    @Override
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOTipoImpuesto dtoti = super.obtenerTipoImpuesto(codigo); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoti;
    }

    @Override
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerEmpresaTipoImpuesto(String cuitEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaTipoImpuesto> dtoETI = super.obtenerEmpresaTipoImpuesto(cuitEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoETI;
    }

    @Override
    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarTipoImpuesto(nombreTipoImpuestoIngres, nombreActualTipoImpuesto, esMontoEditableIngres, habilitado); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos() {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto= super.obtenerTipoImpuestos(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDtoTipoImpuesto;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestosEmpresa(String cuitEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto = super.obtenerTipoImpuestosEmpresa(cuitEmpresa); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDtoTipoImpuesto;
    }

    @Override
    public void eliminarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, String nombreTipoEmpresa, int ordenItem) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.eliminarItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa, ordenItem); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
}
    