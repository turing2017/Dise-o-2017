package sistemapagoimpuestos.Dto;

import java.util.Date;
import sistemapagoimpuestos.Entity.TipoUsuario;

/**
 *
 * @author Rodri
 */
public class DTOUsuario {

    private String nombreDTOUsuario;
    private String passwordDTOUsuario;
    private Date fechaHoraInhabilitacionDTOUsuario;
    private Date fechaHoraUltimoIngresoSistemaDTOUsuario;
    public DTOTipoUsuario tipoUsuarioDTOUsuario;

    public DTOUsuario(DTOTipoUsuario tipoUsuarioDTOUsuario) {
        this.tipoUsuarioDTOUsuario = tipoUsuarioDTOUsuario;
    }

    public DTOUsuario() {
    }

    public DTOUsuario(String nombreDTOUsuario, String passwordDTOUsuario) {
        this.nombreDTOUsuario = nombreDTOUsuario;
        this.passwordDTOUsuario = passwordDTOUsuario;
    }

    public DTOUsuario(String nombreUsuario, Date fechaHoraInhabilitacionUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombreDTOUsuario() {
        return nombreDTOUsuario;
    }

    public void setNombreDTOUsuario(String nombreDTOUsuario) {
        this.nombreDTOUsuario = nombreDTOUsuario;
    }

    public String getPasswordDTOUsuario() {
        return passwordDTOUsuario;
    }

    public void setPasswordDTOUsuario(String passwordDTOUsuario) {
        this.passwordDTOUsuario = passwordDTOUsuario;
    }

    public Date getFechaHoraInhabilitacionDTOUsuario() {
        return fechaHoraInhabilitacionDTOUsuario;
    }

    public void setFechaHoraInhabilitacionDTOUsuario(Date fechaHoraInhabilitacionDTOUsuario) {
        this.fechaHoraInhabilitacionDTOUsuario = fechaHoraInhabilitacionDTOUsuario;
    }

    public Date getFechaHoraUltimoIngresoSistemaDTOUsuario() {
        return fechaHoraUltimoIngresoSistemaDTOUsuario;
    }

    public void setFechaHoraUltimoIngresoSistemaDTOUsuario(Date fechaHoraUltimoIngresoSistemaDTOUsuario) {
        this.fechaHoraUltimoIngresoSistemaDTOUsuario = fechaHoraUltimoIngresoSistemaDTOUsuario;
    }

    public DTOTipoUsuario getTipoUsuarioDTOUsuario() {
        return tipoUsuarioDTOUsuario;
    }

    public void setTipoUsuarioDTOUsuario(DTOTipoUsuario tipoUsuarioDTOUsuario) {
        this.tipoUsuarioDTOUsuario = tipoUsuarioDTOUsuario;
    }
    

}
