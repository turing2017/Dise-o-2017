/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Expert.ExpertoGestionarTipoDeCuenta;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;

/**
 *
 * @author mvissio
 */
public class ControladorGestionarTipoDeCuenta {
   
    private static ControladorGestionarTipoDeCuenta controladorGestionarTipoDeCuenta;
    
    private ExpertoGestionarTipoDeCuenta experto = (ExpertoGestionarTipoDeCuenta) FabricaExpertos.getInstancia().crearExperto("CU05");
    
    public ControladorGestionarTipoDeCuenta() {
    }
    
    public static ControladorGestionarTipoDeCuenta getInstance(){
        if(controladorGestionarTipoDeCuenta==null){
            return controladorGestionarTipoDeCuenta = new ControladorGestionarTipoDeCuenta();
        }
        return controladorGestionarTipoDeCuenta;
    }
    
    public void iniciar(){
        System.out.println(experto.iniciar());
    }
    
}
