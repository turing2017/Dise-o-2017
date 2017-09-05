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
public class ParametroCalculoEditable extends Entity{
    
     private double siEditable;
     private double noEditable;
      
    public ParametroCalculoEditable() {
    }
     
    public ParametroCalculoEditable(double valorSiEditable, double valorNoEditable) {
        this.siEditable = valorSiEditable;
        this.noEditable = valorNoEditable;
        
    }
    public double getSiEditable() {
        return siEditable;
    }

    public void setSiEditable(double valorSiEditable) {
        this.siEditable = valorSiEditable;
    }
    
    public double getNoEditable() {
        return noEditable;
    }

    public void setNoEditable(double valorNoEditable) {
        this.noEditable = valorNoEditable;
    }    
    
}
