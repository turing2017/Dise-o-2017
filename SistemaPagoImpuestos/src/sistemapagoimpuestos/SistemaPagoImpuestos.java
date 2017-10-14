package sistemapagoimpuestos;

import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Controller.ControladorPagarImpuestos;
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
        //ControladorGestionarLiquidacion controlador = new ControladorGestionarLiquidacion();
        //controlador.iniciar();
        ControladorPagarImpuestos controladorPagarImpuestos = new ControladorPagarImpuestos();
        IUPagarImpuesto iUPagarImpuesto = new IUPagarImpuesto();
        iUPagarImpuesto.setVisible(true);
    }
}
