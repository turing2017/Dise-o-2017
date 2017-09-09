package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Entity.TipoDatoItem;
import sistemapagoimpuestos.Expert.ExpertoGestionarItem;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author lunamarcos
 */
public class DecoradorGestionarItem extends ExpertoGestionarItem{
    
    // Debemos utilizarlo como singletone
    private static DecoradorGestionarItem decoradorGestionarItem;
    public DecoradorGestionarItem() {      
    } 
    public static DecoradorGestionarItem getInstance()
    {
        if (decoradorGestionarItem == null)
        {
            decoradorGestionarItem = new DecoradorGestionarItem();
        }
        return decoradorGestionarItem;
    }
    
    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar();
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }
    
    @Override
    public List<DTOTipoDatoItem> buscarTipoDatoItems() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoDatoItem> tempString = super.buscarTipoDatoItems();
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }

    @Override
    public void nuevoTipoImpuesto(String codigoItemIngres, String nombreItemIngres, int longitudItemIngres, boolean esMontoEditableIngres, String tipoIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoTipoImpuesto(codigoItemIngres, nombreItemIngres, longitudItemIngres, esMontoEditableIngres, tipoIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public ArrayList<DTOItem> obtenerItems() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOItem> dtoItems = super.obtenerItems();
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoItems;
    }

    @Override
    public DTOItem obtenerItem(String codigo) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOItem dtoItem = super.obtenerItem(codigo);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoItem;
    }

    @Override
    public void modificarItem(String nombreActual, String nombreItem, int longitud, boolean isRequerido, boolean habilitado, String tipoIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarItem(nombreActual, nombreItem, longitud, isRequerido, habilitado, tipoIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    
    
}
