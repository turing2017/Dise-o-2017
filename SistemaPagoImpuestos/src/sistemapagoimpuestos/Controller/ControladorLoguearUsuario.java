package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Expert.ExpertoLoguearUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;

/**
 *
 * @author Rodri
 */
public class ControladorLoguearUsuario {

    private static ControladorLoguearUsuario controladorLoguearUsuario;

    public ControladorLoguearUsuario() {
    }

    public static ControladorLoguearUsuario getInstance() {
        if (controladorLoguearUsuario == null) {
            controladorLoguearUsuario = new ControladorLoguearUsuario();
        }
        return controladorLoguearUsuario;
    }

    private ExpertoLoguearUsuario experto = (ExpertoLoguearUsuario) FabricaExpertos.getInstancia().crearExperto("CU08");

    public void iniciar(){
        IULogin login = new IULogin();
        MetodosPantalla.getInstance().setearPantalla(login);
    }
    
    public void buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {
        experto.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
    }
}
