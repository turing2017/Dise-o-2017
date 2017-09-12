package sistemapagoimpuestos.Entity;

/**
 *
 * @author Gabriel
 */
public class ParametroCalculoEditable extends Entity {

    private static ParametroCalculoEditable instancia;
    private double siEditablePCEditable;
    private double noEditablePCEditable;
 
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

    public double getSiEditablePCEditable() {
        return siEditablePCEditable;
    }

    public double getNoEditablePCEditable() {
        return noEditablePCEditable;
    }

    //setter

    public void setSiEditablePCEditable(double siEditablePCEditable) {
        this.siEditablePCEditable = siEditablePCEditable;
    }

    public void setNoEditablePCEditable(double noEditablePCEditable) {
        this.noEditablePCEditable = noEditablePCEditable;
    }

    public static void setInstancia(ParametroCalculoEditable aInstancia) {
        instancia = aInstancia;
    }
    
}
