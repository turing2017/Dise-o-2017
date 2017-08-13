    package sistemapagoimpuestos.Dto;

import java.util.Date;

/**
 *
 * @author lunamarcos
 */
public class DTOTipoImpuesto {
    
    // Atributos propios de la clase
    private int codigoDTOTipoImpuesto;
    private boolean esMontoEditableDTOTipoImpuesto;
    private Date fechaHoraInhabilitacionDTOTipoImpuesto;
    private String nombreDTOTipoImpuesto;
    
    // Setters
    public void setCodigoDTOTipoImpuesto(int codigoDTOTipoImpuesto) {
        this.codigoDTOTipoImpuesto = codigoDTOTipoImpuesto;
    }

    public void setEsMontoEditableDTOTipoImpuesto(boolean esMontoEditableDTOTipoImpuesto) {
        this.esMontoEditableDTOTipoImpuesto = esMontoEditableDTOTipoImpuesto;
    }

    public void setFechaHoraInhabilitacionDTOTipoImpuesto(Date fechaHoraInhabilitacionDTOTipoImpuesto) {
        this.fechaHoraInhabilitacionDTOTipoImpuesto = fechaHoraInhabilitacionDTOTipoImpuesto;
    }

    public void setNombreDTOTipoImpuesto(String nombreDTOTipoImpuesto) {
        this.nombreDTOTipoImpuesto = nombreDTOTipoImpuesto;
    }
    
    // Getters
    public int getCodigoDTOTipoImpuesto() {
        return codigoDTOTipoImpuesto;
    }

    public boolean isEsMontoEditableDTOTipoImpuesto() {
        return esMontoEditableDTOTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionDTOTipoImpuesto() {
        return fechaHoraInhabilitacionDTOTipoImpuesto;
    }

    public String getNombreDTOTipoImpuesto() {
        return nombreDTOTipoImpuesto;
    }
    
}
