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
    
    Date fechaCalculoComision;
    Operacion operacion;

    public Comision() {
    }

    public Comision( Date fechaCalculoComision, Operacion operacion) {
       
        this.fechaCalculoComision = fechaCalculoComision;
        this.operacion = operacion;
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
