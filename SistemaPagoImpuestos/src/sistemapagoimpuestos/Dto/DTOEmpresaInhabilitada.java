/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author Tongas
 */
public class DTOEmpresaInhabilitada {
    
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String cuitEmpresa;
    private Date fechaHoraInhabilitacionEmpresa;

    public DTOEmpresaInhabilitada(String nombreEmpresa, String direccionEmpresa, String cuitEmpresa, Date fechaHoraInhabilitacionEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.cuitEmpresa = cuitEmpresa;
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
    }

    public DTOEmpresaInhabilitada() {
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public Date getFechaHoraInhabilitacionEmpresa() {
        return fechaHoraInhabilitacionEmpresa;
    }

    public void setFechaHoraInhabilitacionEmpresa(Date fechaHoraInhabilitacionEmpresa) {
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
    }
    
    
    
}
