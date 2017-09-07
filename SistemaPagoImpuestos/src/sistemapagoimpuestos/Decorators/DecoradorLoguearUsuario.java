package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoLoguearUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Rodri
 */
public class DecoradorLoguearUsuario extends ExpertoLoguearUsuario {

    @Override
    public DTOUsuario buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOUsuario dTOUsuario=super.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dTOUsuario;
    }
}
