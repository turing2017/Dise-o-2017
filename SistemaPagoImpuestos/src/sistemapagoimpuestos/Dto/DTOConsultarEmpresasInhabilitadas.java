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
public class DTOConsultarEmpresasInhabilitadas {
    
    private List<DTOEmpresaInhabilitada> listaDTOEmpresaInhabilitada;

    public boolean add(DTOEmpresaInhabilitada e) {
        return listaDTOEmpresaInhabilitada.add(e);
    }
    
    
}
