package sistemapagoimpuestos;


import java.util.ArrayList;
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
       
        ArrayList<DTOAccionesSistema> dtoAcciones =new ArrayList();
      //  ControladorCalcularLiquidaciones controlador = new ControladorCalcularLiquidaciones();
       // dtoAcciones = controlador.iniciar(dtoAcciones);
        
       // for ( DTOAccionesSistema dtoAccion : dtoAcciones){
       ///     dtoAccion.imprimirSTD();
      //  }
    
      
       //ControladorCalcularLiquidaciones controlador = new ControladorCalcularLiquidaciones();
       ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
       controlador.iniciar();  /*
       ControladorGestionarLiquidacion controlador = new ControladorGestionarLiquidacion();
       controlador.iniciar();
       */
    }
}
