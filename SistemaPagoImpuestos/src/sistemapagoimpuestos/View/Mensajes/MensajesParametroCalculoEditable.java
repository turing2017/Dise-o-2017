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
public class MensajesParametroCalculoEditable extends Mensajes {

  private static MensajesParametroCalculoEditable mensaje;
  
  
    public MensajesParametroCalculoEditable() {
       
    }                                     
  
    public static MensajesParametroCalculoEditable getInstance()
    {
        if (mensaje == null)
        {
            mensaje = new MensajesParametroCalculoEditable();
        }
        return mensaje;
    }
        
    public void modificacionExitosa(){
        modificacionExitosa("Los parámetros de cálculo editable" + "\n" + "fueron actualizados con éxito.");
    }
    
    public void modificacionFallida(){
        modificacionFallida("Ocurrió un error y los parámetros de cálculo editable" + "\n" + "no pudieron ser actualizados.");
    }
                  
}


