package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.Entity.TipoEmpresa;
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
    
     public void modificarEmpresa (String cuit,String nombre,String nuevoTipoImpuesto, String nuevoTipoEmpresa, int frecuenciaLiquidacion){
             try {
            //Busco la Empresa
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuit);
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
        
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
            EmpresaTipoImpuesto empresaTI = new EmpresaTipoImpuesto();
            empresaTI.setEmpresa(empresa);
            empresaTI.setTipoEmpresa(nuevoTEmpresa);
            empresaTI.setTipoImpuesto(nuevoTImpuesto);
            empresaTI.setFrecuenciaLiquidacionEmpresaTipoImpuesto(frecuenciaLiquidacion);
            
            //Guardo la empresa, y la empresa tipo impuesto

            FachadaPersistencia.getInstance().guardar(empresaTI);

            Excepciones.getInstance().modificacionExito();
        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().cuitNoExistente();
         
        }
    }
     
     public void eliminarItem(String nombreItem,String  cuitEmpresa,int codigoTipoImpuesto,String nombreTipoEmpresa,int ordenItem){
     List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("codigoTipoImpuesto", "=", codigoTipoImpuesto));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        
        //Busca instancia de Empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", cuitEmpresa));
        List e = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        Empresa empresa = (Empresa) e.get(0);
        
        //Busca instancia de TipoEmpresa
        List<DTOCriterio> criterioTipoEmpresa = new ArrayList();
        criterioTipoEmpresa.add(new DTOCriterio("nombreTipoEmpresa", "=", nombreTipoEmpresa));
        List tE = FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTipoEmpresa);
        TipoEmpresa tipoEmpresa = (TipoEmpresa) tE.get(0);
        
        // Busco Item
        List<DTOCriterio> criterioItem = new ArrayList();
        criterioItem.add(new DTOCriterio("nombreItem", "=", nombreItem));
        List i = FachadaPersistencia.getInstance().buscar("Item", criterioItem);
        Item item = (Item) i.get(0);
        
        // Busco EmpresaTipoImpuesto
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto).get(0);
        
        
        List<DTOCriterio> criterioItemEmpresaTipoImpuesto = new ArrayList();
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("item", "=", item));
        criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemEmpresaTipoImpuesto).get(0);
        Date fecha = new Date();
        itemEmpresaTipoImpuesto.setFechaInhabilitacionItemEmpresaTipoImpuesto(fecha);
        
        FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
  
     
     }
 
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerEmpresaTipoImpuesto(String cuitEmpresa){
        List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
        DTOCriterio criterioEmpresa = new DTOCriterio("cuitEmpresa", "=", cuitEmpresa);
        criteriosEmpresa.add(criterioEmpresa);
        Object empresa =  FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa).get(0);
        Empresa empre = (Empresa) empresa;
        List<DTOCriterio> criteriosETI = new ArrayList<>();
        DTOCriterio criterioETI = new DTOCriterio("empresa", "=", empre);
        criteriosETI.add(criterioETI);
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto",criteriosETI);
        ArrayList<DTOEmpresaTipoImpuesto> listDtoEmpresaTipoImpuesto = new ArrayList<DTOEmpresaTipoImpuesto>();
        for(Object obj : listObject){
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj;
            DTOEmpresaTipoImpuesto dtoEmpresaTipoImpuesto = new DTOEmpresaTipoImpuesto();
            Empresa dtoEmpresa= new Empresa();
            dtoEmpresa.setCuitEmpresa(empresaTipoImpuesto.getEmpresa().getCuitEmpresa());
            dtoEmpresa.setNombreEmpresa(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
            dtoEmpresaTipoImpuesto.setEmpresa(dtoEmpresa);
            TipoImpuesto tI = new TipoImpuesto();
            tI.setCodigoTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getCodigoTipoImpuesto());
            tI.setNombreTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getNombreTipoImpuesto());
            tI.setEsMontoEditableTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().isEsMontoEditableTipoImpuesto());
            tI.setFechaHoraInhabilitacionTipoImpuesto(empresaTipoImpuesto.getTipoImpuesto().getFechaHoraInhabilitacionTipoImpuesto());
            dtoEmpresaTipoImpuesto.setTipoImpuesto(tI);
            TipoEmpresa tE = new TipoEmpresa();
            tE.setNombreTipoEmpresa(empresaTipoImpuesto.getTipoEmpresa().getNombreTipoEmpresa());
            dtoEmpresaTipoImpuesto.setTipoEmpresa(tE);
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
  
    
    
    public DTOEmpresa buscarEmpresa(String cuitEmpresa) {
        
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        DTOCriterio criteriosEmpresa = new DTOCriterio("cuitEmpresa", "=", cuitEmpresa);
        criterioEmpresa.add(criteriosEmpresa);
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        
        DTOEmpresa dtoEmpresa = new DTOEmpresa();
        Empresa empresa = (Empresa) empresas.get(0);
        String nombreEmpresa = empresa.getNombreEmpresa();
        dtoEmpresa.setNombreEmpresa(nombreEmpresa);

        
        return dtoEmpresa;
    }
    
    // Metodo para recuperar los tipos de impuestos asociados a una empresa
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestosEmpresa(String cuitEmpresa){
        
        ArrayList<DTOTipoImpuesto> listaDTOTipoImpuesto = new ArrayList<DTOTipoImpuesto>();
        
        // Busco la empresa por nombre
        List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
        DTOCriterio criterioCuit = new DTOCriterio();
        criterioCuit.setAtributo("cuitEmpresa");
        criterioCuit.setOperacion("=");
        criterioCuit.setValor(cuitEmpresa);
        criteriosEmpresa.add(criterioCuit);
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa).get(0);
        
        // Busco los empresa tipo impuesto
        List<DTOCriterio> criteriosEmpresaTI = new ArrayList<>();
        DTOCriterio criterioEmpresa = new DTOCriterio();
        criterioEmpresa.setAtributo("empresa");
        criterioEmpresa.setOperacion("=");
        criterioEmpresa.setValor(empresa);
        criteriosEmpresaTI.add(criterioEmpresa);
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosEmpresaTI);
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
}