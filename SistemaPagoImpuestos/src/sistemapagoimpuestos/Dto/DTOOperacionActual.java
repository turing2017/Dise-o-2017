/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author mviss
 */
public class DTOOperacionActual {

    private int numeroOperacion;
    private String codigoPagoElectronicoOperacion;
    private Date fechaHoraOperacion;
    private double importePagadoOperacion;
    private long nroComprobanteFactura;
    private String nombreEmpresa;
    private String nombreTipoImpuesto;
    public DTOOperacionActual() {
    }

    public DTOOperacionActual(int numeroOperacion, String codigoPagoElectronicoOperacion, Date fechaHoraOperacion, double importePagadoOperacion, long nroComprobanteFactura, String nombreEmpresa, String nombreTipoImpuesto) {
        this.numeroOperacion = numeroOperacion;
        this.codigoPagoElectronicoOperacion = codigoPagoElectronicoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.importePagadoOperacion = importePagadoOperacion;
        this.nroComprobanteFactura = nroComprobanteFactura;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getCodigoPagoElectronicoOperacion() {
        return codigoPagoElectronicoOperacion;
    }

    public void setCodigoPagoElectronicoOperacion(String codigoPagoElectronicoOperacion) {
        this.codigoPagoElectronicoOperacion = codigoPagoElectronicoOperacion;
    }

    public Date getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(Date fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public double getImportePagadoOperacion() {
        return importePagadoOperacion;
    }

    public void setImportePagadoOperacion(double importePagadoOperacion) {
        this.importePagadoOperacion = importePagadoOperacion;
    }

    public long getNroComprobanteFactura() {
        return nroComprobanteFactura;
    }

    public void setNroComprobanteFactura(long nroComprobanteFactura) {
        this.nroComprobanteFactura = nroComprobanteFactura;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreTipoImpuesto() {
        return nombreTipoImpuesto;
    }

    public void setNombreTipoImpuesto(String nombreTipoImpuesto) {
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }

    
    
}
