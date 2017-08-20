/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

/**
 *
 * @author mvissio
 */
public class ParametroSistema extends Entity{
    
    private int cantIntentosSincronizacionParametroSistema;
    private String cuitBancoParametroSistema;
    private int frecuenciaSincronizacionParametroSistema;
    private String nombreBancoParametroSistema;
    private String urlConexionBancoParametroSistema;

    public ParametroSistema() {
    }

    public ParametroSistema(int cantIntentosSincronizacionParametroSistema, String cuitBancoParametroSistema, int frecuenciaSincronizacionParametroSistema, String nombreBancoParametroSistema, String urlConexionBancoParametroSistema) {
        this.cantIntentosSincronizacionParametroSistema = cantIntentosSincronizacionParametroSistema;
        this.cuitBancoParametroSistema = cuitBancoParametroSistema;
        this.frecuenciaSincronizacionParametroSistema = frecuenciaSincronizacionParametroSistema;
        this.nombreBancoParametroSistema = nombreBancoParametroSistema;
        this.urlConexionBancoParametroSistema = urlConexionBancoParametroSistema;
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

    public String getUrlConexionBancoParametroSistema() {
        return urlConexionBancoParametroSistema;
    }

    public void setUrlConexionBancoParametroSistema(String urlConexionBancoParametroSistema) {
        this.urlConexionBancoParametroSistema = urlConexionBancoParametroSistema;
    }

    
    
    
}
