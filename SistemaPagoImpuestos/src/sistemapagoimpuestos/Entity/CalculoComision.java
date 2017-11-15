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
public class CalculoComision extends Entity {

    Date fechaCalculoComision;
    double valorTotalCalculoComision;
    private List<CalculoComisionEstado> CalculoComisionEstadoList;
    private List<Comision> ComisionList;

    public CalculoComision(Date fechaCalculoComision, double valorTotalCalculoComision, List<CalculoComisionEstado> listCalculoComisionEstado, List<Comision> listComision) {
        this.fechaCalculoComision = fechaCalculoComision;
        this.valorTotalCalculoComision = valorTotalCalculoComision;
        this.CalculoComisionEstadoList = listCalculoComisionEstado;
        this.ComisionList = listComision;
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

    public List<CalculoComisionEstado> getCalculoComisionEstadoList() {
        return CalculoComisionEstadoList;
    }

    public void setCalculoComisionEstadoList(List<CalculoComisionEstado> CalculoComisionEstadoList) {
        this.CalculoComisionEstadoList = CalculoComisionEstadoList;
    }

    public List<Comision> getComisionList() {
        return ComisionList;
    }

    public void setComisionList(List<Comision> ComisionList) {
        this.ComisionList = ComisionList;
    }

}
