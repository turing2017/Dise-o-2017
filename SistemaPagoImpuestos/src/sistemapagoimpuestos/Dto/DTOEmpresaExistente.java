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
public class DTOEmpresaExistente {
    private String cuitDTOEmpresaExistente;
    private String nombreDTOEmpresaExistente;
    private String direccionDTOEmpresaExistente;
    private String habilitadaDTOEmpresaExistente;
    private String nombreTipoEmpresaDTOEmpresaExistente;
    private Date fechaLiquidacionDTOEmpresaExistente;
    public DTOEmpresaExistente() {
    }

    public DTOEmpresaExistente(String cuitDTOEmpresaExistente, String nombreDTOEmpresaExistente, String direccionDTOEmpresaExistente, String habilitadaDTOEmpresaExistente, String nombreTipoEmpresaDTOEmpresaExistente, Date fechaLiquidacionDTOEmpresaExistente) {
        this.cuitDTOEmpresaExistente = cuitDTOEmpresaExistente;
        this.nombreDTOEmpresaExistente = nombreDTOEmpresaExistente;
        this.direccionDTOEmpresaExistente = direccionDTOEmpresaExistente;
        this.habilitadaDTOEmpresaExistente = habilitadaDTOEmpresaExistente;
        this.nombreTipoEmpresaDTOEmpresaExistente = nombreTipoEmpresaDTOEmpresaExistente;
        this.fechaLiquidacionDTOEmpresaExistente = fechaLiquidacionDTOEmpresaExistente;
    }

    public Date getFechaLiquidacionDTOEmpresaExistente() {
        return fechaLiquidacionDTOEmpresaExistente;
    }

    public void setFechaLiquidacionDTOEmpresaExistente(Date fechaLiquidacionDTOEmpresaExistente) {
        this.fechaLiquidacionDTOEmpresaExistente = fechaLiquidacionDTOEmpresaExistente;
    }

    public String getCuitDTOEmpresaExistente() {
        return cuitDTOEmpresaExistente;
    }

    public void setCuitDTOEmpresaExistente(String cuitDTOEmpresaExistente) {
        this.cuitDTOEmpresaExistente = cuitDTOEmpresaExistente;
    }

    public String getNombreDTOEmpresaExistente() {
        return nombreDTOEmpresaExistente;
    }

    public void setNombreDTOEmpresaExistente(String nombreDTOEmpresaExistente) {
        this.nombreDTOEmpresaExistente = nombreDTOEmpresaExistente;
    }

    public String getDireccionDTOEmpresaExistente() {
        return direccionDTOEmpresaExistente;
    }

    public void setDireccionDTOEmpresaExistente(String direccionDTOEmpresaExistente) {
        this.direccionDTOEmpresaExistente = direccionDTOEmpresaExistente;
    }

    public String getHabilitadaDTOEmpresaExistente() {
        return habilitadaDTOEmpresaExistente;
    }

    public void setHabilitadaDTOEmpresaExistente(String habilitadaDTOEmpresaExistente) {
        this.habilitadaDTOEmpresaExistente = habilitadaDTOEmpresaExistente;
    }

    public String getNombreTipoEmpresaDTOEmpresaExistente() {
        return nombreTipoEmpresaDTOEmpresaExistente;
    }

    public void setNombreTipoEmpresaDTOEmpresaExistente(String nombreTipoEmpresaDTOEmpresaExistente) {
        this.nombreTipoEmpresaDTOEmpresaExistente = nombreTipoEmpresaDTOEmpresaExistente;
    }

}
