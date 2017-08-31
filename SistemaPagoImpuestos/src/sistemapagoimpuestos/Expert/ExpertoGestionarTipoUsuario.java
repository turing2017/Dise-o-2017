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
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuestoItems;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Rodri
 */
public class ExpertoGestionarTipoUsuario {
    
    Usuario usuario = new Usuario();


    public String iniciar() {
        
        return "Administrador";
}

    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario() {
      
        List<Object> listObject =  FachadaPersistencia.getInstance().buscar("TipoUsuario", null);
        ArrayList<DTOTipoUsuario> listDtoTipoUsuario = new ArrayList<DTOTipoUsuario>();
        for(Object obj : listObject){
            TipoUsuario tipoUsuario = (TipoUsuario) obj;
            DTOTipoUsuario dtoTipoUsuario = new DTOTipoUsuario();
            dtoTipoUsuario.setNombreDTOTipoUsuario(tipoUsuario.getNombreTipoUsuario());
            dtoTipoUsuario.setFechaHoraInhabilitacionDTOTipoUsuario(tipoUsuario.getFechaHoraInhabilitacionTipoUsuario());
            listDtoTipoUsuario.add(dtoTipoUsuario);
        }
        return listDtoTipoUsuario;
        
    }
    
    public DTOTipoUsuario obtenerTipoUsuario(String nombre){
        // De alguna forma devuelvo el TipoImpuesto de la DB
        try{
        List<DTOCriterio> criterios = new ArrayList<>();

        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("nombreTipoUsuario");
        criterio1.setOperacion("=");
        criterio1.setValor(nombre);
        criterios.add(criterio1);
        TipoUsuario tipoUsuario = (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
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
            dTOEmpresaTipoImpuestoItems.setdTOItems(new ArrayList<>());
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
    
    
    
}
