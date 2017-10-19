package sistemapagoimpuestos.Expert;
import exceptions.Excepciones;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.Cliente.IUPantallaCliente;
import sistemapagoimpuestos.View.Admin.Principal.IUAdminPantallaPrincipal;
import sistemapagoimpuestos.View.Login.IULogin;

/**
 *
 * @author Rodri
 */
public class ExpertoLoguearUsuario {
    Usuario usuario = new Usuario();
    private String fechaHoraInhabilitacionUsuarioEncontrada;

    public ExpertoLoguearUsuario() {
    }

    public String iniciar() {

        return "Administrador";
    }

    public void buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {

        try {
            List<DTOCriterio> criteriosList = new ArrayList<>();
            criteriosList.add(new DTOCriterio("nombreUsuario","=", nombreUsuarioIngres));
            criteriosList.add(new DTOCriterio("passwordUsuario","=", passwordUsuarioIngres));
            criteriosList.add(new DTOCriterio("fechaHoraInhabilitacionUsuario","IS", null));
            GlobalVars.userActive = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criteriosList).get(0);
            GlobalVars.userActive.setFechaHoraUltimoIngresoSistemaUsuario(new Date());
            FachadaPersistencia.getInstance().guardar(GlobalVars.userActive);
            
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Usuario");

        }
    }
}
