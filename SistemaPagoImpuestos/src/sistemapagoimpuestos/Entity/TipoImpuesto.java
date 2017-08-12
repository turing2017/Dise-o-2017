package sistemapagoimpuestos.Entity;

import java.util.Date;


public class TipoImpuesto extends Entity {
    
    // Atributos propios de la clase
    private int codigoTipoImpuesto;
    private boolean esMontoEditableTipoImpuesto;
    private Date fechaHoraInhabilitacionTipoImpuesto;
    private String nombreTipoImpuesto;
    
    // Setters
    public void setCodigoTipoImpuesto(int codigoTipoImpuesto) {
        this.codigoTipoImpuesto = codigoTipoImpuesto;
    }

    public void setEsMontoEditableTipoImpuesto(boolean esMontoEditableTipoImpuesto) {
        this.esMontoEditableTipoImpuesto = esMontoEditableTipoImpuesto;
    }

    public void setFechaHoraInhabilitacionTipoImpuesto(Date fechaHoraInhabilitacionTipoImpuesto) {
        this.fechaHoraInhabilitacionTipoImpuesto = fechaHoraInhabilitacionTipoImpuesto;
    }

    public void setNombreTipoImpuesto(String nombreTipoImpuesto) {
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }
    
    // Getters 
    public int getCodigoTipoImpuesto() {
        return codigoTipoImpuesto;
    }

    public boolean isEsMontoEditableTipoImpuesto() {
        return esMontoEditableTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionTipoImpuesto() {
        return fechaHoraInhabilitacionTipoImpuesto;
    }

    public String getNombreTipoImpuesto() {
        return nombreTipoImpuesto;
    }
    
}
