/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

/**
 *
 * @author mvissio
 */
public class TipoDatoItem extends Entity{
    
    private int codigoTipoDatoItem;
    private String nombreTipoDatoItem;

    public TipoDatoItem() {
    }

    public TipoDatoItem(int codigoTipoDatoItem, String nombreTipoDatoItem) {
        this.codigoTipoDatoItem = codigoTipoDatoItem;
        this.nombreTipoDatoItem = nombreTipoDatoItem;
    }

    public int getCodigoTipoDatoItem() {
        return codigoTipoDatoItem;
    }

    public void setCodigoTipoDatoItem(int codigoTipoDatoItem) {
        this.codigoTipoDatoItem = codigoTipoDatoItem;
    }

    public String getNombreTipoDatoItem() {
        return nombreTipoDatoItem;
    }

    public void setNombreTipoDatoItem(String nombreTipoDatoItem) {
        this.nombreTipoDatoItem = nombreTipoDatoItem;
    }
    
}
