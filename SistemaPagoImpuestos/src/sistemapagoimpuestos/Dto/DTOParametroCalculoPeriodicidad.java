/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;


/**
 *
 * @author Gabriel
 */
public class DTOParametroCalculoPeriodicidad {
    
    private double mensualPCPeriodicidad = 0.0;
    private double bimestralPCPeriodicidad = 0.0;
    private double trimestralPCPeriodicidad = 0.0;
    private double cuatrimestralPCPeriodicidad = 0.0;
    private double semestralPCPeriodicidad = 0.0;
    private double anualPCPeriodicidad = 0.0;
    private double quincenalPCPeriodicidad = 0.0;

    //constructor
    public DTOParametroCalculoPeriodicidad() {

    }

    //getter
    public double getMensualPCPeriodicidad() {
        return mensualPCPeriodicidad;
    }

    public double getBimestralPCPeriodicidad() {
        return bimestralPCPeriodicidad;
    }

    public double getTrimestralPCPeriodicidad() {
        return trimestralPCPeriodicidad;
    }

    public double getCuatrimestralPCPeriodicidad() {
        return cuatrimestralPCPeriodicidad;
    }

    public double getSemestralPCPeriodicidad() {
        return semestralPCPeriodicidad;
    }

    public double getAnualPCPeriodicidad() {
        return anualPCPeriodicidad;
    }

    public double getQuincenalPCPeriodicidad() {
        return quincenalPCPeriodicidad;
    }

    //setter
    public void setMensualPCPeriodicidad(double mensualPCPeriodicidad) {
        this.mensualPCPeriodicidad = mensualPCPeriodicidad;
    }

    public void setBimestralPCPeriodicidad(double bimestralPCPeriodicidad) {
        this.bimestralPCPeriodicidad = bimestralPCPeriodicidad;
    }

    public void setTrimestralPCPeriodicidad(double trimestralPCPeriodicidad) {
        this.trimestralPCPeriodicidad = trimestralPCPeriodicidad;
    }

    public void setCuatrimestralPCPeriodicidad(double cuatrimestralPCPeriodicidad) {
        this.cuatrimestralPCPeriodicidad = cuatrimestralPCPeriodicidad;
    }

    public void setSemestralPCPeriodicidad(double semestralPCPeriodicidad) {
        this.semestralPCPeriodicidad = semestralPCPeriodicidad;
    }

    public void setAnualPCPeriodicidad(double anualPCPeriodicidad) {
        this.anualPCPeriodicidad = anualPCPeriodicidad;
    }

    public void setQuincenalPCPeriodicidad(double quincenalPCPeriodicidad) {
        this.quincenalPCPeriodicidad = quincenalPCPeriodicidad;
    }
}
