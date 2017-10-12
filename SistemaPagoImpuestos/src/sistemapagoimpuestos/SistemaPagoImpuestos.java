package sistemapagoimpuestos;


import java.util.List;
import sistemapagoimpuestos.Controller.ControladorCalcularLiquidaciones;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Controller.ControladorGestionarLiquidacion;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;

import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.View.User.IUPagarImpuesto;


public class SistemaPagoImpuestos {
  
    public static void main(String[] args) {
       
        //  DTOAccionesSistema dtoAccionesSistema = new DTOAccionesSistema();
       // ControladorGestionarLiquidacion.getInstance().iniciar();
       // ControladorCalcularLiquidaciones controlador = new ControladorCalcularLiquidaciones();
        //controlador.iniciar(dtoAccionesSistema);
       // ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
       // controlador.iniciar();
   
        ControladorGestionarLiquidacion controlador = new ControladorGestionarLiquidacion();
        controlador.iniciar();

    }
}
