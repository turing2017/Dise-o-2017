/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaAdherida extends ExpertoGestionarEmpresaAdherida{

    @Override
    public String iniciar() {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        String temporalUser = super.iniciar(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return temporalUser;
    }

    @Override
    public DTOEmpresaExistente cargarDatos(String cuitEmpresa, String nombreEmpresa, String tipoImpuesto, String tipoEmpresa, String direccionEmpresa, String habilitada) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresaExistente dtoEe= super.cargarDatos(cuitEmpresa, nombreEmpresa,tipoImpuesto, tipoEmpresa, direccionEmpresa, habilitada); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoEe;
    }
    

    @Override
    public void modificarEmpresa(String cuit,String nombre,String tipoImpuesto, String tipoEmpresa, String direccion,boolean habilitada, String fechaLiquidacion) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarEmpresa(cuit, nombre, tipoImpuesto, tipoEmpresa, direccion,  habilitada, fechaLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public void ingresarDatosEmpresa(String cuit,String nombre,String tipoImpuesto, String tipoEmpresa, String direccion,boolean habilitada, String fechaLiquidacion) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.ingresarDatosEmpresa(cuit, nombre, tipoImpuesto, tipoEmpresa, direccion,  habilitada, fechaLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOEmpresaTipoImpuesto> consultarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaTipoImpuesto> dtoeti=  super.consultarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoeti;
    }

    

   

    }

   