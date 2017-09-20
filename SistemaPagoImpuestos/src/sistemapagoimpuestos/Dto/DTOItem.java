/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author Markz
 */
public class DTOItem {
    
    private String codigoDTOItem;
    private String nombreDTOItem;
    private int longitudDTOItem;
    private boolean requeridoDTOItem;
    private Date fechaHoraInhabilitacionDTOItem;

    public DTOItem() {
    }

    public DTOItem(String codigoDTOItem, String nombreDTOItem, int longitudDTOItem, boolean requeridoDTOItem, Date fechaHoraInhabilitacionDTOItem) {
        this.codigoDTOItem = codigoDTOItem;
        this.nombreDTOItem = nombreDTOItem;
        this.longitudDTOItem = longitudDTOItem;
        this.requeridoDTOItem = requeridoDTOItem;
        this.fechaHoraInhabilitacionDTOItem = fechaHoraInhabilitacionDTOItem;
    }

    public String getCodigoDTOItem() {
        return codigoDTOItem;
    }

    public void setCodigoDTOItem(String codigoDTOItem) {
        this.codigoDTOItem = codigoDTOItem;
    }

    public String getNombreDTOItem() {
        return nombreDTOItem;
    }

    public void setNombreDTOItem(String nombreDTOItem) {
        this.nombreDTOItem = nombreDTOItem;
    }

    public int getLongitudDTOItem() {
        return longitudDTOItem;
    }

    public void setLongitudDTOItem(int longitudDTOItem) {
        this.longitudDTOItem = longitudDTOItem;
    }

    public boolean isRequeridoDTOItem() {
        return requeridoDTOItem;
    }

    public void setRequeridoDTOItem(boolean requeridoDTOItem) {
        this.requeridoDTOItem = requeridoDTOItem;
    }

    public Date getFechaHoraInhabilitacionDTOItem() {
        return fechaHoraInhabilitacionDTOItem;
    }

    public void setFechaHoraInhabilitacionDTOItem(Date fechaHoraInhabilitacionDTOItem) {
        this.fechaHoraInhabilitacionDTOItem = fechaHoraInhabilitacionDTOItem;
    }
    
    }
