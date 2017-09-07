/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

/**
 *
 * @author Markz
 */
public class ControladorGestionarEmpresaTipoImpuestoItem {
    private static ControladorGestionarEmpresaTipoImpuestoItem controladorGestionarEmpresaTipoImpuestoItem;

    public ControladorGestionarEmpresaTipoImpuestoItem() {
    }
    
    public static ControladorGestionarEmpresaTipoImpuestoItem getInstance()
    {
        if (controladorGestionarEmpresaTipoImpuestoItem == null)
        {
            controladorGestionarEmpresaTipoImpuestoItem = new ControladorGestionarEmpresaTipoImpuestoItem();
        }
        return controladorGestionarEmpresaTipoImpuestoItem;
    }
}
