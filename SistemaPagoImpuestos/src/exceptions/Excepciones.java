/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.List;
import sistemapagoimpuestos.View.Errors.CamposVacios;
import sistemapagoimpuestos.View.Errors.CuitExistente;
import sistemapagoimpuestos.View.Errors.CuitNoExistente;
import sistemapagoimpuestos.View.Errors.EmpresaCreada;
import sistemapagoimpuestos.View.Errors.ModificacionExito;

import sistemapagoimpuestos.View.Errors.ObjetoNoSeleccionado;
import sistemapagoimpuestos.View.Errors.UsuarioNoValido;

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
    public void empresaCreada(){
    EmpresaCreada Ec= new EmpresaCreada();
    Ec.setLabel_Titulo("Empresa Creada");
    Ec.setLabel_mensaje("La empresa fue creada con éxito");
    Ec.setVisible(true);
    }
    public void usuarioNoValido(){
        UsuarioNoValido unv = new UsuarioNoValido();
        unv.setLabel_title("Usuario Incorrecto");
        unv.setLabel_mensaje(" No tiene la autorizacion para realizar esta operación");
        unv.setVisible(true);
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
}
 

