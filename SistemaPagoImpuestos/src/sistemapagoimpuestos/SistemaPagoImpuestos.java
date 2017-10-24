package sistemapagoimpuestos;

import sistemapagoimpuestos.View.Login.IULogin;


public class SistemaPagoImpuestos {
  
    public static void main(String[] args) {
        
        IULogin iULogin = new IULogin();
        iULogin.setVisible(true);  
        
    }

}

//
//package sistemapagoimpuestos;
//
//import java.util.ArrayList;
//import sistemapagoimpuestos.Controller.ControladorCalcularLiquidaciones;
//import sistemapagoimpuestos.Dto.DTOAccionesSistema;
//
//
//public class SistemaPagoImpuestos {
//  
//    public static void main(String[] args) {
//        
//        ControladorCalcularLiquidaciones controlador = new ControladorCalcularLiquidaciones();
//        ArrayList<DTOAccionesSistema> dtosAccionesSistema = new ArrayList<>();
//        controlador.iniciar(dtosAccionesSistema);
//        for (int i = 0; i < dtosAccionesSistema.size(); i++) {
//            dtosAccionesSistema.get(i).imprimirSTD();   
//        }
//    }
//}