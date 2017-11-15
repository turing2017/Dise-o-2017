/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class DTOExportar {
  private ArrayList<DTOExporteOperacion> listDtoOperaciones ;
  private String empresa ;
  private String tipoImpuesto;
  private String fechaDesde;
  private String fechaHasta;
  private double importeTotalPagado;

    public ArrayList<DTOExporteOperacion> getListDtoOperaciones() {
        return listDtoOperaciones;
    }

    public void setListDtoOperaciones(ArrayList<DTOExporteOperacion> listDtoOperaciones) {
        this.listDtoOperaciones = listDtoOperaciones;
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

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public double getImporteTotalPagado() {
        return importeTotalPagado;
    }

    public void setImporteTotalPagado(double importeTotalPagado) {
        this.importeTotalPagado = importeTotalPagado;
    }
}
