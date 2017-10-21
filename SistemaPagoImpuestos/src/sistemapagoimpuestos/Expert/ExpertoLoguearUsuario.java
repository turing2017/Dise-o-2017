package sistemapagoimpuestos.Expert;
import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Rodri
 */
public class ExpertoLoguearUsuario {
    Usuario usuario = new Usuario();
    private String fechaHoraInhabilitacionUsuarioEncontrada;

    public ExpertoLoguearUsuario() {
    }

    public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
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
