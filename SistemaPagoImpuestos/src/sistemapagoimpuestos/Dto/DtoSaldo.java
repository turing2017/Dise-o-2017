/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author mviss
 */
public class DtoSaldo {
    private String cbu;
    private String nombreTipoCuenta;
    private double saldo;

    public DtoSaldo() {
    }

    public DtoSaldo(String cbu, String nombreTipoCuenta, double saldo) {
        this.cbu = cbu;
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.saldo = saldo;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
  
  
}
