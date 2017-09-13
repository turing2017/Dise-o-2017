
package sistemapagoimpuestos;


/**
 *
 * @author Markz
 */
import sistemapagoimpuestos.Controller.ControladorGestionarItem;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {
        //ControladorLoguearUsuario.getInstance().iniciar();
        ControladorGestionarTipoImpuesto controlador = new ControladorGestionarTipoImpuesto();
        controlador.iniciar();
    }
}
