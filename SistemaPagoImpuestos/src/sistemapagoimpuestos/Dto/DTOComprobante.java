package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lunamarcos
 */
public class DTOComprobante {
    
    private int numeroFactura;
    private String codigoComprobante;
    private Date fechaHoraVencimientoComprobante;
    private double montoTotalComprobante;
    private List<DTOItemComprobante> atributosAdicionalesComprobante;

    public DTOComprobante() {
    }

    public DTOComprobante(int numeroFactura, String codigoComprobante, Date fechaHoraVencimientoComprobante, double montoTotalComprobante, List<DTOItemComprobante> atributosAdicionalesComprobante) {
        this.numeroFactura = numeroFactura;
        this.codigoComprobante = codigoComprobante;
        this.fechaHoraVencimientoComprobante = fechaHoraVencimientoComprobante;
        this.montoTotalComprobante = montoTotalComprobante;
        this.atributosAdicionalesComprobante = atributosAdicionalesComprobante;
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

    public List<DTOItemComprobante> getAtributosAdicionalesComprobante() {
        return atributosAdicionalesComprobante;
    }

    public void setAtributosAdicionalesComprobante(List<DTOItemComprobante> atributosAdicionalesComprobante) {
        this.atributosAdicionalesComprobante = atributosAdicionalesComprobante;
    }


    
}
