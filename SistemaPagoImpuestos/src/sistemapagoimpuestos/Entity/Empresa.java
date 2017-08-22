package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class Empresa extends Entity {
    
    // Atributos propios de la clase
    private String cuitEmpresa;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private Date fechaHoraInhabilitacionEmpresa;
    private TipoEmpresa tipoEmpresa;
    public Empresa() {
    }

    public Empresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa, Date fechaHoraInhabilitacionEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
    }
    
    
    
    // Setters
    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public void setFechaHoraInhabilitacionEmpresa(Date fechaHoraInhabilitacionEmpresa) {
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
    }
    
    // Getters
    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public Date getFechaHoraInhabilitacionEmpresa() {
        return fechaHoraInhabilitacionEmpresa;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
    
}
