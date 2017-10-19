/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author mviss
 */
public class DTOItemComprobantePantalla {
    private String codigoItem;
    private String nombreItem;
    private String itemVal;

    public DTOItemComprobantePantalla() {
    }

    public DTOItemComprobantePantalla(String codigoItem, String nombreItem, String itemVal) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.itemVal = itemVal;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getItemVal() {
        return itemVal;
    }

    public void setItemVal(String itemVal) {
        this.itemVal = itemVal;
    }
    
    
}
