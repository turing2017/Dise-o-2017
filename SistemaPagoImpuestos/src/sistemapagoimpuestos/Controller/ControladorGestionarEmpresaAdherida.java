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
        switch(opcion) {
        case "NuevaEmpresa" :
        // Muestro pantalla de Nueva Empresa
            IUGestionarEmpresaAdheridaNueva pantallaNuevaEmpresa = new IUGestionarEmpresaAdheridaNueva();
            pantallaNuevaEmpresa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaNuevaEmpresa.setVisible(true); // La hago visible
        break; // optional
        }
    }
    //crea una empresa
    public void ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa){
        experto.ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa);
    }
}

