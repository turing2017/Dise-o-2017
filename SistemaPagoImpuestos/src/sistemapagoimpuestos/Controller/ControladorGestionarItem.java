package sistemapagoimpuestos.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Expert.ExpertoGestionarItem;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarItem.IUGestionarItem;
import sistemapagoimpuestos.View.Admin.GestionarItem.IUGestionarItemAlta;
import sistemapagoimpuestos.View.Admin.GestionarItem.IUGestionarItemModificar;

/**
 *
 * @author lunamarcos
 */
public class ControladorGestionarItem {
  
    // Experto GestionarItem
    private ExpertoGestionarItem experto = (ExpertoGestionarItem) FabricaExpertos.getInstancia().crearExperto("CU13");
    
        // Funcion para mostrar la pantalla adecuada, en base a la opción seleccionada
    public void seleccionarOpcion(String opcion, Object object) {
        switch (opcion) {
            // Si se presiona el botón de alta
            case "Alta":
                // Creo pantalla de alta
                IUGestionarItemAlta pantallaAlta = new IUGestionarItemAlta();
                // Hago visible la pantalla de alta
                pantallaAlta.setVisible(true);
                // Modifico la operación de cierre para volver a la pantalla principal, al presionar x no stopea
                pantallaAlta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                
                //pantallaAlta.generarEmpresaItems();
                // Modifico el Listener para que al presionar x genere la pantalla ppal.
                pantallaAlta.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent ev) {
                        pantallaAlta.dispose();
                        iniciar();
                    }
                });

                break; // optional
            // Si se presiona el botón de modificar
            case "Modificar":
                // Muestro pantalla de Modificación
                DTOItem dtoItem = obtenerItem((String) object);
                
                if (dtoItem != null){
                    // Creo la pantalla
                    IUGestionarItemModificar pantallaModificar = new IUGestionarItemModificar();
                    pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                    pantallaModificar.setVisible(true); // La hago visible
                    pantallaModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    pantallaModificar.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent ev) {
                            pantallaModificar.dispose();
                            iniciar();
                        }
                    });
                    pantallaModificar.setTextfield_nombre(dtoItem.getNombreItem());
                    pantallaModificar.setTextfield_longitud(dtoItem.getLongitudItem());
                    pantallaModificar.setCheckbox_requerido(dtoItem.isRequeridoItem());
                    if (dtoItem.getFechaHoraInhabilitacionItem() == null) {
                        pantallaModificar.setCheckbox_habilitado(true);
                    } else {
                        pantallaModificar.setCheckbox_habilitado(false);
                    }
                    // Completo el comboBox
                    DTOTipoDatoItem dtoTipoDatoItem = dtoItem.getDtoTipoDatoItem();
                    String nombreItemActual = dtoTipoDatoItem.getNombreTipoDatoItem();
                    List<DTOTipoDatoItem> list = buscarTipoDatoItems();
                    pantallaModificar.llenarCombo(list, nombreItemActual);
                    pantallaModificar.setNombreActual(dtoItem.getNombreItem());
                }

                break; // optional

            // You can have any number of case statements.
            default: // Optional
            // Statements
        }
    }
    
    // Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarItem pantallaPrincipal = new IUGestionarItem();
        pantallaPrincipal.setVisible(true); 
        }        
    }
    
    // Método para recuperar los TipoDatoItem
    public List<DTOTipoDatoItem> buscarTipoDatoItems(){
        List<DTOTipoDatoItem> listado = experto.buscarTipoDatoItems();
        return listado;
    }
    
    // Método para crear un Item
    public void nuevoItem(String codigoItemIngres, String nombreItemIngres, int longitudItemIngres, boolean esMontoEditableIngres, String tipoIngres){
        experto.nuevoTipoImpuesto(codigoItemIngres, nombreItemIngres, longitudItemIngres, esMontoEditableIngres, tipoIngres);   
    }
    
    // Método para obtener todos los Items
    public ArrayList<DTOItem> obtenerItems(){
        return experto.obtenerItems();
    }
    
    // Método para obtener un Item
    public DTOItem obtenerItem(String codigo){
        DTOItem dtoItem = experto.obtenerItem(codigo);
        System.out.println(dtoItem.getCodigoItem());
        DTOTipoDatoItem tipoDato = dtoItem.getDtoTipoDatoItem();
        System.out.println(tipoDato.getNombreTipoDatoItem());
        return dtoItem;
        //return experto.obtenerItem(codigo);
    }
    
    // Método para modificar un item
    public void modificarItem(String nombreActual,String nombreItem, int longitud, boolean isRequerido, boolean habilitado, String tipoIngres){
        experto.modificarItem(nombreActual, nombreItem, longitud, isRequerido, habilitado, tipoIngres);
    }
}
