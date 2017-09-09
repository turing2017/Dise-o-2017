/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Entity.CuentaBancaria;
import sistemapagoimpuestos.Entity.DetalleOperacion;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;

/**
 *
 * @author vande
 */
public class DTOOperacion {
    int numeroOperacion;
    String codigoPagoElectronicoOperacion;
    Date fechaHoraOperacion;
    double importePagadoOperacion;
    long nroComprobanteFactura;
    double valorComisionOperacion;
    boolean liquidadaOperacion;
    Empresa empresa;
    CuentaBancaria cuentabancaria;
    List<DetalleOperacion> detalleOperacion;
    TipoImpuesto tipoImpuesto;

    public DTOOperacion() {
    }
    public DTOOperacion(int numeroOperacion, String codigoPagoElectronicoOperacion, Date fechaHoraOperacion, double importePagadoOperacion, long nroComprobanteFactura, double valorComisionOperacion, boolean liquidadaOperacion, Empresa empresa, CuentaBancaria cuentabancaria, List<DetalleOperacion> detalleOperacion, TipoImpuesto tipoImpuesto) {
        this.numeroOperacion = numeroOperacion;
        this.codigoPagoElectronicoOperacion = codigoPagoElectronicoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.importePagadoOperacion = importePagadoOperacion;
        this.nroComprobanteFactura = nroComprobanteFactura;
        this.valorComisionOperacion = valorComisionOperacion;
        this.liquidadaOperacion = liquidadaOperacion;
        this.empresa = empresa;
        this.cuentabancaria = cuentabancaria;
        this.detalleOperacion = detalleOperacion;
        this.tipoImpuesto = tipoImpuesto;
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

    public double getValorComisionOperacion() {
        return valorComisionOperacion;
    }

    public void setValorComisionOperacion(double valorComisionOperacion) {
        this.valorComisionOperacion = valorComisionOperacion;
    }

    public boolean isLiquidadaOperacion() {
        return liquidadaOperacion;
    }

    public void setLiquidadaOperacion(boolean liquidadaOperacion) {
        this.liquidadaOperacion = liquidadaOperacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public CuentaBancaria getCuentabancaria() {
        return cuentabancaria;
    }

    public void setCuentabancaria(CuentaBancaria cuentabancaria) {
        this.cuentabancaria = cuentabancaria;
    }

    public List<DetalleOperacion> getDetalleOperacion() {
        return detalleOperacion;
    }

    public void setDetalleOperacion(List<DetalleOperacion> detalleOperacion) {
        this.detalleOperacion = detalleOperacion;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }



}
