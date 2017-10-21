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

    public DTOAccionesSistema(String accion, String descripcionAccion, Date fechaHoraAccion) {
        this.accion = accion;
        this.descripcionAccion = descripcionAccion;
        this.fechaHoraAccion = fechaHoraAccion;
    }
      
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
        System.out.println("-------------------------");
        System.out.println(fechaHoraAccion);
        System.out.println(accion);
        System.out.println();
        String[] lineasDescripcion = descripcionAccion.split("\\r?\\n");
        for (String linea : lineasDescripcion) {
            System.out.println(linea);
        }
        System.out.println("-------------------------");
    }
}
