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
public class DTOTipoEmpresa {
    private String nombreTipoEmpresa;
    private Date fechaInhabilitacionTipoEmpresa; 

    public DTOTipoEmpresa() {
    }

    public DTOTipoEmpresa(String nombreTipoEmpresa, Date fechaInhabilitacionTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.fechaInhabilitacionTipoEmpresa = fechaInhabilitacionTipoEmpresa;
    }

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Date getFechaInhabilitacionTipoEmpresa() {
        return fechaInhabilitacionTipoEmpresa;
    }

    public void setFechaInhabilitacionTipoEmpresa(Date fechaInhabilitacionTipoEmpresa) {
        this.fechaInhabilitacionTipoEmpresa = fechaInhabilitacionTipoEmpresa;
    }
    
}