package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class DTOCuentaBancaria {
    // Atributos propios de la clase
    private String nroCuentaBancaria;
    private String cbuCuentaBancaria;
    private Date fechaInhabilitacionCuentaBancaria;
    // Saldo recuperado del servicio del banco
    private double saldoRecuperado;
    
    // Atributos dados por relación
    private DTOTipoCuenta tipoCuenta;
    private DTOCliente cliente;

    public DTOCuentaBancaria() {
    }

    public DTOCuentaBancaria(String nroCuentaBancaria, String cbuCuentaBancaria, Date fechaInhabilitacionCuentaBancaria, DTOTipoCuenta tipoCuenta, DTOCliente cliente) {
        this.nroCuentaBancaria = nroCuentaBancaria;
        this.cbuCuentaBancaria = cbuCuentaBancaria;
        this.fechaInhabilitacionCuentaBancaria = fechaInhabilitacionCuentaBancaria;
        this.tipoCuenta = tipoCuenta;
        this.cliente = cliente;
    }
    
    
    
    
    // Setters
    public void setNroCuentaBancaria(String nroCuentaBancaria) {
        this.nroCuentaBancaria = nroCuentaBancaria;
    }

    public void setCbuCuentaBancaria(String cbuCuentaBancaria) {
        this.cbuCuentaBancaria = cbuCuentaBancaria;
    }

    public void setFechaInhabilitacionCuentaBancaria(Date fechaInhabilitacionCuentaBancaria) {
        this.fechaInhabilitacionCuentaBancaria = fechaInhabilitacionCuentaBancaria;
    }

    public void setTipoCuenta(DTOTipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setCliente(DTOCliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldoRecuperado(double saldoRecuperado) {
        this.saldoRecuperado = saldoRecuperado;
    }
    
    

    // Getters
    public String getNroCuentaBancaria() {
        return nroCuentaBancaria;
    }

    public String getCbuCuentaBancaria() {
        return cbuCuentaBancaria;
    }

    public Date getFechaInhabilitacionCuentaBancaria() {
        return fechaInhabilitacionCuentaBancaria;
    } 

    public DTOTipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public DTOCliente getCliente() {
        return cliente;
    }

    public double getSaldoRecuperado() {
        return saldoRecuperado;
    }
    
}
