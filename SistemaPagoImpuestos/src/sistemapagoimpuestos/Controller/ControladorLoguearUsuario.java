package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Expert.ExpertoLoguearUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;

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

    public void buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {
        experto.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
    }
}
