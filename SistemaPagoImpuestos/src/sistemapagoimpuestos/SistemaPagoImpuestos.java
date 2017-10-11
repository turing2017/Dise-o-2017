package sistemapagoimpuestos;

import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;


public class SistemaPagoImpuestos {
  
    public static void main(String[] args) {
        
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
        //FachadaInterna.getInstance().iniciarTransaccion();
//        DatosPrueba.createOperation();
        
        //AdaptadorEmpresaClaro c = new AdaptadorEmpresaClaro();
        //c.findComprobantes("test");
        //FachadaInterna.getInstance().finalizarTransaccion();
       // IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
       // iUPagarImpuesto.setVisible(true);
        
        ControladorGestionarLiquidacion controlador = new ControladorGestionarLiquidacion();
        controlador.iniciar();
    }
}
