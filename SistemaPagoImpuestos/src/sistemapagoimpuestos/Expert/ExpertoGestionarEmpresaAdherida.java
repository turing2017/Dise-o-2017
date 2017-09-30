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
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
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

        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";
    }
    public ArrayList<DTOEmpresaTipoImpuesto > consultarEmpresas (){
        
    List<Object> listObject = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
    ArrayList<DTOEmpresaTipoImpuesto> listDTOEmpresaTipoImpuesto = new ArrayList<>();
    for(Object obj : listObject){
     EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
     empresaTipoImpuesto.setEmpresa(new Empresa());
     empresaTipoImpuesto = (EmpresaTipoImpuesto) obj ;
      DTOEmpresaTipoImpuesto DTOeti = new DTOEmpresaTipoImpuesto();
      DTOeti.setEmpresa(empresaTipoImpuesto.getEmpresa());
      /*
      La fechaHoraAltaEmpresa no se si ponerla o no, 
      de ultima es solo mostrarla en pantalla despues
      */
      DTOeti.setFechaHoraAltaEmpresaTipoImpuesto(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
      DTOeti.setFechaHoraInhabilitacionEmpresaTipoImpuestoa(empresaTipoImpuesto.getFechaHoraInhabilitacionEmpresaTipoImpuesto());
      DTOeti.setTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa());
      DTOeti.setTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto());
      DTOeti.setFrecuenciaLiquidacionDTOEmpresaExistente(empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto());

      listDTOEmpresaTipoImpuesto.add(DTOeti);
    
      }
    return listDTOEmpresaTipoImpuesto ;
}
    
    public List<ItemEmpresaTipoImpuesto> setearTabla(Vector vct){
        
        List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(vct.get(0));
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

        
            //Busco el TipoImpuesto Anterior
            List<DTOCriterio> criterios2 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreTipoImpuesto");
            criterio2.setOperacion("=");
            criterio2.setValor(vct.get(2));
            criterios2.add(criterio2);
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios2).get(0);

            //Busco el TipoEmpresa Anterior
            List<DTOCriterio> criterios3 = new ArrayList<>();
            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("nombreTipoEmpresa");
            criterio3.setOperacion("=");
            criterio3.setValor(vct.get(3));
            criterios3.add(criterio3);
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios3).get(0);

            //Busco el EmpresaTipoImpuesto asociado a las 3 busquedas anteriores
            List<DTOCriterio> criteriosEmpresaTipoImpuesto = new ArrayList<>();
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tImpuesto));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tEmpresa));
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuesto).get(0);
            
            
            //List<ItemEmpresaTipoImpuesto> listItemETI = null;
            
            List<DTOCriterio> criterios4 = new ArrayList<>();
            DTOCriterio criterio4 = new DTOCriterio();
            criterio4.setAtributo("empresaTipoImpuesto");
            criterio4.setOperacion("=");
            criterio4.setValor(empresaTI);
            DTOCriterio criterioHabilitada = new DTOCriterio();
            criterioHabilitada.setAtributo("fechaInhabilitacionItemEmpresaTipoImpuesto");
            criterioHabilitada.setOperacion("IS");
            criterioHabilitada.setValor(null);
            criterios4.add(criterioHabilitada);
            List<Object> listObject = (List<Object>) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterios4);
            List<ItemEmpresaTipoImpuesto> listItemETI = new ArrayList<>();
            ArrayList<ItemEmpresaTipoImpuesto> listItemEmpresaTipoImpuesto = new ArrayList<>();
            for(Object obj : listObject){
                ItemEmpresaTipoImpuesto itemETI = new ItemEmpresaTipoImpuesto();
                itemETI = (ItemEmpresaTipoImpuesto) obj;
                listItemETI.add(itemETI);
            }
            
            /*
            List<Object> listObject = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
            ArrayList<DTOEmpresaTipoImpuesto> listDTOEmpresaTipoImpuesto = new ArrayList<>();
            for(Object obj : listObject){
            EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
            empresaTipoImpuesto.setEmpresa(new Empresa());
            empresaTipoImpuesto = (EmpresaTipoImpuesto) obj ;
            DTOEmpresaTipoImpuesto DTOeti = new DTOEmpresaTipoImpuesto();
            DTOeti.setEmpresa(empresaTipoImpuesto.getEmpresa());
             
            
             
             DTOeti.setFechaHoraAltaEmpresaTipoImpuesto(empresaTipoImpuesto.getFechaHoraAltaEmpresaTipoImpuesto());
             DTOeti.setFechaHoraInhabilitacionEmpresaTipoImpuestoa(empresaTipoImpuesto.getFechaHoraInhabilitacionEmpresaTipoImpuesto());
             DTOeti.setTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa());
             DTOeti.setTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto());
             DTOeti.setFrecuenciaLiquidacionDTOEmpresaExistente(empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto());

             listDTOEmpresaTipoImpuesto.add(DTOeti);

             }
            
            
            */
            
            return listItemETI;
             
    }
    
    
    
    public void modificarItemEmpresaTipoImpuesto(DTOEmpresaTipImpItem dTOEmpresaTipImpItemList){
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(dTOEmpresaTipImpItemList.getCuitEmpresa());
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

        
            //Busco el TipoImpuesto Anterior
            List<DTOCriterio> criterios2 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreTipoImpuesto");
            criterio2.setOperacion("=");
            criterio2.setValor(dTOEmpresaTipImpItemList.getNombreTipoImpuesto());
            criterios2.add(criterio2);
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios2).get(0);

            //Busco el TipoEmpresa Anterior
            List<DTOCriterio> criterios3 = new ArrayList<>();
            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("nombreTipoEmpresa");
            criterio3.setOperacion("=");
            criterio3.setValor(dTOEmpresaTipImpItemList.getNombreTipoEmpresa());
            criterios3.add(criterio3);
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios3).get(0);

            //Busco el EmpresaTipoImpuesto asociado a las 3 busquedas anteriores
            List<DTOCriterio> criteriosEmpresaTipoImpuesto = new ArrayList<>();
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tImpuesto));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tEmpresa));
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuesto).get(0);
            
            
            for(int i = 0; i < dTOEmpresaTipImpItemList.getDtoItemOrdenList().size(); i++){
                Boolean seleccionado = dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getSeleccionado();
                if(seleccionado.equals(true)){
                    try{
                        List<DTOCriterio> criteriosItemEmpresaTI = new ArrayList<>();
                        
                        List<DTOCriterio> criterios4 = new ArrayList<>();
                        DTOCriterio criterio4 = new DTOCriterio();
                        criterio4.setAtributo("nombreItem");
                        criterio4.setOperacion("=");
                        criterio4.setValor(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getNombreItem());
                        criterios4.add(criterio4);
                        Item item = (Item) FachadaPersistencia.getInstance().buscar("Item", criterios4).get(0);
                        criteriosItemEmpresaTI.add(new DTOCriterio("Item", "=", item ));
                        criteriosItemEmpresaTI.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null ));
                        criteriosItemEmpresaTI.add(new DTOCriterio("EmpresaTipoImpuesto", "=", empresaTI ));
                        ItemEmpresaTipoImpuesto itemETI = (ItemEmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criteriosItemEmpresaTI);
                        itemETI.setOrdenItemEmpresaTipoImpuesto(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getOrden());
                        itemETI.setIndicaPeriodicidadItemEmpresaTipoImpuesto(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getPerioricidad());
                    
                    }catch(Exception x){
                    
                        ItemEmpresaTipoImpuesto itemETI = new ItemEmpresaTipoImpuesto();
                        itemETI.setOrdenItemEmpresaTipoImpuesto(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getOrden());
                        itemETI.setIndicaPeriodicidadItemEmpresaTipoImpuesto(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getPerioricidad());
                        itemETI.setEmpresaTipoImpuesto(empresaTI);
                        List<DTOCriterio> criterios4 = new ArrayList<>();
                        DTOCriterio criterio4 = new DTOCriterio();
                        criterio4.setAtributo("nombreItem");
                        criterio4.setOperacion("=");
                        criterio4.setValor(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getNombreItem());
                        criterios4.add(criterio4);
                        Item item = (Item) FachadaPersistencia.getInstance().buscar("Item", criterios4).get(0);
                        itemETI.setItem(item);
                        FachadaPersistencia.getInstance().guardar(itemETI);
                    }
                }else{
                     try{
                        List<DTOCriterio> criteriosItemEmpresaTI = new ArrayList<>();
                        List<DTOCriterio> criterios4 = new ArrayList<>();
                        DTOCriterio criterio4 = new DTOCriterio();
                        criterio4.setAtributo("nombreItem");
                        criterio4.setOperacion("=");
                        criterio4.setValor(dTOEmpresaTipImpItemList.getDtoItemOrdenList().get(i).getNombreItem());
                        criterios4.add(criterio4);
                        Item item = (Item) FachadaPersistencia.getInstance().buscar("Item", criterios4).get(0);
                        criteriosItemEmpresaTI.add(new DTOCriterio("Item", "=", item ));
                        criteriosItemEmpresaTI.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null ));
                        criteriosItemEmpresaTI.add(new DTOCriterio("EmpresaTipoImpuesto", "=", empresaTI ));
                        ItemEmpresaTipoImpuesto itemETI = (ItemEmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criteriosItemEmpresaTI);
                        itemETI.setFechaInhabilitacionItemEmpresaTipoImpuesto(new Date());
                        FachadaPersistencia.getInstance().guardar(itemETI);
                        
                    }catch(Exception x){
                                 }
                    }
            }
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
  
    
    
    
    
    
    
    
    
    
    public void ingresarDatosEmpresa(String cuit,String nombre,String tipoImpuesto, String tipoEmpresa, int frecuencia ,String direccion,boolean habilitada) {
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
            Empresa empresa = new Empresa();
            empresa.setCuitEmpresa(cuit);
            empresa.setNombreEmpresa(nombre);
            empresa.setDireccionEmpresa(direccion);
            if (habilitada == true) {
                empresa.setFechaHoraInhabilitacionEmpresa(null);
            } else {
                empresa.setFechaHoraInhabilitacionEmpresa(new Date());
            }
        
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

            //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);
            FachadaPersistencia.getInstance().guardar(eti);

            Excepciones.getInstance().empresaCreada();
            }
    }
   
    
    public void modificarEmpresa (String cuit,String nombre,String nuevoTipoImpuesto, String anteriorTipoImpuesto, String nuevoTipoEmpresa,String anteriorTipoEmpresa, String direccion,boolean habilitada, int frecuenciaLiquidacion){
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
        
            //Busco el TipoImpuesto Anterior
            List<DTOCriterio> criterios2 = new ArrayList<>();
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("nombreTipoImpuesto");
            criterio2.setOperacion("=");
            criterio2.setValor(anteriorTipoImpuesto);
            criterios2.add(criterio2);
            TipoImpuesto tImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios2).get(0);

            //Busco el TipoEmpresa Anterior
            List<DTOCriterio> criterios3 = new ArrayList<>();
            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("nombreTipoEmpresa");
            criterio3.setOperacion("=");
            criterio3.setValor(anteriorTipoEmpresa);
            criterios3.add(criterio3);
            TipoEmpresa tEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterios3).get(0);

            //Busco el EmpresaTipoImpuesto asociado a las 3 busquedas anteriores
            List<DTOCriterio> criteriosEmpresaTipoImpuesto = new ArrayList<>();
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tImpuesto));
            criteriosEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tEmpresa));
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosEmpresaTipoImpuesto).get(0);
            
            
            //Busco el TipoImpuesto ingresado en pantalla
            List<DTOCriterio> criteriosnuevoTI = new ArrayList<>();
            DTOCriterio criterionuevoTI = new DTOCriterio();
            criterionuevoTI.setAtributo("nombreTipoImpuesto");
            criterionuevoTI.setOperacion("=");
            criterionuevoTI.setValor(nuevoTipoImpuesto);
            criteriosnuevoTI.add(criterionuevoTI);
            TipoImpuesto nuevoTImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criteriosnuevoTI).get(0);
            
            //Busco el TipoEmpresaIngresado en la pantalla
            List<DTOCriterio> criteriosnuevoTE = new ArrayList<>();
            DTOCriterio criterionuevoTE = new DTOCriterio();
            criterionuevoTE.setAtributo("nombreTipoEmpresa");
            criterionuevoTE.setOperacion("=");
            criterionuevoTE.setValor(nuevoTipoEmpresa);
            criteriosnuevoTE.add(criterionuevoTE);
            TipoEmpresa nuevoTEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criteriosnuevoTE).get(0);

            //Seteo lo que ha seleccionado en la pantalla, el nuevo TipoImpuesto, la nueva TipoEmpresa y la frecuenciaLiquidacion
            empresaTI.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuenciaLiquidacion);
            empresaTI.setTipoEmpresa(nuevoTEmpresa);
            empresaTI.setTipoImpuesto(nuevoTImpuesto);
            
            //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresa);
            FachadaPersistencia.getInstance().guardar(empresaTI);

            Excepciones.getInstance().modificacionExito();
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().cuitNoExistente();
         
        }
    }
    public DTOEmpresaExistente cargarDatos (String cuitEmpresa,String nombreEmpresa,String tipoImpuesto, String tipoEmpresa, String frecuenciaEmpresaTipoImpuesto, String direccionEmpresa, String habilitada){
        DTOEmpresaExistente dtoEe = new DTOEmpresaExistente();
        dtoEe.setCuitEmpresaExistente(cuitEmpresa);
        dtoEe.setNombreEmpresaExistente(nombreEmpresa);
        dtoEe.setTipoImpuestoEmpresaEmpresaExistente(tipoImpuesto);
        dtoEe.setNombreTipoEmpresaEmpresaExistente(tipoEmpresa);
        dtoEe.setDireccionEmpresaExistente(direccionEmpresa);
        dtoEe.setHabilitadaEmpresaExistente(habilitada);
        dtoEe.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuenciaEmpresaTipoImpuesto);

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
 
   
 