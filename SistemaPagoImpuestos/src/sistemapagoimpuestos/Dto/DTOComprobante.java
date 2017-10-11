package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lunamarcos
 */
public class DTOComprobante {
    
    private int numeroFactura;
    private String codigoDTOComprobante;
    private Date fechaHoraVencimientoDTOComprobante;
    private double montoTotalDTOComprobante;
    private List<DTOItem> atributosAdicionalesDTOComprobante;

    public DTOComprobante() {
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
