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
    private int frecuenciaSincro;
    public DTOTipoImpuesto() {
    }

    public DTOTipoImpuesto(int codigoDTOTipoImpuesto, String nombreDTOTipoImpuesto, boolean esMontoEditableDTOTipoImpuesto, Date fechaHoraInhabilitacionDTOTipoImpuesto) {
        this.codigoDTOTipoImpuesto = codigoDTOTipoImpuesto;
        this.nombreDTOTipoImpuesto = nombreDTOTipoImpuesto;
        this.esMontoEditableDTOTipoImpuesto = esMontoEditableDTOTipoImpuesto;
        this.fechaHoraInhabilitacionDTOTipoImpuesto = fechaHoraInhabilitacionDTOTipoImpuesto;
    }

    public DTOTipoImpuesto(int codigoDTOTipoImpuesto, String nombreDTOTipoImpuesto, boolean esMontoEditableDTOTipoImpuesto, Date fechaHoraInhabilitacionDTOTipoImpuesto, List<DTOEmpresaTipoImpuestoItems> dTOEmpresaTipoImpuestoItemList, int frecuenciaSincro) {
        this.codigoDTOTipoImpuesto = codigoDTOTipoImpuesto;
        this.nombreDTOTipoImpuesto = nombreDTOTipoImpuesto;
        this.esMontoEditableDTOTipoImpuesto = esMontoEditableDTOTipoImpuesto;
        this.fechaHoraInhabilitacionDTOTipoImpuesto = fechaHoraInhabilitacionDTOTipoImpuesto;
        this.dTOEmpresaTipoImpuestoItemList = dTOEmpresaTipoImpuestoItemList;
        this.frecuenciaSincro = frecuenciaSincro;
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

    public int getFrecuenciaSincro() {
        return frecuenciaSincro;
    }

    public void setFrecuenciaSincro(int frecuenciaSincro) {
        this.frecuenciaSincro = frecuenciaSincro;
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
