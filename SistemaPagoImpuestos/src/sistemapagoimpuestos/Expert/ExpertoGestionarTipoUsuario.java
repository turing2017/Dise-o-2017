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
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import static sistemapagoimpuestos.Utils.Utils.existeDato;

/**
 *
 * @author Rodri
 */
public class ExpertoGestionarTipoUsuario {
    
    Usuario usuario = new Usuario();


    public String iniciar() {
        
        return "Administrador";
}

    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario() {
      
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("TipoUsuario", null);
        ArrayList<DTOTipoUsuario> listDtoTipoUsuario = new ArrayList<DTOTipoUsuario>();
      for(Object obj : listObject){
            TipoUsuario tipoUsuario = (TipoUsuario) obj;
            listDtoTipoUsuario.add(ConvertDTO.getInstance().convertTipoUsuario(tipoUsuario));
        }
        return listDtoTipoUsuario;
        
    }   

    public void nuevoTipoUsuario(String nombreTipoUsuarioIngres) {
    
       List<DTOCriterio> criteriosNombre = new ArrayList<>();
        
        DTOCriterio criterioNombre = new DTOCriterio("nombreTipoUsuario", "=", nombreTipoUsuarioIngres);
        criteriosNombre.add(criterioNombre);
        
        if(!existeDato("TipoUsuario", criteriosNombre)){
           System.out.println("Nombre Ingresado No Encontrado");
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setNombreTipoUsuario(nombreTipoUsuarioIngres);
        
            
            FachadaPersistencia.getInstance().guardar(tipoUsuario);        
        }else{
          Excepciones.getInstance().objetoExistente("Nombre");

        }
    
    }
        
    
}
