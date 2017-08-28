package sistemapagoimpuestos.Entity;

import java.util.Date;

public class Cliente extends Entity{
    
    // Atributos propios de la clase
    private String cuilCuitCliente;
    private String apellidoCliente;
    private String nombreCliente;
    private String dniCliente;
    private Date fechaHoraInhabilitacionCliente;
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(String cuilCuitCliente, String apellidoCliente, String nombreCliente, String dniCliente, Date fechaHoraInhabilitacionCliente) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
