    package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author lunamarcos
 */
public class DTOTipoImpuesto {
    
    // Atributos propios de la clase
    private int codigoDTOTipoImpuesto;
    private String nombreDTOTipoImpuesto;
    private boolean esMontoEditableDTOTipoImpuesto;
    private Date fechaHoraInhabilitacionDTOTipoImpuesto;
    private List<DTOEmpresaTipoImpuestoItems> dTOEmpresaTipoImpuestoItemList;
    public DTOTipoImpuesto() {
    }

    public DTOTipoImpuesto(int codigoDTOTipoImpuesto, String nombreDTOTipoImpuesto, boolean esMontoEditableDTOTipoImpuesto, Date fechaHoraInhabilitacionDTOTipoImpuesto) {
        this.codigoDTOTipoImpuesto = codigoDTOTipoImpuesto;
        this.nombreDTOTipoImpuesto = nombreDTOTipoImpuesto;
        this.esMontoEditableDTOTipoImpuesto = esMontoEditableDTOTipoImpuesto;
        this.fechaHoraInhabilitacionDTOTipoImpuesto = fechaHoraInhabilitacionDTOTipoImpuesto;
    }

    
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

    public List<DTOEmpresaTipoImpuestoItems> getdTOEmpresaTipoImpuestoItemList() {
        return dTOEmpresaTipoImpuestoItemList;
    }

    public void setdTOEmpresaTipoImpuestoItemList(List<DTOEmpresaTipoImpuestoItems> dTOEmpresaTipoImpuestoItemList) {
        this.dTOEmpresaTipoImpuestoItemList = dTOEmpresaTipoImpuestoItemList;
    }
    
}
