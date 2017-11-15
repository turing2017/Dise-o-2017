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
    Operacion operacion;

    public Comision() {
    }

    public Comision( double valorComision, Operacion operacion) {
       
        this.valorComision = valorComision;
        this.operacion = operacion;
    }

    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
    }

   

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    
    
}
