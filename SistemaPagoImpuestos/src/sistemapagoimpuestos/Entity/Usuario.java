package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class Usuario extends Entity{
    
    // Atriburos propios de la clase
    private String nombreUsuario;
    private String passwordUsuario;
    private Date fechaHoraInhabilitacionUsuario;
    private Date fechaHoraUltimoIngresoSistemaUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = password;
    }
    
    
    // Atributos por relación
    private TipoUsuario tipoUsuario;
    private Cliente cliente;
    private Empresa empresa;
    
    // Setters
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String password) {
        this.passwordUsuario = password;
    }

    public void setFechaHoraInhabilitacionUsuario(Date fechaHoraInhabilitacionUsuario) {
        this.fechaHoraInhabilitacionUsuario = fechaHoraInhabilitacionUsuario;
    }

    public void setFechaHoraUltimoIngresoSistemaUsuario(Date fechaHoraUltimoIngresoSistemaUsuario) {
        this.fechaHoraUltimoIngresoSistemaUsuario = fechaHoraUltimoIngresoSistemaUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    // Getters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return passwordUsuario;
    }

    public Date getFechaHoraInhabilitacionUsuario() {
        return fechaHoraInhabilitacionUsuario;
    }

    public Date getFechaHoraUltimoIngresoSistemaUsuario() {
        return fechaHoraUltimoIngresoSistemaUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    
    
}
