/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author Administrador
 */
public class DTOEmpresasConsultadas {
    private String cuitEmpresasConsultadas;
    private String nombreEmpresasConsultadas;
    private String direccionEmpresasConsultadas;
    private String habilitadaEmpresasConsultadas;
    

    public DTOEmpresasConsultadas() {
    }

    public DTOEmpresasConsultadas(String cuitEmpresasConsultadas, String nombreEmpresasConsultadas, String direccionEmpresasConsultadas, String habilitadaEmpresasConsultadas) {
        this.cuitEmpresasConsultadas = cuitEmpresasConsultadas;
        this.nombreEmpresasConsultadas = nombreEmpresasConsultadas;
        this.direccionEmpresasConsultadas = direccionEmpresasConsultadas;
        this.habilitadaEmpresasConsultadas = habilitadaEmpresasConsultadas;
    }

    public String getCuitEmpresasConsultadas() {
        return cuitEmpresasConsultadas;
    }

    public void setCuitEmpresasConsultadas(String cuitEmpresasConsultadas) {
        this.cuitEmpresasConsultadas = cuitEmpresasConsultadas;
    }

    public String getNombreEmpresasConsultadas() {
        return nombreEmpresasConsultadas;
    }

    public void setNombreEmpresasConsultadas(String nombreEmpresasConsultadas) {
        this.nombreEmpresasConsultadas = nombreEmpresasConsultadas;
    }

    public String getDireccionEmpresasConsultadas() {
        return direccionEmpresasConsultadas;
    }

    public void setDireccionEmpresasConsultadas(String direccionEmpresasConsultadas) {
        this.direccionEmpresasConsultadas = direccionEmpresasConsultadas;
    }

    public String getHabilitadaEmpresasConsultadas() {
        return habilitadaEmpresasConsultadas;
    }

    public void setHabilitadaEmpresasConsultadas(String habilitadaEmpresasConsultadas) {
        this.habilitadaEmpresasConsultadas = habilitadaEmpresasConsultadas;
    }

}