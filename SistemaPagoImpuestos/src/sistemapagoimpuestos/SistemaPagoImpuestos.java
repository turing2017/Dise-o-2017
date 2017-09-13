
package sistemapagoimpuestos;


import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;


public class SistemaPagoImpuestos {

    static ControladorLoguearUsuario controlador = new ControladorLoguearUsuario();
   
    public static void main(String[] args) {

        //generarDatosPrueba();
        //ControladorGestionarTipoDeCuenta.getInstance().iniciar();
        //ControladorGestionarEmpresaTipoImpuesto.getInstance().iniciar();
//        FachadaInterna.getInstance().iniciarTransaccion();
//        DatosPrueba.createOperation();
//        FachadaInterna.getInstance().finalizarTransaccion();
        controlador.iniciar();
    }
}
