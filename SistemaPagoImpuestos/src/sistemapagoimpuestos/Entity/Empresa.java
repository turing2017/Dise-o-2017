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
    public Empresa() {
    }

    public Empresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa, Date fechaHoraInhabilitacionEmpresa, TipoEmpresa tipoEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
        this.tipoEmpresa = tipoEmpresa;
    }

<<<<<<< HEAD

    
    
=======
>>>>>>> origin/cambios_develop
    
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
    
}
