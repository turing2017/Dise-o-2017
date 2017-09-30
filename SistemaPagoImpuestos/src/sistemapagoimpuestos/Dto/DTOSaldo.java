package sistemapagoimpuestos.Dto;

import sistemapagoimpuestos.Entity.TipoCuenta;

public class DTOSaldo {
    TipoCuenta tipoCuenta;
    String cbuCuentaBancaria;
    double saldoCuentaBancaria;

    public DTOSaldo() {
    }

    public DTOSaldo(TipoCuenta tipoCuenta, String cbuCuentaBancaria, double saldoCuentaBancaria) {
        this.tipoCuenta = tipoCuenta;
        this.cbuCuentaBancaria = cbuCuentaBancaria;
        this.saldoCuentaBancaria = saldoCuentaBancaria;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getCbuCuentaBancaria() {
        return cbuCuentaBancaria;
    }

    public void setCbuCuentaBancaria(String cbuCuentaBancaria) {
        this.cbuCuentaBancaria = cbuCuentaBancaria;
    }

    public double getSaldoCuentaBancaria() {
        return saldoCuentaBancaria;
    }

    public void setSaldoCuentaBancaria(double saldoCuentaBancaria) {
        this.saldoCuentaBancaria = saldoCuentaBancaria;
    }
    
}
