/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author facun
 */
public class DTOLiquidacion {
    
    private int numeroLiquidacion;
    private Date fechaHoraLiquidacion;
    private Date fechaHoraDesdeLiquidacion;
    private Date fechaHoraHastaLiquidacion;
    private String nombreEmpresa;
    private String nombreTipoImpuesto;
    private String nombreEstadoLiquidacion;
    private List<DTOOperacionComision> listOperacionComision;
    private double valorTotalCalculoComision;
    
    public DTOLiquidacion() {
    }

   

    public List<DTOOperacionComision> getListOperacionComision() {
        return listOperacionComision;
    }

    public void setListOperacionComision(List<DTOOperacionComision> listOperacionComision) {
        this.listOperacionComision = listOperacionComision;
    }

    public double getValorTotalCalculoComision() {
        return valorTotalCalculoComision;
    }

    public void setValorTotalCalculoComision(double valorTotalCalculoComision) {
        this.valorTotalCalculoComision = valorTotalCalculoComision;
    }

   

   

    public int getNumeroLiquidacion() {
        return numeroLiquidacion;
    }

    public void setNumeroLiquidacion(int numeroLiquidacion) {
        this.numeroLiquidacion = numeroLiquidacion;
    }

    public Date getFechaHoraLiquidacion() {
        return fechaHoraLiquidacion;
    }

    public void setFechaHoraLiquidacion(Date fechaHoraLiquidacion) {
        this.fechaHoraLiquidacion = fechaHoraLiquidacion;
    }

    public Date getFechaHoraDesdeLiquidacion() {
        return fechaHoraDesdeLiquidacion;
    }

    public void setFechaHoraDesdeLiquidacion(Date fechaHoraDesdeLiquidacion) {
        this.fechaHoraDesdeLiquidacion = fechaHoraDesdeLiquidacion;
    }

    public Date getFechaHoraHastaLiquidacion() {
        return fechaHoraHastaLiquidacion;
    }

    public void setFechaHoraHastaLiquidacion(Date fechaHoraHastaLiquidacion) {
        this.fechaHoraHastaLiquidacion = fechaHoraHastaLiquidacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreTipoImpuesto() {
        return nombreTipoImpuesto;
    }

    public void setNombreTipoImpuesto(String nombreTipoImpuesto) {
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }

    public String getNombreEstadoLiquidacion() {
        return nombreEstadoLiquidacion;
    }

    public void setNombreEstadoLiquidacion(String nombreEstadoLiquidacion) {
        this.nombreEstadoLiquidacion = nombreEstadoLiquidacion;
    }
    
    
}
