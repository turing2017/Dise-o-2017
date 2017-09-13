
package sistemapagoimpuestos;


import datosPrueba.DatosPrueba;
import static datosPrueba.DatosPrueba.generarDatosPrueba;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.cfg.Configuration;

import sistemapagoimpuestos.Controller.ControladorGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoDeCuenta;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.Utils.HibernateUtil;



 
import datosPrueba.DatosPrueba;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {

        //generarDatosPrueba();
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();

        
       // FachadaInterna.getInstance().iniciarTransaccion();
       // DatosPrueba.createOperation();
       // FachadaInterna.getInstance().finalizarTransaccion();
       // ControladorLoguearUsuario.getInstance().iniciar();
       ControladorGestionarParametrosCalculoComision.getInstance().iniciar();
    }
}
