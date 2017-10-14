/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Globals;

import sistemapagoimpuestos.Entity.Usuario;

/**
 *
 * @author mviss
 */
public class GlobalVars {

    private GlobalVars instance;
    public static Usuario userActive;
    public GlobalVars getInstances() {
        if (instance == null) {
            instance = new GlobalVars();
        }
        return instance;
    }
    
}
