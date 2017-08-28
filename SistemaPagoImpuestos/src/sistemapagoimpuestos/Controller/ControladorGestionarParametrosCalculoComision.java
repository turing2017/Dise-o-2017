/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;


import sistemapagoimpuestos.Expert.ExpertoGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.IUGestionarParametrosCalculoComision;

/**
 *
 * @author Gabriel
 */
public class ControladorGestionarParametrosCalculoComision {
    
    private static ControladorGestionarParametrosCalculoComision controladorGestionarParametrosCalculoComision;

    public ControladorGestionarParametrosCalculoComision() {
    }
    
    public static ControladorGestionarParametrosCalculoComision getInstance()
    {
        if (controladorGestionarParametrosCalculoComision == null)
        {
            controladorGestionarParametrosCalculoComision = new ControladorGestionarParametrosCalculoComision();
        }
        return controladorGestionarParametrosCalculoComision;
    }
    
    
    private ExpertoGestionarParametrosCalculoComision experto = (ExpertoGestionarParametrosCalculoComision) FabricaExpertos.getInstancia().crearExperto("CU22");
    
    // Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarParametrosCalculoComision pantallaPrincipal = new IUGestionarParametrosCalculoComision();
        pantallaPrincipal.setVisible(true); 
        }        
    }
    
     // Metodo para recuperar el TipoImpuesto a modificar
    /*public DTOParametroCalculoEditable consultarParametrosCalculoEditable(){
        return experto.consultarParametrosCalculoEditable();
    }
    */
    public void modificarParametrosPeriodicidad(double anual, double bimestral, double cuatrimestral, double mensual, double quincenal, double semestral, double trimestral) {
        experto.modificarParametrosPeriodicidad(anual, bimestral, cuatrimestral, mensual, quincenal, semestral, trimestral);
    }
    
}
