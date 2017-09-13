package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarTipoUsuario.IUGestionarTipoUsuario;

public class ControladorGestionarTipoUsuario {

    public ControladorGestionarTipoUsuario() {
    }

    private ExpertoGestionarTipoUsuario experto = (ExpertoGestionarTipoUsuario) FabricaExpertos.getInstancia().crearExperto("CU06");

    public void iniciar() {
        if (experto.iniciar().equals("Administrador")) {
            IUGestionarTipoUsuario pantallaPrincipal = new IUGestionarTipoUsuario();
            pantallaPrincipal.setLocationRelativeTo(null);
            pantallaPrincipal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            pantallaPrincipal.setVisible(true);
        }
    }

    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario() {
        return experto.obtenerTipoUsuario();

    }

    public List<DTOTipoUsuario> obtenerTipoUsuario(String codigo) {
        return experto.obtenerTipoUsuario(codigo);
    }

    public void nuevoTipoUsuario(String nombreTipoUsuario) {
        experto.nuevoTipoUsuario(nombreTipoUsuario);

    }

    public void modificarTipoUsuario(String nombreActualTipoUsuario) {
        experto.modificarTipoUsuario(nombreActualTipoUsuario);

    }

}
