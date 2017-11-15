/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class DTOExporteLiquidacion {
    private String empresa;
    private String tipoImpuesto;
    private Integer numeroLiquidacion;
    private String fechaLiquidacion;
    private String periodo;
    private String montoTotalComision;

    public String getMontoTotalComision() {
        return montoTotalComision;
    }

    public void setMontoTotalComision(String montoTotalComision) {
        this.montoTotalComision = montoTotalComision;
    }
    private ArrayList<DTODetalleExporteLiquidacion> listDetallesExporte = new ArrayList<DTODetalleExporteLiquidacion>();

    public ArrayList<DTODetalleExporteLiquidacion> getListDetallesExporte() {
        return listDetallesExporte;
    }

    public void setListDetallesExporte(ArrayList<DTODetalleExporteLiquidacion> listDetallesExporte) {
        this.listDetallesExporte = listDetallesExporte;
    }
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Integer getNumeroLiquidacion() {
        return numeroLiquidacion;
    }

    public void setNumeroLiquidacion(Integer numeroLiquidacion) {
        this.numeroLiquidacion = numeroLiquidacion;
    }

    public String getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    public void setFechaLiquidacion(String fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
  
    
}
