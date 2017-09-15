/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

/**
 *
 * @author mvissio
 */
public class DetalleOperacion extends Entity{
    
    private String valorDetalleOperacion;
    private ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto;

    public DetalleOperacion() {
    }

    

    
    public String getValorDetalleOperacion() {
        return valorDetalleOperacion;
    }

    public void setValorDetalleOperacion(String valorDetalleOperacion) {
        this.valorDetalleOperacion = valorDetalleOperacion;
    }

    public ItemEmpresaTipoImpuesto getItemEmpresaTipoImpuesto() {
        return itemEmpresaTipoImpuesto;
    }

    public void setItemEmpresaTipoImpuesto(ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto) {
        this.itemEmpresaTipoImpuesto = itemEmpresaTipoImpuesto;
    }

 
    
    
    
}
