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
    private String codigoDTOComprobante;
    private Date fechaHoraVencimientoDTOComprobante;
    private double montoTotalDTOComprobante;
    private List<DTOItem> atributosAdicionalesDTOComprobante;

    public DTOComprobanteUnico() {
    }

    public DTOComprobanteUnico(int numeroFactura, String codigoDTOComprobante, Date fechaHoraVencimientoDTOComprobante, double montoTotalDTOComprobante, List<DTOItem> atributosAdicionalesDTOComprobante) {
        this.numeroFactura = numeroFactura;
        this.codigoDTOComprobante = codigoDTOComprobante;
        this.fechaHoraVencimientoDTOComprobante = fechaHoraVencimientoDTOComprobante;
        this.montoTotalDTOComprobante = montoTotalDTOComprobante;
        this.atributosAdicionalesDTOComprobante = atributosAdicionalesDTOComprobante;
    }
    
    

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setCodigoDTOComprobante(String codigoDTOComprobante) {
        this.codigoDTOComprobante = codigoDTOComprobante;
    }

    public void setFechaHoraVencimientoDTOComprobante(Date fechaHoraVencimientoDTOComprobante) {
        this.fechaHoraVencimientoDTOComprobante = fechaHoraVencimientoDTOComprobante;
    }

    public void setMontoTotalDTOComprobante(double montoTotalDTOComprobante) {
        this.montoTotalDTOComprobante = montoTotalDTOComprobante;
    }

    public void setAtributosAdicionalesDTOComprobante(List<DTOItem> atributosAdicionalesDTOComprobante) {
        this.atributosAdicionalesDTOComprobante = atributosAdicionalesDTOComprobante;
    }

    public String getCodigoDTOComprobante() {
        return codigoDTOComprobante;
    }

    public Date getFechaHoraVencimientoDTOComprobante() {
        return fechaHoraVencimientoDTOComprobante;
    }

    public double getMontoTotalDTOComprobante() {
        return montoTotalDTOComprobante;
    }

    public List<DTOItem> getAtributosAdicionalesDTOComprobante() {
        return atributosAdicionalesDTOComprobante;
    }
}
