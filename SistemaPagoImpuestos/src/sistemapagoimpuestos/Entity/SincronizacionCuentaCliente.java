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
public class SincronizacionCuentaCliente extends Entity{
    private Date fechaHoraSincronizacionClienteEntidad;
    private EstadoSincronizacionCuentaCliente estadoSincronizacionCuentaCliente;

    public SincronizacionCuentaCliente() {
    }

    public SincronizacionCuentaCliente(Date fechaHoraSincronizacionClienteEntidad, EstadoSincronizacionCuentaCliente estadoSincronizacionCuentaCliente) {
        this.fechaHoraSincronizacionClienteEntidad = fechaHoraSincronizacionClienteEntidad;
        this.estadoSincronizacionCuentaCliente = estadoSincronizacionCuentaCliente;
    }

    public Date getFechaHoraSincronizacionClienteEntidad() {
        return fechaHoraSincronizacionClienteEntidad;
    }

    public void setFechaHoraSincronizacionClienteEntidad(Date fechaHoraSincronizacionClienteEntidad) {
        this.fechaHoraSincronizacionClienteEntidad = fechaHoraSincronizacionClienteEntidad;
    }

    public EstadoSincronizacionCuentaCliente getEstadoSincronizacionCuentaCliente() {
        return estadoSincronizacionCuentaCliente;
    }

    public void setEstadoSincronizacionCuentaCliente(EstadoSincronizacionCuentaCliente estadoSincronizacionCuentaCliente) {
        this.estadoSincronizacionCuentaCliente = estadoSincronizacionCuentaCliente;
    }
    
    
}
