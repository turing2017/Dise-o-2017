
package sistemapagoimpuestos;


/**
 *
 * @author Markz
 */
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {

        ControladorLoguearUsuario.getInstance().iniciar();

    }
}
