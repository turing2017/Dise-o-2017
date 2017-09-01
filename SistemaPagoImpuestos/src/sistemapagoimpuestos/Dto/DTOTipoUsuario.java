
package sistemapagoimpuestos.Dto;

import java.util.Date;


public class DTOTipoUsuario {

    private String nombreDTOTipoUsuario;
    private Date fechaHoraInhabilitacionDTOTipoUsuario;
   
    
    public DTOTipoUsuario() {       
}


public DTOTipoUsuario(String nombreDTOTipoUsuario, Date fechaHoraInhabilitacionDTOTipoUsuario){

    this.nombreDTOTipoUsuario = nombreDTOTipoUsuario;
    this.fechaHoraInhabilitacionDTOTipoUsuario = fechaHoraInhabilitacionDTOTipoUsuario;

   
}

    public String getNombreDTOTipoUsuario() {
        return nombreDTOTipoUsuario;
    }

    public void setNombreDTOTipoUsuario(String nombreDTOTipoUsuario) {
        this.nombreDTOTipoUsuario = nombreDTOTipoUsuario;
    }

    public Date getFechaHoraInhabilitacionDTOTipoUsuario() {
        return fechaHoraInhabilitacionDTOTipoUsuario;
    }

    public void setFechaHoraInhabilitacionDTOTipoUsuario(Date fechaHoraInhabilitacionDTOTipoUsuario) {
        this.fechaHoraInhabilitacionDTOTipoUsuario = fechaHoraInhabilitacionDTOTipoUsuario;
    }


}
