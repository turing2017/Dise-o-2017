
package sistemapagoimpuestos;

import sistemapagoimpuestos.View.Admin.Principal.IUAdminPantallaPrincipal;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;

/**
 *
 * @author Markz
 */
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {

        IULogin login = new IULogin();
        MetodosPantalla.getInstance().setearPantalla(login);

    }
}
