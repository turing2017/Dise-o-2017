/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author vande
 */
public class DTOEstadoCalculoComision {
    String nombreEstado;
    Date fechaDesdeComisionEstado;
    Date fechaHastaComisionEstado;

    public DTOEstadoCalculoComision() {
    }

    public DTOEstadoCalculoComision(String nombreEstado, Date fechaDesdeComisionEstado, Date fechaHastaComisionEstado) {
        this.nombreEstado = nombreEstado;
        this.fechaDesdeComisionEstado = fechaDesdeComisionEstado;
        this.fechaHastaComisionEstado = fechaHastaComisionEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Date getFechaDesdeComisionEstado() {
        return fechaDesdeComisionEstado;
    }

    public void setFechaDesdeComisionEstado(Date fechaDesdeComisionEstado) {
        this.fechaDesdeComisionEstado = fechaDesdeComisionEstado;
    }

    public Date getFechaHastaComisionEstado() {
        return fechaHastaComisionEstado;
    }

    public void setFechaHastaComisionEstado(Date fechaHastaComisionEstado) {
        this.fechaHastaComisionEstado = fechaHastaComisionEstado;
    }
    
}
