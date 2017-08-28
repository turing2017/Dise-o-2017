/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

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
    }private double anual;
    private double bimestral;
    private double cuatrimestral;
    private double mensual;
    private double quincenal;
    private double semestral;
    private double trimestral;
    

    //@Override
    public void modificarParametroCalculoPeriodicidad(double anual, double bimestral, double cuatrimestral, double mensual , double quincenal, double semestral , double trimestral ) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarParametrosPeriodicidad(anual, bimestral, cuatrimestral, mensual,quincenal,semestral,trimestral); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    public void modificarParametroCalculoEditable() {
        FachadaInterna.getInstance().iniciarTransaccion();
       // super.consultarParametrosCalculoEditable();
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
