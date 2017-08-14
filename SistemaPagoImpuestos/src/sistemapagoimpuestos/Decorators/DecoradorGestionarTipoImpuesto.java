/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author mvissio
 */
public class DecoradorGestionarTipoImpuesto extends ExpertoGestionarTipoImpuesto {

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }

    @Override
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOTipoImpuesto dtoti = super.obtenerTipoImpuesto(codigo); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoti;
    }

    @Override
    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarTipoImpuesto(nombreTipoImpuestoIngres, nombreActualTipoImpuesto, esMontoEditableIngres, habilitado); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos() {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto= super.obtenerTipoImpuestos(); 
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDtoTipoImpuesto;//To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
    