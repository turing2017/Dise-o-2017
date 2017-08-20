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
public class TipoEmpresa extends Entity{
    private String nombreTipoEmpresa;
    private Date fechaInhabilitacion;

    public TipoEmpresa() {
    }

    public TipoEmpresa(String nombreTipoEmpresa, Date fechaInhabilitacion) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.fechaInhabilitacion = fechaInhabilitacion;
    }

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Date getFechaInhabilitacion() {
        return fechaInhabilitacion;
    }

    public void setFechaInhabilitacion(Date fechaInhabilitacion) {
        this.fechaInhabilitacion = fechaInhabilitacion;
    }
    
    
}
