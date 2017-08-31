/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import sistemapagoimpuestos.Expert.ExpertoGestionarTipoUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;


public class DecoradorGestionarTipoUsuario extends ExpertoGestionarTipoUsuario {
    
    @Override
    public String iniciar(){
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar();
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
}
    }
