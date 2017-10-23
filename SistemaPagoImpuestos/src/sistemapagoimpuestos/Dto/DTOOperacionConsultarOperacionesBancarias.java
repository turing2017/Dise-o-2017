package sistemapagoimpuestos.Dto;
import java.util.Date;




public class DTOOperacionConsultarOperacionesBancarias {

	private int numeroOperacion;
	private String codigoPagoElectronicoOperacion;
	private Date fechaHoraOperacion;
	private double importePagadoOperacion;
	private int nroComprobanteFacturaOperacion;
	private String TipoImpuesto;

	public DTOOperacionConsultarOperacionesBancarias(){

        }

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getCodigoPagoElectronicoOperacion() {
        return codigoPagoElectronicoOperacion;
    }

    public void setCodigoPagoElectronicoOperacion(String codigoPagoElectronicoOperacion) {
        this.codigoPagoElectronicoOperacion = codigoPagoElectronicoOperacion;
    }

    public Date getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(Date fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public double getImportePagadoOperacion() {
        return importePagadoOperacion;
    }

    public void setImportePagadoOperacion(double importePagadoOperacion) {
        this.importePagadoOperacion = importePagadoOperacion;
    }

    public int getNroComprobanteFacturaOperacion() {
        return nroComprobanteFacturaOperacion;
    }

    public void setNroComprobanteFacturaOperacion(int nroComprobanteFacturaOperacion) {
        this.nroComprobanteFacturaOperacion = nroComprobanteFacturaOperacion;
    }

    public String getTipoImpuesto() {
        return TipoImpuesto;
    }

    public void setTipoImpuesto(String TipoImpuesto) {
        this.TipoImpuesto = TipoImpuesto;
    }
        
}