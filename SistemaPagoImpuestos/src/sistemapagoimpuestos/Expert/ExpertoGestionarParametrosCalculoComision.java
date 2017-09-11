/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
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
    public void modificarParametrosPeriodicidad(Date fechaDesde, double mensual, double bimestral, double trimestral, double cuatrimestral,  double semestral, double anual, double quincenal) {

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        
        criterio1.setAtributo("fechaInhabilitacionPCPeriodicidad");
        criterio1.setOperacion("<>");
        criterio1.setValor(null);
        criterios.add(criterio1);
        
        criterio1.setAtributo("fechaDesdePCPeriodicidad");
        criterio1.setOperacion("=");
        criterio1.setValor(fechaDesde);
        criterios.add(criterio1);
        
        FachadaInterna.getInstance().iniciarTransaccion();
        
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", criterios);
        ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
        
        if (parametros.isEmpty()){
            parametrosCalculoPeriodicidad = new ParametroCalculoPeriodicidad();
        }
        else{
            parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
        }                                                                      
       
        parametrosCalculoPeriodicidad.setFechaDesdePCPeriodicidad(fechaDesde);
        parametrosCalculoPeriodicidad.setMensualPCPeriodicidad(mensual);
        parametrosCalculoPeriodicidad.setBimestralPCPeriodicidad(bimestral);
        parametrosCalculoPeriodicidad.setTrimestralPCPeriodicidad(trimestral);
        parametrosCalculoPeriodicidad.setCuatrimestralPCPeriodicidad(cuatrimestral);
        parametrosCalculoPeriodicidad.setQuincenalPCPeriodicidad(quincenal);
        parametrosCalculoPeriodicidad.setSemestralPCPeriodicidad(semestral);
        parametrosCalculoPeriodicidad.setAnualPCPeriodicidad(anual);
        parametrosCalculoPeriodicidad.setFechaInhabilitacionPCPeriodicidad(null);
        
        FachadaPersistencia.getInstance().guardar(parametrosCalculoPeriodicidad);
              FachadaInterna.getInstance().finalizarTransaccion();
    }

    
     public void modificarParametrosEditable(Date fechaDesde, double montoSiEditable, double montoNoEditable) {

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        
        criterio1.setAtributo("fechaInhabilitacionPCEditable");
        criterio1.setOperacion("<>");
        criterio1.setValor(null);
        criterios.add(criterio1);
        
        criterio1.setAtributo("fechaDesdePCEditable");
        criterio1.setOperacion("=");
        criterio1.setValor(fechaDesde);
        criterios.add(criterio1);
        
        FachadaInterna.getInstance().iniciarTransaccion();
        
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoEditable", criterios);
        ParametroCalculoEditable parametrosCalculoEditable;
        
        if (parametros.isEmpty()){
            parametrosCalculoEditable = new ParametroCalculoEditable();
        }
        else{
            parametrosCalculoEditable = (ParametroCalculoEditable) parametros.get(0);
        }   
                
        parametrosCalculoEditable.setFechaDesdePCEditable(fechaDesde);
        parametrosCalculoEditable.setSiEditablePCEditable(montoSiEditable);
        parametrosCalculoEditable.setNoEditablePCEditable(montoNoEditable);
        parametrosCalculoEditable.setFechaInhabilitacionPCEditable(null);
         
        
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
}
