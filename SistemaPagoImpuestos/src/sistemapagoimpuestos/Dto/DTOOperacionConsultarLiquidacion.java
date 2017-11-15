/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;
import java.util.Date;



public class DTOOperacionConsultarLiquidacion {
   
    double valorComision;
    
    int numeroOperacion;
    int nroComprobanteFactura;
    double importePagadoOperacion;
    Date fechaHoraOperacion;
    String nombreTipoImpuesto;
    public DTOOperacionConsultarLiquidacion() {
    }

    public DTOOperacionConsultarLiquidacion(double valorComision, int numeroOperacion, int nroComprobanteFactura, double importePagadoOperacion,Date fechaHoraOperacion) {
        this.valorComision = valorComision;
       
        this.numeroOperacion = numeroOperacion;
        this.nroComprobanteFactura = nroComprobanteFactura;
        this.importePagadoOperacion = importePagadoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public String getNombreTipoImpuesto() {
        return nombreTipoImpuesto;
    }

    public void setNombreTipoImpuesto(String nombreTipoImpuesto) {
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }

    public Date getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(Date fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
    }

    

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public int getNroComprobanteFactura() {
        return nroComprobanteFactura;
    }

    public void setNroComprobanteFactura(int nroComprobanteFactura) {
        this.nroComprobanteFactura = nroComprobanteFactura;
    }

    public double getImportePagadoOperacion() {
        return importePagadoOperacion;
    }

    public void setImportePagadoOperacion(double importePagadoOperacion) {
        this.importePagadoOperacion = importePagadoOperacion;
    }


}
  

