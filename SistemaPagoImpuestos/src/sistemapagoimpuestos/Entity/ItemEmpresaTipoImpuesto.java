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
public class ItemEmpresaTipoImpuesto extends Entity{
    private int ordenItemEmpresaTipoImpuesto;
    private Date fechaInhabilitacionItemEmpresaTipoImpuesto;
    private Item item;
    private EmpresaTipoImpuesto empresaTipoImpuesto;
    private boolean indicaPeriodicidadItemEmpresaTipoImpuesto;

    public ItemEmpresaTipoImpuesto() {
    }

    public ItemEmpresaTipoImpuesto(int ordenItemEmpresaTipoImpuesto, Date fechaInhabilitacionItemEmpresaTipoImpuesto, Item item, EmpresaTipoImpuesto empresaTipoImpuesto, boolean indicaPerioricidadItemEmpresaTipoImpuesto) {
        this.ordenItemEmpresaTipoImpuesto = ordenItemEmpresaTipoImpuesto;
        this.fechaInhabilitacionItemEmpresaTipoImpuesto = fechaInhabilitacionItemEmpresaTipoImpuesto;
        this.item = item;
        this.empresaTipoImpuesto = empresaTipoImpuesto;
        this.indicaPeriodicidadItemEmpresaTipoImpuesto = indicaPerioricidadItemEmpresaTipoImpuesto;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public EmpresaTipoImpuesto getEmpresaTipoImpuesto() {
        return empresaTipoImpuesto;
    }

    public void setEmpresaTipoImpuesto(EmpresaTipoImpuesto empresaTipoImpuesto) {
        this.empresaTipoImpuesto = empresaTipoImpuesto;
    }

    public boolean isIndicaPeriodicidadItemEmpresaTipoImpuesto() {
        return indicaPeriodicidadItemEmpresaTipoImpuesto;
    }

    public void setIndicaPeriodicidadItemEmpresaTipoImpuesto(boolean indicaPerioricidadItemEmpresaTipoImpuesto) {
        this.indicaPeriodicidadItemEmpresaTipoImpuesto = indicaPerioricidadItemEmpresaTipoImpuesto;
    }
    
}
