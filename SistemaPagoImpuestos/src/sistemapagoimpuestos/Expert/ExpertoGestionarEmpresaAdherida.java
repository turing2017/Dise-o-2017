/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Tongas
 */
public class ExpertoGestionarEmpresaAdherida {
    
    
        public String iniciar(){
        
        
        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";        
    }
    
    public void ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa){
    try{

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("fechaHoraInhabilitacionEmpresa");
        criterio1.setOperacion("=");
        criterio1.setValor(null);
        criterios.add(criterio1);
        //Se arma el criterio de busqueda para la condicion fechaHoraInhabilitacionEmpresa = null
        DTOCriterio criterio2 = new DTOCriterio();
        criterio1.setAtributo("cuitEmpresa");
        criterio1.setOperacion("=");
        criterio1.setValor(cuitEmpresa);
        criterios.add(criterio2);
        //Se arma el criterio de busqueda para la condicion cuitEmpresa = cuitEmpresa ingresado
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
        System.out.println("El cuit ya existe");//En el caso de que exista, tira mensaje   
        
        }catch(IndexOutOfBoundsException exception){//Si no encuentra Empresa con ese cuit, la crea
            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa(nombreEmpresa);
            empresa.setCuitEmpresa(cuitEmpresa);
            empresa.setDireccionEmpresa(direccionEmpresa);
            empresa.setFechaHoraInhabilitacionEmpresa(null);
            FachadaPersistencia.getInstance().guardar(empresa);        
        }

}
     public List<DTOEmpresaExistente> ingresarNroCuit(String cuitEmpresa){
         ArrayList<DTOEmpresaExistente> listDTOEmpresaExistente = new ArrayList<DTOEmpresaExistente>();
    try{

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("cuit");
        criterio1.setOperacion("=");
        criterio1.setValor(cuitEmpresa);
        criterios.add(criterio1);
        //Se arma el criterio de busqueda para la condicion fechaHoraInhabilitacionEmpresa = null
        DTOCriterio criterio2 = new DTOCriterio();
        criterio1.setAtributo("fechaHoraInhabilitacionEmpresa");
        criterio1.setOperacion("=");
        criterio1.setValor(null);
        criterios.add(criterio2);
        //Se arma el criterio de busqueda para la condicion cuitEmpresa = cuitEmpresa ingresado
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
        DTOEmpresaExistente dtoEmpresaExistente= new DTOEmpresaExistente ();
        dtoEmpresaExistente.setNombreEmpresa(empresa.getNombreEmpresa());
        dtoEmpresaExistente.setCuitEmpresa(cuitEmpresa);
        dtoEmpresaExistente.setDireccionEmpresa(empresa.getDireccionEmpresa());
        listDTOEmpresaExistente.add(dtoEmpresaExistente);
       
    
    }catch(IndexOutOfBoundsException exception){//Si no encuentra Empresa con ese cuit, la crea
            System.out.println("El cuit no existe"); 
                   
        }
return listDTOEmpresaExistente;
}
    
    
}
