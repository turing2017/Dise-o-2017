package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuestoTipoImpuesto;
import sistemapagoimpuestos.Dto.DtoItemOrdenGestionarTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author lunamarcos
 */
public class ControladorGestionarEmpresaTipoImpuesto {
    
    ExpertoGestionarEmpresaTipoImpuesto experto = (ExpertoGestionarEmpresaTipoImpuesto) FabricaExpertos.getInstancia().crearExperto("CU15");
    
    // Método para crear un ETI
    // Método para recueprar los tipos de empresas
    public List<DTOTipoEmpresa> obtenerTipoEmpresas(){
        return experto.obtenerTipoEmpresas();
    }
    
    // Recuperar Items
    public ArrayList<DtoItemOrdenGestionarTipoImpuesto> obtenerItems(String cuitEmpresa, int codigoTipoImpuesto, String nombreTE){
        return experto.obtenerItems(cuitEmpresa, codigoTipoImpuesto, nombreTE);
    }
    
    
    public List<DTOTipoImpuestoTipoImpuesto> obtenerTipoImpuesto(){
        return experto.obtenerTipoImpuesto();
    }
    
    public void modificarItem(String nombreItem,String cuitEmpresa,int codigoTipoImpuesto,String nombreTipoEmpresa, int orden,int ordenAnterior){
        experto.modificarItem(nombreItem, cuitEmpresa,codigoTipoImpuesto,nombreTipoEmpresa,orden, ordenAnterior);
    }
    
    
    // Recuperar todos los items
    public List<DTOItem> obtenerTodosItems(){
        return experto.obtenerTodosItems();
    }
    
    // Agrego item
    public void agregarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, String nombreTE, int orden){
        experto.agregarItem(nombreItem, cuitEmpresa, codigoTipoImpuesto, nombreTE, orden);
    }
}
