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
import sistemapagoimpuestos.Dto.DTOEmpresaGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaAdherida extends ExpertoGestionarEmpresaAdherida{


    @Override
    public void modificarEmpresa(String cuit, String nombre, String nombreAntiguo, String direccion, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre,nombreAntiguo, direccion, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public void ingresarDatosEmpresaCrear(String cuit, String nombre, String direccion, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion(); 
        super.ingresarDatosEmpresaCrear(cuit, nombre, direccion, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOEmpresa> consultarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion(); 
        ArrayList<DTOEmpresa> dtoEmpresa = super.consultarEmpresas();
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEmpresa;//To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public DTOEmpresaExistente cargarDatos(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa, String habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresaExistente dtoEe = super.cargarDatos(cuitEmpresa, nombreEmpresa, direccionEmpresa, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEe;
    }

    @Override
    public List<DTOEmpresaGestionarEmpresaAdherida> buscarEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresaGestionarEmpresaAdherida>  dtoE = super.buscarEmpresa(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoE;//To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<DTOTipoEmpresa> buscarTipoEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresa> listDTOTE =  super.buscarTipoEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOTE;
    }

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String i = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return i;
    }

    

    }

   