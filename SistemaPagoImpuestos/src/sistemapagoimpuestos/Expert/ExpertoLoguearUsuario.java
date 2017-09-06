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

    public String iniciar() {

        return "Administrador";
    }

    public void buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {

        try {
            List<DTOCriterio> criteriosUsuario = new ArrayList<>();
            List<DTOCriterio> criteriosTipoUsuario = new ArrayList<>();

            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("nombreUsuario");
            criterio1.setOperacion("=");
            criterio1.setValor(nombreUsuarioIngres);

            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("passwordUsuario");
            criterio2.setOperacion("=");
            criterio2.setValor(passwordUsuarioIngres);

            DTOCriterio criterio3 = new DTOCriterio();
            criterio3.setAtributo("fechaHoraInhabilitacionUsuario");
            criterio3.setOperacion("IS");
            criterio3.setValor(null);

            criteriosUsuario.add(criterio1);
            criteriosUsuario.add(criterio2);
            criteriosUsuario.add(criterio3);

            Usuario usuario = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criteriosUsuario).get(0);
            String tipoUsuarioEncontrado = usuario.tipoUsuario.getNombreTipoUsuario();
            Date dateFechaUltimoAcceso = (Date) usuario.getFechaHoraUltimoIngresoSistemaUsuario();

            if (dateFechaUltimoAcceso == null) {
                fechaHoraInhabilitacionUsuarioEncontrada = "Sin último acceso";              
            } else {
                fechaHoraInhabilitacionUsuarioEncontrada = dateFechaUltimoAcceso.toString();
            }            
                                  
            //Criterio para buscar el tipo de usuario del usuario encontrado
            DTOCriterio criterio4 = new DTOCriterio();
            criterio4.setAtributo("nombreTipoUsuario");
            criterio4.setOperacion("=");
            criterio4.setValor(tipoUsuarioEncontrado);

            DTOCriterio criterio5 = new DTOCriterio();
            criterio5.setAtributo("fechaHoraInhabilitacionTipoUsuario");
            criterio5.setOperacion("IS");
            criterio5.setValor(null);

            criteriosTipoUsuario.add(criterio4);
            criteriosTipoUsuario.add(criterio5);

            TipoUsuario tipoUsuario = (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criteriosTipoUsuario).get(0);
            String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
            
            //Setear la fecha de nuevo ingreso en la BD, obviamente no se ve reflejada hasta el proximo inicio.
            usuario.setFechaHoraUltimoIngresoSistemaUsuario(new Date());
            FachadaPersistencia.getInstance().guardar(usuario);

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
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Usuario");

        }
    }
}
