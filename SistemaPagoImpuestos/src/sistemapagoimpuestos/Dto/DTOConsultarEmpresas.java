/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.List;


/**
 *
 * @author Tongas
 */
public class DTOConsultarEmpresas {
    
    private List<DTOEmpresaHabilitada> listaDTOEmpresaHabilitada;
    private List<DTOEmpresaInhabilitada> listaDTOEmpresaInhabilitada;

    public boolean add(DTOEmpresaHabilitada e) {
        return listaDTOEmpresaHabilitada.add(e);
    }

    public boolean add(DTOEmpresaInhabilitada e) {
        return listaDTOEmpresaInhabilitada.add(e);
    }

    public List<DTOEmpresaHabilitada> getListaDTOEmpresaHabilitada() {
        return listaDTOEmpresaHabilitada;
    }

    public List<DTOEmpresaInhabilitada> getListaDTOEmpresaInhabilitada() {
        return listaDTOEmpresaInhabilitada;
    }
    
    

    
    
    
    
}
