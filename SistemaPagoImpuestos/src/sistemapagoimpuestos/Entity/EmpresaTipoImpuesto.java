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
public class EmpresaTipoImpuesto extends Entity{
    private String urlConexionEmpresaTipoImpuesto;
    private Date fechaHoraInhabilitacionEmpresaTipoImpuesto;
    private TipoImpuesto tipoImpuesto;
    private Empresa empresa;

    public EmpresaTipoImpuesto() {
    }

    public EmpresaTipoImpuesto(String urlConexionEmpresaTipoImpuesto, Date fechaHoraInhabilitacionEmpresaTipoImpuesto, TipoImpuesto tipoImpuesto, Empresa empresa) {
        this.urlConexionEmpresaTipoImpuesto = urlConexionEmpresaTipoImpuesto;
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
        this.tipoImpuesto = tipoImpuesto;
        this.empresa = empresa;
    }

  

    public String getUrlConexionEmpresaTipoImpuesto() {
        return urlConexionEmpresaTipoImpuesto;
    }

    public void setUrlConexionEmpresaTipoImpuesto(String urlConexionEmpresaTipoImpuesto) {
        this.urlConexionEmpresaTipoImpuesto = urlConexionEmpresaTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionEmpresaTipoImpuesto() {
        return fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public void setFechaHoraInhabilitacionEmpresaTipoImpuesto(Date fechaHoraInhabilitacionEmpresaTipoImpuesto) {
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
}
