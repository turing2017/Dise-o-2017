package sistemapagoimpuestos.Entity;
/**
 *
 * @author Gabriel
 */
public class ParametroCalculoPeriodicidad extends Entity{
    private static ParametroCalculoPeriodicidad instancia;
    private double anual = 0.0;
    private double bimestral = 0.0;
    private double cuatrimestral= 0.0;
    private double mensual= 0.0;
    private double quincenal= 0.0;
    private double semestral= 0.0;
    private double trimestral= 0.0;
    
    public ParametroCalculoPeriodicidad(){
        
    }

     public static ParametroCalculoPeriodicidad getInstancia ()
    {
        if (instancia == null)
        {
            instancia = new ParametroCalculoPeriodicidad();
        }
        return instancia;
    }
     
    public double getAnual() {
        return anual;
    }

    public void setAnual(double anual) {
        this.anual = anual;
    }

    public double getBimestral() {
        return bimestral;
    }

    public void setBimestral(double bimestral) {
        this.bimestral = bimestral;
    }

    public double getCuatrimestral() {
        return cuatrimestral;
    }

    public void setCuatrimestral(double cuatrimestral) {
        this.cuatrimestral = cuatrimestral;
    }

    public double getMensual() {
        return mensual;
    }

    public void setMensual(double mensual) {
        this.mensual = mensual;
    }

    public double getQuincenal() {
        return quincenal;
    }

    public void setQuincenal(double quincenal) {
        this.quincenal = quincenal;
    }

    public double getSemestral() {
        return semestral;
    }

    public void setSemestral(double semestral) {
        this.semestral = semestral;
    }

    public double getTrimestral() {
        return trimestral;
    }

    public void setTrimestral(double trimestral) {
        this.trimestral = trimestral;
    }
    
    
    
}
