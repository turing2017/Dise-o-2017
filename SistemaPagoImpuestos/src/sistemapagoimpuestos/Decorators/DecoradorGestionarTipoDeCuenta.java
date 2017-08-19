/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import sistemapagoimpuestos.Expert.ExpertoGestionarTipoDeCuenta;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarTipoDeCuenta extends ExpertoGestionarTipoDeCuenta {

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String tempStrig = super.iniciar(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempStrig;
    }
    
}
