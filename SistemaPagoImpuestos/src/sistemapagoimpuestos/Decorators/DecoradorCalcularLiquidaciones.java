/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import sistemapagoimpuestos.Expert.ExpertoCalcularLiquidaciones;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Gabriel
 */
public class DecoradorCalcularLiquidaciones extends ExpertoCalcularLiquidaciones{
    
    @Override
    public void iniciar(){
         FachadaInterna.getInstance().iniciarTransaccion();
         super.iniciar();
         FachadaInterna.getInstance().finalizarTransaccion();
    }
}
