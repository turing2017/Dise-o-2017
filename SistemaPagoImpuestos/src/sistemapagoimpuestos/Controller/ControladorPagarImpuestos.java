/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

/**
 *
 * @author mvissio
 */
public class ControladorPagarImpuestos {
        
    private static ControladorPagarImpuestos controladorPagarImpuesto;

    public ControladorPagarImpuestos() {
    }
    
    public static ControladorPagarImpuestos getInstance()
    {
        if (controladorPagarImpuesto == null)
        {
            controladorPagarImpuesto = new ControladorPagarImpuestos();
        }
        return controladorPagarImpuesto;
    }
    
    
    
}
