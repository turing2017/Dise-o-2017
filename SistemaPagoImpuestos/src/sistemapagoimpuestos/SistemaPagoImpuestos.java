package sistemapagoimpuestos;

import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;

public class SistemaPagoImpuestos {
  
    public static void main(String[] args) {
        //generarDatosPrueba();
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
//        FachadaInterna.getInstance().iniciarTransaccion();
//        DatosPrueba.createOperation();
//        FachadaInterna.getInstance().finalizarTransaccion();

        ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
        controlador.iniciar();
    }
}
