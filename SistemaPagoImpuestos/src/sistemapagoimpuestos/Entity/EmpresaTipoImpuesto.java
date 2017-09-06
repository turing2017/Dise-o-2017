package sistemapagoimpuestos.Entity;

import java.util.Date;

public class EmpresaTipoImpuesto extends Entity{
    private Date fechaHoraAltaEmpresaTipoImpuesto;
    private Date fechaHoraInhabilitacionEmpresaTipoImpuesto;
    private int frecuenciaLiquidacionEmpresaTipoImpuesto;
    private TipoImpuesto tipoImpuesto;
    private Empresa empresa;
    private TipoEmpresa tipoEmpresa;
    private Date fechaProximaLiquidacionEmpresaTipoImpuesto;

    public EmpresaTipoImpuesto() {
    }

    public Date getFechaProximaLiquidacionEmpresaTipoImpuesto() {
        return fechaProximaLiquidacionEmpresaTipoImpuesto;
    }

    public void setFechaProximaLiquidacionEmpresaTipoImpuesto(Date fechaProximaLiquidacionEmpresaTipoImpuesto) {
        this.fechaProximaLiquidacionEmpresaTipoImpuesto = fechaProximaLiquidacionEmpresaTipoImpuesto;
    }
    
    public EmpresaTipoImpuesto(Date fechaHoraAltaEmpresaTipoImpuesto, Date fechaHoraInhabilitacionEmpresaTipoImpuesto, int frecuenciaLiquidacionEmpresaTipoImpuesto, TipoImpuesto tipoImpuesto, Empresa empresa, TipoEmpresa tipoEmpresa) {
        this.fechaHoraAltaEmpresaTipoImpuesto = fechaHoraAltaEmpresaTipoImpuesto;
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
        this.tipoImpuesto = tipoImpuesto;
        this.empresa = empresa;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Date getFechaHoraAltaEmpresaTipoImpuesto() {
        return fechaHoraAltaEmpresaTipoImpuesto;
    }

    public void setFechaHoraAltaEmpresaTipoImpuesto(Date fechaHoraAltaEmpresaTipoImpuesto) {
        this.fechaHoraAltaEmpresaTipoImpuesto = fechaHoraAltaEmpresaTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionEmpresaTipoImpuesto() {
        return fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public void setFechaHoraInhabilitacionEmpresaTipoImpuesto(Date fechaHoraInhabilitacionEmpresaTipoImpuesto) {
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public int getFrecuenciaLiquidacionEmpresaTipoImpuesto() {
        return frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public void setFrecuenciaLiquidacionEmpresaTipoImpuesto(int frecuenciaLiquidacionEmpresaTipoImpuesto) {
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
    }
    
    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    
}
