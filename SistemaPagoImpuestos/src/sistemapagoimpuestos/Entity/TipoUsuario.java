package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class TipoUsuario extends Entity {
    
    // Atributos propios de la clase
    private int codigoTipoUsuario;
    private String nombreTipoUsuario;
    private Date fechaHoraInhabilitacionTipoUsuario;
    private Usuario usuario;

    public TipoUsuario() {
    }

    public TipoUsuario(int codigoTipoUsuario, String nombreTipoUsuario, Date fechaHoraInhabilitacionTipoUsuario, Usuario usuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.fechaHoraInhabilitacionTipoUsuario = fechaHoraInhabilitacionTipoUsuario;
        this.usuario = usuario;
    }


    // Setters
    public void setCodigoTipoUsuario(int codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public void setFechaHoraInhabilitacionTipoUsuario(Date fechaHoraInhabilitacionTipoUsuario) {
        this.fechaHoraInhabilitacionTipoUsuario = fechaHoraInhabilitacionTipoUsuario;
    }
    
    // Getters
    public int getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public Date getFechaHoraInhabilitacionTipoUsuario() {
        return fechaHoraInhabilitacionTipoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
