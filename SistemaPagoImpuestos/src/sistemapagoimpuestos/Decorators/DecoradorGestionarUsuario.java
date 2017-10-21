package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Rodri
 */
public class DecoradorGestionarUsuario extends ExpertoGestionarUsuario {

    public DecoradorGestionarUsuario() {
    }
    
    @Override
    public void validarUsuario() throws Exception {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.validarUsuario(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();

    }

    @Override
    public void nuevoUsuario(String nombreIngres, String passwordIngres, String tipoUsuarioSelec, String empresaSelec) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoUsuario(nombreIngres, passwordIngres, tipoUsuarioSelec, empresaSelec);
        FachadaInterna.getInstance().finalizarTransaccion();
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

    @Override
    public List<DTOEmpresa> setearComboEmpresa() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresa> listado = super.setearComboEmpresa(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        
        return listado;
    }

    @Override
    public void modificarDatosUsuario(String nombreUsuario, String contraseñaNueva, boolean esHabilitado, String tipoUsuarioSelec, String empresaSelec) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarDatosUsuario(nombreUsuario, contraseñaNueva, esHabilitado, tipoUsuarioSelec, empresaSelec); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
    }
}
