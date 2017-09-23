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
import sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida.IUGestionarEmpresaAdheridaCrear;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaAdherida.IUGestionarEmpresaAdheridaModificacion;


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
    
    public ArrayList<DTOEmpresaTipoImpuesto> consultarEmpresas (){
    return experto.consultarEmpresas();
}
    
    public void modificarEmpresa (String cuit,String nombre,String tipoImpuesto, String tipoEmpresa, String direccion,boolean habilitada, String fechaLiquidacion) {
    
    experto.modificarEmpresa(cuit, nombre, tipoImpuesto, tipoEmpresa, direccion,  habilitada, fechaLiquidacion);
        
    }
   
    public void ingresarDatosEmpresa(String cuit, String nombre, String tipoImpuesto, String tipoEmpresa, String fechaLiquidacion, boolean habilitada, String direccion ){
       experto.ingresarDatosEmpresa(cuit, nombre, tipoImpuesto, tipoEmpresa, fechaLiquidacion, habilitada, direccion);
    }
    
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa, String tipoImpuesto, String tipoEmpresa, String direccionEmpresa, String habilitada){
        return experto.cargarDatos(cuitEmpresa, nombreEmpresa, tipoImpuesto, tipoEmpresa, direccionEmpresa, habilitada);
    }
    public List<DTOTipoEmpresa> buscarTipoEmpresa(){
    return experto.buscarTipoEmpresa();
    }
    
    public List<DTOTipoImpuesto> buscarTipoImpuesto(){
    return experto.buscarTipoImpuesto();
    }
    
    public void crearEmpresa(Object evt, Object controlador){
        // Muestro pantalla de Nueva Empresa
            IUGestionarEmpresaAdheridaCrear pantallaCrear = new IUGestionarEmpresaAdheridaCrear(controlador);
            pantallaCrear.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaCrear.setVisible(true); // La hago visible
     }
        
    public void modificarEmpresa(Object evt, Object controlador){
        // Muestro pantalla de Modificación
        Vector vct = new Vector();
        vct = (Vector) evt;
        DTOEmpresaExistente dtoEe = cargarDatos(vct.get(0).toString(), vct.get(1).toString(), vct.get(2).toString(),  vct.get(3).toString(), vct.get(4).toString(), vct.get(5).toString());
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
                );
          
        }
     }
  
  }

