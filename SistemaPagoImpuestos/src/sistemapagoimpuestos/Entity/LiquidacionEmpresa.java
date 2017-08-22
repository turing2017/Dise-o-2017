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
public class LiquidacionEmpresa extends Entity{
    private int numeroLiquidacionEmpresa;
    private Date fechaHoraLiquidacionEmpresa;
    private String periodoLiquidacionEmpresa;
    private Empresa empresa;
    private Set<Operacion> listOperacion = new HashSet<Operacion>(0);

    public LiquidacionEmpresa() {
    }

    public LiquidacionEmpresa(int numeroLiquidacionEmpresa, Date fechaHoraLiquidacionEmpresa, String periodoLiquidacionEmpresa, Empresa empresa) {
        this.numeroLiquidacionEmpresa = numeroLiquidacionEmpresa;
        this.fechaHoraLiquidacionEmpresa = fechaHoraLiquidacionEmpresa;
        this.periodoLiquidacionEmpresa = periodoLiquidacionEmpresa;
        this.empresa = empresa;
    }


    public int getNumeroLiquidacionEmpresa() {
        return numeroLiquidacionEmpresa;
    }

    public void setNumeroLiquidacionEmpresa(int numeroLiquidacionEmpresa) {
        this.numeroLiquidacionEmpresa = numeroLiquidacionEmpresa;
    }

    public Date getFechaHoraLiquidacionEmpresa() {
        return fechaHoraLiquidacionEmpresa;
    }

    public void setFechaHoraLiquidacionEmpresa(Date fechaHoraLiquidacionEmpresa) {
        this.fechaHoraLiquidacionEmpresa = fechaHoraLiquidacionEmpresa;
    }

    public String getPeriodoLiquidacionEmpresa() {
        return periodoLiquidacionEmpresa;
    }

    public void setPeriodoLiquidacionEmpresa(String periodoLiquidacionEmpresa) {
        this.periodoLiquidacionEmpresa = periodoLiquidacionEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<Operacion> getListOperacion() {
        return listOperacion;
    }

    public void setListOperacion(Set<Operacion> listOperacion) {
        this.listOperacion = listOperacion;
    }

}
