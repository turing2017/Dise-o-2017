/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.time.Instant;
import java.util.Date;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoDatoItem;

/**
 *
 * @author Maximiliano
 */
public class DTOEmpresa {
    
    private String cuitDTOEmpresa;
    private String direccionDTOEmpresa;
    private Date fechaHoraInhabilitacionDTOEmpresa;
    private String nombreDTOEmpresa;

    public DTOEmpresa() {
    }

    public DTOEmpresa(String cuitDTOEmpresa, String direccionDTOEmpresa, Date fechaHoraInhabilitacionDTOEmpresa, String nombreDTOEmpresa) {
        this.cuitDTOEmpresa = cuitDTOEmpresa;
        this.direccionDTOEmpresa = direccionDTOEmpresa;
        this.fechaHoraInhabilitacionDTOEmpresa = fechaHoraInhabilitacionDTOEmpresa;
        this.nombreDTOEmpresa = nombreDTOEmpresa;
    }

    public String getCuitDTOEmpresa() {
        return cuitDTOEmpresa;
    }

    public void setCuitDTOEmpresa(String cuitDTOEmpresa) {
        this.cuitDTOEmpresa = cuitDTOEmpresa;
    }

    public String getDireccionDTOEmpresa() {
        return direccionDTOEmpresa;
    }

    public void setDireccionDTOEmpresa(String direccionDTOEmpresa) {
        this.direccionDTOEmpresa = direccionDTOEmpresa;
    }

    public Date getFechaHoraInhabilitacionDTOEmpresa() {
        return fechaHoraInhabilitacionDTOEmpresa;
    }

    public void setFechaHoraInhabilitacionDTOEmpresa(Date fechaHoraInhabilitacionDTOEmpresa) {
        this.fechaHoraInhabilitacionDTOEmpresa = fechaHoraInhabilitacionDTOEmpresa;
    }

    public String getNombreDTOEmpresa() {
        return nombreDTOEmpresa;
    }

    public void setNombreDTOEmpresa(String nombreDTOEmpresa) {
        this.nombreDTOEmpresa = nombreDTOEmpresa;
    }
    
    
}
