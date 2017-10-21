/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import java.util.Date;
import java.util.Vector;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Dto.DTOEmpresaTipImpItem;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DtoItemOrden;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;

/**
 *
 * @author Tongas
 */


public class ExpertoGestionarEmpresaAdherida {
    
    public String iniciar() {

        return "Administrador";
    }
    public ArrayList<DTOEmpresa > consultarEmpresas (){
        
    List<Object> listObject = FachadaPersistencia.getInstance().buscar("Empresa", null);
    ArrayList<DTOEmpresa> listDTOEmpresa = new ArrayList<>();
    for(Object obj : listObject){
     Empresa empresa = new Empresa();
     empresa = (Empresa) obj;
      DTOEmpresa dTOe = new DTOEmpresa();
      dTOe.setNombreEmpresa(empresa.getNombreEmpresa());
      dTOe.setCuitEmpresa(empresa.getCuitEmpresa());
      dTOe.setDireccionEmpresa(empresa.getDireccionEmpresa());
      dTOe.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());

      listDTOEmpresa.add(dTOe);
    
      }
    return listDTOEmpresa ;
}
    
    public List<ItemEmpresaTipoImpuesto> setearTabla(Vector vct){
        
        List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(vct.get(0));
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            criterios.clear();
        
            //Busco el TipoImpuesto Anterior
            List<DTOCriterio> criterios2 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreTipoImpuesto");
            criterio2.setOperacion("=");
            criterio2.setValor(vct.get(2));
            criterios2.add(criterio2);
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios2).get(0);
            criterios2.clear();
            
            //Busco el TipoEmpresa Anterior
            List<DTOCriterio> criterios3 = new ArrayList<>();
            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("nombreTipoEmpresa");
            criterio3.setOperacion("=");
            criterio3.setValor(vct.get(3));
            criterios3.add(criterio3);
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios3).get(0);
            criterios3.clear();
            
            //Busco el EmpresaTipoImpuesto asociado a las 3 busquedas anteriores
            List<DTOCriterio> criteriosEmpresaTipoImpuesto = new ArrayList<>();
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tImpuesto));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tEmpresa));
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuesto).get(0);
            criteriosEmpresaTipoImpuesto.clear();
            
            //List<ItemEmpresaTipoImpuesto> listItemETI = null;
            
            List<DTOCriterio> criterios4 = new ArrayList<>();
            DTOCriterio criterio4 = new DTOCriterio();
            criterio4.setAtributo("empresaTipoImpuesto");
            criterio4.setOperacion("=");
            criterio4.setValor(empresaTI);
            criterios4.add(criterio4);
            DTOCriterio criterioHabilitada = new DTOCriterio();
            criterioHabilitada.setAtributo("fechaInhabilitacionItemEmpresaTipoImpuesto");
            criterioHabilitada.setOperacion("IS");
            criterioHabilitada.setValor(null);
            criterios4.add(criterioHabilitada);
            List<Object> listObject = (List<Object>) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterios4);
            List<ItemEmpresaTipoImpuesto> listItemETI = new ArrayList<>();
            ArrayList<ItemEmpresaTipoImpuesto> listItemEmpresaTipoImpuesto = new ArrayList<>();
            criterios4.clear();
            for(Object obj : listObject){
                ItemEmpresaTipoImpuesto itemETI = new ItemEmpresaTipoImpuesto();
                itemETI = (ItemEmpresaTipoImpuesto) obj;
                listItemETI.add(itemETI);
            }
            
            return listItemETI;
             
    }
    
     public void ingresarDatosEmpresaCrear(String cuit,String nombre ,String direccion,boolean habilitada) {
       boolean camposIncompletos= camposNulos(cuit, nombre, direccion);
       if(camposIncompletos == true){
       Excepciones.getInstance().camposVacios();
       } else{
         try {
            //Busco la empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().cuitExistente();
            } catch (IndexOutOfBoundsException exception) {
                try{
                    //Busco la empresa
            List<DTOCriterio> criterios1 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreEmpresa");
            criterio2.setOperacion("=");
            criterio2.setValor(nombre);
            criterios1.add(criterio2);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios1).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().nombreExistente();
                }catch(IndexOutOfBoundsException exc)  {              
            Empresa empresa = new Empresa();
            empresa.setCuitEmpresa(cuit);
            empresa.setNombreEmpresa(nombre);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true) {
                empresa.setFechaHoraInhabilitacionEmpresa(null);
            } else {
                empresa.setFechaHoraInhabilitacionEmpresa(new Date());
            }
            FachadaPersistencia.getInstance().guardar(empresa);
            }
            }
        }
     }
    public void modificarItemEmpresaTipoImpuesto(DTOEmpresaTipImpItem dTOEmpresaTipImpItem){
        
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            criterios.add(new DTOCriterio("cuitEmpresa","=" ,dTOEmpresaTipImpItem.getCuitEmpresa()));
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            criterios.clear();
            //Busca el tipoImpuesto
            criterios.add(new DTOCriterio("nombreTipoImpuesto","=" ,dTOEmpresaTipImpItem.getNombreTipoImpuesto()));
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
            criterios.clear();
            //Busca el tipoEmpresa
            criterios.add(new DTOCriterio("nombreTipoEmpresa","=" ,dTOEmpresaTipImpItem.getNombreTipoEmpresa()));
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios).get(0);
            criterios.clear();
            //Busca el empresaTipoImpuesto relacionado a los 3 anteriores
            criterios.add(new DTOCriterio("empresa", "=", empresa));
            criterios.add(new DTOCriterio("tipoImpuesto", "=", tImpuesto));
            criterios.add(new DTOCriterio("tipoEmpresa", "=", tEmpresa));
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios).get(0);
            criterios.clear();
            //Busca los items
            criterios.add(new DTOCriterio("fechaHoraInhabilitacionItem", "IS", null ));
            List<Object> itemListObject = FachadaPersistencia.getInstance().buscar("Item", criterios);
            criterios.clear();
            //Busca el itemEmpresaTipoImpuesto asosiado a al empresaTipoImpuesto
            criterios.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTI ));
            criterios.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null ));
            List<Object> itemETIObject =FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterios);
            
            //Para cada objeto de la lista de items que busco
            for(Object objectItem : itemListObject){
                boolean change = false;

                ItemEmpresaTipoImpuesto ieti = new ItemEmpresaTipoImpuesto();
                Item item = (Item) objectItem;
                //Para cada itemEmpresaTipoImpuesto que busco
                for(Object objectETI : itemETIObject){
                    ItemEmpresaTipoImpuesto tempEti= (ItemEmpresaTipoImpuesto) objectETI;
                    //compara los oid de lo que tenia
                    if(item.getCodigoItem().equals(tempEti.getItem().getCodigoItem())){
                        ieti = tempEti;
                        change=true;
                        break;
                    }
                }
                
                DtoItemOrden dio = setItemOrden(dTOEmpresaTipImpItem.getDtoItemOrdenList(), item.getNombreItem());
                
                if(change){
                    if(!dio.getSeleccionado()){
                        ieti.setFechaInhabilitacionItemEmpresaTipoImpuesto(new Date());
                        
                    }
                    ieti.setOrdenItemEmpresaTipoImpuesto(dio.getOrden());
                }else{
                    
                    ieti.setEmpresaTipoImpuesto(empresaTI);
                    ieti.setItem(item);
                    ieti.setFechaInhabilitacionItemEmpresaTipoImpuesto(null);
                    ieti.setOrdenItemEmpresaTipoImpuesto(dio.getOrden());         }
                FachadaPersistencia.getInstance().guardar(ieti);
            }
            
    }
    
    public DtoItemOrden setItemOrden(List<DtoItemOrden> itemOrdenList, String nombre){
        DtoItemOrden dio = new DtoItemOrden();
        for(DtoItemOrden dtoItemOrden :itemOrdenList){
            if(dtoItemOrden.getNombreItem().equals(nombre)){
                dio = dtoItemOrden;
                break;
            }
        }
        return dio;
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
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object tipoEmpresaObject :tipoEmpresaObjectList) {
            dTOTipoEmpresa = new DTOTipoEmpresa();
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipoEmpresaObject;
            dTOTipoEmpresa.setNombreTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa());
            dTOTipoEmpresaList.add(dTOTipoEmpresa);
        }
        
        
        
        return dTOTipoEmpresaList;
    }

        public List<DTOEmpresa> buscarEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List<Object> empresaObjectList = FachadaPersistencia.getInstance().buscar("Empresa", criterioItem);
        
        List <DTOEmpresa> dTOEmpresaList = new ArrayList<>();
        DTOEmpresa dTOEmpresa;
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object empresaObject :empresaObjectList) {
            dTOEmpresa = new DTOEmpresa();
            Empresa empresa = (Empresa) empresaObject;
            dTOEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
            dTOEmpresaList.add(dTOEmpresa);
        }
        
        
        
        return dTOEmpresaList;
    }

    
    
  
        
    
    public List<DTOTipoImpuesto> buscarTipoImpuesto(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List<Object> tipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioItem);
        
        List <DTOTipoImpuesto> dTOTipoImpuestoList = new ArrayList<>();
        DTOTipoImpuesto dTOTipoImpuesto;
        
        for (Object tipoImpuestoObject :tipoImpuestoObjectList) {
            dTOTipoImpuesto = new DTOTipoImpuesto();
            TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestoObject;
            dTOTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dTOTipoImpuestoList.add(dTOTipoImpuesto);
        }
        return dTOTipoImpuestoList;
    }
  
    
    
    
    
    
    
    
    
    
    public void ingresarDatosEmpresa(String cuitEmpresa, String tipoImpuesto, String tipoEmpresa, int frecuencia) {

            //Busco la empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("nombreEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuitEmpresa);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().cuitExistente();
           
        
            //Busco el Tipo Impuesto, de acuerdo a lo que ingreso en pantalla
        
            List<DTOCriterio> criterios2 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreTipoImpuesto");
            criterio2.setOperacion("=");
            criterio2.setValor(tipoImpuesto);
            criterios2.add(criterio2);
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios2).get(0);

            //Busco el TIpo Empresa, de acuerdo a lo que ingreso en pantalla
            List<DTOCriterio> criterios3 = new ArrayList<>();
            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("nombreTipoEmpresa");
            criterio3.setOperacion("=");
            criterio3.setValor(tipoEmpresa);
            criterios2.add(criterio3);
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios3).get(0);

            //Creo el nuevo Empresa Tipo Impuesto con los datos seleccionados
            EmpresaTipoImpuesto eti = new EmpresaTipoImpuesto();
            eti.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuencia);
            eti.setEmpresa(empresa);
            eti.setTipoEmpresa(tEmpresa);
            eti.setTipoImpuesto(tImpuesto);
            eti.setFechaHoraAltaEmpresaTipoImpuesto(new Date());
            eti.setFechaHoraInhabilitacionEmpresaTipoImpuesto(null);

            //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);
            FachadaPersistencia.getInstance().guardar(eti);

            Excepciones.getInstance().empresaCreada();
            
    }
   
    
    public void modificarEmpresa (String cuit,String nombre, String direccion,boolean habilitada){
       boolean camposIncompletos= camposNulos(cuit, nombre, direccion);
       if(camposIncompletos == true){
       Excepciones.getInstance().camposVacios();   
       }else{
           try{
                    //Busco la empresa
            List<DTOCriterio> criterios1 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreEmpresa");
            criterio2.setOperacion("=");
            criterio2.setValor(nombre);
            criterios1.add(criterio2);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios1).get(0);
            //En el caso de que exista, tira mensaje
            Excepciones.getInstance().nombreExistente();
                }catch(IndexOutOfBoundsException exc)  {   
        try {
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
  
            empresa.setNombreEmpresa(nombre);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true) {
                empresa.setFechaHoraInhabilitacionEmpresa(null);
            } else {
                empresa.setFechaHoraInhabilitacionEmpresa(new Date());
            }
        
                       //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);

            Excepciones.getInstance().modificacionExito();
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().cuitNoExistente();
        }  
        }
    }
    }
    
    public List<DTOEmpresaTipoImpuesto> verTipoImpuesto(Vector vct){
        List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
        criteriosEmpresa.add(new DTOCriterio("cuitEmpresa", "=", vct.get(0)));
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa).get(0);
    
        List<DTOCriterio> criteriosEmpresaTipoImpuesto = new ArrayList<>();
        criteriosEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        List<Object> listObject = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuesto);

        List<DTOEmpresaTipoImpuesto> ListDTOETI = null;
        for(Object obj : listObject){
            EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
            empresaTipoImpuesto = (EmpresaTipoImpuesto) obj;
            DTOEmpresa dTOE = new DTOEmpresa();
            
            dTOE.setCuitEmpresa(empresaTipoImpuesto.getEmpresa().getCuitEmpresa());
            dTOE.setDireccionEmpresa(empresaTipoImpuesto.getEmpresa().getDireccionEmpresa());
            dTOE.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());
            
            DTOTipoEmpresa dTOTE = new DTOTipoEmpresa();
            dTOTE.setNombreTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa().getNombreTipoEmpresa());
            dTOTE.setFechaInhabilitacionTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa().getfechaInhabilitacionTipoEmpresa());
                    
            DTOTipoImpuesto dTOTI = new DTOTipoImpuesto();
            dTOTI.setCodigoDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getCodigoTipoImpuesto());
            dTOTI.setEsMontoEditableDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().isEsMontoEditableTipoImpuesto());
            dTOTI.setFechaHoraInhabilitacionDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getFechaHoraInhabilitacionTipoImpuesto());
            dTOTI.setNombreDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
     
            dTOE.setNombreEmpresa(empresa.getNombreEmpresa());
            DTOEmpresaTipoImpuesto dtoETI = new DTOEmpresaTipoImpuesto();
            dtoETI.setdTOempresa(dTOE);
            dtoETI.setFechaHoraAltaEmpresaTipoImpuesto(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
            dtoETI.setFechaHoraInhabilitacionEmpresaTipoImpuesto(empresaTipoImpuesto.getFechaHoraInhabilitacionEmpresaTipoImpuesto());
            dtoETI.setFrecuenciaLiquidacionEmpresaTipoImpuesto(empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto());
            dtoETI.setdTOtipoImpuesto(dTOTI);
            dtoETI.setdTOtipoEmpresa(dTOTE);

          ListDTOETI.add(dtoETI);

            }
    return ListDTOETI ;
    
    }
    
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa, String direccionEmpresa, String habilitada){
        DTOEmpresaExistente dtoEe = new DTOEmpresaExistente();
        dtoEe.setCuitDTOEmpresaExistente(cuitEmpresa);
        dtoEe.setNombreDTOEmpresaExistente(nombreEmpresa);
        dtoEe.setDireccionDTOEmpresaExistente(direccionEmpresa);
        dtoEe.setHabilitadaDTOEmpresaExistente(habilitada);

        return dtoEe;
    }
    
  
    public boolean camposNulos(String cuit, String nombre, String direccion ){
        boolean error=false;
        if (cuit.isEmpty()){
        error=true;
        } 
        if(nombre.isEmpty()){
        error=true;
        }
        if(direccion.isEmpty()){
        error=true;
        }
       
        return error;
    }
  }
 
   
 