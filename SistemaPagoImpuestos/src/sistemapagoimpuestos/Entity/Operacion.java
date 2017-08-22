/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mvissio
 */
public class Operacion extends Entity{
    private int numeroOperacion;
    private String codigoPagoElectrionicoOperacion;
    private Date fechaHoraOperacion;
    private double importePagadoOperacion;
    private int nroComprobanteFacturaOperacion;
    private boolean calculadaOperacion;
    private double valorComisionOperacion;
    private CuentaBancaria cuentaBancaria;
    private Empresa empresa;
    private EmpresaTipoImpuesto empresaTipoImpuesto;
    private TipoImpuesto tipoImpuesto;
    private Set<DetalleOperacion> listDetalleOperacion= new HashSet<DetalleOperacion>(0);

    public Operacion() {
    }

    public Operacion(int numeroOperacion, String codigoPagoElectrionicoOperacion, Date fechaHoraOperacion, double importePagadoOperacion, int nroComprobanteFacturaOperacion, boolean calculadaOperacion, double valorComisionOperacion) {
        this.numeroOperacion = numeroOperacion;
        this.codigoPagoElectrionicoOperacion = codigoPagoElectrionicoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.importePagadoOperacion = importePagadoOperacion;
        this.nroComprobanteFacturaOperacion = nroComprobanteFacturaOperacion;
        this.calculadaOperacion = calculadaOperacion;
        this.valorComisionOperacion = valorComisionOperacion;
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

    public boolean isCalculadaOperacion() {
        return calculadaOperacion;
    }

    public void setCalculadaOperacion(boolean calculadaOperacion) {
        this.calculadaOperacion = calculadaOperacion;
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

    public Set<DetalleOperacion> getListDetalleOperacion() {
        return listDetalleOperacion;
    }

    public void setListDetalleOperacion(Set<DetalleOperacion> listDetalleOperacion) {
        this.listDetalleOperacion = listDetalleOperacion;
    }

    
}
