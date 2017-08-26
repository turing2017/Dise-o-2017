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
public class DTOEmpresaItem {
    private int id;
    private DTOEmpresa dtoEmpresa;
    private List<DTOItem> dtoItemList;

    public DTOEmpresaItem() {
    }

    public DTOEmpresaItem(int id, DTOEmpresa dtoEmpresa, List<DTOItem> dtoItemList) {
        this.id = id;
        this.dtoEmpresa = dtoEmpresa;
        this.dtoItemList = dtoItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DTOEmpresa getDtoEmpresa() {
        return dtoEmpresa;
    }

    public void setDtoEmpresa(DTOEmpresa dtoEmpresa) {
        this.dtoEmpresa = dtoEmpresa;
    }

    public List<DTOItem> getDtoItemList() {
        return dtoItemList;
    }

    public void setDtoItemList(List<DTOItem> dtoItemList) {
        this.dtoItemList = dtoItemList;
    }
    
    
}
