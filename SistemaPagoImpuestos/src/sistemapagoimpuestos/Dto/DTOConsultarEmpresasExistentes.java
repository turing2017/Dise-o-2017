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
public class DTOConsultarEmpresasExistentes {
    
    private List<DTOEmpresaHabilitada> listaDTOEmpresaHabilitada;

    public boolean add(DTOEmpresaHabilitada e) {
        return listaDTOEmpresaHabilitada.add(e);
    }

    
    
    
    
}
