/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;

/**
 *
 * @author Markz
 */
public class Utils {
    
       
    public static Boolean existeDato(String entidad, List<DTOCriterio> criterios){
        try{
            FachadaPersistencia.getInstance().buscar(entidad, criterios).get(0);
            return true;
        }catch(IndexOutOfBoundsException exception){
            return false;
        }
    }
    
}
