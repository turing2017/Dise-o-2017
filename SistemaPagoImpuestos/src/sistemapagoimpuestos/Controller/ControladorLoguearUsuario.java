package sistemapagoimpuestos.Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.WindowConstants;
import sistemapagoimpuestos.Expert.ExpertoLoguearUsuario;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.Principal.IUAdminPantallaPrincipal;
import sistemapagoimpuestos.View.Login.IULogin;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;

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
    
    public void buscarUsuario(String nombreUsuarioIngres, String passwordUsuarioIngres) {
        experto.buscarUsuario(nombreUsuarioIngres, passwordUsuarioIngres);
        switch(GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario()){
            case "Administrador":
                IUAdminPantallaPrincipal pp = new IUAdminPantallaPrincipal();
                pp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                pp.setLocationRelativeTo(null);
                pp.mostrarPantallaPrincipal();
                pp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent ev) {
                    }
                });
                break;
            case "Cliente":
                IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
                iUPagarImpuesto.setVisible(true);
                break;
        }
    }
}
