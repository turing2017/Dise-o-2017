package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.GestionarUsuario.IUGestionarUsuario;
import sistemapagoimpuestos.View.Admin.GestionarUsuario.IUGestionarUsuarioAlta;

/**
 *
 * @author Rodri
 */
public class ControladorGestionarUsuario {

    private static ControladorGestionarUsuario controladorGestionarUsuario;

    public ControladorGestionarUsuario() {
    }

    public static ControladorGestionarUsuario getInstance() {

        if (controladorGestionarUsuario == null) {
            controladorGestionarUsuario = new ControladorGestionarUsuario();
        }
        return controladorGestionarUsuario;
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

    public void mostrarPantallaAlta() {
        IUGestionarUsuarioAlta pantallaAlta = new IUGestionarUsuarioAlta();
        MetodosPantalla.getInstance().setearPantalla(pantallaAlta);
    }

    public List<DTOTipoUsuario> setearComboTipoUsuario() {
        return experto.setearComboTipoUsuario();
    }

    public void nuevoUsuario(String nombreIngres, String passwordIngres, String tipoUsuarioSelec, String empresaSelec) {
        experto.nuevoUsuario(nombreIngres, passwordIngres, tipoUsuarioSelec, empresaSelec);
    }

    public List<DTOEmpresa> setearComboEmpresa() {
        return experto.setearComboEmpresa();
    }

}
