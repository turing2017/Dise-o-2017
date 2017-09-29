/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaAdherida extends ExpertoGestionarEmpresaAdherida{

    @Override
    public void modificarItemEmpresaTipoImpuesto(DTOEmpresaTipImpItem dTOEmpresaTipImpItemList) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarItemEmpresaTipoImpuesto(dTOEmpresaTipImpItemList);
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public void modificarEmpresa(String cuit,String nombre,String nuevoTipoImpuesto, String anteriorTipoImpuesto, String nuevoTipoEmpresa,String anteriorTipoEmpresa, String direccion,boolean habilitada, int frecuenciaLiquidacion) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre, nuevoTipoImpuesto, anteriorTipoImpuesto, nuevoTipoEmpresa, anteriorTipoEmpresa, direccion, habilitada, frecuenciaLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public List<ItemEmpresaTipoImpuesto> setearTabla(Vector vct) {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<ItemEmpresaTipoImpuesto> listIETI = super.setearTabla(vct); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listIETI;
    }

    @Override
    public List<DTOItem> buscarItems() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOItem>  dtoI= super.buscarItems(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoI;
    }

    @Override
    public boolean camposNulos(String cuit, String nombre, String direccion) {
        FachadaInterna.getInstance().iniciarTransaccion();
        boolean cn = super.camposNulos(cuit, nombre, direccion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return cn;
    }

    @Override
    public DTOEmpresaExistente cargarDatos(String cuitEmpresa, String nombreEmpresa, String tipoImpuesto, String tipoEmpresa, String frecuenciaEmpresaTipoImpuesto, String direccionEmpresa, String habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresaExistente dtoEe = super.cargarDatos(cuitEmpresa, nombreEmpresa, tipoImpuesto, tipoEmpresa, frecuenciaEmpresaTipoImpuesto, direccionEmpresa, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEe;
    }

    

    

//    @Override
//    public void modificarEmpresa(String cuit, String nombre, String tipoImpuesto, String tipoEmpresa, String direccion, boolean habilitada, Date fechaLiquidacion) {
//        FachadaInterna.getInstance().iniciarTransaccion();
//        super.modificarEmpresa(cuit, nombre, tipoImpuesto, tipoEmpresa, direccion, habilitada, fechaLiquidacion); //To change body of generated methods, choose Tools | Templates.
//        FachadaInterna.getInstance().finalizarTransaccion();
//    }

    @Override
    public void ingresarDatosEmpresa(String cuit, String nombre, String tipoImpuesto, String tipoEmpresa, int frecuencia ,String direccion, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.ingresarDatosEmpresa(cuit, nombre, tipoImpuesto, tipoEmpresa, frecuencia ,direccion, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

   

    @Override
    public List<DTOTipoImpuesto> buscarTipoImpuesto() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoImpuesto> listDTOTI = super.buscarTipoImpuesto(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOTI;
    }

    @Override
    public List<DTOTipoEmpresa> buscarTipoEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresa> listDTOTE =  super.buscarTipoEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOTE;
    }

    @Override
    public ArrayList<DTOEmpresaTipoImpuesto> consultarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaTipoImpuesto> listDTOTI = super.consultarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOTI;
    }

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String i = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return i;
    }

    

    }

   