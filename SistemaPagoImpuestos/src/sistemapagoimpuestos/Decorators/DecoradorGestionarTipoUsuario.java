/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;

public class DecoradorGestionarTipoUsuario extends ExpertoGestionarTipoUsuario {

    public DecoradorGestionarTipoUsuario() {
    }

    @Override
    public void validarUsuario() throws Exception {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.validarUsuario(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();

    }

    @Override
    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario() {

        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOTipoUsuario> listadoDtoTipoUsuario = super.obtenerTipoUsuario();
        FachadaInterna.getInstance().finalizarTransaccion();

        return listadoDtoTipoUsuario;
    }

    @Override
    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario(String codigo) {

        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOTipoUsuario> listadoDtoTipoUsuario = super.obtenerTipoUsuario();
        FachadaInterna.getInstance().finalizarTransaccion();
        return listadoDtoTipoUsuario;
    }

    @Override
    public void nuevoTipoUsuario(String nombreTipoUsuarioIngres) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.nuevoTipoUsuario(nombreTipoUsuarioIngres);
        FachadaInterna.getInstance().finalizarTransaccion();
    }

    @Override
    public void modificarTipoUsuario(String nombreActualTipoUsuario) {
        FachadaInterna.getInstance().iniciarTransaccion();
        super.modificarTipoUsuario(nombreActualTipoUsuario);
        FachadaInterna.getInstance().finalizarTransaccion();
    }

}
