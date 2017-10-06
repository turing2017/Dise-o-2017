/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTORangoFecha;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Expert.ExpertoConsultarOperacionesBancarias;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.ConsultarOperacionesBancarias.IUConsultarOperacionesBancariasArchivo;
import sistemapagoimpuestos.View.Admin.ConsultarOperacionesBancarias.IUConsultarOperacionesBancariasSeleccion;


public class ControladorConsultarOperacionesBancarias {
    
    private ExpertoConsultarOperacionesBancarias experto = (ExpertoConsultarOperacionesBancarias) FabricaExpertos.getInstancia().crearExperto("CU17");
    
    public void crearOperacionesBancariasSeleccion(DTOEmpresa dtoEmpresa,ControladorConsultarOperacionesBancarias controlador){
        IUConsultarOperacionesBancariasSeleccion pantallaSeleccion = new IUConsultarOperacionesBancariasSeleccion(dtoEmpresa, controlador);
    
    }
    
    public void consultarOperacionesBancariasArchivo(DTORangoFecha dtoRF, ControladorConsultarOperacionesBancarias controlador,List<DTOOperacion> dtoOperacion){
        IUConsultarOperacionesBancariasArchivo cOBA = new IUConsultarOperacionesBancariasArchivo(dtoRF, controlador, dtoOperacion);
    }
    
    
    
    public DTOEmpresa verificarEmpresa(String cuitEmpresa){
        return experto.verificarEmpresa(cuitEmpresa);  
    }
    
    
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerTipoImpuestosAsociados(){
        return experto.obtenerTipoImpuestosAsociados();
    }
    
    public ArrayList<DTOOperacion> consultarOperaciones(DTORangoFecha dtoRF){
        return experto.consultarOperaciones(dtoRF);
    }
}
