/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import sistemapagoimpuestos.Entity.EstadoLiquidacion;

/**
 *
 * @author vande
 */
public class DTOLiquidacionEstado {
     private Date fechaHoraDesdeLiquidacionEstado;
    private Date fechaHoraHastaLiquidacionEstado;
    private String estadoLiquidacion;

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

    public String getEstadoLiquidacion() {
        return estadoLiquidacion;
    }

    public void setEstadoLiquidacion(String estadoLiquidacion) {
        this.estadoLiquidacion = estadoLiquidacion;
    }
    
    
}
