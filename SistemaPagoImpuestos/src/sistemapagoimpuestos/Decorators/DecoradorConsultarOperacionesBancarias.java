/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.List;
import sistemapagoimpuestos.Expert.ExpertoConsultarOperacionesBancarias;
import sistemapagoimpuestos.Utils.FachadaInterna;


public class DecoradorConsultarOperacionesBancarias extends ExpertoConsultarOperacionesBancarias{

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String tempString = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
    
    
}
