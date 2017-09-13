/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class DTOTipoEmpresa {
  private String nombreDTOTipoEmpresa;
    private Date fechaInhabilitacionDTOTipoEmpresa;

    public DTOTipoEmpresa(String nombreDTOTipoEmpresa, Date fechaInhabilitacionDTOTipoEmpresa) {
        this.nombreDTOTipoEmpresa = nombreDTOTipoEmpresa;
        this.fechaInhabilitacionDTOTipoEmpresa = fechaInhabilitacionDTOTipoEmpresa;
    }

    

    public DTOTipoEmpresa() {
    }
    
    

    public String getNombreDTOTipoEmpresa() {
        return nombreDTOTipoEmpresa;
    }

    public void setNombreDTOTipoEmpresa(String nombreDTOTipoEmpresa) {
        this.nombreDTOTipoEmpresa = nombreDTOTipoEmpresa;
    }

    public Date getFechaInhabilitacionDTOTipoEmpresa() {
        return fechaInhabilitacionDTOTipoEmpresa;
    }

    public void setFechaInhabilitacionDTOTipoEmpresa(Date fechaInhabilitacionDTOTipoEmpresa) {
        this.fechaInhabilitacionDTOTipoEmpresa = fechaInhabilitacionDTOTipoEmpresa;
    }
      
}
