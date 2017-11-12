/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

/**
 *
 * @author vande
 */
public class EstadoCalculoComision extends Entity {

    String nombreEstadoCalculoComision;

    public EstadoCalculoComision(String nombreEstadoCalculoComision) {
        this.nombreEstadoCalculoComision = nombreEstadoCalculoComision;
    }

    public EstadoCalculoComision() {

    }

    public String getNombreEstadoCalculoComision() {
        return nombreEstadoCalculoComision;
    }

    public void setNombreEstadoCalculoComision(String nombreEstadoCalculoComision) {
        this.nombreEstadoCalculoComision = nombreEstadoCalculoComision;
    }

}
