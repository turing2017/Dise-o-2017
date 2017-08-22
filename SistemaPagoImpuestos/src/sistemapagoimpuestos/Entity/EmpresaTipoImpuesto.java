package sistemapagoimpuestos.Entity;

import java.util.Date;

public class EmpresaTipoImpuesto {
    
    private Date fechaHoraInhabilitacionEmpresaTipoImpuesto;
    private Date fechaProximaLiquidacionEmpresaTipoImpuesto;
    private int frecuenciaLiquidacionEmpresaTipoImpuesto;
    private String urlConexionEmpresaTipoImpuesto;

    public EmpresaTipoImpuesto() {
    }

    public EmpresaTipoImpuesto(Date fechaHoraInhabilitacionEmpresaTipoImpuesto, Date fechaProximaLiquidacionEmpresaTipoImpuesto, int frecuenciaLiquidacionEmpresaTipoImpuesto, String urlConexionEmpresaTipoImpuesto, Empresa empresa, TipoEmpresa tipoEmpresa, TipoImpuesto tipoImpuesto) {
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
        this.fechaProximaLiquidacionEmpresaTipoImpuesto = fechaProximaLiquidacionEmpresaTipoImpuesto;
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
        this.urlConexionEmpresaTipoImpuesto = urlConexionEmpresaTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionEmpresaTipoImpuesto() {
        return fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public void setFechaHoraInhabilitacionEmpresaTipoImpuesto(Date fechaHoraInhabilitacionEmpresaTipoImpuesto) {
        this.fechaHoraInhabilitacionEmpresaTipoImpuesto = fechaHoraInhabilitacionEmpresaTipoImpuesto;
    }

    public Date getFechaProximaLiquidacionEmpresaTipoImpuesto() {
        return fechaProximaLiquidacionEmpresaTipoImpuesto;
    }

    public void setFechaProximaLiquidacionEmpresaTipoImpuesto(Date fechaProximaLiquidacionEmpresaTipoImpuesto) {
        this.fechaProximaLiquidacionEmpresaTipoImpuesto = fechaProximaLiquidacionEmpresaTipoImpuesto;
    }

    public int getFrecuenciaLiquidacionEmpresaTipoImpuesto() {
        return frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public void setFrecuenciaLiquidacionEmpresaTipoImpuesto(int frecuenciaLiquidacionEmpresaTipoImpuesto) {
        this.frecuenciaLiquidacionEmpresaTipoImpuesto = frecuenciaLiquidacionEmpresaTipoImpuesto;
    }

    public String getUrlConexionEmpresaTipoImpuesto() {
        return urlConexionEmpresaTipoImpuesto;
    }

    public void setUrlConexionEmpresaTipoImpuesto(String urlConexionEmpresaTipoImpuesto) {
        this.urlConexionEmpresaTipoImpuesto = urlConexionEmpresaTipoImpuesto;
    }
    
    
    
}
