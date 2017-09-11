/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Dto.DTOEmpresaBuscada;
import sistemapagoimpuestos.Expert.ExpertoConsultarOperacionesBancarias;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.ConsultarOperacionesBancarias.IUConsultarOperacionesBancarias;


public class ControladorConsultarOperacionesBancarias {
    
    private ExpertoConsultarOperacionesBancarias experto = (ExpertoConsultarOperacionesBancarias)  FabricaExpertos.getInstancia().crearExperto("CU17");
    
    
     public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUConsultarOperacionesBancarias pantallaPrincipal = new IUConsultarOperacionesBancarias();
        pantallaPrincipal.setVisible(true); 
        }        
    }
     
    public DTOEmpresaBuscada buscarEmpresa (String cuitEmpresa) {
        return experto.buscarEmpresa(cuitEmpresa);
    }
}
