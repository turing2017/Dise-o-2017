/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author vande
 */
public class DTOComision {
    
    double valorComision;
    Date fechaCalculoComision;
    DTOOperacion dtoOperacion;

    public DTOOperacion getDtoOperacion() {
        return dtoOperacion;
    }

    public void setDtoOperacion(DTOOperacion dtoOperacion) {
        this.dtoOperacion = dtoOperacion;
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
     
}
