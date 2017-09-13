package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Expert.ExpertoGestionarItem;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarItem.IUGestionarItem;

/**
 *
 * @author lunamarcos
 */
public class ControladorGestionarItem {
    
    public ControladorGestionarItem() {      
    }
  
    // Experto GestionarItem
    private ExpertoGestionarItem experto = (ExpertoGestionarItem) FabricaExpertos.getInstancia().crearExperto("CU13");
    
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
