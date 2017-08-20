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
public class Periodicidad extends Entity{
    private int cantDiasPeriodicidad;
    private Date fechaInhabilitacionPeriodicidad;
    private String tipoPeriodicidad;

    public Periodicidad() {
    }

    public Periodicidad(int cantDiasPeriodicidad, Date fechaInhabilitacionPeriodicidad, String tipoPeriodicidad) {
        this.cantDiasPeriodicidad = cantDiasPeriodicidad;
        this.fechaInhabilitacionPeriodicidad = fechaInhabilitacionPeriodicidad;
        this.tipoPeriodicidad = tipoPeriodicidad;
    }

    public int getCantDiasPeriodicidad() {
        return cantDiasPeriodicidad;
    }

    public void setCantDiasPeriodicidad(int cantDiasPeriodicidad) {
        this.cantDiasPeriodicidad = cantDiasPeriodicidad;
    }

    public Date getFechaInhabilitacionPeriodicidad() {
        return fechaInhabilitacionPeriodicidad;
    }

    public void setFechaInhabilitacionPeriodicidad(Date fechaInhabilitacionPeriodicidad) {
        this.fechaInhabilitacionPeriodicidad = fechaInhabilitacionPeriodicidad;
    }

    public String getTipoPeriodicidad() {
        return tipoPeriodicidad;
    }

    public void setTipoPeriodicidad(String tipoPeriodicidad) {
        this.tipoPeriodicidad = tipoPeriodicidad;
    }
    
    
}
