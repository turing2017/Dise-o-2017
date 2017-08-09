package sistemapagoimpuestos.Entity;

import java.util.Date;

public class Cliente {
    
    // Atributos propios de la clase
    private String cuil_cuitCliente;
    private String apellidoCliente;
    private String nombreCliente;
    private String dniCliente;
    private Date fechaHoraInhabilitacionCliente;
    
    
    // Setters
    public void setCuil_cuitCliente(String cuil_cuitCliente) {
        this.cuil_cuitCliente = cuil_cuitCliente;
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
    public String getCuil_cuitCliente() {
        return cuil_cuitCliente;
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
    
}
