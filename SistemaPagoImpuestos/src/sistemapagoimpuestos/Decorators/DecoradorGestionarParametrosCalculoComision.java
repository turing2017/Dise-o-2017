/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.Date;
import sistemapagoimpuestos.Dto.DTOParametroCalculoEditable;
import sistemapagoimpuestos.Dto.DTOParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Expert.ExpertoGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Gabriel
 */
public class DecoradorGestionarParametrosCalculoComision extends ExpertoGestionarParametrosCalculoComision {
   
   
    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }
    
    @Override
    public void modificarParametrosPeriodicidad(double mensual, double bimestral, double trimestral, double cuatrimestral , double semestral, double anual , double quincenal ) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarParametrosPeriodicidad(mensual, bimestral, trimestral, cuatrimestral, semestral, anual, quincenal); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    @Override
    public void modificarParametrosEditable(double siEditable, double noEditable) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarParametrosEditable(siEditable, noEditable); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
   
    @Override
    public DTOParametroCalculoPeriodicidad obtenerParametrosCalculoPeriodicidad(){
         FachadaInterna.getInstance().iniciarTransaccion();
         DTOParametroCalculoPeriodicidad dtoPCP = super.obtenerParametrosCalculoPeriodicidad();
         FachadaInterna.getInstance().finalizarTransaccion();
         return dtoPCP;
    }
    
    @Override
    public DTOParametroCalculoEditable obtenerParametrosCalculoEditable(){
         FachadaInterna.getInstance().iniciarTransaccion();
         DTOParametroCalculoEditable dtoPCP = super.obtenerParametrosCalculoEditable();
         FachadaInterna.getInstance().finalizarTransaccion();
         return dtoPCP;
    }
}
