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
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author mvissio
 */
public class ExpertoGestionarEmpresaTipoImpuesto {
        Usuario usuario = new Usuario();
    
    // Metodo iniciar
    public List<DTOTipoImpuesto> iniciar(){
        List<DTOCriterio> criterioFecha = new ArrayList();
        DTOCriterio criteriosFecha = new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "=", null);
        criterioFecha.add(criteriosFecha);
        
        List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioFecha);
    
        DTOTipoImpuesto dTOTipoImpuesto = new DTOTipoImpuesto();
        
        List <DTOTipoImpuesto> lista = new ArrayList<>();
        
        for (int i = 0; i < tipoImpuestos.size(); i++) {
            TipoImpuesto tipoImpuesto = (TipoImpuesto)tipoImpuestos.get(i);
            String nombreTipoImpuesto = tipoImpuesto.getNombreTipoImpuesto();
            dTOTipoImpuesto.setNombreDTOTipoImpuesto(nombreTipoImpuesto);
            lista.add(dTOTipoImpuesto);
        }
        
        return lista;
    }
    
    public String validar(){
        return "Administrador";
    }
}
