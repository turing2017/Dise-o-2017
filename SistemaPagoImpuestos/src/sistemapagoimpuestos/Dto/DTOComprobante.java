package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lunamarcos
 */
public class DTOComprobante {
    
    String codigoDTOComprobante;
    Date fechaHoraVencimientoDTOComprobante;
    double montoTotalDTOComprobante;
    List<DTOItem> atributosAdicionalesDTOComprobante;

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
