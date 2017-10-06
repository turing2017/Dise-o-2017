/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ggiorgi
 */
public class DTOAccionesSistema {
    private Date fechaHoraAccion;
    private String accion;
    private String descripcionAccion;
      
    public Date getFechaHoraAccion() {
        return fechaHoraAccion;
    }

    public void setFechaHoraAccion(Date fechaHoraAccion) {
        this.fechaHoraAccion = fechaHoraAccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcionAccion() {
        return descripcionAccion;
    }

    public void setDescripcionAccion(String descripcionAccion) {
        this.descripcionAccion = descripcionAccion;
    }

    public void imprimirSTD() {
        System.out.println(fechaHoraAccion);
        System.out.println(accion);
        System.out.println(descripcionAccion);
    }
}
