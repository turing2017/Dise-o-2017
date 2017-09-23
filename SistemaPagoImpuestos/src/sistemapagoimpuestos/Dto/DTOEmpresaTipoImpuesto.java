package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class DTOEmpresaTipoImpuesto {
    private Date fechaHoraAltaEmpresaTipoImpuesto;
    private Date fechaHoraInhabilitacionEmpresaTipoImpuesto;
    private int frecuenciaLiquidacionEmpresaTipoImpuesto;
    private DTOTipoImpuesto dTOtipoImpuesto;
    private DTOEmpresa dTOempresa;
    private DTOTipoEmpresa dTOtipoEmpresa;
    private Date fechaProximaLiquidacionEmpresaTipoImpuesto;

    public void setFechaHoraAltaEmpresaTipoImpuesto(Date fechaHoraAltaEmpresaTipoImpuesto) {
        this.fechaHoraAltaEmpresaTipoImpuesto = fechaHoraAltaEmpresaTipoImpuesto;
    }

    public void setFechaHoraInhabilitacionEmpresaTipoImpuesto(Date fechaHoraInhabilitacionEmpresaTipoImpuesto) {
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public void setFrecuenciaLiquidacionEmpresaTipoImpuesto(int frecuenciaLiquidacionEmpresaTipoImpuesto) {
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public void setdTOtipoImpuesto(DTOTipoImpuesto dTOtipoImpuesto) {
        this.dTOtipoImpuesto = dTOtipoImpuesto;
    }

    public void setdTOempresa(DTOEmpresa dTOempresa) {
        this.dTOempresa = dTOempresa;
    }

    public void setdTOtipoEmpresa(DTOTipoEmpresa dTOtipoEmpresa) {
        this.dTOtipoEmpresa = dTOtipoEmpresa;
    }

    public void setFechaProximaLiquidacionEmpresaTipoImpuesto(Date fechaProximaLiquidacionEmpresaTipoImpuesto) {
        this.fechaProximaLiquidacionEmpresaTipoImpuesto = fechaProximaLiquidacionEmpresaTipoImpuesto;
    }

    public Date getFechaHoraAltaEmpresaTipoImpuesto() {
        return fechaHoraAltaEmpresaTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionEmpresaTipoImpuesto() {
        return fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public int getFrecuenciaLiquidacionEmpresaTipoImpuesto() {
        return frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public DTOTipoImpuesto getdTOtipoImpuesto() {
        return dTOtipoImpuesto;
    }

    public DTOEmpresa getdTOempresa() {
        return dTOempresa;
    }

    public DTOTipoEmpresa getdTOtipoEmpresa() {
        return dTOtipoEmpresa;
    }

    public Date getFechaProximaLiquidacionEmpresaTipoImpuesto() {
        return fechaProximaLiquidacionEmpresaTipoImpuesto;
    }
    
    
}
