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
 * @author mviss
 */
public class DTOComprobanteUnico {

    private int numeroFactura;
    private String codigoComprobante;
    private Date fechaHoraVencimientoComprobante;
    private double montoTotalComprobante;
    private List<DTOItemComprobante> atributosAdicionalesDTOComprobante;

    public DTOComprobanteUnico() {
    }

    public DTOComprobanteUnico(int numeroFactura, String codigoComprobante, Date fechaHoraVencimientoComprobante, double montoTotalComprobante, List<DTOItemComprobante> atributosAdicionalesDTOComprobante) {
        this.numeroFactura = numeroFactura;
        this.codigoComprobante = codigoComprobante;
        this.fechaHoraVencimientoComprobante = fechaHoraVencimientoComprobante;
        this.montoTotalComprobante = montoTotalComprobante;
        this.atributosAdicionalesDTOComprobante = atributosAdicionalesDTOComprobante;
    }


    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(String codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public Date getFechaHoraVencimientoComprobante() {
        return fechaHoraVencimientoComprobante;
    }

    public void setFechaHoraVencimientoComprobante(Date fechaHoraVencimientoComprobante) {
        this.fechaHoraVencimientoComprobante = fechaHoraVencimientoComprobante;
    }

    public double getMontoTotalComprobante() {
        return montoTotalComprobante;
    }

    public void setMontoTotalComprobante(double montoTotalComprobante) {
        this.montoTotalComprobante = montoTotalComprobante;
    }

    public List<DTOItemComprobante> getAtributosAdicionalesDTOComprobante() {
        return atributosAdicionalesDTOComprobante;
    }

    public void setAtributosAdicionalesDTOComprobante(List<DTOItemComprobante> atributosAdicionalesDTOComprobante) {
        this.atributosAdicionalesDTOComprobante = atributosAdicionalesDTOComprobante;
    }



}
