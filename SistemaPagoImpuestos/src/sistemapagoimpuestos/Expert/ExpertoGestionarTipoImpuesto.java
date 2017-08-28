package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuestoItems;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import static sistemapagoimpuestos.Utils.Utils.existeDato;

public class ExpertoGestionarTipoImpuesto {
    
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
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
       
        List<DTOCriterio> criteriosNombre = new ArrayList<>();
        List<DTOCriterio> criteriosCodigo = new ArrayList<>();

        DTOCriterio criterioNombre = new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuestoIngres);
        DTOCriterio criterioCodigo = new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuestoIngres);
        criteriosNombre.add(criterioNombre);
        criteriosCodigo.add(criterioCodigo);
        if(!existeDato("TipoImpuesto", criteriosNombre)&&!existeDato("TipoImpuesto", criteriosCodigo)){
            System.out.println("Codigo Ingresado No Encontrado");
            TipoImpuesto tipoImpuesto = new TipoImpuesto();
            tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
            tipoImpuesto.setCodigoTipoImpuesto(codigoTipoImpuestoIngres);
            tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);

            FachadaPersistencia.getInstance().guardar(tipoImpuesto);        
        }else{
            Excepciones.getInstance().objetoExistente("Tipo Impuesto - Codigo o Nombre ");

        }

    }
 
    
    
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
        // Como vuelven de la DB?
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("TipoImpuesto", null);
        ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = new ArrayList<DTOTipoImpuesto>();
        for(Object obj : listObject){
            TipoImpuesto tipoImpuesto = (TipoImpuesto) obj;
            DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
            dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
            dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
            dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
            listDtoTipoImpuesto.add(dtoTipoImpuesto);
        }
        return listDtoTipoImpuesto;
    }
    
    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo){
        // De alguna forma devuelvo el TipoImpuesto de la DB
        try{
        List<DTOCriterio> criterios = new ArrayList<>();

        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("codigoTipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(codigo);
        criterios.add(criterio1);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
        DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto(),
                                                                tipoImpuesto.getNombreTipoImpuesto(),  
                                                                tipoImpuesto.isEsMontoEditableTipoImpuesto(),
                                                                tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
        ArrayList<Empresa> empresaList = optenerEmpresaConTipoImpuesto(tipoImpuesto);
        for(Empresa tempEmp : empresaList){
            ArrayList<Item> dTOItemList = optenerItemsEmpresaConTipoImpuesto(tipoImpuesto, tempEmp);

        }
        
        // Para probar seteo uno nuevo
        dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
        dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
        dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
        dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
        return dtoTipoImpuesto;        
        }catch(IndexOutOfBoundsException exception){
            System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Tipo Impuesto");
            return null;
        }

    }
    
    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado){

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("nombreTipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(nombreActualTipoImpuesto);
        criterios.add(criterio1);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
        tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
        tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);
        if(habilitado){
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(null);
        }else{
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(new Date());
        }
        FachadaPersistencia.getInstance().guardar(tipoImpuesto);
        System.out.println("Guardando en la DB: " + tipoImpuesto.getNombreTipoImpuesto());
    }
    
    public ArrayList<DTOEmpresaItem> obtenerEmpresaItem(){
        List<Object> listEmpresa =  FachadaPersistencia.getInstance().buscar("Empresa", null);
        List<Object> listItem =  FachadaPersistencia.getInstance().buscar("Empresa", null);

        ArrayList<DTOEmpresaItem> listDtoTipoImpuesto = new ArrayList<DTOEmpresaItem>();
        for(Object obj : listEmpresa){
            TipoImpuesto tipoImpuesto = (TipoImpuesto) obj;
            DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
            dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
            dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
            dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
            //listDtoTipoImpuesto.add(dtoTipoImpuesto);
        }
        return listDtoTipoImpuesto;
    }
    
    public ArrayList<Empresa> optenerEmpresaConTipoImpuesto(TipoImpuesto tipoImpuesto){
         List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("tipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(tipoImpuesto);
        criterios.add(criterio1);
        List<Object> tipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
        ArrayList<Empresa> listEmpresa = new ArrayList<>();
        for(Object tipoImpuestoObject: tipoImpuestoObjectList){
            EmpresaTipoImpuesto empresaTipoImpuestoTemp = (EmpresaTipoImpuesto) tipoImpuestoObject;
            Empresa empresaTemp = (Empresa) empresaTipoImpuestoTemp.getEmpresa();
            listEmpresa.add(empresaTipoImpuestoTemp.getEmpresa());
        }
        return listEmpresa;
    }
    
    public ArrayList<Item> optenerItemsEmpresaConTipoImpuesto(TipoImpuesto tipoImpuesto, Empresa empresa){
         List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio("tipoImpuesto", "=", tipoImpuesto);
        DTOCriterio criterio2 = new DTOCriterio("empresa", "=", empresa);
        criterios.add(criterio1);
        criterios.add(criterio2);
        List<Object> tipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
        ArrayList<DTOEmpresa> listDTOEmpresa = new ArrayList<>();
        for(Object tipoImpuestoObject: tipoImpuestoObjectList){
            EmpresaTipoImpuesto empresaTipoImpuestoTemp = (EmpresaTipoImpuesto) tipoImpuestoObject;
            
            List<Object> itemEmpresaTipoImpuestoObjectLis = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterios);
    
        }
        return null;
    }
}
