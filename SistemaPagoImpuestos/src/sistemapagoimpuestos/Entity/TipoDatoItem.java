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
    
    private int codigoTipoDato;
    private String nombreTipoDato;

    public TipoDatoItem() {
    }

    public TipoDatoItem(int codigoTipoDato, String nombreTipoDato) {
        this.codigoTipoDato = codigoTipoDato;
        this.nombreTipoDato = nombreTipoDato;
    }

    public int getCodigoTipoDato() {
        return codigoTipoDato;
    }

    public void setCodigoTipoDato(int codigoTipoDato) {
        this.codigoTipoDato = codigoTipoDato;
    }

    public String getNombreTipoDato() {
        return nombreTipoDato;
    }

    public void setNombreTipoDato(String nombreTipoDato) {
        this.nombreTipoDato = nombreTipoDato;
    }
    
    
    
}
