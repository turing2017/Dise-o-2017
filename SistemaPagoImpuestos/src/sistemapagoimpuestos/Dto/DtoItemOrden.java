/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

/**
 *
 * @author Markz
 */
public class DtoItemOrden {
    private String nombreItem;
    private int orden;
    private Boolean perioricidad;
    private Boolean seleccionado;

    public DtoItemOrden(String nombreItem, int orden, Boolean perioricidad, Boolean seleccionado) {
        this.nombreItem = nombreItem;
        this.orden = orden;
        this.perioricidad = perioricidad;
        this.seleccionado = seleccionado;
    }

    
    
    
    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
        public DtoItemOrden() {
    }

    

    public Boolean getPerioricidad() {
        return perioricidad;
    }

    public void setPerioricidad(Boolean perioricidad) {
        this.perioricidad = perioricidad;
    }



    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
}
