/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Expert.ExpertoGestionarItem;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;

/**
 *
 * @author mvissio
 */
public class ControladorGestionarItem {
    
    private ExpertoGestionarItem experto = (ExpertoGestionarItem) FabricaExpertos.getInstancia().crearExperto("CU13");
    
    public void iniciar(){
        experto.iniciar();
    }
}
