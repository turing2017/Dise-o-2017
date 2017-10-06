package sistemapagoimpuestos;

import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Controller.ControladorCalcularLiquidaciones;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;

public class SistemaPagoImpuestos {
  
    public static void main(String[] args) {
         DTOAccionesSistema dtoAccionesSistema = new DTOAccionesSistema();
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
        //FachadaInterna.getInstance().iniciarTransaccion();
//        DatosPrueba.createOperation();
        
        //AdaptadorEmpresaClaro c = new AdaptadorEmpresaClaro();
        //c.findComprobantes("test");
        //FachadaInterna.getInstance().finalizarTransaccion();
        //IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
        //iUPagarImpuesto.show();
        
        ControladorCalcularLiquidaciones controlador = new ControladorCalcularLiquidaciones();
        controlador.iniciar(dtoAccionesSistema);
       // ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
       // controlador.iniciar();
    }
}
