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
public class ParametroSistema extends Entity{
    
    private int codigoParametroSistema;
    private int cantIntentosSincronizacionParametroSistema;
    private String cuitBancoParametroSistema;
    private int frecuenciaSincronizacionParametroSistema;
    private String nombreBancoParametroSistema;
    private Date fechaInhabilitacionParametroSistema;

    public ParametroSistema() {
    }

    public ParametroSistema(int codigoParametroSistema, int cantIntentosSincronizacionParametroSistema, String cuitBancoParametroSistema, int frecuenciaSincronizacionParametroSistema, String nombreBancoParametroSistema, Date fechaInhabilitacionParametroSistema) {
        this.codigoParametroSistema = codigoParametroSistema;
        this.cantIntentosSincronizacionParametroSistema = cantIntentosSincronizacionParametroSistema;
        this.cuitBancoParametroSistema = cuitBancoParametroSistema;
        this.frecuenciaSincronizacionParametroSistema = frecuenciaSincronizacionParametroSistema;
        this.nombreBancoParametroSistema = nombreBancoParametroSistema;
        this.fechaInhabilitacionParametroSistema = fechaInhabilitacionParametroSistema;
    }


    public int getCantIntentosSincronizacionParametroSistema() {
        return cantIntentosSincronizacionParametroSistema;
    }

    public void setCantIntentosSincronizacionParametroSistema(int cantIntentosSincronizacionParametroSistema) {
        this.cantIntentosSincronizacionParametroSistema = cantIntentosSincronizacionParametroSistema;
    }

    public String getCuitBancoParametroSistema() {
        return cuitBancoParametroSistema;
    }

    public void setCuitBancoParametroSistema(String cuitBancoParametroSistema) {
        this.cuitBancoParametroSistema = cuitBancoParametroSistema;
    }

    public int getFrecuenciaSincronizacionParametroSistema() {
        return frecuenciaSincronizacionParametroSistema;
    }

    public void setFrecuenciaSincronizacionParametroSistema(int frecuenciaSincronizacionParametroSistema) {
        this.frecuenciaSincronizacionParametroSistema = frecuenciaSincronizacionParametroSistema;
    }

    public String getNombreBancoParametroSistema() {
        return nombreBancoParametroSistema;
    }

    public void setNombreBancoParametroSistema(String nombreBancoParametroSistema) {
        this.nombreBancoParametroSistema = nombreBancoParametroSistema;
    }

    public int getCodigoParametroSistema() {
        return codigoParametroSistema;
    }

    public void setCodigoParametroSistema(int codigoParametroSistema) {
        this.codigoParametroSistema = codigoParametroSistema;
    }

    public Date getFechaInhabilitacionParametroSistema() {
        return fechaInhabilitacionParametroSistema;
    }

    public void setFechaInhabilitacionParametroSistema(Date fechaInhabilitacionParametroSistema) {
        this.fechaInhabilitacionParametroSistema = fechaInhabilitacionParametroSistema;
    }    
}
