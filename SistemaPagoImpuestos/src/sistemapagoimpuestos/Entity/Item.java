/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author mvissio
 */
public class Item extends Entity{
    private String codigoItem;
    private String nombreItem;
    private int longitudItem;
    private boolean requeridoItem;
    private Date fechaHoraInhabilitacionItem;
    private TipoDatoItem tipoDatoItem;

    public Item(String codigoItem, String nombreItem, int longitudItem, boolean requeridoItem, Date fechaHoraInhabilitacionItem, TipoDatoItem tipoDatoItem) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.longitudItem = longitudItem;
        this.requeridoItem = requeridoItem;
        this.fechaHoraInhabilitacionItem = fechaHoraInhabilitacionItem;
        this.tipoDatoItem = tipoDatoItem;
    }

    public Item() {
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

    public int getLongitudItem() {
        return longitudItem;
    }

    public void setLongitudItem(int longitudItem) {
        this.longitudItem = longitudItem;
    }

    public boolean isRequeridoItem() {
        return requeridoItem;
    }

    public void setRequeridoItem(boolean requeridoItem) {
        this.requeridoItem = requeridoItem;
    }

    public Date getFechaHoraInhabilitacionItem() {
        return fechaHoraInhabilitacionItem;
    }

    public void setFechaHoraInhabilitacionItem(Date fechaHoraInhabilitacionItem) {
        this.fechaHoraInhabilitacionItem = fechaHoraInhabilitacionItem;
    }

    public TipoDatoItem getTipoDatoItem() {
        return tipoDatoItem;
    }

    public void setTipoDatoItem(TipoDatoItem tipoDatoItem) {
        this.tipoDatoItem = tipoDatoItem;
    }
    
}
