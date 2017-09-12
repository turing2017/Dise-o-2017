/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author Tongas
 */
public class DTOEmpresaHabilitada {
    
    private String direccionEmpresa;
    private String nombreEmpresa;
    private String cuitEmpresa;

    public DTOEmpresaHabilitada(String direccionEmpresa, String nombreEmpresa, String cuitEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.cuitEmpresa = cuitEmpresa;
    }

    public DTOEmpresaHabilitada() {
    }
    
    

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }
    
    
    
}
