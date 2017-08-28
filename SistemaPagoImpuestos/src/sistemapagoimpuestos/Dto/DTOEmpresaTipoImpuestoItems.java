/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.List;

/**
 *
 * @author Markz
 */
public class DTOEmpresaTipoImpuestoItems {
    private DTOTipoImpuesto dTOTipoImpuesto;
    private DTOEmpresa dTOEmpresa;
    private List<DTOItem> dTOItems;

    public DTOEmpresaTipoImpuestoItems() {
    }

    public DTOEmpresaTipoImpuestoItems(DTOTipoImpuesto dTOTipoImpuesto, DTOEmpresa dTOEmpresa, List<DTOItem> dTOItems) {
        this.dTOTipoImpuesto = dTOTipoImpuesto;
        this.dTOEmpresa = dTOEmpresa;
        this.dTOItems = dTOItems;
    }

    public DTOTipoImpuesto getdTOTipoImpuesto() {
        return dTOTipoImpuesto;
    }

    public void setdTOTipoImpuesto(DTOTipoImpuesto dTOTipoImpuesto) {
        this.dTOTipoImpuesto = dTOTipoImpuesto;
    }

    public DTOEmpresa getdTOEmpresa() {
        return dTOEmpresa;
    }

    public void setdTOEmpresa(DTOEmpresa dTOEmpresa) {
        this.dTOEmpresa = dTOEmpresa;
    }

    public List<DTOItem> getdTOItems() {
        return dTOItems;
    }

    public void setdTOItems(List<DTOItem> dTOItems) {
        this.dTOItems = dTOItems;
    }
    
    
}
