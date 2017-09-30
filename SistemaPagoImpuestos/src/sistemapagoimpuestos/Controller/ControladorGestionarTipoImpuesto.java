package sistemapagoimpuestos.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Dto.DTOEmpresaItem;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoAlta;
import sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoEmpresa;
import static sistemapagoimpuestos.View.Admin.GestionarTipoImpuesto.IUGestionarTipoImpuestoItems.setNuevoTipoImpuesto;
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
    
    public void mostrarPantallaAlta() {
        IUGestionarTipoImpuestoAlta pantallaAlta = new IUGestionarTipoImpuestoAlta();
        pantallaAlta.setVisible(true); // La hago visible
        // Modifico la operación de cierre para volver a la pantalla principal
        pantallaAlta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pantallaAlta.generarEmpresaItems();
        IUGestionarTipoImpuestoAlta.setDtoetiisModfAlta(new ArrayList<DTOEmpresaTipImpItem>());
        pantallaAlta.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                iniciar();
            }
        });
    }
    
    public void mostrarPantallaGestionETI(String codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean editableTipoImpuestoIngres){
        IUGestionarTipoImpuestoEmpresa pantallaGestionarETI = new IUGestionarTipoImpuestoEmpresa(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, editableTipoImpuestoIngres);
        MetodosPantalla.getInstance().setearPantalla(pantallaGestionarETI);
        setNuevoTipoImpuesto(true);
        pantallaGestionarETI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
            pantallaModificar.obtenerEmpresaItems(dtoTi.getdTOEmpresaTipoImpuestoItemList());
            pantallaModificar.RecuperarEmpresaItems();
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

}
