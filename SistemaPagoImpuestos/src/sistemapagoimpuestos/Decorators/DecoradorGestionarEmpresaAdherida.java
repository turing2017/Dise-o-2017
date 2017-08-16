/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarEmpresaAdherida extends ExpertoGestionarEmpresaAdherida{

    @Override
    public String iniciar() {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        String temporalUser = super.iniciar(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return temporalUser;
    }
    
    
    
}
