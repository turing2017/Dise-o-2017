/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoDatoItem;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;

/**
 *
 * @author Maximiliano
 */
public class DTOEmpresaTipoImpuesto {
    
    private Date fechaHoraAltaEmpresaTipoImpuesto;
    private Date fechaHoraInhabilitacionEmpresaTipoImpuestoa;
    private Date FechaProximaLiquidacionEmpresaTipoImpuesto;
    private TipoEmpresa tipoEmpresa;
    private TipoImpuesto tipoImpuesto;
    private Empresa empresa;
    private Date fechaLiquidacionDTOEmpresaExistente;

    public Date getFechaLiquidacionDTOEmpresaExistente() {
        return fechaLiquidacionDTOEmpresaExistente;
    }

    public void setFechaLiquidacionDTOEmpresaExistente(Date fechaLiquidacionDTOEmpresaExistente) {
        this.fechaLiquidacionDTOEmpresaExistente = fechaLiquidacionDTOEmpresaExistente;
    }


    public DTOEmpresaTipoImpuesto() {
    }

    public Date getFechaHoraAltaEmpresaTipoImpuesto() {
        return fechaHoraAltaEmpresaTipoImpuesto;
    }

    public void setFechaHoraAltaEmpresaTipoImpuesto(Date fechaHoraAltaEmpresaTipoImpuesto) {
        this.fechaHoraAltaEmpresaTipoImpuesto = fechaHoraAltaEmpresaTipoImpuesto;
    }

    public Date getFechaHoraInhabilitacionEmpresaTipoImpuestoa() {
        return fechaHoraInhabilitacionEmpresaTipoImpuestoa;
    }

    public void setFechaHoraInhabilitacionEmpresaTipoImpuestoa(Date fechaHoraInhabilitacionEmpresaTipoImpuestoa) {
        this.fechaHoraInhabilitacionEmpresaTipoImpuestoa = fechaHoraInhabilitacionEmpresaTipoImpuestoa;
    }

    public Date getFechaProximaLiquidacionEmpresaTipoImpuesto() {
        return FechaProximaLiquidacionEmpresaTipoImpuesto;
    }

    public void setFechaProximaLiquidacionEmpresaTipoImpuesto(Date FechaProximaLiquidacionEmpresaTipoImpuesto) {
        this.FechaProximaLiquidacionEmpresaTipoImpuesto = FechaProximaLiquidacionEmpresaTipoImpuesto;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public DTOEmpresaTipoImpuesto(Date fechaHoraAltaEmpresaTipoImpuesto, Date fechaHoraInhabilitacionEmpresaTipoImpuestoa, Date FechaProximaLiquidacionEmpresaTipoImpuesto, TipoEmpresa tipoEmpresa, TipoImpuesto tipoImpuesto, Empresa empresa) {
        this.fechaHoraAltaEmpresaTipoImpuesto = fechaHoraAltaEmpresaTipoImpuesto;
        this.fechaHoraInhabilitacionEmpresaTipoImpuestoa = fechaHoraInhabilitacionEmpresaTipoImpuestoa;
        this.FechaProximaLiquidacionEmpresaTipoImpuesto = FechaProximaLiquidacionEmpresaTipoImpuesto;
        this.tipoEmpresa = tipoEmpresa;
        this.tipoImpuesto = tipoImpuesto;
        this.empresa = empresa;
    }

}    