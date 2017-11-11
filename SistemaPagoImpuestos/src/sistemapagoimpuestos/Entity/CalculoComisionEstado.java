/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author vande
 */
public class CalculoComisionEstado {
    Date fechaHoraDesdeCalculoComisionEstado;
    Date fechaHoraHastaCalculoComisionEstado;
    EstadoCalculoComision estadoCalculoComision;

    public CalculoComisionEstado(Date fechaHoraDesdeCalculoComisionEstado, Date fechaHoraHastaCalculoComisionEstado, EstadoCalculoComision estadoCalculoComision) {
        this.fechaHoraDesdeCalculoComisionEstado = fechaHoraDesdeCalculoComisionEstado;
        this.fechaHoraHastaCalculoComisionEstado = fechaHoraHastaCalculoComisionEstado;
        this.estadoCalculoComision = estadoCalculoComision;
    }

    public Date getFechaHoraDesdeCalculoComisionEstado() {
        return fechaHoraDesdeCalculoComisionEstado;
    }

    public void setFechaHoraDesdeCalculoComisionEstado(Date fechaHoraDesdeCalculoComisionEstado) {
        this.fechaHoraDesdeCalculoComisionEstado = fechaHoraDesdeCalculoComisionEstado;
    }

    public Date getFechaHoraHastaCalculoComisionEstado() {
        return fechaHoraHastaCalculoComisionEstado;
    }

    public void setFechaHoraHastaCalculoComisionEstado(Date fechaHoraHastaCalculoComisionEstado) {
        this.fechaHoraHastaCalculoComisionEstado = fechaHoraHastaCalculoComisionEstado;
    }

    public EstadoCalculoComision getEstadoCalculoComision() {
        return estadoCalculoComision;
    }

    public void setEstadoCalculoComision(EstadoCalculoComision estadoCalculoComision) {
        this.estadoCalculoComision = estadoCalculoComision;
    }
    
}
