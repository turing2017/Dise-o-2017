/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import sistemapagoimpuestos.Entity.Item;

/**
 *
 * @author Markz
 */
public class DTOItem {
    private String codigoItem;
    private String nombreItem;
    private String itemVal;
    private int longitudItem;
    private boolean requeridoItem;
    private Date fechaHoraInhabilitacionItem;
    private DTOTipoDatoItem dtoTipoDatoItem;

    public DTOItem() {
    }
    
    public DTOItem(String codigoItem, String nombreItem, int longitudItem, boolean requeridoItem, Date fechaHoraInhabilitacionItem) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.longitudItem = longitudItem;
        this.requeridoItem = requeridoItem;
        this.fechaHoraInhabilitacionItem = fechaHoraInhabilitacionItem;
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

    public void setDtoTipoDatoItem(DTOTipoDatoItem dtoTipoDatoItem) {
        this.dtoTipoDatoItem = dtoTipoDatoItem;
    }

    public DTOTipoDatoItem getDtoTipoDatoItem() {
        return dtoTipoDatoItem;
    }

    public String getItemVal() {
        return itemVal;
    }

    public void setItemVal(String itemVal) {
        this.itemVal = itemVal;
    }
    
    public DTOItem ConvertDto(Item item){
        return new DTOItem(item.getCodigoItem(), item.getNombreItem(), item.getLongitudItem(), item.isRequeridoItem(), item.getFechaHoraInhabilitacionItem());
    }
}
