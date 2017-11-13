/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mvissio
 */
public class Operacion extends Entity{
    private int numeroOperacion;
    private String codigoPagoElectrionicoOperacion;
    private Date fechaHoraOperacion;
    private Date fechaVencimientoComprobante;
    private double importePagadoOperacion;
    private double valorTotalComprobante;
    private int nroComprobanteFacturaOperacion;
    private boolean liquidadaOperacion;
    private double valorComisionOperacion;
    private CuentaBancaria cuentaBancaria;
    private Empresa empresa;
    private EmpresaTipoImpuesto empresaTipoImpuesto;
    private TipoImpuesto tipoImpuesto;
    private List<DetalleOperacion> detalleOperacionList = new ArrayList<>();
 
    public Operacion() {
    }

    public Operacion(int numeroOperacion, String codigoPagoElectrionicoOperacion, Date fechaHoraOperacion, Date fechaVencimientoComprobante, double importePagadoOperacion, double valorTotalComprobante, int nroComprobanteFacturaOperacion, boolean liquidadaOperacion, double valorComisionOperacion, CuentaBancaria cuentaBancaria, Empresa empresa, EmpresaTipoImpuesto empresaTipoImpuesto, TipoImpuesto tipoImpuesto) {
        this.numeroOperacion = numeroOperacion;
        this.codigoPagoElectrionicoOperacion = codigoPagoElectrionicoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.fechaVencimientoComprobante = fechaVencimientoComprobante;
        this.importePagadoOperacion = importePagadoOperacion;
        this.valorTotalComprobante = valorTotalComprobante;
        this.nroComprobanteFacturaOperacion = nroComprobanteFacturaOperacion;
        this.liquidadaOperacion = liquidadaOperacion;
        this.valorComisionOperacion = valorComisionOperacion;
        this.cuentaBancaria = cuentaBancaria;
        this.empresa = empresa;
        this.empresaTipoImpuesto = empresaTipoImpuesto;
        this.tipoImpuesto = tipoImpuesto;
    }

 
    
    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getCodigoPagoElectrionicoOperacion() {
        return codigoPagoElectrionicoOperacion;
    }

    public void setCodigoPagoElectrionicoOperacion(String codigoPagoElectrionicoOperacion) {
        this.codigoPagoElectrionicoOperacion = codigoPagoElectrionicoOperacion;
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

    public int getNroComprobanteFacturaOperacion() {
        return nroComprobanteFacturaOperacion;
    }

    public void setNroComprobanteFacturaOperacion(int nroComprobanteFacturaOperacion) {
        this.nroComprobanteFacturaOperacion = nroComprobanteFacturaOperacion;
    }

    public boolean isLiquidadaOperacion() {
        return liquidadaOperacion;
    }

    public void setLiquidadaOperacion(boolean liquidadaOperacion) {
        this.liquidadaOperacion = liquidadaOperacion;
    }

    public double getValorComisionOperacion() {
        return valorComisionOperacion;
    }

    public void setValorComisionOperacion(double valorComisionOperacion) {
        this.valorComisionOperacion = valorComisionOperacion;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EmpresaTipoImpuesto getEmpresaTipoImpuesto() {
        return empresaTipoImpuesto;
    }

    public void setEmpresaTipoImpuesto(EmpresaTipoImpuesto empresaTipoImpuesto) {
        this.empresaTipoImpuesto = empresaTipoImpuesto;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public List<DetalleOperacion> getDetalleOperacionList() {
        return detalleOperacionList;
    }

    public void setDetalleOperacionList(List<DetalleOperacion> detalleOperacion) {
        this.detalleOperacionList = detalleOperacion;
    }

    public Date getFechaVencimientoComprobante() {
        return fechaVencimientoComprobante;
    }

    public void setFechaVencimientoComprobante(Date fechaVencimientoComprobante) {
        this.fechaVencimientoComprobante = fechaVencimientoComprobante;
    }

    public double getValorTotalComprobante() {
        return valorTotalComprobante;
    }

    public void setValorTotalComprobante(double valorTotalComprobante) {
        this.valorTotalComprobante = valorTotalComprobante;
    }

 
    
}