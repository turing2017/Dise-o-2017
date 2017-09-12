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
public class DTOParametroCalculoEditable {
    
    private double siEditablePCEditable;
    private double noEditablePCEditable;
 
    //constructor
    
    public DTOParametroCalculoEditable() {

    }

    //getter

    public double getSiEditablePCEditable() {
        return siEditablePCEditable;
    }

    public double getNoEditablePCEditable() {
        return noEditablePCEditable;
    }

    //setter

    public void setSiEditablePCEditable(double siEditablePCEditable) {
        this.siEditablePCEditable = siEditablePCEditable;
    }

    public void setNoEditablePCEditable(double noEditablePCEditable) {
        this.noEditablePCEditable = noEditablePCEditable;
    }  
}
