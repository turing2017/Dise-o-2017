/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;


import sistemapagoimpuestos.Dto.DTOParametroCalculoEditable;
import sistemapagoimpuestos.Dto.DTOParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Expert.ExpertoGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarParametrosPeriodicidad.IUGestionarParametrosComision;

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
        IUGestionarParametrosComision pantallaPrincipal = new IUGestionarParametrosComision();
        pantallaPrincipal.setVisible(true); 
        pantallaPrincipal.setLocationRelativeTo(null);
        pantallaPrincipal.setTitle("Gestionar Parámetros de Cálculo de Comisión");
        }        
    }
   
    public void modificarParametrosPeriodicidad(double mensual, double bimestral, double trimestral, double cuatrimestral, double semestral, double anual, double quincenal) {
        experto.modificarParametrosPeriodicidad(mensual, bimestral, trimestral, cuatrimestral, semestral, anual, quincenal);
    }
    
    public void modificarParametrosEditable(double montoSiEditable, double montoNoEditable) {
        experto.modificarParametrosEditable(montoSiEditable, montoNoEditable);
    }

    public DTOParametroCalculoPeriodicidad obtenerParametrosCalculoPeriodicidad() {
      return experto.obtenerParametrosCalculoPeriodicidad();
    }

    public DTOParametroCalculoEditable obtenerParametrosCalculoEditable() {
      return experto.obtenerParametrosCalculoEditable();
    }
    
}
