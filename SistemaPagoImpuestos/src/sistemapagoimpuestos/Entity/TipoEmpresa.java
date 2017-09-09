/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author Tongas
 */
public class TipoEmpresa extends Entity {
    
    private String nombreTipoEmpresa;
    private Date fechaHoraInhabilitacionTipoEmpresa;

    public TipoEmpresa(String nombreTipoEmpresa, Date fechaHoraInhabilitacionTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.fechaHoraInhabilitacionTipoEmpresa = fechaHoraInhabilitacionTipoEmpresa;
    }

    public TipoEmpresa() {
    }
    

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Date getFechaHoraInhabilitacionTipoEmpresa() {
        return fechaHoraInhabilitacionTipoEmpresa;
    }

    public void setFechaHoraInhabilitacionTipoEmpresa(Date fechaHoraInhabilitacionTipoEmpresa) {
        this.fechaHoraInhabilitacionTipoEmpresa = fechaHoraInhabilitacionTipoEmpresa;
    }
    
    
    
}
