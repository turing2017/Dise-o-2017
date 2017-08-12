package sistemapagoimpuestos.Controller;

import javax.swing.JFrame;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoAlta;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoConsultar;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoModificar;

public class ControladorGestionarTipoImpuesto {
    
    ExpertoGestionarTipoImpuesto experto = new ExpertoGestionarTipoImpuesto();
    
    // Metodo iniciar
    public void iniciar(){
        experto.iniciar();
    }
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
        
    }
    
    public void opcionSeleccionada(String opcion){
        switch(opcion) {
        case "Alta" :
        // Muestro pantalla de Alta
            IUGestionarTipoImpuestoAlta pantallaAlta = new IUGestionarTipoImpuestoAlta();
            pantallaAlta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaAlta.setVisible(true); // La hago visible
        break; // optional
   
        case "Modificar" :
        // Muestro pantalla de Modificación
            IUGestionarTipoImpuestoModificar pantallaModificar= new IUGestionarTipoImpuestoModificar();
            pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaModificar.setVisible(true); // La hago visible
        break; // optional
        
        case "Consultar" :
        // Muestro pantalla de Consultar
            IUGestionarTipoImpuestoConsultar pantallaConsultar= new IUGestionarTipoImpuestoConsultar();
            pantallaConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaConsultar.setVisible(true); // La hago visible
            
        break; // optional
   
        // You can have any number of case statements.
        default : // Optional
        // Statements
        }
    }
}
