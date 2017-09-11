/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

public class DTOEmpresaBuscada {
    
    private String cuitDTOEmpresa;
    private String nombreDTOEmpresa;

    public DTOEmpresaBuscada(String cuitDTOEmpresa, String nombreDTOEmpresa) {
        this.cuitDTOEmpresa = cuitDTOEmpresa;
        this.nombreDTOEmpresa = nombreDTOEmpresa;
    }

    public DTOEmpresaBuscada() {
    }

    public String getCuitDTOEmpresa() {
        return cuitDTOEmpresa;
    }

    public void setCuitDTOEmpresa(String cuitDTOEmpresa) {
        this.cuitDTOEmpresa = cuitDTOEmpresa;
    }

    public String getNombreDTOEmpresa() {
        return nombreDTOEmpresa;
    }

    public void setNombreDTOEmpresa(String nombreDTOEmpresa) {
        this.nombreDTOEmpresa = nombreDTOEmpresa;
    }
    
    
    
}
