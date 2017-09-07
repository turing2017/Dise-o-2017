/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

/**
 *
 * @author Markz
 */
public class ControladorGestionarEmpresaTipoImpuesto {
    private static ControladorGestionarEmpresaTipoImpuesto controladorGestionarEmpresaTipoImpuesto;

    public ControladorGestionarEmpresaTipoImpuesto() {
    }
    
    public static ControladorGestionarEmpresaTipoImpuesto getInstance()
    {
        if (controladorGestionarEmpresaTipoImpuesto == null)
        {
            controladorGestionarEmpresaTipoImpuesto = new ControladorGestionarEmpresaTipoImpuesto();
        }
        return controladorGestionarEmpresaTipoImpuesto;
    }
    
    public void iniciar(){
        
    }
}
