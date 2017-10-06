/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;


public class DTORangoFecha {
    private String nombreTipoEmpresa;
    private String cuitEmpresa;
    private String nombreEmpresa;
    private String nombreTipoImpuesto;
    private Date fechaDesde;
    private Date fechaHasta;

    public DTORangoFecha() {
    }

    public DTORangoFecha(String nombreTipoEmpresa, String cuitEmpresa, String nombreEmpresa, String nombreTipoImpuesto, Date fechaDesde, Date fechaHasta) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.cuitEmpresa = cuitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreTipoImpuesto = nombreTipoImpuesto;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    
    

    public String getNombreTipoImpuesto() {
        return nombreTipoImpuesto;
    }

    public void setNombreTipoImpuesto(String nombreTipoImpuesto) {
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    
    
}
