/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPrueba;

import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Markz
 */
public class DatosPrueba {
    public void generarDatosPrueba(){
        FachadaInterna.getInstance().iniciarTransaccion();
        TipoUsuario tipoUsuario =new TipoUsuario(1, "Administrador");
        Usuario usuario = new Usuario("mvissio", "123456");
        usuario.setTipoUsuario(tipoUsuario);
                
        FachadaPersistencia.getInstance().guardar(tipoUsuario);
        FachadaPersistencia.getInstance().guardar(usuario);
        System.out.println("Guardado");
        FachadaInterna.getInstance().finalizarTransaccion();
    }
}
