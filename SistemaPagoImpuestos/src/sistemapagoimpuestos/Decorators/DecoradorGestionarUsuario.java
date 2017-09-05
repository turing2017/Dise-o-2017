package sistemapagoimpuestos.Decorators;

import sistemapagoimpuestos.Expert.ExpertoGestionarUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Rodri
 */
public class DecoradorGestionarUsuario extends ExpertoGestionarUsuario {

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String role = super.iniciar();
        FachadaInterna.getInstance().finalizarTransaccion();
        return role;
    }

}
