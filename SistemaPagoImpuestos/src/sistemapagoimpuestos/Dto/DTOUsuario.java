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
//    private DTOTipoUsuario tipoUsuarioDTOTipoUsuario;
//    private DTOEmpresa empresaDTOTipoUsuario;
    private String tipoUsuarioDTOUsuario;
    private String empresaDTOUsuario;

    public String getTipoUsuarioDTOUsuario() {
        return tipoUsuarioDTOUsuario;
    }

    public void setTipoUsuarioDTOUsuario(String tipoUsuarioDTOUsuario) {
        this.tipoUsuarioDTOUsuario = tipoUsuarioDTOUsuario;
    }

    public String getEmpresaDTOUsuario() {
        return empresaDTOUsuario;
    }

    public void setEmpresaDTOUsuario(String empresaDTOUsuario) {
        this.empresaDTOUsuario = empresaDTOUsuario;
    }

//    public DTOUsuario(String nombreDTOUsuario, String passwordDTOUsuario, Date fechaHoraInhabilitacionDTOUsuario, Date fechaHoraUltimoIngresoSistemaDTOUsuario, DTOTipoUsuario tipoUsuarioDTOTipoUsuario, DTOEmpresa empresaDTOTipoUsuario) {
//        this.nombreDTOUsuario = nombreDTOUsuario;
//        this.passwordDTOUsuario = passwordDTOUsuario;
//        this.fechaHoraInhabilitacionDTOUsuario = fechaHoraInhabilitacionDTOUsuario;
//        this.fechaHoraUltimoIngresoSistemaDTOUsuario = fechaHoraUltimoIngresoSistemaDTOUsuario;
//        this.tipoUsuarioDTOTipoUsuario = tipoUsuarioDTOTipoUsuario;
//        this.empresaDTOTipoUsuario = empresaDTOTipoUsuario;
//    }

    public DTOUsuario(String nombreDTOUsuario, String passwordDTOUsuario, Date fechaHoraInhabilitacionDTOUsuario, Date fechaHoraUltimoIngresoSistemaDTOUsuario) {
        this.nombreDTOUsuario = nombreDTOUsuario;
        this.passwordDTOUsuario = passwordDTOUsuario;
        this.fechaHoraInhabilitacionDTOUsuario = fechaHoraInhabilitacionDTOUsuario;
        this.fechaHoraUltimoIngresoSistemaDTOUsuario = fechaHoraUltimoIngresoSistemaDTOUsuario;
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

//    public DTOTipoUsuario getTipoUsuarioDTOTipoUsuario() {
//        return tipoUsuarioDTOTipoUsuario;
//    }
//
//    public void setTipoUsuarioDTOTipoUsuario(DTOTipoUsuario tipoUsuarioDTOTipoUsuario) {
//        this.tipoUsuarioDTOTipoUsuario = tipoUsuarioDTOTipoUsuario;
//    }
//
//    public DTOEmpresa getEmpresaDTOTipoUsuario() {
//        return empresaDTOTipoUsuario;
//    }
//
//    public void setEmpresaDTOTipoUsuario(DTOEmpresa empresaDTOTipoUsuario) {
//        this.empresaDTOTipoUsuario = empresaDTOTipoUsuario;
//    }
    

}
