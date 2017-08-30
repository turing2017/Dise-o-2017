package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author Maximiliano
 */
public class TipoEmpresa extends Entity{
    private String nombreTipoEmpresa;
    private Date fechaInhabilitacionTipoEmpresa;

    public TipoEmpresa() {
    }

    public TipoEmpresa(String nombreTipoEmpresa, Date fechaInhabilitacionTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.fechaInhabilitacionTipoEmpresa = fechaInhabilitacionTipoEmpresa;
    }

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Date getfechaInhabilitacionTipoEmpresa() {
        return fechaInhabilitacionTipoEmpresa;
    }

    public void setfechaInhabilitacionTipoEmpresa(Date fechaInhabilitacionTipoEmpresa) {
        this.fechaInhabilitacionTipoEmpresa = fechaInhabilitacionTipoEmpresa;
    }
    
}
