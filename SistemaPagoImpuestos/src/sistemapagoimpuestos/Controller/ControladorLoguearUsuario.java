package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Expert.ExpertoLoguearUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;

/**
 *
 * @author Rodri
 */
public class ControladorLoguearUsuario {

    public ControladorLoguearUsuario() {
    }

    private ExpertoLoguearUsuario experto = (ExpertoLoguearUsuario) FabricaExpertos.getInstancia().crearExperto("CU08");

    public void iniciar(){
        IULogin login = new IULogin();
        MetodosPantalla.getInstance().setearPantalla(login);
    }
    
    public DTOUsuario buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {
       return experto.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
    }
}
