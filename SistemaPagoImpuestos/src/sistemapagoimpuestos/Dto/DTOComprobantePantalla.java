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
public class DTOComprobantePantalla {

    private int numeroFactura;
    private String codigoComprobante;
    private Date fechaHoraVencimientoComprobante;
    private double montoTotalComprobante;
    private List<DTOItem> atributosAdicionalesComprobante;

    public DTOComprobantePantalla() {
    }

    public DTOComprobantePantalla(int numeroFactura, String codigoDTOComprobante, Date fechaHoraVencimientoDTOComprobante, double montoTotalDTOComprobante, List<DTOItem> atributosAdicionalesDTOComprobante) {
        this.numeroFactura = numeroFactura;
        this.codigoComprobante = codigoDTOComprobante;
        this.fechaHoraVencimientoComprobante = fechaHoraVencimientoDTOComprobante;
        this.montoTotalComprobante = montoTotalDTOComprobante;
        this.atributosAdicionalesComprobante = atributosAdicionalesDTOComprobante;
    }
    
    

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setCodigoDTOComprobante(String codigoDTOComprobante) {
        this.codigoComprobante = codigoDTOComprobante;
    }

    public void setFechaHoraVencimientoDTOComprobante(Date fechaHoraVencimientoDTOComprobante) {
        this.fechaHoraVencimientoComprobante = fechaHoraVencimientoDTOComprobante;
    }

    public void setMontoTotalDTOComprobante(double montoTotalDTOComprobante) {
        this.montoTotalComprobante = montoTotalDTOComprobante;
    }

    public void setAtributosAdicionalesDTOComprobante(List<DTOItem> atributosAdicionalesDTOComprobante) {
        this.atributosAdicionalesComprobante = atributosAdicionalesDTOComprobante;
    }

    public String getCodigoDTOComprobante() {
        return codigoComprobante;
    }

    public Date getFechaHoraVencimientoDTOComprobante() {
        return fechaHoraVencimientoComprobante;
    }

    public double getMontoTotalDTOComprobante() {
        return montoTotalComprobante;
    }

    public List<DTOItem> getAtributosAdicionalesDTOComprobante() {
        return atributosAdicionalesComprobante;
    }
}
