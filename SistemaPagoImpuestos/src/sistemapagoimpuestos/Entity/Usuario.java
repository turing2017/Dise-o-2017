package sistemapagoimpuestos.Entity;

import java.util.Date;


public class Usuario extends Entity{
    
    // Atriburos propios de la clase
    private String nombreUsuario;
    private String passwordUsuario;
    private Date fechaHoraInhabilitacionUsuario;
    private Date fechaHoraUltimoIngresoSistemaUsuario;
    
    // Atributos por relación
    public TipoUsuario tipoUsuario;
    private Cliente cliente;
    private Empresa empresa;
    
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String passwordUsuario, Date fechaHoraInhabilitacionUsuario, Date fechaHoraUltimoIngresoSistemaUsuario, TipoUsuario tipoUsuario, Cliente cliente, Empresa empresa) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.fechaHoraInhabilitacionUsuario = fechaHoraInhabilitacionUsuario;
        this.fechaHoraUltimoIngresoSistemaUsuario = fechaHoraUltimoIngresoSistemaUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cliente = cliente;
        this.empresa = empresa;
    }

    public Usuario(String nombreUsuario, String passwordUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Usuario(TipoUsuario tipoUsuario, String OID) {
        super(OID);
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    
    

    // Setters
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPasswordUsuario(String password) {
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

    public String getPasswordUsuario() {
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
