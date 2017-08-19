package sistemapagoimpuestos.Entity;

import java.util.Date;


public class CuentaBancaria extends Entity {
    
    // Atributos propios de la clase
    private String nroCuentaBancaria;
    private String cbuCuentaBancaria;
    private Date fechaInhabilitacionCuentaBancaria;
    
    // Atributos dados por relación
    private TipoCuenta tipoCuenta;
    private Cliente cliente;
    
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

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    
}
