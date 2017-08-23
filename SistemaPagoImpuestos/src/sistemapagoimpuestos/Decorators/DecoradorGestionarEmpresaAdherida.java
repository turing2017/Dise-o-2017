/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
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

    @Override
    public List<DTOEmpresaExistente> ingresarNroCuit(String cuitEmpresa) {
         FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresaExistente dtoEmp = (DTOEmpresaExistente) super.ingresarNroCuit(cuitEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return (List<DTOEmpresaExistente>) dtoEmp; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.ingresarDatosEmpresa(cuitEmpresa, nombreEmpresa, direccionEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
