/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;


import java.util.Date;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoDatoItem;

/**
 *
 * @author Maximiliano
 */
public class DTOEmpresa {
    
    private String cuitEmpresa;
    private String direccionEmpresa;
    private Date fechaHoraInhabilitacionEmpresa;
    private String nombreEmpresa;
    
    public DTOEmpresa() {
    }

    public DTOEmpresa(String cuitEmpresa, String direccionEmpresa, Date fechaHoraInhabilitacionEmpresa, String nombreEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public Date getFechaHoraInhabilitacionEmpresa() {
        return fechaHoraInhabilitacionEmpresa;
    }

    public void setFechaHoraInhabilitacionEmpresa(Date fechaHoraInhabilitacionEmpresa) {
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    
}
