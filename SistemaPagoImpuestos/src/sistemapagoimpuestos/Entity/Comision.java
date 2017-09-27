/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author vande
 */
public class Comision extends Entity {
    double valorComision;
    Date fechaCalculoComision;
    Operacion operacion;

    public Comision() {
    }

    public Comision(double valorComision, Date fechaCalculoComision, Operacion operacion) {
        this.valorComision = valorComision;
        this.fechaCalculoComision = fechaCalculoComision;
        this.operacion = operacion;
    }

    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
    }

    public Date getFechaCalculoComision() {
        return fechaCalculoComision;
    }

    public void setFechaCalculoComision(Date fechaCalculoComision) {
        this.fechaCalculoComision = fechaCalculoComision;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    
    
}
