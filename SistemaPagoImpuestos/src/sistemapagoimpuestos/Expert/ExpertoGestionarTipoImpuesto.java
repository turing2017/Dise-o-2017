package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoEmpresaGEA;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Globals.GlobalVars;
import static sistemapagoimpuestos.Utils.Utils.existeDato;

public class ExpertoGestionarTipoImpuesto {
    
    Usuario usuario = new Usuario();
    
    // Metodo iniciar

     public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }

    public int setearFrecuencia(String nombreTipoImpuesto, String cuitEmpresa, String nombreTipoEmpresa){
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        Empresa empresa = new Empresa();
        TipoEmpresa tipoEmpresa = new TipoEmpresa();
        EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
        
        try{ 
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
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
        // Busco EmpresaTipoImpuesto
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        }
        int frecuencia = empresaTipoImpuesto.getFrecuenciaLiquidacionEmpresaTipoImpuesto();
        return frecuencia;
    
    
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
    
    public void ModificarETI(String nombreTE, String nombreTI, String cuit, String  nuevoTE, String nuevoTI, int frec, boolean habilitada){
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        Empresa empresa = new Empresa();
        TipoEmpresa tipoEmpresa = new TipoEmpresa();
        EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto();
        TipoImpuesto nuevoTipoImpuesto = new TipoImpuesto();
        TipoEmpresa nuevoTipoEmpresa = new TipoEmpresa();
        
        try{ 
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTI));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        tipoImpuesto = (TipoImpuesto) ti.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
       
        try{ 
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nuevoTI));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        nuevoTipoImpuesto = (TipoImpuesto) ti.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
        
        try{
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuit));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        empresa = (Empresa) e.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        
        try{
        //Busca instancia de TipoEmpresa
        List<DTOCriterio> criterioTipoEmpresa = new ArrayList();
        criterioTipoEmpresa.add(new DTOCriterio("nombreTipoEmpresa", "=", nombreTE));
        List tE = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTipoEmpresa);
        tipoEmpresa = (TipoEmpresa) tE.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Empresa");
        } 
        
        
        try{
        //Busca instancia de TipoEmpresa
        List<DTOCriterio> criterioTipoEmpresa = new ArrayList();
        criterioTipoEmpresa.add(new DTOCriterio("nombreTipoEmpresa", "=", nuevoTE));
        List tE = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTipoEmpresa);
        nuevoTipoEmpresa = (TipoEmpresa) tE.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Empresa");
        }  
        
        try{
            // Busco EmpresaTipoImpuesto
            List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
            criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
            criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
            criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
            empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
            empresaTipoImpuesto.setTipoEmpresa(nuevoTipoEmpresa);
            empresaTipoImpuesto.setTipoImpuesto(nuevoTipoImpuesto);
            empresaTipoImpuesto.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frec);
            if(habilitada){
                empresaTipoImpuesto.setFechaHoraInhabilitacionEmpresaTipoImpuesto(null);
            }else{
                empresaTipoImpuesto.setFechaHoraInhabilitacionEmpresaTipoImpuesto(new Date());
            }
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        }
     
        
        
        
        
    }
    
     public void modificarEmpresa (String cuit,String nombre,String nuevoTipoImpuesto, String nuevoTipoEmpresa, int frecuenciaLiquidacion){
        Empresa empresa = new Empresa();
        TipoImpuesto nuevoTImpuesto = new TipoImpuesto();
        TipoEmpresa nuevoTEmpresa = new TipoEmpresa();
        try {
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("fechaHoraInhabilitacionEmpresa");
            criterio2.setOperacion("IS");
            criterio2.setValor(null);
            criterios.add(criterio2);
            empresa= (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            
            } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        try {
            //Busco el TipoImpuesto ingresado en pantalla
            List<DTOCriterio> criteriosnuevoTI = new ArrayList<>();
            DTOCriterio criterionuevoTI = new DTOCriterio();
            criterionuevoTI.setAtributo("nombreTipoImpuesto");
            criterionuevoTI.setOperacion("=");
            criterionuevoTI.setValor(nuevoTipoImpuesto);
            criteriosnuevoTI.add(criterionuevoTI);DTOCriterio criterionuevoTI2 = new DTOCriterio();
            criterionuevoTI2.setAtributo("fechaHoraInhabilitacionTipoImpuesto");
            criterionuevoTI2.setOperacion("IS");
            criterionuevoTI2.setValor(null);
            criteriosnuevoTI.add(criterionuevoTI2);
            nuevoTImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criteriosnuevoTI).get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Impuesto");
        }
        
        try {    
            //Busco el TipoEmpresaIngresado en la pantalla
            List<DTOCriterio> criteriosnuevoTE = new ArrayList<>();
            DTOCriterio criterionuevoTE = new DTOCriterio();
            criterionuevoTE.setAtributo("nombreTipoEmpresa");
            criterionuevoTE.setOperacion("=");
            criterionuevoTE.setValor(nuevoTipoEmpresa);
            criteriosnuevoTE.add(criterionuevoTE);
            DTOCriterio criterionuevoTE2 = new DTOCriterio();
            criterionuevoTE2.setAtributo("fechaInhabilitacionTipoEmpresa");
            criterionuevoTE2.setOperacion("IS");
            criterionuevoTE2.setValor(null);
            criteriosnuevoTE.add(criterionuevoTE2);
            nuevoTEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criteriosnuevoTE).get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Tipo de Empresa");
        }
        
        
        
        List<DTOCriterio> criteriosETI = new ArrayList<>();
        criteriosETI.add(new DTOCriterio("empresa", "=", empresa));
        criteriosETI.add(new DTOCriterio("tipoImpuesto", "=", nuevoTImpuesto));
        criteriosETI.add(new DTOCriterio("tipoEmpresa", "=", nuevoTEmpresa));
        if(!existeDato("EmpresaTipoImpuesto", criteriosETI)){
            //Seteo lo que ha seleccionado en la pantalla, el nuevo TipoImpuesto, la nueva TipoEmpresa y la frecuenciaLiquidacion
            EmpresaTipoImpuesto empresaTI = new EmpresaTipoImpuesto();
            empresaTI.setFechaHoraAltaEmpresaTipoImpuesto(new Date());
            empresaTI.setEmpresa(empresa);
            empresaTI.setTipoEmpresa(nuevoTEmpresa);
            empresaTI.setTipoImpuesto(nuevoTImpuesto);
            empresaTI.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuenciaLiquidacion);
            
            //Guardo la empresa, y la empresa tipo impuesto
            FachadaPersistencia.getInstance().guardar(empresaTI);

            Excepciones.getInstance().modificacionExito();
            }else{
                Excepciones.getInstance().objetoLaExistente("combinacion");
            
        } 
    }
     
     public void eliminarItem(String nombreItem,String  cuitEmpresa,int codigoTipoImpuesto,String nombreTipoEmpresa,int ordenItem){
        Empresa empresa = new Empresa();
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        TipoEmpresa tipoEmpresa = new TipoEmpresa();
        Item item = new Item();
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
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
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
        
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("ordenItemEmpresaTipoImpuesto", "=", ordenItem));
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("item", "=", item));
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemEmpresaTipoImpuesto).get(0);
        Date fecha = new Date();
        itemEmpresaTipoImpuesto.setFechaInhabilitacionItemEmpresaTipoImpuesto(fecha);
        
        FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
  
     
     }
 
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerEmpresaTipoImpuesto(String cuitEmpresa){
        Empresa empre = new Empresa();
        List<Object> listObject = null;
        try{
        List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
        DTOCriterio criterioEmpresa = new DTOCriterio("cuitEmpresa", "=", cuitEmpresa);
        DTOCriterio criterioEmpresa2 = new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null);
        criteriosEmpresa.add(criterioEmpresa);
        Object empresa =  FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa).get(0);
        empre = (Empresa) empresa;
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        
        try{
        List<DTOCriterio> criteriosETI = new ArrayList<>();
        DTOCriterio criterioETI = new DTOCriterio("empresa", "=", empre);
        criteriosETI.add(criterioETI);
        DTOCriterio criterioETI2 = new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null);
        criteriosETI.add(criterioETI2);
        listObject =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto",criteriosETI);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        }
        
        ArrayList<DTOEmpresaTipoImpuesto> listDtoEmpresaTipoImpuesto = new ArrayList<DTOEmpresaTipoImpuesto>();
        for(Object obj : listObject){
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj;
            DTOEmpresaTipoImpuesto dtoEmpresaTipoImpuesto = new DTOEmpresaTipoImpuesto();
            DTOEmpresa dtoEmpresa= new DTOEmpresa();
            dtoEmpresa.setCuitEmpresa(empresaTipoImpuesto.getEmpresa().getCuitEmpresa());
            dtoEmpresa.setNombreEmpresa(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
            dtoEmpresaTipoImpuesto.setdTOempresa(dtoEmpresa);
            DTOTipoImpuesto tI = new DTOTipoImpuesto();
            tI.setCodigoDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getCodigoTipoImpuesto());
            tI.setNombreDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
            tI.setEsMontoEditableDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().isEsMontoEditableTipoImpuesto());
            tI.setFechaHoraInhabilitacionDTOTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getFechaHoraInhabilitacionTipoImpuesto());
            dtoEmpresaTipoImpuesto.setdTOtipoImpuesto(tI);
            DTOTipoEmpresaGEA tE = new DTOTipoEmpresaGEA();
            tE.setNombreTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa().getNombreTipoEmpresa());
            dtoEmpresaTipoImpuesto.setdTOtipoEmpresa(tE);
            listDtoEmpresaTipoImpuesto.add(dtoEmpresaTipoImpuesto);
        }
     return listDtoEmpresaTipoImpuesto;
        
    }    

    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
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
    
      public List<DTOTipoEmpresaGEA> buscarTipoEmpresa(){
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("fechaInhabilitacionTipoEmpresa", "IS", null));
        List<Object> tipoEmpresaObjectList = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioItem);
        
        List <DTOTipoEmpresaGEA> dTOTipoEmpresaList = new ArrayList<>();
        DTOTipoEmpresaGEA dTOTipoEmpresa;
        
        
        
        //Se rompe aca, tenemos que armar la listita, para mandarla :D
        
        for (Object tipoEmpresaObject :tipoEmpresaObjectList) {
            dTOTipoEmpresa = new DTOTipoEmpresaGEA();
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
  
    public ArrayList<DTOTipoImpuesto> buscarTipoImpuestos(){
        List<DTOCriterio> criterioItem = new ArrayList();
        List<Object> tipoImpuestoObjectList = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioItem);
        
        ArrayList <DTOTipoImpuesto> dTOTipoImpuestoList = new ArrayList<>();
        DTOTipoImpuesto dTOTipoImpuesto;
        
        for (Object tipoImpuestoObject :tipoImpuestoObjectList) {
            dTOTipoImpuesto = new DTOTipoImpuesto();
            TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestoObject;
            dTOTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
            dTOTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
            dTOTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
            dTOTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dTOTipoImpuestoList.add(dTOTipoImpuesto);
        }
        return dTOTipoImpuestoList;
    }
    
    
    public DTOEmpresa buscarEmpresa(String cuitEmpresa) {
        
        DTOEmpresa dtoEmpresa = new DTOEmpresa();
        
        try{
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        DTOCriterio criteriosEmpresa = new DTOCriterio("cuitEmpresa", "=", cuitEmpresa);
        criterioEmpresa.add(criteriosEmpresa);
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        
        
        Empresa empresa = (Empresa) empresas.get(0);
        String nombreEmpresa = empresa.getNombreEmpresa();
        dtoEmpresa.setNombreEmpresa(nombreEmpresa);
        
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        } 
        return dtoEmpresa;
    }
    
    // Metodo para recuperar los tipos de impuestos asociados a una empresa
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestosEmpresa(String cuitEmpresa){
        
        ArrayList<DTOTipoImpuesto> listaDTOTipoImpuesto = new ArrayList<DTOTipoImpuesto>();
        Empresa empresa = new Empresa();
        List<Object> listObject = null;
        
        try{
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        empresa = (Empresa) e.get(0);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa");
        }
        
        try{
        List<DTOCriterio> criteriosETI = new ArrayList<>();
        DTOCriterio criterioETI = new DTOCriterio("empresa", "=", empresa);
        criteriosETI.add(criterioETI);
        DTOCriterio criterioETI2 = new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null);
        criteriosETI.add(criterioETI2);
        listObject =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto",criteriosETI);
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().objetoNoExistente("Empresa Tipo Impuesto");
        } 
                
        for(Object obj : listObject){
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj;
            TipoImpuesto tipoImpuesto = empresaTipoImpuesto.getTipoImpuesto();
            DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
            dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
            dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
            dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
            listaDTOTipoImpuesto.add(dtoTipoImpuesto);
        }
        
        return listaDTOTipoImpuesto;
    }
    
    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo){
        // De alguna forma devuelvo el TipoImpuesto de la DB
        DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
        try{
        List<DTOCriterio> criterios = new ArrayList<>();

        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("codigoTipoImpuesto");
        criterio1.setOperacion("=");
        criterio1.setValor(codigo);
        criterios.add(criterio1);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);
        
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
        
        List<DTOCriterio> criteriosTipoImpuesto = new ArrayList<>();
        criteriosTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuestoIngres));
        if(!existeDato("TipoImpuesto", criteriosTipoImpuesto)){
          
       
        tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
        tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);
        if(habilitado){
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(null);
        }else{
            tipoImpuesto.setFechaHoraInhabilitacionTipoImpuesto(new Date());
        }
        FachadaPersistencia.getInstance().guardar(tipoImpuesto);
        System.out.println("Guardando en la DB: " + tipoImpuesto.getNombreTipoImpuesto());
    }else{
            Excepciones.getInstance().objetoExistente("Nombre del Tipo de Impuesto");
        }
    }
}