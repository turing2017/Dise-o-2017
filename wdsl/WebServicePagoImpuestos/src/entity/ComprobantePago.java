package entity;


import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Markz
 */
public class ComprobantePago {
    private Date fechaVencimiento;
    private int nroComprobante;
    private double montoTotal;
    private List<AtributoAdicional> atrributosAdicionales;

    public ComprobantePago() {
    }

    public ComprobantePago(Date fechaVencimiento, int nroComprobante, double montoTotal, List<AtributoAdicional> atrributosAdicionales) {
        this.fechaVencimiento = fechaVencimiento;
        this.nroComprobante = nroComprobante;
        this.montoTotal = montoTotal;
        this.atrributosAdicionales = atrributosAdicionales;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(int nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<AtributoAdicional> getAtrributosAdicionales() {
        return atrributosAdicionales;
    }

    public void setAtrributosAdicionales(List<AtributoAdicional> atrributosAdicionales) {
        this.atrributosAdicionales = atrributosAdicionales;
    }
    
    
}
