
package sistemapagoimpuestos;


/**
 *
 * @author Markz
 */
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Admin.GestionarUsuario.IUGestionarUsuario;
import sistemapagoimpuestos.View.Admin.GestionarUsuario.IUGestionarUsuarioAlta;
import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {
//        IUGestionarUsuarioAlta gestionarUsuarioAlta = new IUGestionarUsuarioAlta();
//                gestionarUsuarioAlta.setVisible(true);
//                
//                gestionarUsuarioAlta.getCombo_TipoUsuario().addItemListener(new ItemListener() {
//                    @Override
//                    public void itemStateChanged(ItemEvent e) {
//                       if(gestionarUsuarioAlta.getCombo_TipoUsuario().getSelectedItem().toString().equals("Administrador")){
//                            System.out.println("test");  
//                    }
//                    }
//                });
        ControladorLoguearUsuario.getInstance().iniciar();

    }
}
