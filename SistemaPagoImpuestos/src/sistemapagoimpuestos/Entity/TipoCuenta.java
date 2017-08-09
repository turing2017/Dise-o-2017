package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class TipoCuenta {
    
    // Atributos propios de la clase
    private int codigoTipoCuenta;
    private String nombreTipoCuenta;
    private boolean habilitadaTipoCuenta;
    private Date fechaHoraInhabilitacionTipoCuenta;

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
