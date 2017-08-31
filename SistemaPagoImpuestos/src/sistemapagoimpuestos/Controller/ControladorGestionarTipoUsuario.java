
package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarTipoUsuario.IUGestionarTipoUsuario;


public class ControladorGestionarTipoUsuario {

private static ControladorGestionarTipoUsuario controladorGestionarTipoUsuario;

    public ControladorGestionarTipoUsuario() {
    }
   //singleton 
    public static ControladorGestionarTipoUsuario getInstance(){
        
        if (controladorGestionarTipoUsuario == null)
        {
            controladorGestionarTipoUsuario = new ControladorGestionarTipoUsuario();
        }
        return controladorGestionarTipoUsuario;
        
        }
    
    private ExpertoGestionarTipoUsuario experto = (ExpertoGestionarTipoUsuario) FabricaExpertos.getInstancia().crearExperto("CU06");
    
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarTipoUsuario pantallaPrincipal = new IUGestionarTipoUsuario();
        pantallaPrincipal.setVisible(true); 
        }  
    } 
           
    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario(){
        return experto.obtenerTipoUsuario();
    
    }
    
    public void nuevoTipoUsuario(String nombreTipoUsuario){
        experto.nuevoTipoUsuario(nombreTipoUsuario);           
    
    }
    
}

