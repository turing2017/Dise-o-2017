/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import sistemapagoimpuestos.Entity.Entity;

/**
 *
 * @author Tongas
 */
public class DTOEmpresa extends Entity {
    
    private String cuitDTOEmpresa;
    private String nombreDTOEmpresa;
    private String direccionDTOEmpresa;
    private Date fechaHoraInhabilitacionDTOEmpresa;
    private String nombreTipoEmpresaDTOEmpresa;

    public DTOEmpresa(String cuitDTOEmpresa, String nombreDTOEmpresa, String direccionDTOEmpresa, Date fechaHoraInhabilitacionDTOEmpresa, String nombreTipoEmpresaDTOEmpresa) {
        this.cuitDTOEmpresa = cuitDTOEmpresa;
        this.nombreDTOEmpresa = nombreDTOEmpresa;
        this.direccionDTOEmpresa = direccionDTOEmpresa;
        this.fechaHoraInhabilitacionDTOEmpresa = fechaHoraInhabilitacionDTOEmpresa;
        this.nombreTipoEmpresaDTOEmpresa = nombreTipoEmpresaDTOEmpresa;
    }

    

    public DTOEmpresa() {
    }
    
    

    public String getCuitDTOEmpresa() {
        return cuitDTOEmpresa;
    }

    public void setCuitDTOEmpresa(String cuitDTOEmpresa) {
        this.cuitDTOEmpresa = cuitDTOEmpresa;
    }

    public String getNombreDTOEmpresa() {
        return nombreDTOEmpresa;
    }

    public void setNombreDTOEmpresa(String nombreDTOEmpresa) {
        this.nombreDTOEmpresa = nombreDTOEmpresa;
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

    public String getNombreTipoEmpresaDTOEmpresa() {
        return nombreTipoEmpresaDTOEmpresa;
    }

    public void setNombreTipoEmpresaDTOEmpresa(String nombreTipoEmpresaDTOEmpresa) {
        this.nombreTipoEmpresaDTOEmpresa = nombreTipoEmpresaDTOEmpresa;
    }

    


    
}
