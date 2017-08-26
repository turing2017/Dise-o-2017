/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;


import javax.swing.JFrame;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaNueva;
import java.lang.String;
import java.util.Vector;
import sistemapagoimpuestos.Dto.DTOConsultarEmpresas;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdherida;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaConsultarEmpresa;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaModificacion;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaMuestra;
import javax.swing.table.DefaultTableModel;
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
        
        case "Modificar" :
        // Muestro pantalla de Modificación
            experto.modificarDatosEmpresa(object.toString());
  
        break; // optional
        
            
        case "ConsultarEmpresa" :
        IUGestionarEmpresaAdheridaConsultarEmpresa pantallaConsultarEmpresa = new IUGestionarEmpresaAdheridaConsultarEmpresa();
        pantallaConsultarEmpresa.setVisible(true);
        break;
        }
    }
    public void modificarDatosEmpresa (String nombreEmpresa, String cuitEmpresa, String direccionEmpresa){
        
        IUGestionarEmpresaAdheridaModificacion pantallaModificacion = new IUGestionarEmpresaAdheridaModificacion();
            
        
    }
    
    public void seleccionarModificar (String nombreEmpresa, String direccionEmpresa) {
    
        experto.seleccionarModificar(nombreEmpresa, direccionEmpresa);
    }
    
    public void seleccionarEliminar (String cuitEmpresa){
        experto.seleccionarEliminar(cuitEmpresa);
    }
    
    public DTOConsultarEmpresas ingresarOpcion (String opcion){
        
        return experto.ingresarOpcion(opcion);
        
    }
    
    public void mostrarConsulta (DTOConsultarEmpresas dto){
        
        IUGestionarEmpresaAdheridaMuestra pantallaMuestra = new IUGestionarEmpresaAdheridaMuestra();
        dto.getListaDTOEmpresaHabilitada();
        
        DefaultTableModel modelo = new DefaultTableModel();
        for (int i=0; i <= dto.getListaDTOEmpresaHabilitada().size(); i++){
            
            //modelo.addRow((Vector) dto.getListaDTOEmpresaHabilitada().get(i)); 
            
        }
     
    
    }
    
    public void ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa){
        experto.ingresarDatosEmpresa(cuitEmpresa, nombreEmpresa, direccionEmpresa);
    }
    
}

