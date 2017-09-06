/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author Markz
 */
public class DtoItemOrden {
    private String nombreItem;
    private int orden;

    public DtoItemOrden() {
    }

    public DtoItemOrden(String nombreItem, int orden) {
        this.nombreItem = nombreItem;
        this.orden = orden;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
}
