
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class ParametroCalculoEditable extends Entity{
    
    private static ParametroCalculoEditable instancia;
    private Date fechaDesde = new Date();
    private double noEditable;
    private double siEditable;

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    
    public double getNoEditable() {
        return noEditable;
    }

    public void setNoEditable(double noEditable) {
        this.noEditable = noEditable;
    }

    public double getSiEditable() {
        return siEditable;
    }

    public void setSiEditable(double siEditable) {
        this.siEditable = siEditable;
    }
    
    public ParametroCalculoEditable() {
        
    }

    public static ParametroCalculoEditable getInstancia() {
        if (instancia == null) {
            instancia = new ParametroCalculoEditable();
        }
        return instancia;
    }
}
