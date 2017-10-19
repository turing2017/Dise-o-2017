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
public class DTOOperacionComision {
   
    double valorComision;
    Date fechaCalculoComision;
    int numeroOperacion;
    double nroComprobanteFactura;
    double importePagadoOperacion;

    public DTOOperacionComision() {
    }

    public DTOOperacionComision(double valorComision, Date fechaCalculoComision, int numeroOperacion, double nroComprobanteFactura, double importePagadoOperacion) {
        this.valorComision = valorComision;
        this.fechaCalculoComision = fechaCalculoComision;
        this.numeroOperacion = numeroOperacion;
        this.nroComprobanteFactura = nroComprobanteFactura;
        this.importePagadoOperacion = importePagadoOperacion;
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

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public double getNroComprobanteFactura() {
        return nroComprobanteFactura;
    }

    public void setNroComprobanteFactura(double nroComprobanteFactura) {
        this.nroComprobanteFactura = nroComprobanteFactura;
    }

    public double getImportePagadoOperacion() {
        return importePagadoOperacion;
    }

    public void setImportePagadoOperacion(double importePagadoOperacion) {
        this.importePagadoOperacion = importePagadoOperacion;
    }


}
