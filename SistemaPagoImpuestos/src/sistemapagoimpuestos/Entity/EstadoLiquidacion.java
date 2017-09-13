package sistemapagoimpuestos.Entity;


public class EstadoLiquidacion extends Entity {
    
    private String nombreEstadoLiquidacion;

    public EstadoLiquidacion() {
    }

    public EstadoLiquidacion(String nombreEstadoLiquidacion) {
        this.nombreEstadoLiquidacion = nombreEstadoLiquidacion;
    }

    public String getNombreEstadoLiquidacion() {
        return nombreEstadoLiquidacion;
    }

    public void setNombreEstadoLiquidacion(String nombreEstadoLiquidacion) {
        this.nombreEstadoLiquidacion = nombreEstadoLiquidacion;
    }
    
}
