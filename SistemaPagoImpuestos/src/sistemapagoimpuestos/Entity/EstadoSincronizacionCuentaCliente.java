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
public class EstadoSincronizacionCuentaCliente extends Entity{
    private String nombreEstadoSincronizacionCuentaCliente;
    private String descripcionEstadoSincronizacionCuentaCliente;
    private Date fechaInhabilitacionEstadoSincronizacionCuentaCliente;

    public EstadoSincronizacionCuentaCliente() {
    }

    public EstadoSincronizacionCuentaCliente(String nombreEstadoSincronizacionCuentaCliente, String descripcionEstadoSincronizacionCuentaCliente, Date fechaInhabilitacionEstadoSincronizacionCuentaCliente) {
        this.nombreEstadoSincronizacionCuentaCliente = nombreEstadoSincronizacionCuentaCliente;
        this.descripcionEstadoSincronizacionCuentaCliente = descripcionEstadoSincronizacionCuentaCliente;
        this.fechaInhabilitacionEstadoSincronizacionCuentaCliente = fechaInhabilitacionEstadoSincronizacionCuentaCliente;
    }

    public String getNombreEstadoSincronizacionCuentaCliente() {
        return nombreEstadoSincronizacionCuentaCliente;
    }

    public void setNombreEstadoSincronizacionCuentaCliente(String nombreEstadoSincronizacionCuentaCliente) {
        this.nombreEstadoSincronizacionCuentaCliente = nombreEstadoSincronizacionCuentaCliente;
    }

    public String getDescripcionEstadoSincronizacionCuentaCliente() {
        return descripcionEstadoSincronizacionCuentaCliente;
    }

    public void setDescripcionEstadoSincronizacionCuentaCliente(String descripcionEstadoSincronizacionCuentaCliente) {
        this.descripcionEstadoSincronizacionCuentaCliente = descripcionEstadoSincronizacionCuentaCliente;
    }

    public Date getFechaInhabilitacionEstadoSincronizacionCuentaCliente() {
        return fechaInhabilitacionEstadoSincronizacionCuentaCliente;
    }

    public void setFechaInhabilitacionEstadoSincronizacionCuentaCliente(Date fechaInhabilitacionEstadoSincronizacionCuentaCliente) {
        this.fechaInhabilitacionEstadoSincronizacionCuentaCliente = fechaInhabilitacionEstadoSincronizacionCuentaCliente;
    }
}
