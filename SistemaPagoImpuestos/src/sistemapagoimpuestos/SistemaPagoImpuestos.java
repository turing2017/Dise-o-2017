package sistemapagoimpuestos;

import java.util.List;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Controller.ControladorCalcularLiquidaciones;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;

public class SistemaPagoImpuestos {
  
    public static void main(String[] args) {
       //  DTOAccionesSistema dtoAccionesSistema = new DTOAccionesSistema();
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
      //  FachadaInterna.getInstance().iniciarTransaccion();
//        DatosPrueba.createOperation();
        //AdaptadorEmpresaClaro c = new AdaptadorEmpresaClaro();
        //c.findComprobantes("test");
      //  FachadaInterna.getInstance().finalizarTransaccion();
        //IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
        //iUPagarImpuesto.show();
        ControladorGestionarLiquidacion.getInstance().iniciar();
       // ControladorCalcularLiquidaciones controlador = new ControladorCalcularLiquidaciones();
        //controlador.iniciar(dtoAccionesSistema);
       // ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
       // controlador.iniciar();
    }
}
