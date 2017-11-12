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
 * @author vande
 */
public class DTOLiquidacionComision {
    int numeroLiquidacion;
    Date fechaHoraLiquidacion;
    List<DTOEstadoCalculoComision> estadoComisionList;

    public DTOLiquidacionComision(int numeroLiquidacion, Date fechaHoraLiquidacion, List<DTOEstadoCalculoComision> estadoComisionList) {
        this.numeroLiquidacion = numeroLiquidacion;
        this.fechaHoraLiquidacion = fechaHoraLiquidacion;
        this.estadoComisionList = estadoComisionList;
    }

    public DTOLiquidacionComision() {
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

    public List<DTOEstadoCalculoComision> getEstadoComisionList() {
        return estadoComisionList;
    }

    public void setEstadoComisionList(List<DTOEstadoCalculoComision> estadoComisionList) {
        this.estadoComisionList = estadoComisionList;
    }
    
}
