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
    private double valorAtributo;

    public AtributoAdicional() {
    }

    public AtributoAdicional(String nombreAtributo, double valorAtributo) {
        this.nombreAtributo = nombreAtributo;
        this.valorAtributo = valorAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public double getValorAtributo() {
        return valorAtributo;
    }

    public void setValorAtributo(double valorAtributo) {
        this.valorAtributo = valorAtributo;
    }
    
}
