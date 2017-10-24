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
import sistemapagoimpuestos.Dto.DTOEmpresaGEA;
import sistemapagoimpuestos.Dto.DTOTipoEmpresaGEA;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaAdherida extends ExpertoGestionarEmpresaAdherida{

    @Override
    public void modificarEmpresa(String cuit, String nombre, String direccion, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre,direccion, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
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
    public List<DTOEmpresaGEA> buscarEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresaGEA>  dtoE= super.buscarEmpresa();
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoE;
    }

    @Override
    public List<DTOTipoEmpresaGEA> buscarTipoEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoEmpresaGEA> listDTOTE =  super.buscarTipoEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOTE;
    }

    @Override
    public boolean camposNulos(String cuit, String nombre, String direccion) {
        FachadaInterna.getInstance().iniciarTransaccion();
        boolean bool = super.camposNulos(cuit, nombre, direccion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return bool;    
    }

    @Override
    public ArrayList<DTOEmpresaGEA> consultarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaGEA> dtoEGEA = super.consultarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEGEA;
    }

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String i = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return i;
    }
    }

   