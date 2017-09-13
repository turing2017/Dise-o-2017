package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.GestionarUsuario.IUGestionarUsuario;

/**
 *
 * @author Rodri
 */
public class ControladorGestionarUsuario {

    public ControladorGestionarUsuario() {
    }

    private ExpertoGestionarUsuario experto = (ExpertoGestionarUsuario) FabricaExpertos.getInstancia().crearExperto("CU07");

    public void iniciar() {
        if (experto.iniciar().equals("Administrador")) {
            IUGestionarUsuario pantallaUsuario = new IUGestionarUsuario();
            MetodosPantalla.getInstance().setearPantalla(pantallaUsuario);
        }
    }

    public ArrayList<DTOUsuario> obtenerUsuario() {
        return experto.obtenerUsuario();

    }

    public List<DTOUsuario> obtenerUsuario(String codigo) {
        return experto.obtenerUsuario(codigo);
    }

}
