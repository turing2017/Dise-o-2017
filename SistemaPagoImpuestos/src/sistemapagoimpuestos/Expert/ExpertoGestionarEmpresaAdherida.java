/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import java.util.Date;
import java.util.Vector;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaGestionarEmpresaAdherida;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Globals.GlobalVars;

/**
 *
 * @author Tongas
 */


public class ExpertoGestionarEmpresaAdherida {
    
    
    
     public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }
    public String iniciar() {

        return "Administrador";
    }
    
     public void ingresarDatosEmpresaCrear(String cuit,String nombre ,String direccion,boolean habilitada) {
       boolean camposIncompletos= camposNulos(cuit, nombre, direccion);
       if(camposIncompletos == true){
       Excepciones.getInstance().camposVacios();
       } else{
         try {
            //Busco la empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().cuitExistente();
            } catch (IndexOutOfBoundsException exception) {
                try{
                    //Busco la empresa
            List<DTOCriterio> criterios1 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreEmpresa");
            criterio2.setOperacion("=");
            criterio2.setValor(nombre);
            criterios1.add(criterio2);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios1).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().nombreExistente();
                }catch(IndexOutOfBoundsException exc)  {              
            Empresa empresa = new Empresa();
            empresa.setCuitEmpresa(cuit);
            empresa.setNombreEmpresa(nombre);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true) {
                empresa.setFechaHoraInhabilitacionEmpresa(null);
            } else {
                empresa.setFechaHoraInhabilitacionEmpresa(new Date());
            }
            
            FachadaPersistencia.getInstance().guardar(empresa);
            Excepciones.getInstance().empresaCreada();
            }
            }
        }
     }
    
    public List<DTOTipoEmpresa> buscarTipoEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List<Object> tipoEmpresaObjectList = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioItem);
        List <DTOTipoEmpresa> dTOTipoEmpresaList = new ArrayList<>();
        DTOTipoEmpresa dTOTipoEmpresa;
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object tipoEmpresaObject :tipoEmpresaObjectList) {
            dTOTipoEmpresa = new DTOTipoEmpresa();
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipoEmpresaObject;
            dTOTipoEmpresa.setNombreTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa());
            dTOTipoEmpresaList.add(dTOTipoEmpresa);
        }
        
        
        
        return dTOTipoEmpresaList;
    }

        public List<DTOEmpresaGestionarEmpresaAdherida> buscarEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List<Object> empresaObjectList = FachadaPersistencia.getInstance().buscar("Empresa", criterioItem);
        
        List <DTOEmpresaGestionarEmpresaAdherida> dTOEmpresaList = new ArrayList<>();
        DTOEmpresaGestionarEmpresaAdherida dTOEmpresa;
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object empresaObject :empresaObjectList) {
            dTOEmpresa = new DTOEmpresaGestionarEmpresaAdherida();
            Empresa empresa = (Empresa) empresaObject;
            dTOEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
            dTOEmpresaList.add(dTOEmpresa);
        }
        return dTOEmpresaList;
    }
        
        
    public ArrayList<DTOEmpresa > consultarEmpresas (){
        
    List<Object> listObject = FachadaPersistencia.getInstance().buscar("Empresa", null);
    ArrayList<DTOEmpresa> listDTOEmpresa = new ArrayList<>();
    for(Object obj : listObject){
     Empresa empresa = new Empresa();
     empresa = (Empresa) obj;
      DTOEmpresa dTOe = new DTOEmpresa();
      dTOe.setNombreEmpresa(empresa.getNombreEmpresa());
      dTOe.setCuitEmpresa(empresa.getCuitEmpresa());
      dTOe.setDireccionEmpresa(empresa.getDireccionEmpresa());
      dTOe.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());

      listDTOEmpresa.add(dTOe);
    
      }
    return listDTOEmpresa ;
}
    
    public void modificarEmpresa (String cuit,String nombre, String nombreAntiguo, String direccion,boolean habilitada){
       boolean camposIncompletos= camposNulos(cuit, nombre, direccion);
       if(camposIncompletos == true){
       Excepciones.getInstance().camposVacios();   
       }else{
           if(!(nombreAntiguo.equals(nombre))){
           try{
            //Busco la empresa
            List<DTOCriterio> criterios1 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreEmpresa");
            criterio2.setOperacion("=");
            criterio2.setValor(nombre);
            criterios1.add(criterio2);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios1).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().nombreExistente();
                }catch(IndexOutOfBoundsException exc){   
        try {
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
  
            empresa.setNombreEmpresa(nombre);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true) {
                empresa.setFechaHoraInhabilitacionEmpresa(null);
            } else {
                empresa.setFechaHoraInhabilitacionEmpresa(new Date());
            }
        //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);
            Excepciones.getInstance().modificacionExito();
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().cuitNoExistente();
        }  
        }
    }else{
                       try {
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            empresa.setNombreEmpresa(nombre);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true) {
                empresa.setFechaHoraInhabilitacionEmpresa(null);
            } else {
                empresa.setFechaHoraInhabilitacionEmpresa(new Date());
            }
        //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);

            Excepciones.getInstance().modificacionExito();
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().cuitNoExistente();
        }
           }
    }
       
    }
    
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa, String direccionEmpresa, String habilitada){
        DTOEmpresaExistente dtoEe = new DTOEmpresaExistente();
        dtoEe.setCuitDTOEmpresaExistente(cuitEmpresa);
        dtoEe.setNombreDTOEmpresaExistente(nombreEmpresa);
        dtoEe.setDireccionDTOEmpresaExistente(direccionEmpresa);
        dtoEe.setHabilitadaDTOEmpresaExistente(habilitada);

        return dtoEe;
    }
    
  
    public boolean camposNulos(String cuit, String nombre, String direccion ){
        boolean error=false;
        if (cuit.isEmpty()){
        error=true;
        } 
        if(nombre.isEmpty()){
        error=true;
        }
        if(direccion.isEmpty()){
        error=true;
        }
       
        return error;
    }
  }
 
   
 