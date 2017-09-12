/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Entity.ParametroCalculoEditable;
import sistemapagoimpuestos.Entity.ParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Gabriel
 */
public class ExpertoGestionarParametrosCalculoComision {

    Usuario usuario = new Usuario();

    // Metodo iniciar
    public String iniciar() {
        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";
    }

    /* public DTOParametroCalculoEditable consultarParametrosCalculoEditable() {
     
       
        try{
        DTOParametroCalculoEditable dtoParametrosCalculoEditable = new DTOParametroCalculoEditable();
        
        List<DTOCriterio> criterios = new ArrayList<>();

        DTOCriterio criterio1 = new DTOCriterio();
       // criterio1.setAtributo("codigoTipoImpuesto");
        //criterio1.setOperacion("=");
       // criterio1.setValor(codigo);
        criterios.add(criterio1);
        FachadaInterna.getInstance().iniciarTransaccion();
        ParametroCalculoEditable tipoImpuesto = (ParametroCalculoEditable) FachadaPersistencia.getInstance().buscar("TipoImpuesto",criterios).get(0);
        
        dtoParametrosCalculoEditable.setSiEditable(ParametroCalculoEditable.getInstancia().getSiEditable());
        dtoParametrosCalculoEditable.setNoEditable(ParametroCalculoEditable.getInstancia().getNoEditable());
        FachadaInterna.getInstance().finalizarTransaccion();
        
        }
        catch(Exception e){
         
        }
        return dtoParametrosCalculoEditable;        

        /* FachadaInterna.getInstance().iniciarTransaccion();
       DTOParametroCalculoEditable dtoParametrosCalculoEditable = super.obtenerParametrosCalculoEditable();
       FachadaInterna.getInstance().finalizarTransaccion();
       return dtoParametrosCalculoEditable;*/

 /*   
    public DTOParametroCalculoPeriodicidad obtenerTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        //ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto= super.obtenerTipoImpuestos(); 
        FachadaInterna.getInstance().finalizarTransaccion();
       //  return dtoParametroCalculoPeriodicidad;//To change body of generated methods, choose Tools | Templates.
    }
    
 
    public DTOParametroCalculoEditable obtenerTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        //ArrayList<DTOTipoImpuesto> listadoDtoTipoImpuesto= super.obtenerTipoImpuestos(); 
        FachadaInterna.getInstance().finalizarTransaccion();
       //  return dtoParametroCalculoEditable;//To change body of generated methods, choose Tools | Templates.
    }
    public void modificarParametrosCalculoComision(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado){
    
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
    }
     */
//    }
    public void modificarParametrosPeriodicidad(double mensual, double bimestral, double trimestral, double cuatrimestral,  double semestral, double anual, double quincenal) {

       
       
        FachadaInterna.getInstance().iniciarTransaccion();
        
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null);
        ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
        parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
        /*
        if (parametros.isEmpty()){
            parametrosCalculoPeriodicidad = new ParametroCalculoPeriodicidad();
        }
        else{
            parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
        }                                                                      
       */
        parametrosCalculoPeriodicidad.setMensualPCPeriodicidad(mensual);
        parametrosCalculoPeriodicidad.setBimestralPCPeriodicidad(bimestral);
        parametrosCalculoPeriodicidad.setTrimestralPCPeriodicidad(trimestral);
        parametrosCalculoPeriodicidad.setCuatrimestralPCPeriodicidad(cuatrimestral);
        parametrosCalculoPeriodicidad.setQuincenalPCPeriodicidad(quincenal);
        parametrosCalculoPeriodicidad.setSemestralPCPeriodicidad(semestral);
        parametrosCalculoPeriodicidad.setAnualPCPeriodicidad(anual);
        
