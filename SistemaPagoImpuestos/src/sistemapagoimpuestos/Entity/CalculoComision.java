/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author vande
 */
public class CalculoComision {
    Date fechaCalculoComision;
    double valorTotalCalculoComision;
    List<CalculoComisionEstado> listCalculoComisionEstado;
    List<Comision> listComision;

    public CalculoComision(Date fechaCalculoComision, double valorTotalCalculoComision, List<CalculoComisionEstado> listCalculoComisionEstado, List<Comision> listComision) {
        this.fechaCalculoComision = fechaCalculoComision;
        this.valorTotalCalculoComision = valorTotalCalculoComision;
        this.listCalculoComisionEstado = listCalculoComisionEstado;
        this.listComision = listComision;
    }

    public CalculoComision() {
    }
    

    public Date getFechaCalculoComision() {
        return fechaCalculoComision;
    }

    public void setFechaCalculoComision(Date fechaCalculoComision) {
        this.fechaCalculoComision = fechaCalculoComision;
    }

    public double getValorTotalCalculoComision() {
        return valorTotalCalculoComision;
    }

    public void setValorTotalCalculoComision(double valorTotalCalculoComision) {
        this.valorTotalCalculoComision = valorTotalCalculoComision;
    }

    public List<CalculoComisionEstado> getlistCalculoComisionEstado() {
        return listCalculoComisionEstado;
    }

    public void setListCalculoCOmisionEstado(List<CalculoComisionEstado> listCalculoComisionEstado) {
        this.listCalculoComisionEstado = listCalculoComisionEstado;
    }

    public List<Comision> getListComision() {
        return listComision;
    }

    public void setListComision(List<Comision> listComision) {
        this.listComision = listComision;
    }
   
}
