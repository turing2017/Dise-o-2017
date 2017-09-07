package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoDatoItem;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import static sistemapagoimpuestos.Utils.Utils.existeDato;

/**
 *
 * @author lunamarcos
 */
public class ExpertoGestionarItem {
    
        Usuario usuario = new Usuario();
    
    // Metodo iniciar
    public String iniciar(){
        
        
        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";
    }
    
    // Método para recuperar los Tipos de Dato Item de la base de datos
    public List<DTOTipoDatoItem> buscarTipoDatoItems() {
        
        //Busqueda de todos los TipoDatoItem (sin criterios)
        List tipoDatoItems = FachadaPersistencia.getInstance().buscar("TipoDatoItem", null);
        
        List <DTOTipoDatoItem> lista = new ArrayList<>();
        DTOTipoDatoItem dtoTipoDatoItem;
        
        for (int i = 0; i < tipoDatoItems.size(); i++) {
            dtoTipoDatoItem = new DTOTipoDatoItem();
            TipoDatoItem tipoDatoItem = (TipoDatoItem) tipoDatoItems.get(i);
            String nombreTipoDatoItem = tipoDatoItem.getNombreTipoDatoItem();
            dtoTipoDatoItem.setNombreTipoDatoItem(nombreTipoDatoItem);
            lista.add(dtoTipoDatoItem);
        }
        return lista;
    }
    
    // Méotdo para crear en la db un nuevo Item
        public void nuevoTipoImpuesto(String codigoItemIngres, String nombreItemIngres, int longitudItemIngres, boolean esMontoEditableIngres, String tipoIngres){
       
        List<DTOCriterio> criteriosNombre = new ArrayList<>();
        List<DTOCriterio> criteriosCodigo = new ArrayList<>();

        DTOCriterio criterioNombre = new DTOCriterio("nombreItem", "=", nombreItemIngres);
        DTOCriterio criterioCodigo = new DTOCriterio("codigoItem", "=", codigoItemIngres);
        criteriosNombre.add(criterioNombre);
        criteriosCodigo.add(criterioCodigo);
        if(!existeDato("Item", criteriosNombre)&&!existeDato("Item", criteriosCodigo)){
            System.out.println("Codigo Ingresado No Encontrado");
            Item item = new Item();
            item.setCodigoItem(codigoItemIngres);
            item.setNombreItem(nombreItemIngres);
            item.setLongitudItem(longitudItemIngres);
            item.setRequeridoItem(esMontoEditableIngres);
            
            // Busco el iTipoDatoItem en base al nombre seleccionado
            List<DTOCriterio> criterios = new ArrayList<>();
            // Se puede crear el DTOCriterio de esta forma:
//            DTOCriterio criterio1 = new DTOCriterio();
//            criterio1.setAtributo("nombreTipoDatoItem");
//            criterio1.setOperacion("=");
//            criterio1.setValor(tipoIngres);
            // O de esta otra forma:
            DTOCriterio criterioNombreTipoDatoItem = new DTOCriterio("nombreTipoDatoItem", "=", tipoIngres);
            criterios.add(criterioNombreTipoDatoItem);
            TipoDatoItem tipoDatoItem = (TipoDatoItem)FachadaPersistencia.getInstance().buscar("TipoDatoItem", criterios).get(0);
            
            // Le seteo al Item el TipoDato
            item.setTipoDatoItem(tipoDatoItem);
            
            // Guardo el Item
            FachadaPersistencia.getInstance().guardar(item);    
        }else{
            Excepciones.getInstance().objetoExistente("Item - Codigo o Nombre ");
        }

    }
        
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOItem> obtenerItems(){
        // Obtengo la lista de objetos de la DB
        List<Object>listObject = FachadaPersistencia.getInstance().buscar("Item", null);
        ArrayList<DTOItem>listDTOItem = new ArrayList<DTOItem>();
        // Por cada uno de los objetos recibidos...
        for(Object obj : listObject){
            // Casteo a Item
            Item item = (Item) obj;
            // Creo y seteo los DTOItem
            DTOItem dtoItem = new DTOItem();
            dtoItem.setCodigoItem(item.getCodigoItem());
            dtoItem.setNombreItem(item.getNombreItem());
            dtoItem.setLongitudItem(item.getLongitudItem());
            dtoItem.setRequeridoItem(item.isRequeridoItem());
            dtoItem.setFechaHoraInhabilitacionItem(item.getFechaHoraInhabilitacionItem());
            listDTOItem.add(dtoItem);
        }
        return listDTOItem;
    }
}
