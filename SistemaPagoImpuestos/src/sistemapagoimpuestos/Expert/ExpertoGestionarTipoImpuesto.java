package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuestoItems;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DtoItemOrden;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import static sistemapagoimpuestos.Utils.Utils.existeDato;

public class ExpertoGestionarTipoImpuesto {

    Usuario usuario = new Usuario();

    // Metodo iniciar
    public String iniciar() {

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
        criteriosNombre.add(new DTOCriterio(
                                            "nombreTipoImpuesto", 
                                            "=",
                                            nombreTipoImpuestoIngres));
        if(!existeDato("TipoImpuesto", criteriosNombre)&&!existeDato("TipoImpuesto", criteriosNombre)){
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
    
    public void nuevaEmpresaTipoImpuesto(String nombreTipoImpuestoIngres, List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItem){
        List<DTOCriterio> criteriosNombreTipoImpuesto = new ArrayList<>();


        criteriosNombreTipoImpuesto.add(new DTOCriterio(
                                            "nombreTipoImpuesto", 
                                            "=",
                                            nombreTipoImpuestoIngres));
        TipoImpuesto tipoImpuesto = 
                (TipoImpuesto) 
                FachadaPersistencia.
                getInstance().
                buscar("TipoImpuesto",
                        criteriosNombreTipoImpuesto).get(0);
        List<EmpresaTipoImpuesto> empresaTipoImpuestoList= new ArrayList<>();
        for(DTOEmpresaTipImpItem  dTOEmpresaTipImpItem1 :dTOEmpresaTipImpItem){

            List<DTOCriterio> criteriosNombreTipoEmpresa = new ArrayList<>();
            List<DTOCriterio> criteriosNombreEmpresa = new ArrayList<>();     
        
            criteriosNombreEmpresa.add(new DTOCriterio(
                                                "nombreEmpresa", 
                                                "=", 
                                                dTOEmpresaTipImpItem1.getNombreEmpresa()));
             criteriosNombreTipoEmpresa.add(new DTOCriterio(
                                                "nombreTipoEmpresa", 
                                                "=", 
                                                dTOEmpresaTipImpItem1.getNombreTipoEmpresa()));
             if(existeDato("Empresa", criteriosNombreEmpresa)&&existeDato("TipoEmpresa", criteriosNombreTipoEmpresa)){
                Empresa empresa = 
                    (Empresa) 
                    FachadaPersistencia.
                    getInstance().
                    buscar("Empresa",
                            criteriosNombreEmpresa).get(0);
                TipoEmpresa tipoEmpresa = 
                    (TipoEmpresa) 
                    FachadaPersistencia.
                    getInstance().
                    buscar("TipoEmpresa",
                            criteriosNombreTipoEmpresa).get(0);
                
                    empresaTipoImpuestoList.add(new EmpresaTipoImpuesto(
                                                new Date(),
                                                null,
                                                dTOEmpresaTipImpItem1.getFrecuenciaSincronizacion(),
                                                tipoImpuesto,
                                                empresa,
                                                tipoEmpresa));
             }
        }
        
        for(EmpresaTipoImpuesto empresaTipoImpuesto: empresaTipoImpuestoList){
            FachadaPersistencia.getInstance().guardar(empresaTipoImpuesto);
        }        
    }

        public void nuevaEmpresaTipoImpuestoItem(String nombreTipoImpuestoIngres, List<DTOEmpresaTipImpItem> dTOEmpresaTipImpItem){
            List<DTOCriterio> criteriosNombreTipoImpuesto = new ArrayList<>();
            criteriosNombreTipoImpuesto.add(new DTOCriterio(
                                                "nombreTipoImpuesto", 
                                                "=",
                                                nombreTipoImpuestoIngres));
            TipoImpuesto tipoImpuesto = 
                    (TipoImpuesto) 
                    FachadaPersistencia.
                    getInstance().
                    buscar("TipoImpuesto",
                            criteriosNombreTipoImpuesto).get(0);
            List<ItemEmpresaTipoImpuesto> empresaTipoImpuestoItemList= new ArrayList<>();
            for(DTOEmpresaTipImpItem  dTOEmpresaTipImpItem1 :dTOEmpresaTipImpItem){

                List<DTOCriterio> criteriosNombreTipoEmpresa = new ArrayList<>();
                List<DTOCriterio> criteriosNombreEmpresa = new ArrayList<>();     

                criteriosNombreEmpresa.add(new DTOCriterio(
                                                    "nombreEmpresa", 
                                                    "=", 
                                                    dTOEmpresaTipImpItem1.getNombreEmpresa()));
                 criteriosNombreTipoEmpresa.add(new DTOCriterio(
                                                    "nombreTipoEmpresa", 
                                                    "=", 
                                                    dTOEmpresaTipImpItem1.getNombreTipoEmpresa()));
                if(existeDato("Empresa", criteriosNombreEmpresa)&&existeDato("TipoEmpresa", criteriosNombreTipoEmpresa)){
                    List<DTOCriterio> criteriosEmpresaTipoImpuestoItem = new ArrayList<>();
                    Empresa empresa = 
                        (Empresa) 
                        FachadaPersistencia.
                        getInstance().
                        buscar("Empresa",
                                criteriosNombreEmpresa).get(0);
                    TipoEmpresa tipoEmpresa = 
                        (TipoEmpresa) 
                        FachadaPersistencia.
                        getInstance().
                        buscar("TipoEmpresa",
                                criteriosNombreTipoEmpresa).get(0);
                    criteriosEmpresaTipoImpuestoItem.add(new DTOCriterio("empresa", "=", empresa));
                    criteriosEmpresaTipoImpuestoItem.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
                    criteriosEmpresaTipoImpuestoItem.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
                    if(existeDato("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuestoItem)){
                        EmpresaTipoImpuesto empresaTipoImpuesto = 
                                (EmpresaTipoImpuesto) 
                                FachadaPersistencia.
                                        getInstance().
                                        buscar("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuestoItem).
                                        get(0);
                        for(DtoItemOrden dtoItemOrden :dTOEmpresaTipImpItem1.getDtoItemOrdenList()){
                            List<DTOCriterio> criteriosItems = new ArrayList<>();
                            criteriosItems.add(new DTOCriterio("nombreItem", "=", dtoItemOrden.getNombreItem()));
                            Item item = 
                                (Item) 
                                FachadaPersistencia.
                                        getInstance().
                                        buscar("Item", criteriosItems).
                                        get(0);
                            empresaTipoImpuestoItemList.add(new ItemEmpresaTipoImpuesto(
                                    dtoItemOrden.getOrden(), 
                                    null, 
                                    item, 
                                    empresaTipoImpuesto));

                        }
                    }
                 }
            }
            for(ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto :empresaTipoImpuestoItemList){
                FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
            }
        
        }
    
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos() {
        // Como vuelven de la DB?
        List<Object> listObject = FachadaPersistencia.getInstance().buscar("TipoImpuesto", null);
        ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = new ArrayList<DTOTipoImpuesto>();
        for (Object obj : listObject) {
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
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo) {
        // De alguna forma devuelvo el TipoImpuesto de la DB
        try {
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
        List<DTOEmpresaTipoImpuestoItems> dTOEmpresaTipoImpuestoItemList = new ArrayList<>();
        
        for(Empresa tempEmp : empresaList){
            DTOEmpresaTipoImpuestoItems dTOEmpresaTipoImpuestoItems = new DTOEmpresaTipoImpuestoItems();
            dTOEmpresaTipoImpuestoItems.setdTOEmpresa(ConvertDTO.getInstance().convertEmpresa(tempEmp));
            ArrayList<Item> itemList = optenerItemsEmpresaConTipoImpuesto(tipoImpuesto, tempEmp);
            TipoEmpresa tipoEmpresa = optenerTipoEmpresaConTipoImpuesto(tipoImpuesto, tempEmp).get(0);
            dTOEmpresaTipoImpuestoItems.setFrecuenciaSincro(obtenerEmpresaTipoImpuesto(tipoImpuesto, tempEmp).getFrecuenciaLiquidacionEmpresaTipoImpuesto());
            
            dTOEmpresaTipoImpuestoItems.setdTOItems(new ArrayList<>());
            
            dTOEmpresaTipoImpuestoItems.setdTOTipoEmpresa(ConvertDTO.getInstance().convertTipoEmpresa(tipoEmpresa));
            
            for(Item item : itemList){
                dTOEmpresaTipoImpuestoItems.addItem(ConvertDTO.getInstance().convertItem(item));
            }            
            dTOEmpresaTipoImpuestoItemList.add(dTOEmpresaTipoImpuestoItems);
        }
        
        // Para probar seteo uno nuevo
        dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
        dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
        dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
        dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
        dtoTipoImpuesto.setdTOEmpresaTipoImpuestoItemList(dTOEmpresaTipoImpuestoItemList);
        return dtoTipoImpuesto;        
        }catch(IndexOutOfBoundsException exception){
        System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Tipo Impuesto");
            return null;
        }

    }

    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado) {

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("nombreTipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(nombreActualTipoImpuesto);
        criterios.add(criterio1);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
        tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
        tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);
        if (habilitado) {
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(null);
        } else {
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(new Date());
        }
        FachadaPersistencia.getInstance().guardar(tipoImpuesto);
        System.out.println("Guardando en la DB: " + tipoImpuesto.getNombreTipoImpuesto());
    }

    public ArrayList<DTOEmpresaItem> obtenerEmpresaItem() {
        List<Object> listEmpresa = FachadaPersistencia.getInstance().buscar("Empresa", null);
        List<Object> listItem = FachadaPersistencia.getInstance().buscar("Empresa", null);

        ArrayList<DTOEmpresaItem> listDtoTipoImpuesto = new ArrayList<DTOEmpresaItem>();
        for (Object obj : listEmpresa) {
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

    public ArrayList<Empresa> optenerEmpresaConTipoImpuesto(TipoImpuesto tipoImpuesto) {
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("tipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(tipoImpuesto);
        criterios.add(criterio1);
        List<Object> empresaTipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
        ArrayList<Empresa> listEmpresa = new ArrayList<>();
        for (Object empresaTipoImpuestoObject : empresaTipoImpuestoObjectList) {
            EmpresaTipoImpuesto empresaTipoImpuestoTemp = (EmpresaTipoImpuesto) empresaTipoImpuestoObject;
            Empresa empresaTemp = (Empresa) empresaTipoImpuestoTemp.getEmpresa();
            listEmpresa.add(empresaTemp);
        }
        return listEmpresa;
    }

    public ArrayList<TipoEmpresa> optenerTipoEmpresaConTipoImpuesto(TipoImpuesto tipoImpuesto, Empresa empresa){
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("tipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(tipoImpuesto);
        criterios.add(criterio1);
        criterios.add(new DTOCriterio("empresa", "=", empresa));
        
        List<Object> empresaTipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
        ArrayList<TipoEmpresa> listTipoEmpresa = new ArrayList<>();
        for(Object empresaTipoImpuestoObject: empresaTipoImpuestoObjectList){
            EmpresaTipoImpuesto empresaTipoImpuestoTemp = (EmpresaTipoImpuesto) empresaTipoImpuestoObject;
            TipoEmpresa empresaTemp = (TipoEmpresa) empresaTipoImpuestoTemp.getTipoEmpresa();
            listTipoEmpresa.add(empresaTemp);
        }
        return listTipoEmpresa;
    }
    
    
    public ArrayList<Item> optenerItemsEmpresaConTipoImpuesto(TipoImpuesto tipoImpuesto, Empresa empresa){
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio("tipoImpuesto", "=", tipoImpuesto);
        DTOCriterio criterio2 = new DTOCriterio("empresa", "=", empresa);
        criterios.add(criterio1);
        criterios.add(criterio2);
        List<Object> tipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
        ArrayList<Item> listItem = new ArrayList<>();
        for (Object tipoImpuestoObject : tipoImpuestoObjectList) {
            EmpresaTipoImpuesto empresaTipoImpuestoTemp = (EmpresaTipoImpuesto) tipoImpuestoObject;
            criterios.clear();
            DTOCriterio criterio3 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuestoTemp);
            criterios.add(criterio3);
            List<Object> itemObjectList = FachadaPersistencia.getInstance().buscar("Item", null);
            List<Object> itemEmpresaTipoImpuestoObjectLis = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterios);

            for (Object itemEmpresaTipoImpuestoObject : itemEmpresaTipoImpuestoObjectLis) {
                ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) itemEmpresaTipoImpuestoObject;
                listItem.add(itemEmpresaTipoImpuesto.getItem());
            }
        }
        return listItem;
    }
    
    public EmpresaTipoImpuesto obtenerEmpresaTipoImpuesto( TipoImpuesto tipoImpuesto, Empresa empresa){
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio("tipoImpuesto", "=", tipoImpuesto);
        DTOCriterio criterio2 = new DTOCriterio("empresa", "=", empresa);
        criterios.add(criterio1);
        criterios.add(criterio2);
        return (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios).get(0);
    }
        
    public List<DTOEmpresa> buscarEmpresas() {

        //Busqueda de Empresas habilitadas
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        List <DTOEmpresa> lista = new ArrayList<>();
        for (int i = 0; i < empresas.size(); i++) {
            Empresa empresa = (Empresa) empresas.get(i);
            lista.add(ConvertDTO.getInstance().convertEmpresa(empresa));
        }
        return lista;
    }

    public List<DTOItem> buscarItems() {
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionItem", "IS", null));
        List items = FachadaPersistencia.getInstance().buscar("Item", criterioItem);

        List<DTOItem> lista = new ArrayList<>();
        DTOItem dtoItem;

        for (int i = 0; i < items.size(); i++) {
            dtoItem = new DTOItem();
            Item item = (Item) items.get(i);
            String nombreItem = item.getNombreItem();
            dtoItem.setNombreItem(nombreItem);
            lista.add(dtoItem);
        }
        return lista;
    }
    
    public List<DTOTipoEmpresa> buscarTipoEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List<Object> tipoEmpresaObjectList = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioItem);
        
        List <DTOTipoEmpresa> dTOTipoEmpresaList = new ArrayList<>();
        DTOTipoEmpresa dTOTipoEmpresa;
        
        for (Object tipoEmpresaObject :tipoEmpresaObjectList) {
            dTOTipoEmpresa = new DTOTipoEmpresa();
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipoEmpresaObject;
            dTOTipoEmpresa.setNombreTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa());
            dTOTipoEmpresaList.add(dTOTipoEmpresa);
        }
        return dTOTipoEmpresaList;
    }
}