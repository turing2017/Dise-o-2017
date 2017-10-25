/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import sistemapagoimpuestos.Decorators.DecoradorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DtoItemOrdenGestionarTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoImpuestoTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.Globals.GlobalVars;
import static sistemapagoimpuestos.Utils.Utils.existeDato;



public class ExpertoGestionarEmpresaTipoImpuesto {

    public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }
    public ExpertoGestionarEmpresaTipoImpuesto() {
        
    }
    
    
    public List<DTOTipoImpuestoTipoImpuesto> obtenerTipoImpuesto(){
            List <DTOTipoImpuestoTipoImpuesto> lista = new ArrayList<>();
            List<DTOCriterio> criterioFecha = new ArrayList();
            criterioFecha.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
            List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioFecha);
            
            DTOTipoImpuestoTipoImpuesto dTOTipoImpuesto;

            for (int i = 0; i < tipoImpuestos.size(); i++) {
                dTOTipoImpuesto = new DTOTipoImpuestoTipoImpuesto();
                TipoImpuesto tipoImpuesto = (TipoImpuesto)tipoImpuestos.get(i);
                String nombreTipoImpuesto = tipoImpuesto.getNombreTipoImpuesto();
                dTOTipoImpuesto.setNombreDTOTipoImpuesto(nombreTipoImpuesto);
                lista.add(dTOTipoImpuesto);
            }
        
        
        return lista;
    
    }
    
    
    // Metodo iniciar
    public List<DTOTipoImpuestoTipoImpuesto> iniciar(){
        List <DTOTipoImpuestoTipoImpuesto> lista = new ArrayList<>();
            List<DTOCriterio> criterioFecha = new ArrayList();
            criterioFecha.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
            List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioFecha);
            
            DTOTipoImpuestoTipoImpuesto dTOTipoImpuesto;

            for (int i = 0; i < tipoImpuestos.size(); i++) {
                dTOTipoImpuesto = new DTOTipoImpuestoTipoImpuesto();
                TipoImpuesto tipoImpuesto = (TipoImpuesto)tipoImpuestos.get(i);
                String nombreTipoImpuesto = tipoImpuesto.getNombreTipoImpuesto();
                dTOTipoImpuesto.setNombreDTOTipoImpuesto(nombreTipoImpuesto);
                lista.add(dTOTipoImpuesto);
            }
        
        
        return lista;
    }    

  
    public List ingresarDatosETI(String nombreTipoImpuesto, String nombreEmpresa){
        
        //Busca instancia de TipoImpuesto
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        Empresa empresa = new Empresa();
        try{ 
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
        criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        tipoImpuesto = (TipoImpuesto) ti.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
        try{
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        empresa = (Empresa) e.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        //Busca instancia de EmpresaTipoImpuesto, aplicando la empresa y tipoImpuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        
        return eti;
    }
    
    public void modificarItem(String nombreItem,String cuitEmpresa,int codigoTipoImpuesto,String nombreTipoEmpresa, int orden, int ordenAnterior){
        
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        Empresa empresa = new Empresa();
        TipoEmpresa tipoEmpresa = new TipoEmpresa();
        Item item = new Item();
        EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
        
        try{ 
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuesto));
        criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        tipoImpuesto = (TipoImpuesto) ti.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
        
        
        try{
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        empresa = (Empresa) e.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        
        try{
        //Busca instancia de TipoEmpresa
        List<DTOCriterio> criterioTipoEmpresa = new ArrayList();
        criterioTipoEmpresa.add(new DTOCriterio("nombreTipoEmpresa", "=", nombreTipoEmpresa));
        List tE = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTipoEmpresa);
        tipoEmpresa = (TipoEmpresa) tE.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Empresa");
        }  
        
        try{
        // Busco Item
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("nombreItem", "=", nombreItem));
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionItem", "IS", null));
        List i = FachadaPersistencia.getInstance().buscar("Item", criterioItem);
        item = (Item) i.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Item");
        }
        
        try{
        // Busco EmpresaTipoImpuesto
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null));
        empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        }
 
        
        List<DTOCriterio> criterioItemEmpresaTipoImpuesto = new ArrayList();
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("item", "=", item));
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("ordenItemEmpresaTipoImpuesto", "=", ordenAnterior));
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemEmpresaTipoImpuesto).get(0);
        
        
        List<DTOCriterio> criteriosItem = new ArrayList<>();
        criteriosItem.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        criteriosItem.add(new DTOCriterio("ordenItemEmpresaTipoImpuesto", "=", orden));
        criteriosItem.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null));
        if(!existeDato("ItemEmpresaTipoImpuesto", criteriosItem)){
        
        itemEmpresaTipoImpuesto.setOrdenItemEmpresaTipoImpuesto(orden);
        FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
        Excepciones.getInstance().creacionExitosa("Item");
        }else{
                Excepciones.getInstance().objetoExistente("Orden ingresado");
            }
        
        
        
        

    }
   
    
    
    // Método para recueprar los tipos de empresas
    public List<DTOTipoEmpresa> obtenerTipoEmpresas(){
        // Busco Tipos de empresas
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("TipoEmpresa", null);
        ArrayList<DTOTipoEmpresa> listDTOTipoEmpresa = new ArrayList<DTOTipoEmpresa>();
        for(Object obj : listObject){
            TipoEmpresa tipoEmpresa = (TipoEmpresa) obj;
            DTOTipoEmpresa dtoTipoEmpresa = new DTOTipoEmpresa();
            dtoTipoEmpresa.setNombreTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa());
            listDTOTipoEmpresa.add(dtoTipoEmpresa);
        }
        return listDTOTipoEmpresa;
    }
    
        // Método para crear un ETI

    
    // Recuperar Items
    public ArrayList<DtoItemOrdenGestionarTipoImpuesto> obtenerItems(String cuitEmpresa, int codigoTipoImpuesto, String nombreTE){
        
        Empresa empresa = new Empresa();
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        TipoEmpresa tipoEmpresa = new TipoEmpresa();
        EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
        
        try{ 
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuesto));
        criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        tipoImpuesto = (TipoImpuesto) ti.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
        
        try{
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        empresa = (Empresa) e.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        try{
        //Busca instancia de TipoEmpresa
        List<DTOCriterio> criterioTipoEmpresa = new ArrayList();
        criterioTipoEmpresa.add(new DTOCriterio("nombreTipoEmpresa", "=", nombreTE));
        criterioTipoEmpresa.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List tE = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTipoEmpresa);
        tipoEmpresa = (TipoEmpresa) tE.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Empresa");
        }        
        
        try{
        //Busca instancia de EmpresaTipoImpuesto, aplicando la empresa y tipoImpuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null));
        empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        }
        
        // Busca instancia de ItemEmpresaTipoImpuesto utilizando la empresatipoimpuesto
        List<DTOCriterio> criterioItemETI = new ArrayList();
        criterioItemETI.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        criterioItemETI.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null));
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemETI);
        ArrayList<DtoItemOrdenGestionarTipoImpuesto> listDTOItem = new ArrayList<DtoItemOrdenGestionarTipoImpuesto>();
 

        
        
        for(Object obj : listObject){
            ItemEmpresaTipoImpuesto itemETI = (ItemEmpresaTipoImpuesto) obj;
            Item item = itemETI.getItem();
            DtoItemOrdenGestionarTipoImpuesto dtoItem = new DtoItemOrdenGestionarTipoImpuesto();
            dtoItem.setNombreItem(item.getNombreItem());
            dtoItem.setOrden(itemETI.getOrdenItemEmpresaTipoImpuesto());
            listDTOItem.add(dtoItem);
        }
        
        return listDTOItem;
    }
    
    // Método para recueprar los items
    public List<DTOItem> obtenerTodosItems(){
        // Busco Items
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaHoraInhabilitacionItem", "IS", null));
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("Item", criterioItem);
        ArrayList<DTOItem> listDTOItem = new ArrayList<DTOItem>();
        for(Object obj : listObject){
            Item item = (Item) obj;
            DTOItem dtoItem = new DTOItem();
            dtoItem.setNombreItem(item.getNombreItem());
            listDTOItem.add(dtoItem);
        }
        return listDTOItem;
    }
    
    public void agregarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, String nombreTE, int orden){
       
        Empresa empresa = new Empresa();
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        TipoEmpresa tipoEmpresa = new TipoEmpresa();
        EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
        Item item = new Item();
        
        try{ 
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuesto));
        criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        tipoImpuesto = (TipoImpuesto) ti.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
        
        try{
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        empresa = (Empresa) e.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        try{
        //Busca instancia de TipoEmpresa
        List<DTOCriterio> criterioTipoEmpresa = new ArrayList();
        criterioTipoEmpresa.add(new DTOCriterio("nombreTipoEmpresa", "=", nombreTE));
        criterioTipoEmpresa.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List tE = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTipoEmpresa);
        tipoEmpresa = (TipoEmpresa) tE.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Empresa");
        }        
        
        try{
        //Busca instancia de EmpresaTipoImpuesto, aplicando la empresa y tipoImpuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null));
        empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        }  
        
        try{
        // Busco Item
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("nombreItem", "=", nombreItem));
        List i = FachadaPersistencia.getInstance().buscar("Item", criterioItem);
        item = (Item) i.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Item");
        }        

        List<DTOCriterio> criteriosItem = new ArrayList<>();
        
        criteriosItem.add(new DTOCriterio("item", "=", item));
        criteriosItem.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null));
        criteriosItem.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        if(!existeDato("ItemEmpresaTipoImpuesto", criteriosItem)){
            
            List<DTOCriterio> criteriosItem2 = new ArrayList<>();
            criteriosItem2.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
            criteriosItem2.add(new DTOCriterio("fechaInhabilitacionItemEmpresaTipoImpuesto", "IS", null));
            criteriosItem2.add(new DTOCriterio("ordenItemEmpresaTipoImpuesto", "=", orden));
            if(!existeDato("ItemEmpresaTipoImpuesto", criteriosItem2)){  
                ItemEmpresaTipoImpuesto itemETI = new ItemEmpresaTipoImpuesto();
                itemETI.setEmpresaTipoImpuesto(empresaTipoImpuesto);
                itemETI.setItem(item);
                itemETI.setOrdenItemEmpresaTipoImpuesto(orden);
                FachadaPersistencia.getInstance().guardar(itemETI);

                Excepciones.getInstance().creacionExitosa("Item");            
            }else{
                Excepciones.getInstance().objetoExistente("Orden ingresado");
            }
        }else{
                Excepciones.getInstance().objetoExistente("Item ingresado");
        }
    }
}
