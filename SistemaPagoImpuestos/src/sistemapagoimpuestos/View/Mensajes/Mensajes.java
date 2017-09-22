/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Mensajes;

import javax.swing.JOptionPane;

/**
 *
 * @author Dario
 */
public class Mensajes {
    
    public Mensajes() {
        
    }
    
    private void mensajeExitoso(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,
        titulo, JOptionPane.PLAIN_MESSAGE);
    }
    
    private void mensajeFallido(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,
        titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeInformacion(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,
        titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeAdvertencia(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,
        titulo, JOptionPane.WARNING_MESSAGE);
    }
        
    public void creacionExitosa(String mensaje){
        mensajeExitoso("CREACIÓN EXITOSA", mensaje);
    }
    
    public void modificacionExitosa(String mensaje){
        mensajeExitoso("MODIFICACIÓN EXITOSA", mensaje);
    }
    
    public void eliminacionExitosa(String mensaje){
        mensajeExitoso("ELIMINACIÓN EXITOSA", mensaje);
    }
    
    public void creacionFallida(String mensaje){
        mensajeFallido("CREACIÓN CON ERROR", mensaje);
    }
    
    public void modificacionFallida(String mensaje){
        mensajeFallido("MODIFICACIÓN CON ERROR", mensaje);
    }
    
    public void eliminacionFallida(String mensaje){
        mensajeFallido("ELIMINACIÓN CON ERROR", mensaje);
    }    
       
    public void datosFaltantes(String campo){
        if (campo.equals("")){
            mensajeInformacion("COMPLETE DATOS OBLIGATORIOS", "Todos los campos deben ser ingresados.");            
        }else{
            mensajeInformacion("COMPLETE DATOS OBLIGATORIOS", "Debe ingresar un valor para " + campo);            
        }
        
    }
    
    public void datosIncorrectos(String campo, String mensajeFormato){
        if (campo.equals("")){
            mensajeInformacion("VERIFIQUE DATOS INGRESADOS", "Verifique el formato de los valores ingresados.\n" + mensajeFormato);
        }else{
            mensajeInformacion("VERIFIQUE DATOS INGRESADOS", "Verifique el valor ingresado en " + campo + "\n" + mensajeFormato);
        }        
    }
     
}
