package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class ParametroCalculoEditable extends Entity {

    private static ParametroCalculoEditable instancia;
    private Date fechaDesdePCEditable = new Date();
    private double siEditablePCEditable;
    private double noEditablePCEditable;
    private Date fechaInhabilitacionPCEditable = new Date();

    //constructor
    
    public ParametroCalculoEditable() {

    }

    public static ParametroCalculoEditable getInstancia() {
        if (instancia == null) {
            setInstancia(new ParametroCalculoEditable());
        }
        return instancia;
    }
    
    //getter

    public Date getFechaDesdePCEditable() {
        return fechaDesdePCEditable;
    }

    public double getSiEditablePCEditable() {
        return siEditablePCEditable;
    }

    public double getNoEditablePCEditable() {
        return noEditablePCEditable;
    }

    public Date getFechaInhabilitacionPCEditable() {
        return fechaInhabilitacionPCEditable;
    }
    
    //setter

    public void setFechaDesdePCEditable(Date fechaDesdePCEditable) {
        this.fechaDesdePCEditable = fechaDesdePCEditable;
    }

    public void setSiEditablePCEditable(double siEditablePCEditable) {
        this.siEditablePCEditable = siEditablePCEditable;
    }

    public void setNoEditablePCEditable(double noEditablePCEditable) {
        this.noEditablePCEditable = noEditablePCEditable;
    }

    public void setFechaInhabilitacionPCEditable(Date fechaInhabilitacionPCEditable) {
        this.fechaInhabilitacionPCEditable = fechaInhabilitacionPCEditable;
    }

    public static void setInstancia(ParametroCalculoEditable aInstancia) {
        instancia = aInstancia;
    }
    
}
