package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class DTOCliente {
    // Atributos propios de la clase
    private String cuilCuitCliente;
    private String apellidoCliente;
    private String nombreCliente;
    private String dniCliente;
    private Date fechaHoraInhabilitacionCliente;
    // Atributos por relación
    private DTOUsuario usuario;

    public DTOCliente() {
    }

    public DTOCliente(String cuilCuitCliente, String apellidoCliente, String nombreCliente, String dniCliente, Date fechaHoraInhabilitacionCliente) {
        this.cuilCuitCliente = cuilCuitCliente;
        this.apellidoCliente = apellidoCliente;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaHoraInhabilitacionCliente = fechaHoraInhabilitacionCliente;
    }
    
    // Setters
    public void setCuilCuitCliente(String cuilCuitCliente) {
        this.cuilCuitCliente = cuilCuitCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setFechaHoraInhabilitacionCliente(Date fechaHoraInhabilitacionCliente) {
        this.fechaHoraInhabilitacionCliente = fechaHoraInhabilitacionCliente;
    }
    
    
    // Getters
    public String getCuilCuitCliente() {
        return cuilCuitCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public Date getFechaHoraInhabilitacionCliente() {
        return fechaHoraInhabilitacionCliente;
    }

    public DTOUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DTOUsuario usuario) {
        this.usuario = usuario;
    }
}
