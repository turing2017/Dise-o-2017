/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.Date;
import sistemapagoimpuestos.Expert.ExpertoGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Gabriel
 */
public class DecoradorGestionarParametrosCalculoComision extends ExpertoGestionarParametrosCalculoComision {
   
    
     public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }
    private Date fechaDesde;
    private double mensual;
    private double bimestral;
    private double trimestral;
    private double cuatrimestral;
    private double semestral;
    private double anual;
    private double quincenal;
    

    //@Override
    public void modificarParametroCalculoPeriodicidad(Date fechaDesde ,double mensual, double bimestral, double trimestral, double cuatrimestral , double semestral, double anual , double quincenal ) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarParametrosPeriodicidad(fechaDesde, mensual, bimestral, trimestral, cuatrimestral, semestral, anual, quincenal); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    public void modificarParametroCalculoEditable(Date fechaDesde, double siEditable, double noEditable) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarParametrosEditable(fechaDesde, siEditable, noEditable); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
/*
    @Override   
    public DTOParametroCalculoPeriodicidad obtenerTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        //ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto= super.obtenerTipoImpuestos(); 
        FachadaInterna.getInstance().finalizarTransaccion();
       //  return dtoParametroCalculoPeriodicidad;//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override   
    public DTOParametroCalculoEditable obtenerTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        //ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto= super.obtenerTipoImpuestos(); 
        FachadaInterna.getInstance().finalizarTransaccion();
       //  return dtoParametroCalculoEditable;//To change body of generated methods, choose Tools | Templates.
    }

*/
}
