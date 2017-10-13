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
import sistemapagoimpuestos.Dto.DtoItemOrden;
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
    public void modificarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, String nombreTipoEmpresa, int orden, int ordenAnterior) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa, orden, ordenAnterior);
        FachadaInterna.getInstance().finalizarTransaccion();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, String nombreTE, int orden) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.agregarItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, nombreTE, orden);
        FachadaInterna.getInstance().finalizarTransaccion();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DTOItem> obtenerTodosItems() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOItem> dtoItem =  super.obtenerTodosItems();
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoItem;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DtoItemOrden> obtenerItems(String cuitEmpresa, int codigoTipoImpuesto, String nombreTE) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DtoItemOrden> listDtoItem = super.obtenerItems(cuitEmpresa, codigoTipoImpuesto, nombreTE);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDtoItem;
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevoEmpresaTipoImpuesto(String cuitEmpresa, String nombreTipoImpuesto, String nombreTipoEmpresa, int frecuencia) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoEmpresaTipoImpuesto(cuitEmpresa, nombreTipoImpuesto, nombreTipoEmpresa, frecuencia);
        FachadaInterna.getInstance().finalizarTransaccion();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DTOTipoEmpresa> obtenerTipoEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresa> dtoTE = super.obtenerTipoEmpresas();
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoTE;//To change body of generated methods, choose Tools | Templates.
    }

}
