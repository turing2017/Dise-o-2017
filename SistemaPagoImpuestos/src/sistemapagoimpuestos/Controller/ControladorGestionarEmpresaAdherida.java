/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaAdherida;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida.IUGestionarEmpresaAdherida;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida.IUGestionarEmpresaAdheridaCrearEmpresa;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida.IUGestionarEmpresaAdheridaModificacion;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida.IUGestionarEmpresaAdheridaCrearEmpresa;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuesto;


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
    
    public List<ItemEmpresaTipoImpuesto> setearTabla(Vector vct){
        return experto.setearTabla(vct);
    }
    
    public void modificarItemEmpresaTipoImpuesto (DTOEmpresaTipImpItem dTOEmpresaTipImpItemList){
        experto.modificarItemEmpresaTipoImpuesto(dTOEmpresaTipImpItemList);
    }
            
            
        public void modificarEmpresa(Object eE, Object controlador){
        // Muestro pantalla de Modificación
        Vector vct = new Vector();
        vct = (Vector) eE;
        DTOEmpresaExistente dtoEe = cargarDatos(vct.get(0).toString(), vct.get(1).toString(), vct.get(2).toString(), vct.get(3).toString());
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
                    }
                )
                            ;
          
        }
     }
    
    public List<DTOItem> buscarItems(){
        return experto.buscarItems();
    }
    
    public void asociarEmpresa(String cuitEmpresa){
   
    IUGestionarTipoImpuesto pantallaAsociar = new IUGestionarTipoImpuesto(cuitEmpresa);
    pantallaAsociar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
    pantallaAsociar.setVisible(true); // La hago visible
    
    }
    public void ingresarDatosEmpresa(String cuitEmpresa, String tipoImpuesto, String tipoEmpresa, int frecuencia){
       experto.ingresarDatosEmpresa(cuitEmpresa, tipoImpuesto, tipoEmpresa, frecuencia);
    }
    public void ingresarDatosEmpresaCrear(String cuitEmpresa,String nombreEmpresa,String direccionEmpresa,boolean habilitada){
           experto.ingresarDatosEmpresaCrear(cuitEmpresa,nombreEmpresa,direccionEmpresa,habilitada);
    }
    
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa, String direccionEmpresa, String habilitada){
        return experto.cargarDatos(cuitEmpresa, nombreEmpresa, direccionEmpresa, habilitada);
    }
    public List<DTOTipoEmpresa> buscarTipoEmpresa(){
    return experto.buscarTipoEmpresa();
    }
    
    public List<DTOTipoImpuesto> buscarTipoImpuesto(){
    return experto.buscarTipoImpuesto();
    }
    
    public List<DTOEmpresa> buscarEmpresa(){
    return experto.buscarEmpresa();
    }
    
    public List<DTOEmpresaTipoImpuesto> consultarTipoImpuesto(Vector vct){
        return experto.verTipoImpuesto(vct);
    }
    

    
    public void crearEmpresa(Object evt, Object controlador){
        // Muestro pantalla de Nueva Empresa
            IUGestionarEmpresaAdheridaCrearEmpresa pantallaCrear = new IUGestionarEmpresaAdheridaCrearEmpresa(controlador);
            pantallaCrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaCrear.setVisible(true); // La hago visible
     }
      public void crearEmpresaCrear(Object controlador){
        // Muestro pantalla de Nueva Empresa
            IUGestionarEmpresaAdheridaCrearEmpresa pantallaCrear = new IUGestionarEmpresaAdheridaCrearEmpresa(controlador);
            pantallaCrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaCrear.setVisible(true); // La hago visible
     }     
 
  
  }

