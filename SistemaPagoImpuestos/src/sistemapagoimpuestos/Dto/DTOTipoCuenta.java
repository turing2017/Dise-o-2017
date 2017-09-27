package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class DTOTipoCuenta {
        // Atributos propios de la clase
    private int codigoTipoCuenta;
    private String nombreTipoCuenta;
    private boolean habilitadaTipoCuenta;
    private Date fechaHoraInhabilitacionTipoCuenta;

    public DTOTipoCuenta() {
    }

    public DTOTipoCuenta(int codigoTipoCuenta, String nombreTipoCuenta, boolean habilitadaTipoCuenta, Date fechaHoraInhabilitacionTipoCuenta) {
        this.codigoTipoCuenta = codigoTipoCuenta;
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.habilitadaTipoCuenta = habilitadaTipoCuenta;
        this.fechaHoraInhabilitacionTipoCuenta = fechaHoraInhabilitacionTipoCuenta;
    }

    
    
    // Setters
    public void setCodigoTipoCuenta(int codigoTipoCuenta) {
        this.codigoTipoCuenta = codigoTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public void setHabilitadaTipoCuenta(boolean habilitadaTipoCuenta) {
        this.habilitadaTipoCuenta = habilitadaTipoCuenta;
    }

    public void setFechaHoraInhabilitacionTipoCuenta(Date fechaHoraInhabilitacionTipoCuenta) {
        this.fechaHoraInhabilitacionTipoCuenta = fechaHoraInhabilitacionTipoCuenta;
    }

    // Getters
    public int getCodigoTipoCuenta() {
        return codigoTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public boolean isHabilitadaTipoCuenta() {
        return habilitadaTipoCuenta;
    }

    public Date getFechaHoraInhabilitacionTipoCuenta() {
        return fechaHoraInhabilitacionTipoCuenta;
    }
}
