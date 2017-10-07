/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaTipoImpuesto extends ExpertoGestionarEmpresaTipoImpuesto{

    public DecoradorGestionarEmpresaTipoImpuesto() {
    }
    
    @Override
    public List iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List tempString = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
    @Override
    public List buscarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List tempString = super.buscarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
    @Override
    public List ingresarDatosETI(String nombreTipoImpuesto, String nombreEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List tempString = super.ingresarDatosETI(nombreTipoImpuesto, nombreEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }

    @Override
    public List<DTOTipoEmpresa> obtenerTipoEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresa> listadoDTOTipoEmpresa = super.obtenerTipoEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDTOTipoEmpresa;
    }

    @Override
    public void nuevoEmpresaTipoImpuesto(String cuitEmpresa, String nombreTipoImpuesto, String nombreTipoEmpresa, int frecuencia) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoEmpresaTipoImpuesto(cuitEmpresa, nombreTipoImpuesto, nombreTipoEmpresa, frecuencia); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOItem> obtenerItems(String cuitEmpresa, int codigoTipoImpuesto) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOItem> listadoDTOItem = super.obtenerItems(cuitEmpresa, codigoTipoImpuesto); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDTOItem;
    }

    @Override
    public List<DTOItem> obtenerTodosItems() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOItem> listadoItems = super.obtenerTodosItems();
        FachadaInterna.getInstance().finalizarTransaccion();
        return  listadoItems;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, int orden) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.agregarItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, orden); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    
    
}
