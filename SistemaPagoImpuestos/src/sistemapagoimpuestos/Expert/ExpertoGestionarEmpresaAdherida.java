/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import java.util.Date;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;

/**
 *
 * @author Tongas
 */
public class ExpertoGestionarEmpresaAdherida {
    
    protected Empresa empresa;

    public String iniciar() {

        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";
    }
    public ArrayList<DTOEmpresaTipoImpuesto > consultarEmpresas (){
        
    List<Object> listObject = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
    ArrayList<DTOEmpresaTipoImpuesto> listDTOEmpresaTipoImpuesto = new ArrayList<>();
    for(Object obj : listObject){
      EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj ;
      DTOEmpresaTipoImpuesto DTOeti = new DTOEmpresaTipoImpuesto();
      DTOeti.setEmpresa(empresaTipoImpuesto.getEmpresa());
      /*
      La fechaHoraAltaEmpresa no se si ponerla o no, 
      de ultima es solo mostrarla en pantalla despues
      */
      DTOeti.setFechaHoraAltaEmpresaTipoImpuesto(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
      DTOeti.setFechaHoraInhabilitacionEmpresaTipoImpuestoa(empresaTipoImpuesto.getFechaHoraInhabilitacionEmpresaTipoImpuesto());
      DTOeti.setTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa());
      DTOeti.setTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto());
      DTOeti.setFrecuenciaLiquidacionDTOEmpresaExistente(empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto());

      listDTOEmpresaTipoImpuesto.add(DTOeti);
    
      }
    return listDTOEmpresaTipoImpuesto ;
}
    
    public List<DTOTipoEmpresa> buscarTipoEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List<Object> tipoEmpresaObjectList = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioItem);
        
        List <DTOTipoEmpresa> dTOTipoEmpresaList = new ArrayList<>();
        DTOTipoEmpresa dTOTipoEmpresa;
        
        for (Object tipoEmpresaObject :tipoEmpresaObjectList) {
            dTOTipoEmpresa = new DTOTipoEmpresa();
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipoEmpresaObject;
            dTOTipoEmpresa.setNombreTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa());
            dTOTipoEmpresaList.add(dTOTipoEmpresa);
        }
        return dTOTipoEmpresaList;
    }

    
    
    
    
    
    
    public List<DTOTipoImpuesto> buscarTipoImpuesto(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List<Object> tipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioItem);
        
        List <DTOTipoImpuesto> dTOTipoImpuestoList = new ArrayList<>();
        DTOTipoImpuesto dTOTipoImpuesto;
        
        for (Object tipoImpuestoObject :tipoImpuestoObjectList) {
            dTOTipoImpuesto = new DTOTipoImpuesto();
            TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestoObject;
            dTOTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dTOTipoImpuestoList.add(dTOTipoImpuesto);
        }
        return dTOTipoImpuestoList;
    }
  
    
    
    
    
    
    
    
    
    
    public void ingresarDatosEmpresa(String cuit,String nombre,String tipoImpuesto, String tipoEmpresa, String direccion,boolean habilitada) {
       boolean camposVacios= camposNulos(cuit, nombre, direccion);
       if (camposVacios==true){
       Excepciones.getInstance().camposVacios();
       return;
       }
        
        try {
            
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            Excepciones.getInstance().cuitExistente();//En el caso de que exista, tira mensaje 


        } catch (IndexOutOfBoundsException exception) {//Si no encuentra Empresa con ese cuit, la crea
            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa(nombre);
            empresa.setCuitEmpresa(cuit);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true){
            empresa.setFechaHoraInhabilitacionEmpresa(null);
            }
            else {
            empresa.setFechaHoraInhabilitacionEmpresa(new Date());
                }
            FachadaPersistencia.getInstance().guardar(empresa);
            Excepciones.getInstance().empresaCreada();
        
        }

    }

   
    
    public void modificarEmpresa (String cuit,String nombre, String tipoImpuesto, String tipoEmpresa, String direccion,boolean habilitada, Date fechaLiquidacion){
       
        
        try{
            //Busco la empresa
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("cuitEmpresa");
        criterio1.setOperacion("=");
        criterio1.setValor(cuit);
        criterios.add(criterio1);
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
       //En el caso de que exista, tira mensaje 
        empresa.setNombreEmpresa(nombre);
        empresa.setDireccionEmpresa(direccion);
        empresa.setCuitEmpresa(cuit);
        if (habilitada==true){
            empresa.setFechaHoraInhabilitacionEmpresa(null);
        }else{
            empresa.setFechaHoraInhabilitacionEmpresa(new Date());
        }
        
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
        eti.setEmpresa(empresa);
        eti.setTipoEmpresa(tEmpresa);
        eti.setTipoImpuesto(tImpuesto);
        eti.setFechaHoraAltaEmpresaTipoImpuesto(new Date());

        //Guardo la empresa, y la empresa tipo impuesto
        FachadaPersistencia.getInstance().guardar(empresa);
        FachadaPersistencia.getInstance().guardar(eti);
        
        Excepciones.getInstance().modificacionExito();
    }
        catch (IndexOutOfBoundsException exception) {
         Excepciones.getInstance().cuitNoExistente();
         
    }
    } 
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa,String tipoImpuesto, String tipoEmpresa, String direccionEmpresa, String habilitada){
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

    public void modificarEmpresa(String cuit, String nombre, String tipoImpuesto, String tipoEmpresa, String direccion, boolean habilitada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
 
   
 