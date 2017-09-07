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
    private DTOTipoUsuario dTOTipoUsuario;
    public DTOCliente dTOCliente;
    public DTOEmpresa dTOEmpresa;

    public DTOUsuario() {
    }

    public DTOUsuario(String nombreDTOUsuario, String passwordDTOUsuario, Date fechaHoraInhabilitacionDTOUsuario, Date fechaHoraUltimoIngresoSistemaDTOUsuario, DTOTipoUsuario dTOTipoUsuario, DTOCliente dTOCliente, DTOEmpresa dTOEmpresa) {
        this.nombreDTOUsuario = nombreDTOUsuario;
        this.passwordDTOUsuario = passwordDTOUsuario;
        this.fechaHoraInhabilitacionDTOUsuario = fechaHoraInhabilitacionDTOUsuario;
        this.fechaHoraUltimoIngresoSistemaDTOUsuario = fechaHoraUltimoIngresoSistemaDTOUsuario;
        this.dTOTipoUsuario = dTOTipoUsuario;
        this.dTOCliente = dTOCliente;
        this.dTOEmpresa = dTOEmpresa;
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

    public DTOTipoUsuario getdTOTipoUsuario() {
        return dTOTipoUsuario;
    }

    public void setdTOTipoUsuario(DTOTipoUsuario dTOTipoUsuario) {
        this.dTOTipoUsuario = dTOTipoUsuario;
    }

    public DTOCliente getdTOCliente() {
        return dTOCliente;
    }

    public void setdTOCliente(DTOCliente dTOCliente) {
        this.dTOCliente = dTOCliente;
    }


    public DTOEmpresa getdTOEmpresa() {
        return dTOEmpresa;
    }

    public void setdTOEmpresa(DTOEmpresa dTOEmpresa) {
        this.dTOEmpresa = dTOEmpresa;
    }

    
}
