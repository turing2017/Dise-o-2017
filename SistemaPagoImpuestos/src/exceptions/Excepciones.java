/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.List;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Errors.ErrorDatoNoEncontrado;
import sistemapagoimpuestos.View.Errors.CamposVacios;
import sistemapagoimpuestos.View.Errors.CuitExistente;
import sistemapagoimpuestos.View.Errors.CuitNoExistente;
import sistemapagoimpuestos.View.Errors.EmpresaCreada;
import sistemapagoimpuestos.View.Errors.ModificacionExito;

import sistemapagoimpuestos.View.Errors.ObjetoNoSeleccionado;
import sistemapagoimpuestos.View.Errors.ErrorDatoNoValido;
import sistemapagoimpuestos.View.Errors.UsuarioNoValido;

/**
 *
 * @author mvissio
 */
public class Excepciones extends Exception{

    
    private static Excepciones excepciones;

    
    public static Excepciones getInstance(){
        if (excepciones == null){
            excepciones = new Excepciones();
        }
        return excepciones;
    }
    public Excepciones() {
    }
    public void empresaCreada(){
    EmpresaCreada Ec= new EmpresaCreada();
    Ec.setLabel_Titulo("Empresa Creada");
    Ec.setLabel_mensaje("La empresa fue creada con éxito");
    Ec.setVisible(true);
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
    
    
    public void usuarioNoValido(){
        UsuarioNoValido unv = new UsuarioNoValido();
        unv.setLabel_Titulo("Usuario Incorrecto");
        unv.setField_Error("No tiene la autorizacion para realizar esta operación");
        unv.setVisible(true);
    }
    
    public void datoNoEncontrado(String dato){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Registro No Existente");            
        edne.setLabel_mensaje("El registro "+dato+" no fue encontrado");
        edne.setVisible(true);
    }
    public void objetoNoSeleccionado(){
       
    ObjetoNoSeleccionado ons = new ObjetoNoSeleccionado();
    ons.setLabel_Titulo("Seleccionar opcion");
    ons.setLabel_mensaje(" Debe seleccionar una fila en la tabla para modificar,intente nuevamnete");
    ons.setVisible(true);
    ons.setVisible(true);
    }
    public void cuitNoExistente(){
    CuitNoExistente cne= new CuitNoExistente();
    cne.setLabel_Titulo("Cuit no existente");
    cne.setLabel_mensaje("El CUIT ingresado no existe, intente nuevamente");
    cne.setVisible(true);
    }
    public void cuitExistente(){
    CuitExistente ce= new CuitExistente();
    ce.setLabel_Titulo("Cuit existente");
    ce.setLabel_mensaje("El CUIT ingresado existe, intente nuevamente");
    ce.setVisible(true);
    }
    public void modificacionExito(){
    ModificacionExito me = new ModificacionExito();
    me.setLabel_Titulo("Modificacion Exitosa");
    me.setLabel_mensaje("Los datos fueron modificados con éxito");
    me.setVisible(true);
    }
    public void camposVacios(){
    CamposVacios ca= new CamposVacios();
    ca.setLabel_Titulo("Campos Nulos");
    ca.setLabel_mensaje("Todos los campos deben estar completos, intente nuevamente");
    ca.setVisible(true);
    
    }
        
    public void objetoLaExistente(String objeto){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Registro Existente");            
        edne.setLabel_mensaje("La "+objeto+" ingresado ya existe");
        edne.setVisible(true);
    }
    
    public void objetoExistente(String objeto){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Registro Existente");            
        edne.setLabel_mensaje("El "+objeto+" ingresado ya existe");
        edne.setVisible(true);
    }
    
    public void objetoNoExistente(String objeto){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Registro Existente");            
        edne.setLabel_mensaje("El "+objeto+" ingresado no existe");
        edne.setVisible(true);
    }
    
    public void tipoDatoInvalid(List<String> campos){
        ErrorDatoNoEncontrado edne = new ErrorDatoNoEncontrado();
        edne.setLabel_title("Error: Campo Invalido");
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
           edne.setLabel_mensaje("Campos: "+salidacampo);  
       }else{
           edne.setLabel_mensaje("Campo: "+campos.get(0));  
       }
        edne.setVisible(true);
    }
    
    public void contraseñasNoCoinciden(){
        ErrorDatoNoValido ednv = new ErrorDatoNoValido();
        ednv.setLabel_title("Error: Contraseñas No Valida");
        ednv.setLabel_mensaje("Asegurarse que las contraseñas coincidan");
        MetodosPantalla.getInstance().setearPantalla(ednv);
    }
    
    public void contraseñaVacia(){
        ErrorDatoNoValido ednv = new ErrorDatoNoValido();
        ednv.setLabel_title("Error: Contraseña No Valida");
        ednv.setLabel_mensaje("La contraseña no puede ser vacia");
        MetodosPantalla.getInstance().setearPantalla(ednv);
    }
}
 

