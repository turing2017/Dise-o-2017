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
public class DTOCliente {
    private String cuilCuitCliente;
    private String apellidoCliente;
    private String nombreCliente;
    private String dniCliente;
    private Date fechaHoraInhabilitacionCliente;

    public DTOCliente() {
    }

    public DTOCliente(String cuilCuitCliente, String apellidoCliente, String nombreCliente, String dniCliente, Date fechaHoraInhabilitacionCliente) {
        this.cuilCuitCliente = cuilCuitCliente;
        this.apellidoCliente = apellidoCliente;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaHoraInhabilitacionCliente = fechaHoraInhabilitacionCliente;
    }

    public String getCuilCuitCliente() {
        return cuilCuitCliente;
    }

    public void setCuilCuitCliente(String cuilCuitCliente) {
        this.cuilCuitCliente = cuilCuitCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Date getFechaHoraInhabilitacionCliente() {
        return fechaHoraInhabilitacionCliente;
    }

    public void setFechaHoraInhabilitacionCliente(Date fechaHoraInhabilitacionCliente) {
        this.fechaHoraInhabilitacionCliente = fechaHoraInhabilitacionCliente;
    }
    
    
}
