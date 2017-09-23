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
    private TipoEmpresa tipoEmpresa;
    private TipoImpuesto tipoImpuesto;
    private Empresa empresa;
    private int frecuenciaLiquidacionDTOEmpresaExistente;



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

    public int getFrecuenciaLiquidacionDTOEmpresaExistente() {
        return frecuenciaLiquidacionDTOEmpresaExistente;
    }

    public void setFrecuenciaLiquidacionDTOEmpresaExistente(int frecuenciaLiquidacionDTOEmpresaExistente) {
        this.frecuenciaLiquidacionDTOEmpresaExistente = frecuenciaLiquidacionDTOEmpresaExistente;
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

    public DTOEmpresaTipoImpuesto(Date fechaHoraAltaEmpresaTipoImpuesto, Date fechaHoraInhabilitacionEmpresaTipoImpuestoa, TipoEmpresa tipoEmpresa, TipoImpuesto tipoImpuesto, Empresa empresa, int frecuenciaLiquidacionDTOEmpresaExistente) {
        this.fechaHoraAltaEmpresaTipoImpuesto = fechaHoraAltaEmpresaTipoImpuesto;
        this.fechaHoraInhabilitacionEmpresaTipoImpuestoa = fechaHoraInhabilitacionEmpresaTipoImpuestoa;
        this.tipoEmpresa = tipoEmpresa;
        this.tipoImpuesto = tipoImpuesto;
        this.empresa = empresa;
        this.frecuenciaLiquidacionDTOEmpresaExistente = frecuenciaLiquidacionDTOEmpresaExistente;
    }



}    