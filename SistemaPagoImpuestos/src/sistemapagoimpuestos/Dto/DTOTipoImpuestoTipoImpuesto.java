    package sistemapagoimpuestos.Dto;


public class DTOTipoImpuestoTipoImpuesto {
    
    // Atributos propios de la clase
    private String nombreDTOTipoImpuesto;
    public DTOTipoImpuestoTipoImpuesto() {
    }

    public DTOTipoImpuestoTipoImpuesto(String nombreDTOTipoImpuesto) {
        this.nombreDTOTipoImpuesto = nombreDTOTipoImpuesto;
    }

    public String getNombreDTOTipoImpuesto() {
        return nombreDTOTipoImpuesto;
    }

    public void setNombreDTOTipoImpuesto(String nombreDTOTipoImpuesto) {
        this.nombreDTOTipoImpuesto = nombreDTOTipoImpuesto;
    }
 
}
