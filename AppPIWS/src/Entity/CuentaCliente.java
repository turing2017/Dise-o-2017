/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mviss
 */
@Entity
@Table(name="cuentaCliente"
    ,catalog="empresas"
)
public class CuentaCliente {
    
    @Id 
    @Column(name="cbu", unique=true, nullable=false)
    private String cbu;
    @Column(name="tipoCuenta", nullable=false)
    private String tipoCuenta;
    @Column(name="active", nullable=false)
    private boolean activo;
    @Column(name="monto", nullable=false)
    private double monto;

    public CuentaCliente() {
    }

    public CuentaCliente(String cbu, String tipoCuenta, boolean activo, double monto) {
        this.cbu = cbu;
        this.tipoCuenta = tipoCuenta;
        this.activo = activo;
        this.monto = monto;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
