
package sistemapagoimpuestos.Entity;

/**
 *
 * @author Gabriel
 */
public class ParametroCalculoEditable extends Entity{
    
    private static ParametroCalculoEditable instancia;
    private double noEditable;
    private double siEditable;

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
