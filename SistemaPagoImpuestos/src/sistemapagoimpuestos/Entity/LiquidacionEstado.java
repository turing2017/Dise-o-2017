/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author Maximiliano
 */
public class LiquidacionEstado extends Entity {
    
    private Date fechaHoraDesdeLiquidacionEstado;
    private Date fechaHoraHastaLiquidacionEstado;
    private EstadoLiquidacion estadoLiquidacion;

    public LiquidacionEstado() {
    }

    public LiquidacionEstado(Date fechaHoraDesdeLiquidacionEstado, Date fechaHoraHastaLiquidacionEstado, EstadoLiquidacion estadoLiquidacion) {
        this.fechaHoraDesdeLiquidacionEstado = fechaHoraDesdeLiquidacionEstado;
        this.fechaHoraHastaLiquidacionEstado = fechaHoraHastaLiquidacionEstado;
        this.estadoLiquidacion = estadoLiquidacion;
    }

    public Date getFechaHoraDesdeLiquidacionEstado() {
        return fechaHoraDesdeLiquidacionEstado;
    }

    public void setFechaHoraDesdeLiquidacionEstado(Date fechaHoraDesdeLiquidacionEstado) {
        this.fechaHoraDesdeLiquidacionEstado = fechaHoraDesdeLiquidacionEstado;
    }

    public Date getFechaHoraHastaLiquidacionEstado() {
        return fechaHoraHastaLiquidacionEstado;
    }

    public void setFechaHoraHastaLiquidacionEstado(Date fechaHoraHastaLiquidacionEstado) {
        this.fechaHoraHastaLiquidacionEstado = fechaHoraHastaLiquidacionEstado;
    }

    public EstadoLiquidacion getEstadoLiquidacion() {
        return estadoLiquidacion;
    }

    public void setEstadoLiquidacion(EstadoLiquidacion estadoLiquidacion) {
        this.estadoLiquidacion = estadoLiquidacion;
    }
    
}
