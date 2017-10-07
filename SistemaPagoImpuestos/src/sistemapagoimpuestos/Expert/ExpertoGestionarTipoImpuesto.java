package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
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