package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Markz
 */
public class AtributoAdicional {
    private String nombreAtributo;
    private String valorAtributo;

    public AtributoAdicional() {
    }

    public AtributoAdicional(String nombreAtributo, String valorAtributo) {
        this.nombreAtributo = nombreAtributo;
        this.valorAtributo = valorAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public String getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(String valorAtributo) {
        this.valorAtributo = valorAtributo;
    }

    
}
