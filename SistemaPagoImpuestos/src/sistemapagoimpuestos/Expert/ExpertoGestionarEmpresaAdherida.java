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
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import java.util.Date;
import java.util.Vector;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaGEA;
import sistemapagoimpuestos.Dto.DTOTipoEmpresaGEA;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
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
    public ArrayList<DTOEmpresaGEA > consultarEmpresas (){
        
    List<Object> listObject = FachadaPersistencia.getInstance().buscar("Empresa", null);
    ArrayList<DTOEmpresaGEA> listDTOEmpresa = new ArrayList<>();
    for(Object obj : listObject){
     Empresa empresa = new Empresa();
     empresa = (Empresa) obj;
      DTOEmpresaGEA dTOe = new DTOEmpresaGEA();
      dTOe.setNombreEmpresa(empresa.getNombreEmpresa());
      dTOe.setCuitEmpresa(empresa.getCuitEmpresa());
      dTOe.setDireccionEmpresa(empresa.getDireccionEmpresa());
      dTOe.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());

      listDTOEmpresa.add(dTOe);
    
      }
    return listDTOEmpresa ;
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
            }
            }
        }
     }
          
    
    public List<DTOTipoEmpresaGEA> buscarTipoEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List<Object> tipoEmpresaObjectList = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioItem);
        
        List <DTOTipoEmpresaGEA> dTOTipoEmpresaList = new ArrayList<>();
        DTOTipoEmpresaGEA dTOTipoEmpresa;
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object tipoEmpresaObject :tipoEmpresaObjectList) {
            dTOTipoEmpresa = new DTOTipoEmpresaGEA();
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipoEmpresaObject;
            dTOTipoEmpresa.setNombreTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa());
            dTOTipoEmpresaList.add(dTOTipoEmpresa);
        }
        
        
        
        return dTOTipoEmpresaList;
    }

        public List<DTOEmpresaGEA> buscarEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List<Object> empresaObjectList = FachadaPersistencia.getInstance().buscar("Empresa", criterioItem);
        
        List <DTOEmpresaGEA> dTOEmpresaList = new ArrayList<>();
        DTOEmpresaGEA dTOEmpresa;
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object empresaObject :empresaObjectList) {
            dTOEmpresa = new DTOEmpresaGEA();
            Empresa empresa = (Empresa) empresaObject;
            dTOEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
            dTOEmpresaList.add(dTOEmpresa);
        }
        
        
        
        return dTOEmpresaList;
    }

    
    
    
    public void ingresarDatosEmpresa(String cuitEmpresa, String tipoImpuesto, String tipoEmpresa, int frecuencia) {

            //Busco la empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("nombreEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuitEmpresa);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().cuitExistente();
           
        
            //Busco el Tipo Impuesto, de acuerdo a lo que ingreso en pantalla
        
            List<DTOCriterio> criterios2 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreTipoImpuesto");
            criterio2.setOperacion("=");
            criterio2.setValor(tipoImpuesto);
            criterios2.add(criterio2);
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios2).get(0);

            //Busco el TIpo Empresa, de acuerdo a lo que ingreso en pantalla
            List<DTOCriterio> criterios3 = new ArrayList<>();
            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("nombreTipoEmpresa");
            criterio3.setOperacion("=");
            criterio3.setValor(tipoEmpresa);
            criterios2.add(criterio3);
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios3).get(0);

            //Creo el nuevo Empresa Tipo Impuesto con los datos seleccionados
            EmpresaTipoImpuesto eti = new EmpresaTipoImpuesto();
            eti.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuencia);
            eti.setEmpresa(empresa);
            eti.setTipoEmpresa(tEmpresa);
            eti.setTipoImpuesto(tImpuesto);
            eti.setFechaHoraAltaEmpresaTipoImpuesto(new Date());
            eti.setFechaHoraInhabilitacionEmpresaTipoImpuesto(null);

            //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);
            FachadaPersistencia.getInstance().guardar(eti);

            Excepciones.getInstance().empresaCreada();
            
    }
   
    
    public void modificarEmpresa (String cuit,String nombre, String direccion,boolean habilitada){
       boolean camposIncompletos= camposNulos(cuit, nombre, direccion);
       if(camposIncompletos == true){
       Excepciones.getInstance().camposVacios();   
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
 
   
 