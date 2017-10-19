package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class TipoUsuario extends Entity {
    
    // Atributos propios de la clase
    private String nombreTipoUsuario;
    private Date fechaHoraInhabilitacionTipoUsuario;

    public TipoUsuario() {
    }

    public TipoUsuario(String nombreTipoUsuario, Date fechaHoraInhabilitacionTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.fechaHoraInhabilitacionTipoUsuario = fechaHoraInhabilitacionTipoUsuario;
    }
    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public void setFechaHoraInhabilitacionTipoUsuario(Date fechaHoraInhabilitacionTipoUsuario) {
        this.fechaHoraInhabilitacionTipoUsuario = fechaHoraInhabilitacionTipoUsuario;
    }
    
    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public Date getFechaHoraInhabilitacionTipoUsuario() {
        return fechaHoraInhabilitacionTipoUsuario;
    }    
}
