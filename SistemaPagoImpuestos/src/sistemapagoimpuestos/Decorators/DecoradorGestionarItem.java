/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import sistemapagoimpuestos.Expert.ExpertoGestionarItem;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarItem extends ExpertoGestionarItem{
     @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }
}
