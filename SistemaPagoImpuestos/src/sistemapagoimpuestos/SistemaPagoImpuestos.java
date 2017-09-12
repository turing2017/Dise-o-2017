
package sistemapagoimpuestos;


/**
 *
 * @author Markz
 */
import datosPrueba.DatosPrueba;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        DatosPrueba.createOperation();
        FachadaInterna.getInstance().finalizarTransaccion();
        ControladorLoguearUsuario.getInstance().iniciar();
    }
}
