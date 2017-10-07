/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.List;
import java.util.ArrayList;

import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Decorators.DecoradorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.Utils.Utils;



public class ExpertoGestionarEmpresaTipoImpuesto {

    Usuario usuario = new Usuario();
    TipoUsuario admin = new TipoUsuario(0, "Administrador", null);
    TipoUsuario user = new TipoUsuario(1, "Usuario", null);
    
    public ExpertoGestionarEmpresaTipoImpuesto() {
        usuario.setTipoUsuario(admin);
    }
    
    // Metodo iniciar
    public List<DTOTipoImpuesto> iniciar(){
        List <DTOTipoImpuesto> lista = new ArrayList<>();
        if(usuario.getTipoUsuario().getNombreTipoUsuario() == "Administrador"){
            List<DTOCriterio> criterioFecha = new ArrayList();
            criterioFecha.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
            List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioFecha);

            DTOTipoImpuesto dTOTipoImpuesto;

            for (int i = 0; i < tipoImpuestos.size(); i++) {
                dTOTipoImpuesto = new DTOTipoImpuesto();
                TipoImpuesto tipoImpuesto = (TipoImpuesto)tipoImpuestos.get(i);
                String nombreTipoImpuesto = tipoImpuesto.getNombreTipoImpuesto();
                dTOTipoImpuesto.setNombreDTOTipoImpuesto(nombreTipoImpuesto);
                lista.add(dTOTipoImpuesto);
            }
        }
        else{
            System.out.println("No es posible");
        }
        
        return lista;
    }    

    public List<DTOEmpresa> buscarEmpresas() {
        
        //Busqueda de Empresas habilitadas
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        
        List <DTOEmpresa> lista = new ArrayList<>();
        DTOEmpresa dtoEmpresa;
        
        for (int i = 0; i < empresas.size(); i++) {
            dtoEmpresa = new DTOEmpresa();
            Empresa empresa = (Empresa) empresas.get(i);
            String nombreEmpresa = empresa.getNombreEmpresa();
            dtoEmpresa.setNombreEmpresa(nombreEmpresa);
            lista.add(dtoEmpresa);
        }
        return lista;
    }
    
    public List ingresarDatosETI(String nombreTipoImpuesto, String nombreEmpresa){
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        Empresa empresa = (Empresa) e.get(0);
        
        //Busca instancia de EmpresaTipoImpuesto, aplicando la empresa y tipoImpuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        
        return eti;
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
    public void nuevoEmpresaTipoImpuesto(String cuitEmpresa, String nombreTipoImpuesto, String nombreTipoEmpresa, int frecuencia){
        
        EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
        
        // Busco la empresa por cuit
        List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
        DTOCriterio criterioNombre = new DTOCriterio();
        criterioNombre.setAtributo("cuitEmpresa");
        criterioNombre.setOperacion("=");
        criterioNombre.setValor(cuitEmpresa);
        criteriosEmpresa.add(criterioNombre);
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa).get(0);
        
        // Busco el Tipo de Empresa por nombre
        List<DTOCriterio> criteriosTipoEmpresa = new ArrayList<>();
        DTOCriterio criterioNombreTipoEmpresa = new DTOCriterio("nombreTipoEmpresa", "=", nombreTipoEmpresa);
        criteriosTipoEmpresa.add(criterioNombreTipoEmpresa);
        TipoEmpresa tipoEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criteriosTipoEmpresa).get(0);
        
        // Busco el tipoImpuesto por nombre
        List<DTOCriterio> criteriosTipoImpuesto = new ArrayList<>();
        DTOCriterio criterioNombreTipoImpuesto = new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto);
        criteriosTipoImpuesto.add(criterioNombreTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criteriosTipoImpuesto).get(0);
        
        // Creo la Empresa TipoImpuesto
        empresaTipoImpuesto.setEmpresa(empresa);
        empresaTipoImpuesto.setTipoImpuesto(tipoImpuesto);
        empresaTipoImpuesto.setTipoEmpresa(tipoEmpresa);
        empresaTipoImpuesto.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuencia);
        FachadaPersistencia.getInstance().guardar(empresaTipoImpuesto); 
    }
    
    // Recuperar Items
    public ArrayList<DTOItem> obtenerItems(String cuitEmpresa, int codigoTipoImpuesto){
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuesto));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        Empresa empresa = (Empresa) e.get(0);
        
        //Busca instancia de EmpresaTipoImpuesto, aplicando la empresa y tipoImpuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        
        // Busca instancia de ItemEmpresaTipoImpuesto utilizando la empresatipoimpuesto
        List<DTOCriterio> criterioItemETI = new ArrayList();
        criterioItemETI.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemETI);
        ArrayList<DTOItem> listDTOItem = new ArrayList<DTOItem>();
        for(Object obj : listObject){
            ItemEmpresaTipoImpuesto itemETI = (ItemEmpresaTipoImpuesto) obj;
            Item item = itemETI.getItem();
            DTOItem dtoItem = new DTOItem();
            dtoItem.setNombreItem(item.getNombreItem());
            listDTOItem.add(dtoItem);
        }
        
        return listDTOItem;
    }
    
    // Método para recueprar los items
    public List<DTOItem> obtenerTodosItems(){
        // Busco Items
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("Item", null);
        ArrayList<DTOItem> listDTOItem = new ArrayList<DTOItem>();
        for(Object obj : listObject){
            Item item = (Item) obj;
            DTOItem dtoItem = new DTOItem();
            dtoItem.setNombreItem(item.getNombreItem());
            listDTOItem.add(dtoItem);
        }
        return listDTOItem;
    }
    
    public void agregarItem(String nombreItem, String cuitEmpresa, int codigoTipoImpuesto, int orden){
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuesto));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        Empresa empresa = (Empresa) e.get(0);
        
        // Busco Item
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("nombreItem", "=", nombreItem));
        List i = FachadaPersistencia.getInstance().buscar("Item", criterioItem);
        Item item = (Item) i.get(0);
        
        // Busco Empresa TipoImpuesto
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        
        ItemEmpresaTipoImpuesto itemETI = new ItemEmpresaTipoImpuesto();
        itemETI.setEmpresaTipoImpuesto(empresaTipoImpuesto);
        itemETI.setItem(item);
        itemETI.setOrdenItemEmpresaTipoImpuesto(orden);
        
        FachadaPersistencia.getInstance().guardar(itemETI);
    }
}
