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
    List<CalculoComisionEstado> listCalculoCOmisionEstado;
    List<Comision> listComision;

    public CalculoComision(Date fechaCalculoComision, double valorTotalCalculoComision, List<CalculoComisionEstado> listCalculoCOmisionEstado, List<Comision> listComision) {
        this.fechaCalculoComision = fechaCalculoComision;
        this.valorTotalCalculoComision = valorTotalCalculoComision;
        this.listCalculoCOmisionEstado = listCalculoCOmisionEstado;
        this.listComision = listComision;
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

    public List<CalculoComisionEstado> getListCalculoCOmisionEstado() {
        return listCalculoCOmisionEstado;
    }

    public void setListCalculoCOmisionEstado(List<CalculoComisionEstado> listCalculoCOmisionEstado) {
        this.listCalculoCOmisionEstado = listCalculoCOmisionEstado;
    }

    public List<Comision> getListComision() {
        return listComision;
    }

    public void setListComision(List<Comision> listComision) {
        this.listComision = listComision;
    }
   
}
