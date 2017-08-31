/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Expert.ExpertoGestionarLiquidacion;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUGestionarLiquidacion;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuesto;

/**
 *
 * @author facun
 */
public class ControladorGestionarLiquidacion {
    private static ControladorGestionarLiquidacion controladorGestionarLiquidacion;
    private ExpertoGestionarLiquidacion experto = (ExpertoGestionarLiquidacion) FabricaExpertos.getInstancia().crearExperto("CU21");

    public ControladorGestionarLiquidacion() {
    }
    
     public static ControladorGestionarLiquidacion getInstance()
    {
        if (controladorGestionarLiquidacion == null)
        {
            controladorGestionarLiquidacion = new ControladorGestionarLiquidacion();
        }
        return controladorGestionarLiquidacion;
    }
      // Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarLiquidacion pantallaPrincipal = new IUGestionarLiquidacion();
        pantallaPrincipal.setVisible(true); 
        }        
    }
}
