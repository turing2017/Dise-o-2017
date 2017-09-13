/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaCrear;
import sistemapagoimpuestos.View.Admin.IUGestionarEmpresaAdheridaModificacion;
/**
 *
 * @author Tongas
 */
public class ControladorGestionarEmpresaAdherida {
   
    private ExpertoGestionarEmpresaAdherida experto = (ExpertoGestionarEmpresaAdherida) FabricaExpertos.getInstancia().crearExperto("CU10");
 
// Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarEmpresaAdherida pantallaPrincipal = new IUGestionarEmpresaAdherida();
        pantallaPrincipal.setVisible(true); 
        }   
// Funcion para mostrar la pantalla adecuada, en base a la opción seleccionada
    }
    
    public ArrayList<DTOEmpresa> consultarEmpresas (){
    return experto.consultarEmpresas();
}
    
    public void modificarEmpresa (String cuit,String nombre, String direccion,boolean habilitada) {
    
    experto.modificarEmpresa(cuit, nombre, direccion,  habilitada);
        
    }
   
    public void ingresarDatosEmpresa(String cuit, String nombre, String direccion, boolean habilitada){
       experto.ingresarDatosEmpresa(cuit, nombre, direccion, habilitada);
    }
    
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa, String direccionEmpresa, String habilitada){
        return experto.cargarDatos(cuitEmpresa, nombreEmpresa, direccionEmpresa, habilitada);
    }
    
     public void seleccionarOpcion(String opcion, Object evt, Object controlador){
        switch(opcion) {
        case "NuevaEmpresa" :
        // Muestro pantalla de Nueva Empresa
            IUGestionarEmpresaAdheridaCrear pantallaCrear = new IUGestionarEmpresaAdheridaCrear(controlador);
            pantallaCrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaCrear.setVisible(true); // La hago visible
           
        break; // optional
        
        case "Modificar" :
        // Muestro pantalla de Modificación
        Vector vct = new Vector();
        vct = (Vector) evt;
        DTOEmpresaExistente dtoEe = cargarDatos(vct.get(0).toString(), vct.get(1).toString(), vct.get(2).toString(),  vct.get(3).toString());
        if(dtoEe!= null){
        final IUGestionarEmpresaAdheridaModificacion pantallaModificacion = new IUGestionarEmpresaAdheridaModificacion(dtoEe);
        pantallaModificacion.setVisible(true);
        // Modifico la operación de cierre para volver a la pantalla principal
                    pantallaModificacion.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    pantallaModificacion.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent ev) {
                            pantallaModificacion.dispose();
                            iniciar();
                        }
                    });
          
        } 
  
  
        break; // optional
        
            
        
     }
     }
  
  }

