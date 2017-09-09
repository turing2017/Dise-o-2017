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
public class Liquidacion extends Entity{
    private int numeroLiquidacion;
    private Date fechaHoraLiquidacion;
    private Date fechaHoraDesdeLiquidacion;
    private Date fechaHoraHastaLiquidacion;
    private List<Operacion> operacion;
    private EmpresaTipoImpuesto empresaTipoImpuesto;
    private List<LiquidacionEstado> liquidacionEstado;

    public Liquidacion() {
    }

    public Liquidacion(int numeroLiquidacion, Date fechaHoraLiquidacion, Date fechaHoraDesdeLiquidacion, Date fechaHoraHastaLiquidacion, List<Operacion> operacion, EmpresaTipoImpuesto empresaTipoImpuesto, List<LiquidacionEstado> liquidacionEstado) {
        this.numeroLiquidacion = numeroLiquidacion;
        this.fechaHoraLiquidacion = fechaHoraLiquidacion;
        this.fechaHoraDesdeLiquidacion = fechaHoraDesdeLiquidacion;
        this.fechaHoraHastaLiquidacion = fechaHoraHastaLiquidacion;
        this.operacion = operacion;
        this.empresaTipoImpuesto = empresaTipoImpuesto;
        this.liquidacionEstado = liquidacionEstado;
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

    public List<Operacion> getOperacion() {
        return operacion;
    }

    public void setOperacion(List<Operacion> operacion) {
        this.operacion = operacion;
    }

    public EmpresaTipoImpuesto getEmpresaTipoImpuesto() {
        return empresaTipoImpuesto;
    }

    public void setEmpresaTipoImpuesto(EmpresaTipoImpuesto empresaTipoImpuesto) {
        this.empresaTipoImpuesto = empresaTipoImpuesto;
    }

    public List<LiquidacionEstado> getLiquidacionEstado() {
        return liquidacionEstado;
    }

    public void setLiquidacionEstado(List<LiquidacionEstado> liquidacionEstado) {
        this.liquidacionEstado = liquidacionEstado;
    }
    
}
