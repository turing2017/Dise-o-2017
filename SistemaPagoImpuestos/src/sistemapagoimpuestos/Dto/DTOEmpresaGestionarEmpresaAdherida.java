/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;
//Pablin
public class DTOEmpresaGestionarEmpresaAdherida {
    
    private String nombreEmpresa;

    public DTOEmpresaGestionarEmpresaAdherida() {
    }

    public DTOEmpresaGestionarEmpresaAdherida (String nombreEmpresa) {

        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }


}
