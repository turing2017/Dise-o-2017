/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Entity.TipoEmpresa;

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
    public ArrayList<DTOEmpresa > consultarEmpresas (){
    List<Object> listObject = FachadaPersistencia.getInstance().buscar("Empresa", null);
    ArrayList<DTOEmpresa> listDTOEmpresa = new ArrayList<DTOEmpresa>();
    for(Object obj : listObject){
      Empresa empresa = (Empresa) obj ;
      DTOEmpresa DTOe = new DTOEmpresa();
      DTOe.setCuitEmpresa(empresa.getCuitEmpresa());
      DTOe.setDireccionEmpresa(empresa.getDireccionEmpresa());
      DTOe.setNombreEmpresa(empresa.getNombreEmpresa());
      DTOe.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());
     
      
      listDTOEmpresa.add(DTOe);
    
      }
    return listDTOEmpresa ;
}
    
    
  
    public void ingresarDatosEmpresa(String cuit, String nombre, String direccion, boolean habilitada) {
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

   
    
    public void modificarEmpresa (String cuit,String nombre, String direccion,boolean habilitada){
       
        
        try{
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
       
        FachadaPersistencia.getInstance().guardar(empresa);
        
        Excepciones.getInstance().modificacionExito();
    }
        catch (IndexOutOfBoundsException exception) {
         Excepciones.getInstance().cuitNoExistente();
        
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
 
   
 