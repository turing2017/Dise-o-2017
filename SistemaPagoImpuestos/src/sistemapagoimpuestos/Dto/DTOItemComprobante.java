/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import sistemapagoimpuestos.Entity.Item;

/**
 *
 * @author mviss
 */
public class DTOItemComprobante {
    private Item item;
    private String value;
    public DTOItemComprobante() {
    }

    public DTOItemComprobante(Item item, String value) {
        this.item = item;
        this.value = value;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
