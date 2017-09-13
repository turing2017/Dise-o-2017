/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOConsultarEmpresas;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaAdherida extends ExpertoGestionarEmpresaAdherida{

    public DecoradorGestionarEmpresaAdherida() {
    }
    
    @Override
    public String iniciar() {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        String temporalUser = super.iniciar(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return temporalUser;
    }

    @Override
    public DTOEmpresaExistente cargarDatos(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa, String habilitada, String tipoEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresaExistente dtoEe= super.cargarDatos(cuitEmpresa, nombreEmpresa, direccionEmpresa, habilitada, tipoEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEe;
    }
    

    @Override
    public void modificarEmpresa(String cuit, String nombre, String direccion, boolean habilitada, String tipoEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre, direccion, habilitada, tipoEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    

   

    @Override
    public void ingresarDatosEmpresa(String cuit, String nombre, String direccion, String tipoEmpresa, boolean habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.ingresarDatosEmpresa(cuit, nombre, direccion, tipoEmpresa, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOEmpresa> consultarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresa> dtoe=  super.consultarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoe;
    }

    @Override
    public List<DTOTipoEmpresa> buscarTiposDeEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
         List<DTOTipoEmpresa> dtoTipoEmpresa =super.buscarTiposDeEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoTipoEmpresa;
    }

   

    }

   