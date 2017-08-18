/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;

/**
 *
 * @author facun
 */
public class ItemEmpresaTipoImpuesto extends Entity {
    
    private Date fechaHoraInhabilitacionEmpresa ;
    private int ordenItemEmpresaTipoImpuesto;

    private Date getFechaHoraInhabilitacionEmpresa() {
        return fechaHoraInhabilitacionEmpresa;
    }

    private void setFechaHoraInhabilitacionEmpresa(Date fechaHoraInhabilitacionEmpresa) {
        this.fechaHoraInhabilitacionEmpresa = fechaHoraInhabilitacionEmpresa;
    }

    private int getOrdenItemEmpresaTipoImpuesto() {
        return ordenItemEmpresaTipoImpuesto;
    }

    private void setOrdenItemEmpresaTipoImpuesto(int ordenItemEmpresaTipoImpuesto) {
        this.ordenItemEmpresaTipoImpuesto = ordenItemEmpresaTipoImpuesto;
    }
    
}
