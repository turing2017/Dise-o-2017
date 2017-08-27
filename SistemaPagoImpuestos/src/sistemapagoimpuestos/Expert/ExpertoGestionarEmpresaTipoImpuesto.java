/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import sistemapagoimpuestos.Decorators.DecoradorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Usuario;

/**
 *
 * @author mvissio
 */
public class ExpertoGestionarEmpresaTipoImpuesto {
        Usuario usuario = new Usuario();
    
    // Metodo iniciar
    public String iniciar(){
        
        return "Administrador";      
    }
    
    
}
