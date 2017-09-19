package sistemapagoimpuestos;
/**
 *
 * @author Markz
 */
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;

public class SistemaPagoImpuestos {

    static ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
   
    public static void main(String[] args) {

        controlador.iniciar();

    }
}
