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
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
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

    public DTOUsuario buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {
        DTOUsuario dTOUsuario = new DTOUsuario();
        try {
            List<DTOCriterio> criteriosUsuario = new ArrayList<>();
            List<DTOCriterio> criteriosTipoUsuario = new ArrayList<>();
            criteriosUsuario.add(new DTOCriterio("nombreUsuario", "=", nombreUsuarioIngres));
            criteriosUsuario.add(new DTOCriterio("passwordUsuario", "=", passwordUsuarioIngres));
            criteriosUsuario.add(new DTOCriterio("fechaHoraInhabilitacionUsuario", "Is", null));
            Usuario usuario = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criteriosUsuario).get(0);
            usuario.setFechaHoraInhabilitacionUsuario(new Date());
            FachadaPersistencia.getInstance().guardar(usuario);

            String tipoUsuarioEncontrado = usuario.tipoUsuario.getNombreTipoUsuario();
            dTOUsuario.setFechaHoraInhabilitacionDTOUsuario(usuario.getFechaHoraInhabilitacionUsuario());
            dTOUsuario.setNombreDTOUsuario(usuario.getNombreUsuario());
            dTOUsuario.setPasswordDTOUsuario(usuario.getPasswordUsuario());
            dTOUsuario.setFechaHoraUltimoIngresoSistemaDTOUsuario(usuario.getFechaHoraUltimoIngresoSistemaUsuario());
            dTOUsuario.setdTOTipoUsuario(ConvertDTO.getInstance().convertTipoUsuario(usuario.getTipoUsuario()));
            switch(tipoUsuarioEncontrado){
                case "Empresa":
                    dTOUsuario.setdTOEmpresa(ConvertDTO.getInstance().convertEmpresa(usuario.empresa));
                    break;
                case "Cliente":
                    dTOUsuario.setdTOCliente(ConvertDTO.getInstance().convertCliente(usuario.cliente));
                    break;
                default:
                    break;
            }
/*
            if (nombreTipoUsuario.equals("Administrador")) {
                IUAdminPantallaPrincipal pp = new IUAdminPantallaPrincipal();
                pp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                pp.setLocationRelativeTo(null);
                pp.mostrarPantallaPrincipal(nombreUsuarioIngres, fechaHoraInhabilitacionUsuarioEncontrada);
                pp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent ev) {
                        pp.dispose();
                        ControladorLoguearUsuario.getInstance().iniciar();

                    }
                });
            } else {
                IUPantallaCliente pc = new IUPantallaCliente();
                pc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                pc.setLocationRelativeTo(null);
                pc.mostrarPantallaCliente(nombreUsuarioIngres, fechaHoraInhabilitacionUsuarioEncontrada);
                pc.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent ev) {
                        pc.dispose();
                        ControladorLoguearUsuario.getInstance().iniciar();
                    }
                });
            }
*/
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Usuario");
        }
        return dTOUsuario;
    }
}