        FachadaPersistencia.getInstance().guardar(parametrosCalculoPeriodicidad);
              FachadaInterna.getInstance().finalizarTransaccion();
    }

    
     public void modificarParametrosEditable(double montoSiEditable, double montoNoEditable) {

        ParametroCalculoEditable parametrosCalculoEditable;
        FachadaInterna.getInstance().iniciarTransaccion();
        
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoEditable", null);
        parametrosCalculoEditable = (ParametroCalculoEditable) parametros.get(0);
        /*
        ParametroCalculoEditable parametrosCalculoEditable;
        
        if (parametros.isEmpty()){
            parametrosCalculoEditable = new ParametroCalculoEditable();
        }
        else{
            parametrosCalculoEditable = (ParametroCalculoEditable) parametros.get(0);
        }   
        */        
        parametrosCalculoEditable.setSiEditablePCEditable(montoSiEditable);
        parametrosCalculoEditable.setNoEditablePCEditable(montoNoEditable);
 
        FachadaPersistencia.getInstance().guardar(parametrosCalculoEditable);
              FachadaInterna.getInstance().finalizarTransaccion();
    }
     
    /*
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("nombreTipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(nombreActualTipoImpuesto);
        criterios.add(criterio1);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
        
        tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
        tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);
        if(habilitado){
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(null);
        }else{
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(new Date());
        }
        FachadaPersistencia.getInstance().guardar(tipoImpuesto);
        System.out.println("Guardando en la DB: " + tipoImpuesto.getNombreTipoImpuesto());
    }
}
     */

    public DTOParametroCalculoPeriodicidad obtenerParametrosCalculoPeriodicidad() {
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null);
        ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
        DTOParametroCalculoPeriodicidad dtoParametroCP = new DTOParametroCalculoPeriodicidad();
        if (parametros.isEmpty()){
            parametrosCalculoPeriodicidad = new ParametroCalculoPeriodicidad();
            parametrosCalculoPeriodicidad.setAnualPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setBimestralPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setCuatrimestralPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setMensualPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setQuincenalPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setSemestralPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setTrimestralPCPeriodicidad(0.0);
            dtoParametroCP.setAnualPCPeriodicidad(parametrosCalculoPeriodicidad.getAnualPCPeriodicidad());
            dtoParametroCP.setBimestralPCPeriodicidad(parametrosCalculoPeriodicidad.getBimestralPCPeriodicidad());
            dtoParametroCP.setCuatrimestralPCPeriodicidad(parametrosCalculoPeriodicidad.getCuatrimestralPCPeriodicidad());
            dtoParametroCP.setMensualPCPeriodicidad(parametrosCalculoPeriodicidad.getMensualPCPeriodicidad());
            dtoParametroCP.setQuincenalPCPeriodicidad(parametrosCalculoPeriodicidad.getQuincenalPCPeriodicidad());
            dtoParametroCP.setSemestralPCPeriodicidad(parametrosCalculoPeriodicidad.getSemestralPCPeriodicidad());
            dtoParametroCP.setTrimestralPCPeriodicidad(parametrosCalculoPeriodicidad.getTrimestralPCPeriodicidad());
            FachadaPersistencia.getInstance().guardar(parametrosCalculoPeriodicidad);
            return dtoParametroCP;
        }
        else{
            parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
            dtoParametroCP.setAnualPCPeriodicidad(parametrosCalculoPeriodicidad.getAnualPCPeriodicidad());
            dtoParametroCP.setBimestralPCPeriodicidad(parametrosCalculoPeriodicidad.getBimestralPCPeriodicidad());
            dtoParametroCP.setCuatrimestralPCPeriodicidad(parametrosCalculoPeriodicidad.getCuatrimestralPCPeriodicidad());
            dtoParametroCP.setMensualPCPeriodicidad(parametrosCalculoPeriodicidad.getMensualPCPeriodicidad());
            dtoParametroCP.setQuincenalPCPeriodicidad(parametrosCalculoPeriodicidad.getQuincenalPCPeriodicidad());
            dtoParametroCP.setSemestralPCPeriodicidad(parametrosCalculoPeriodicidad.getSemestralPCPeriodicidad());
            dtoParametroCP.setTrimestralPCPeriodicidad(parametrosCalculoPeriodicidad.getTrimestralPCPeriodicidad());
            return dtoParametroCP;
        }                                         
    }
}
