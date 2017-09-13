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

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }

    @Override
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres); 
        FachadaInterna.getInstance().finalizarTransaccion(); 
    }

    @Override
    public void nuevaEmpresaTipoImpuesto(String nombreTipoImpuestoIngres, List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItems) {
        FachadaInterna.getInstance().iniciarTransaccion(); 
        super.nuevaEmpresaTipoImpuesto(nombreTipoImpuestoIngres, dTOEmpresaTipImpItems); //To change body of generated methods, choose Tools | Templates.
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
    public ArrayList<DTOEmpresaItem> obtenerEmpresaItem() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaItem> empresaItems= super.obtenerEmpresaItem();
        FachadaInterna.getInstance().finalizarTransaccion();
        return empresaItems;
    }

    @Override
    public List<DTOEmpresa> buscarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresa> tempString = super.buscarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
     
    @Override
    public List<DTOItem> buscarItems() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOItem> tempString = super.buscarItems(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }

    @Override
    public List<DTOTipoEmpresa> buscarTipoEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresa> tempDtoTipoEmpresa = super.buscarTipoEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempDtoTipoEmpresa;
    }

    @Override
    public void nuevaEmpresaTipoImpuestoItem(String nombreTipoImpuestoIngres, List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItem) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevaEmpresaTipoImpuestoItem(nombreTipoImpuestoIngres, dTOEmpresaTipImpItem); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    
    
    
}
    