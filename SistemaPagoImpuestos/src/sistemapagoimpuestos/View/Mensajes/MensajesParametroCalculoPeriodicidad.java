/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.View.Mensajes;

/**
 *
 * @author Dario
 */
public class MensajesParametroCalculoPeriodicidad extends Mensajes {

    private static MensajesParametroCalculoPeriodicidad mensaje;
    
    public MensajesParametroCalculoPeriodicidad() {
       
    }
    
    public static MensajesParametroCalculoPeriodicidad getInstance()
    {
        if (mensaje == null)
        {
            mensaje = new MensajesParametroCalculoPeriodicidad();
        }
        return mensaje;
    }
        
    public void modificacionExitosa(){
        modificacionExitosa("Los parámetros de cálculo de periodicidad" + "\n" + "fueron actualizados con éxito.");
    }
    
    public void modificacionFallida(){
        modificacionFallida("Ocurrió un error y los parámetros de cálculo de periodicidad" + "\n" + "no pudieron ser actualizados.");
    }
    
    
   
}
