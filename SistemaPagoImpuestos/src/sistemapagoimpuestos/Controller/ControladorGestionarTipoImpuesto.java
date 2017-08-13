package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import javax.swing.JFrame;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoAlta;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoConsultar;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoModificar;


public class ControladorGestionarTipoImpuesto {
    
    private ExpertoGestionarTipoImpuesto experto = (ExpertoGestionarTipoImpuesto) FabricaExpertos.getInstancia().crearExperto("CU14");
    
    // Metodo iniciar
    public void iniciar(){
        experto.iniciar();
    }
    
    // Funcion para mostrar la pantalla adecuada, en base a la opción seleccionada
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
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
        experto.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres);
    }
    
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){  
        return  experto.obtenerTipoImpuestos();
    }
    
    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(){
        return experto.obtenerTipoImpuesto();
    }
}
