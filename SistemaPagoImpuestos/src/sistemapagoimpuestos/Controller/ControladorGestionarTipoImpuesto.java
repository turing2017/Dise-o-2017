package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoAlta;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoEmpresaTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoModificar;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoModificarTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoModificacionItem;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoModificarETI;

public class ControladorGestionarTipoImpuesto {

public void guardarEmpresaTipoImpuesto(String cuit,String nombre,String nuevoTipoImpuesto, String nuevoTipoEmpresa, int frecuenciaLiquidacion){
    experto.guardarEmpresaTipoImpuesto(cuit, nombre, nuevoTipoImpuesto, nuevoTipoEmpresa, frecuenciaLiquidacion);
}    
    
    public ControladorGestionarTipoImpuesto() {
    }
    private ExpertoGestionarTipoImpuesto experto = (ExpertoGestionarTipoImpuesto) FabricaExpertos.getInstancia().crearExperto("CU14");
    
    // Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarTipoImpuesto pantallaPrincipal = new IUGestionarTipoImpuesto();
        pantallaPrincipal.setVisible(true); 
        }        
    }
     public void validarUsuario() {
        try {
            experto.validarUsuario();
            IUGestionarTipoImpuesto iuGestionarTipoImpuesto = new IUGestionarTipoImpuesto();
            iuGestionarTipoImpuesto.setVisible(true);

        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es Administrador");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }
    public int setearFrecuencia(String nombreTipoImpuesto, String cuitEmpresa, String nombreTipoEmpresa){
       return experto.setearFrecuencia(nombreTipoImpuesto, cuitEmpresa, nombreTipoEmpresa);
    }
    public void modificarETI(String cuitEmpresa, String nombreTI, String nombreTE, boolean estadoETI, boolean montoEditable){
        IUGestionarTipoImpuestoModificarETI pantallaModificarETI = new IUGestionarTipoImpuestoModificarETI(cuitEmpresa, nombreTI,nombreTE, estadoETI, montoEditable);
        pantallaModificarETI.setVisible(true);
    }
        
    
    
    public void iniciar(String cuitEmpresa){
        
        IUGestionarTipoImpuesto pantallaPrincipal = new IUGestionarTipoImpuesto(cuitEmpresa);
        pantallaPrincipal.setVisible(true); 
    }
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres, List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItems){
        experto.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres);
    }
    //Metodo para modificar TipoImpuesto
    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado){
        experto.modificarTipoImpuesto(nombreTipoImpuestoIngres, nombreActualTipoImpuesto, esMontoEditableIngres, habilitado);
        
    }
    
    public ArrayList<DTOTipoImpuesto> buscarTipoImpuestos(){
        return experto.buscarTipoImpuestos();
    }
    
    
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){  
        return  experto.obtenerTipoImpuestos();
    }
    
    public void eliminarItem(String nombreItem, String  cuitEmpresa,int  codigoTipoImpuesto,String  nombreTipoEmpresa,int ordenItem){
        experto.eliminarItem(nombreItem,  cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa, ordenItem);
    }
    
   public void asociarEmpresa(String cuitEmpresa){
        IUGestionarTipoImpuesto pantallaAsociar;
        pantallaAsociar = new IUGestionarTipoImpuesto(cuitEmpresa);
        pantallaAsociar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
        pantallaAsociar.setVisible(true); // La hago visible
   }
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerEmpresaTipoImpuesto(String cuitEmpresa){
        
        return  experto.obtenerEmpresaTipoImpuesto(cuitEmpresa);
        
    }
    
    public void modificarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto,String nombreTipoEmpresa, int ordenItem){
        IUGestionarTipoImpuestoModificacionItem modificarItem = new IUGestionarTipoImpuestoModificacionItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, nombreTipoEmpresa, ordenItem);
        modificarItem.setVisible(true);
    }
    
    
    public void asociarETI(String cuitEmpresa){
        IUGestionarTipoImpuestoEmpresaTipoImpuesto pantallaETI = new IUGestionarTipoImpuestoEmpresaTipoImpuesto(cuitEmpresa);
        pantallaETI.setVisible(true); // La hago visible 
    
    }
    
    public DTOEmpresa buscarEmpresa(String cuitEmpresa){
        return experto.buscarEmpresa(cuitEmpresa);
    }
   
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestosEmpresa(String cuitEmpresa){
        
        return  experto.obtenerTipoImpuestosEmpresa(cuitEmpresa);
    }
    
    public void ModificarETI(String nombreTE, String nombreTI, String cuit, String  nuevoTE, String nuevoTI, int frec, boolean habilitada){
        experto.ModificarETI(nombreTE, nombreTI, cuit, nuevoTE, nuevoTI, frec, habilitada);
    }
    
    public void mostrarPantallaAlta(String cuilEmpresa) {
        IUGestionarTipoImpuestoAlta pantallaAlta = new IUGestionarTipoImpuestoAlta(cuilEmpresa);
        pantallaAlta.setVisible(true); // La hago visible
        // Modifico la operación de cierre para volver a la pantalla principal
        pantallaAlta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        IUGestionarTipoImpuestoAlta.setDtoetiisModfAlta(new ArrayList<DTOEmpresaTipImpItem>());
        pantallaAlta.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                iniciar();
            }
        });
    }

    public List<DTOTipoEmpresa> buscarTipoEmpresa(){
    return experto.buscarTipoEmpresa();
    }
    
    public List<DTOTipoImpuesto> buscarTipoImpuesto(){
    return experto.buscarTipoImpuesto();
    }

    
    public void mostrarItems(String cuitEmpresa, int codigoTipoImpuesto, String nombreTE){
        IUGestionarTipoImpuestoItems pantallaItems = new IUGestionarTipoImpuestoItems(cuitEmpresa, codigoTipoImpuesto, nombreTE);
        pantallaItems.setVisible(true);
        pantallaItems.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    
    public void mostrarPantallaModificacion(Object object) {
        DTOTipoImpuesto dtoTi = obtenerTipoImpuesto((int) object);
        if (dtoTi != null) {
            IUGestionarTipoImpuestoModificar pantallaModificar = new IUGestionarTipoImpuestoModificar();
            pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaModificar.setVisible(true); // La hago visible
            // Modifico la operación de cierre para volver a la pantalla principal
            pantallaModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            pantallaModificar.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                    iniciar();
                }
            });
            pantallaModificar.setNombre_actual(dtoTi.getNombreDTOTipoImpuesto());
            pantallaModificar.setTextfield_nombre(dtoTi.getNombreDTOTipoImpuesto());
            pantallaModificar.setCheckbox_esEditable(dtoTi.isEsMontoEditableDTOTipoImpuesto());
            if (dtoTi.getFechaHoraInhabilitacionDTOTipoImpuesto() == null) {
                pantallaModificar.setCheckbox_Habilitar(true);
            } else {
                pantallaModificar.setCheckbox_Habilitar(false);
            }
        }
    }
    public void mostrarPantallaModificacionEmpresa(Object object,String cuitEmpresa){
        DTOTipoImpuesto dtoTi = obtenerTipoImpuesto((int) object);
        if (dtoTi != null) {
            IUGestionarTipoImpuestoModificarTipoImpuesto pantallaModificarEmpresa = new IUGestionarTipoImpuestoModificarTipoImpuesto(cuitEmpresa);
            pantallaModificarEmpresa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaModificarEmpresa.setVisible(true); // La hago visible
            // Modifico la operación de cierre para volver a la pantalla principal
            pantallaModificarEmpresa.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            pantallaModificarEmpresa.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                    iniciar();
                }
            });
            pantallaModificarEmpresa.setNombre_actual(dtoTi.getNombreDTOTipoImpuesto());
            pantallaModificarEmpresa.setTextfield_nombre(dtoTi.getNombreDTOTipoImpuesto());
            pantallaModificarEmpresa.setCheckbox_esEditable(dtoTi.isEsMontoEditableDTOTipoImpuesto());
            if (dtoTi.getFechaHoraInhabilitacionDTOTipoImpuesto() == null) {
                pantallaModificarEmpresa.setCheckbox_Habilitar(true);
            } else {
                pantallaModificarEmpresa.setCheckbox_Habilitar(false);
            }
        }
    }

    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo){
        return experto.obtenerTipoImpuesto(codigo);
    }

}
