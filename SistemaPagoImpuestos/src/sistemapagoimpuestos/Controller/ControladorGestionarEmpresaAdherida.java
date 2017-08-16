/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;


import javax.swing.JFrame;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaNueva;
import java.lang.String;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdherida;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaModificacion;
/**
 *
 * @author Tongas
 */
public class ControladorGestionarEmpresaAdherida {
    
    private static ControladorGestionarEmpresaAdherida controladorGestionarEmpresaAdherida;

    public ControladorGestionarEmpresaAdherida() {
    }
    
    public static ControladorGestionarEmpresaAdherida getInstance()
    {
        if (controladorGestionarEmpresaAdherida == null)
        {
            controladorGestionarEmpresaAdherida = new ControladorGestionarEmpresaAdherida();
        }
        return controladorGestionarEmpresaAdherida;
    }
    
    private ExpertoGestionarEmpresaAdherida experto = (ExpertoGestionarEmpresaAdherida) FabricaExpertos.getInstancia().crearExperto("CU10");
 
// Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarEmpresaAdherida pantallaPrincipal = new IUGestionarEmpresaAdherida();
        pantallaPrincipal.setVisible(true); 
        }   
// Funcion para mostrar la pantalla adecuada, en base a la opción seleccionada
    }
   
    public void opcionSeleccionada(String opcion, Object object){
        /*switch(opcion) {
        case "NuevaEmpresa" :
        // Muestro pantalla de Nueva Empresa
            IUGestionarEmpresaAdheridaNueva pantallaNuevaEmpresa = new IUGestionarEmpresaAdheridaNueva();
            pantallaNuevaEmpresa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaNuevaEmpresa.setVisible(true); // La hago visible
        break; // optional
        
        case "Modificar" :
        // Muestro pantalla de Modificación
            DTOEmpresa DTOEmpresaExistente = obtenerEmpresa ((int) object);
            if(DTOEmpresaExistente != null){
                IUGestionarEmpresaAdheridaModificacion pantallaModificar= new IUGestionarEmpresaAdheridaModificacion();
                pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                pantallaModificar.setVisible(true); // La hago visible
                pantallaModificar.setTextField_Nombre(DTOEmpresaExistente.getNombreDTOEmpresaExistente());
                pantallaModificar.setTextField_Direccion(DTOEmpresaExistente.getDireccionDTOEmpresaExiste());
                pantallaModificar.setTextField_Cuit(DTOEmpresaExistente.getCuitDTOEmpresaExistente());
                TextField_Cuit.setEditable(false);//hay que ver como se bloquea una vez que lo trae de la bd
                
                
            
        break; // optional
        }*/
    }
    //crea una empresa
    /*public void ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa){
        experto.ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa);
    }*/
    
    public void seleccionarEliminaroModificar (String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado){
//        experto.modificarTipoImpuesto(nombreTipoImpuestoIngres, nombreActualTipoImpuesto, esMontoEditableIngres, habilitado);
        
    }
}

