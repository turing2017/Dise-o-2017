package sistemapagoimpuestos.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoAlta;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoAltaItem;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoModificar;


public class ControladorGestionarTipoImpuesto {

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
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres, List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItems){
        experto.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres);
    }
    //Metodo para modificar TipoImpuesto
    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado,List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItems){
        experto.modificarTipoImpuesto(nombreTipoImpuestoIngres, nombreActualTipoImpuesto, esMontoEditableIngres, habilitado);
        
    }
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){  
        return  experto.obtenerTipoImpuestos();
    }
    
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestosEmpresa(String cuitEmpresa){  
        return  experto.obtenerTipoImpuestosEmpresa(cuitEmpresa);
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
    
    public void mostrarItems(String cuitEmpresa, int codigoTipoImpuesto){
        IUGestionarTipoImpuestoItems pantallaItems = new IUGestionarTipoImpuestoItems(cuitEmpresa, codigoTipoImpuesto);
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
    
    
    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo){
        return experto.obtenerTipoImpuesto(codigo);
    }
    
    // Muestro pantalla agregar
    public void agregarItem(String cuitEmpresa, int codigoTipoImpuesto){
        IUGestionarTipoImpuestoAltaItem pantallaAltaItem = new IUGestionarTipoImpuestoAltaItem(cuitEmpresa, codigoTipoImpuesto);
        pantallaAltaItem.setVisible(true);
        pantallaAltaItem.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}
