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
    private String cuitEmpresaExistente;
    private String nombreEmpresaExistente;
    private String direccionEmpresaExistente;
    private String habilitadaEmpresaExistente;
    private String nombreTipoEmpresaEmpresaExistente;
    private String frecuenciaLiquidacionEmpresaTipoImpuesto;
    private String tipoImpuestoEmpresaEmpresaExistente;
    public DTOEmpresaExistente() {
    }
  
    public DTOEmpresaExistente(String cuitEmpresaExistente, String nombreEmpresaExistente,  String nombreTipoEmpresaEmpresaExistente, String tipoEmpresaEmpresaEmpresaExistente, String frecuenciaLiquidacionEmpresaTipoImpuesto,   String direccionEmpresaExistente,  String tipoImpuestoEmpresaEmpresaExistente, String habilitadaEmpresaExistente) {
        this.cuitEmpresaExistente = cuitEmpresaExistente;
        this.nombreEmpresaExistente = nombreEmpresaExistente;
        this.direccionEmpresaExistente = direccionEmpresaExistente;
        this.habilitadaEmpresaExistente = habilitadaEmpresaExistente;
        this.nombreTipoEmpresaEmpresaExistente = nombreTipoEmpresaEmpresaExistente;
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
        this.tipoImpuestoEmpresaEmpresaExistente = tipoImpuestoEmpresaEmpresaExistente;
    }

    public String getCuitEmpresaExistente() {
        return cuitEmpresaExistente;
    }

    public void setCuitEmpresaExistente(String cuitEmpresaExistente) {
        this.cuitEmpresaExistente = cuitEmpresaExistente;
    }

    public String getNombreEmpresaExistente() {
        return nombreEmpresaExistente;
    }

    public void setNombreEmpresaExistente(String nombreEmpresaExistente) {
        this.nombreEmpresaExistente = nombreEmpresaExistente;
    }

    public String getDireccionEmpresaExistente() {
        return direccionEmpresaExistente;
    }

    public void setDireccionEmpresaExistente(String direccionEmpresaExistente) {
        this.direccionEmpresaExistente = direccionEmpresaExistente;
    }

    public String getHabilitadaEmpresaExistente() {
        return habilitadaEmpresaExistente;
    }

    public void setHabilitadaEmpresaExistente(String habilitadaEmpresaExistente) {
        this.habilitadaEmpresaExistente = habilitadaEmpresaExistente;
    }

    public String getNombreTipoEmpresaEmpresaExistente() {
        return nombreTipoEmpresaEmpresaExistente;
    }

    public void setNombreTipoEmpresaEmpresaExistente(String nombreTipoEmpresaEmpresaExistente) {
        this.nombreTipoEmpresaEmpresaExistente = nombreTipoEmpresaEmpresaExistente;
    }

    public String getFrecuenciaLiquidacionEmpresaTipoImpuesto() {
        return frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public void setFrecuenciaLiquidacionEmpresaTipoImpuesto(String frecuenciaLiquidacionEmpresaTipoImpuesto) {
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public String getTipoImpuestoEmpresaEmpresaExistente() {
        return tipoImpuestoEmpresaEmpresaExistente;
    }

    public void setTipoImpuestoEmpresaEmpresaExistente(String tipoImpuestoEmpresaEmpresaExistente) {
        this.tipoImpuestoEmpresaEmpresaExistente = tipoImpuestoEmpresaEmpresaExistente;
    }


    }
    
    


