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
      DTOe.setCuitDTOEmpresa(empresa.getCuitEmpresa());
      DTOe.setDireccionDTOEmpresa(empresa.getDireccionEmpresa());
      DTOe.setNombreDTOEmpresa(empresa.getNombreEmpresa());
      DTOe.setFechaHoraInhabilitacionDTOEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());
      DTOe.setNombreTipoEmpresaDTOEmpresa(empresa.getTipoEmpresa().getNombreTipoEmpresa());
      
      listDTOEmpresa.add(DTOe);
    
      }
    return listDTOEmpresa ;
}
    
    
  
    public void ingresarDatosEmpresa(String cuit, String nombre, String direccion, String tipoEmpresa, boolean habilitada) {
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
            empresa.setTipoEmpresa(buscarTipoEmpresa(tipoEmpresa));
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

   
    
    public void modificarEmpresa (String cuit,String nombre, String direccion,boolean habilitada, String tipoEmpresa){
       
        
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
        
        empresa.setTipoEmpresa(buscarTipoEmpresa(tipoEmpresa));
        
        
        FachadaPersistencia.getInstance().guardar(empresa);
        
        Excepciones.getInstance().modificacionExito();
    }
        catch (IndexOutOfBoundsException exception) {
         Excepciones.getInstance().cuitNoExistente();
        
     }
        
    }
    
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa, String direccionEmpresa, String habilitada, String tipoEmpresa){
        DTOEmpresaExistente dtoEe = new DTOEmpresaExistente();
        dtoEe.setCuitDTOEmpresaExistente(cuitEmpresa);
        dtoEe.setNombreDTOEmpresaExistente(nombreEmpresa);
        dtoEe.setDireccionDTOEmpresaExistente(direccionEmpresa);
        dtoEe.setHabilitadaDTOEmpresaExistente(habilitada);
        dtoEe.setNombreTipoEmpresaDTOEmpresaExistente(tipoEmpresa);
        
        return dtoEe;
    }
    
    public TipoEmpresa buscarTipoEmpresa (String nombre){
        List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("nombreTipoEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(nombre);
            criterios.add(criterio1);
            TipoEmpresa tipo = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios).get(0);
            return tipo;
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
    public List<DTOTipoEmpresa> buscarTiposDeEmpresa(){
     List<DTOCriterio> criterios = new ArrayList();
      DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("fechaHoraInhabilitacionTipoEmpresa");
        criterio1.setOperacion("IS");
        criterio1.setValor(null);
        criterios.add(criterio1);   
        List tipo = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios);
       
        List<DTOTipoEmpresa> lista = new ArrayList<>();
        DTOTipoEmpresa dtoTipoEmpresa;

        for (int i = 0; i < tipo.size(); i++) {
            dtoTipoEmpresa = new DTOTipoEmpresa();
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipo.get(i);
            String nombreTipoEmpresa = tipoEmpresa.getNombreTipoEmpresa();
            dtoTipoEmpresa.setNombreDTOTipoEmpresa(nombreTipoEmpresa);
            lista.add(dtoTipoEmpresa);
        }
        return lista;
    }

     
    }
 
   
 