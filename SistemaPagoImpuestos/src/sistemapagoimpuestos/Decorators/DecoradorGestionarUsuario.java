package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;
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
    
    @Override
    public ArrayList<DTOUsuario> obtenerUsuario() {

        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOUsuario> listadoDtoUsuario = super.obtenerUsuario();
        FachadaInterna.getInstance().finalizarTransaccion();

        return listadoDtoUsuario;
    }

    @Override
    public List<DTOTipoUsuario> setearComboTipoUsuario() {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoUsuario> listado = super.setearComboTipoUsuario(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        
        return listado;
    }
}
