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
    private List<DTOItem> atributosAdicionalesComprobante;

    public DTOComprobante() {
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
