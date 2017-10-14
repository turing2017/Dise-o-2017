package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class DTOCuentaBancaria {
    
    private String nroCuentaBancaria;
    private String cbuCuentaBancaria;
    private String nombreTipoCuenta;
    private double saldoRecuperado;

    public DTOCuentaBancaria() {
    }

    public DTOCuentaBancaria(String nroCuentaBancaria, String cbuCuentaBancaria, String nombreTipoCuenta, double saldoRecuperado) {
        this.nroCuentaBancaria = nroCuentaBancaria;
        this.cbuCuentaBancaria = cbuCuentaBancaria;
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.saldoRecuperado = saldoRecuperado;
    }

    public String getNroCuentaBancaria() {
        return nroCuentaBancaria;
    }

    public void setNroCuentaBancaria(String nroCuentaBancaria) {
        this.nroCuentaBancaria = nroCuentaBancaria;
    }

    public String getCbuCuentaBancaria() {
        return cbuCuentaBancaria;
    }

    public void setCbuCuentaBancaria(String cbuCuentaBancaria) {
        this.cbuCuentaBancaria = cbuCuentaBancaria;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public double getSaldoRecuperado() {
        return saldoRecuperado;
    }

    public void setSaldoRecuperado(double saldoRecuperado) {
        this.saldoRecuperado = saldoRecuperado;
    }
   
    
}
