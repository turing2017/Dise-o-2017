/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.List;
import sistemapagoimpuestos.View.Errors.ErrorDatoNoEncontrado;

/**
 *
 * @author mvissio
 */
public class Excepciones extends Exception{

    
    private static Excepciones excepciones;

    
    public static Excepciones getInstance()
    {
        if (excepciones == null)
        {
            excepciones = new Excepciones();
        }
        return excepciones;
    }
    
    
    
    
    public Excepciones() {
    }
    
    public void datoNoEncontrado(String dato){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Registro No Existente");            
        edne.setLabel_mensaje("El registro "+dato+" no fue encontrado");
        edne.setVisible(true);
    }
    
    public void camposRequerido(List<String> campos){
       ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
       edne.setLabel_title("Error: Campos Incompletos");
       String salidacampo = "";
       if(campos.size()>1){
           int count = 0;
           String tempoCamp = "";
           for(String campo : campos){
               switch(count){
                   case 0:
                        tempoCamp = campo;
                        break;
                   case 1:
                       salidacampo = campo;
                       break;
                   default:
                       salidacampo = salidacampo + ", " +campo;
               }
               count ++;
           }
           salidacampo = salidacampo + " y "+ tempoCamp;
           edne.setLabel_mensaje("Los campos: "+salidacampo+" es requerido");  
       }else{
           edne.setLabel_mensaje("El campo: "+campos.get(0)+" es requerido");  

       }
        edne.setVisible(true); 
    }
    
    public static void objetoExistente(String objeto){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Registro Existente");            
        edne.setLabel_mensaje("El "+objeto+" ingresado ya existe");
        edne.setVisible(true);
    }
    
    public void objetoNoSeleccionado(){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("No ha efectuado selección");
        edne.setLabel_mensaje("Debe realizar una selección");
        edne.setVisible(true);
    }
}
