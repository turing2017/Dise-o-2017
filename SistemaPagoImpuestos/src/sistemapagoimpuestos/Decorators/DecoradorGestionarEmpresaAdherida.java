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
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DtoItemOrden;
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
    public void modificarEmpresa(String cuit, String nombre, String nombreAntiguo, String direccion, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre,nombreAntiguo, direccion, habilitada); //To change body of generated methods, choose Tools | Templates.
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
    public void ingresarDatosEmpresaCrear(String cuit, String nombre, String direccion, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion(); 
        super.ingresarDatosEmpresaCrear(cuit, nombre, direccion, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }


    @Override
    public DTOEmpresaExistente cargarDatos(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa, String habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresaExistente dtoEe = super.cargarDatos(cuitEmpresa, nombreEmpresa, direccionEmpresa, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEe;
    }

    @Override
    public void ingresarDatosEmpresa(String cuitEmpresa, String tipoImpuesto, String tipoEmpresa, int frecuencia) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.ingresarDatosEmpresa(cuitEmpresa, tipoImpuesto, tipoEmpresa, frecuencia); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public List<DTOEmpresa> buscarEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresa>  dtoE= super.buscarEmpresa();
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoE;
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
    public ArrayList<DTOEmpresa> consultarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresa> listDTOe = super.consultarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOe;
    }

   

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String i = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return i;
    }

    

    }

   