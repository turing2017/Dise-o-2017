/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

/**
 *
 * @author Dario
 */
public class ParametroCalculoPeriodicidad extends Entity{
     private double mensual;
     private double bimestral;
     private double trimestral;
     private double cuatrimestral;
     private double semestral;
     private double anual;
     private double quincenal;
      
    public ParametroCalculoPeriodicidad() {
    }
     
    public ParametroCalculoPeriodicidad(double valorMensual, double valorBimestral) {
        this.mensual = valorMensual;
        this.bimestral = valorBimestral;
        
    }
    public double getMensual() {
        return mensual;
    }

    public void setMensual(double valorSiEditable) {
        this.mensual = valorSiEditable;
    }   

    public double getTrimestral() {
        return trimestral;
    }

    public void setTrimestral(double trimestral) {
        this.trimestral = trimestral;
    }

    public double getCuatrimestral() {
        return cuatrimestral;
    }

    public void setCuatrimestral(double cuatrimestral) {
        this.cuatrimestral = cuatrimestral;
    }

    public double getSemestral() {
        return semestral;
    }

    public void setSemestral(double semestral) {
        this.semestral = semestral;
    }

    public double getAnual() {
        return anual;
    }

    public void setAnual(double anual) {
        this.anual = anual;
    }

    public double getQuincenal() {
        return quincenal;
    }

    public void setQuincenal(double quincenal) {
        this.quincenal = quincenal;
    }

    public double getBimestral() {
        return bimestral;
    }

    public void setBimestral(double bimestral) {
        this.bimestral = bimestral;
    }
    
}
