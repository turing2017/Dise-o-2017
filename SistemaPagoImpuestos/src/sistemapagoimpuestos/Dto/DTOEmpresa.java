/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author Markz
 */
public class DTOEmpresa {
    private String cuitEmpresa;
    private String nombreEmpresa;
    private String direccionEmpresa;

    public DTOEmpresa() {
    }

    public DTOEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    
    
}
