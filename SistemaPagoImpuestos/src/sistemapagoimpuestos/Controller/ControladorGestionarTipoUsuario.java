package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.WindowConstants;
import org.hibernate.TransactionException;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.View.Admin.GestionarTipoUsuario.IUGestionarTipoUsuario;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;

public class ControladorGestionarTipoUsuario {

    public ControladorGestionarTipoUsuario() {
    }

    private ExpertoGestionarTipoUsuario experto = (ExpertoGestionarTipoUsuario) FabricaExpertos.getInstancia().crearExperto("CU06");

    public void validadarUsuario() {
        try {
            experto.validarUsuario();
            IUGestionarTipoUsuario iUGestionarTipoUsuario = new IUGestionarTipoUsuario();
            iUGestionarTipoUsuario.setVisible(true);
        } catch (TransactionException e) {
            FachadaInterna.getInstance().finalizarTransaccion();
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es cliente");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
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
