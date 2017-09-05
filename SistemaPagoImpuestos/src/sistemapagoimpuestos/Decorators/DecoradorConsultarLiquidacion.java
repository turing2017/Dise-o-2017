/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoConsultarLiquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Dario
 */
public class DecoradorConsultarLiquidacion extends ExpertoConsultarLiquidacion {
    
     @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String tempString = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }

    @Override
    public void consultarLiquidacion() {

    }
  
    @Override
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
        ArrayList<DTOTipoImpuesto> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerTipoImpuestos(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
        
    }
}
