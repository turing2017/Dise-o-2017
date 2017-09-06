/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos;

import sistemapagoimpuestos.View.Admin.Principal.IUAdminPantallaPrincipal;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;

/**
 *
 * @author Markz
 */
public class SistemaPagoImpuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //generarDatosPrueba();
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
        
        //ControladorGestionarTipoImpuesto.getInstance().iniciar();
        //ControladorGestionarTipoUsuario.getInstance().iniciar();
        IUAdminPantallaPrincipal pp = new IUAdminPantallaPrincipal();
        pp.setLocationRelativeTo(null);
        pp.setVisible(true);
        
        
        
       
    }
}
