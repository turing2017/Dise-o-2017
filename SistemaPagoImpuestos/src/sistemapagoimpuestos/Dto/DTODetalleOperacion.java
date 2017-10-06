/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

public class DTODetalleOperacion {
    
    private String valorDetalleOperacion;
    private int ordenItemEmpresaTipoImpuesto;
    private Date fechaInhabilitacionItemEmpresaTipoImpuesto;
    private boolean indicaPeriodicidadItemEmpresaTipoImpuesto;
    private String codigoItem;
    private String nombreItem;
    private int longitudItem;
    private boolean requeridoItem;
    private Date fechaHoraInhabilitacionItem;
    private int codigoTipoDatoItem;
    private String nombreTipoDatoItem;

    public DTODetalleOperacion(String valorDetalleOperacion, int ordenItemEmpresaTipoImpuesto, Date fechaInhabilitacionItemEmpresaTipoImpuesto, boolean indicaPeriodicidadItemEmpresaTipoImpuesto, String codigoItem, String nombreItem, int longitudItem, boolean requeridoItem, Date fechaHoraInhabilitacionItem, int codigoTipoDatoItem, String nombreTipoDatoItem) {
        this.valorDetalleOperacion = valorDetalleOperacion;
        this.ordenItemEmpresaTipoImpuesto = ordenItemEmpresaTipoImpuesto;
        this.fechaInhabilitacionItemEmpresaTipoImpuesto = fechaInhabilitacionItemEmpresaTipoImpuesto;
        this.indicaPeriodicidadItemEmpresaTipoImpuesto = indicaPeriodicidadItemEmpresaTipoImpuesto;
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.longitudItem = longitudItem;
        this.requeridoItem = requeridoItem;
        this.fechaHoraInhabilitacionItem = fechaHoraInhabilitacionItem;
        this.codigoTipoDatoItem = codigoTipoDatoItem;
        this.nombreTipoDatoItem = nombreTipoDatoItem;
    }

    public String getValorDetalleOperacion() {
        return valorDetalleOperacion;
    }

    public void setValorDetalleOperacion(String valorDetalleOperacion) {
        this.valorDetalleOperacion = valorDetalleOperacion;
    }

    public int getOrdenItemEmpresaTipoImpuesto() {
        return ordenItemEmpresaTipoImpuesto;
    }

    public void setOrdenItemEmpresaTipoImpuesto(int ordenItemEmpresaTipoImpuesto) {
        this.ordenItemEmpresaTipoImpuesto = ordenItemEmpresaTipoImpuesto;
    }

    public Date getFechaInhabilitacionItemEmpresaTipoImpuesto() {
        return fechaInhabilitacionItemEmpresaTipoImpuesto;
    }

    public void setFechaInhabilitacionItemEmpresaTipoImpuesto(Date fechaInhabilitacionItemEmpresaTipoImpuesto) {
        this.fechaInhabilitacionItemEmpresaTipoImpuesto = fechaInhabilitacionItemEmpresaTipoImpuesto;
    }

    public boolean isIndicaPeriodicidadItemEmpresaTipoImpuesto() {
        return indicaPeriodicidadItemEmpresaTipoImpuesto;
    }

    public void setIndicaPeriodicidadItemEmpresaTipoImpuesto(boolean indicaPeriodicidadItemEmpresaTipoImpuesto) {
        this.indicaPeriodicidadItemEmpresaTipoImpuesto = indicaPeriodicidadItemEmpresaTipoImpuesto;
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
