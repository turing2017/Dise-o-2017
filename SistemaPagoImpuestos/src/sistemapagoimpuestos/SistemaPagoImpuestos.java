
package sistemapagoimpuestos;


/**
 *
 * @author Markz
 */
import datosPrueba.DatosPrueba;
import java.util.List;
import sistemapagoimpuestos.Controller.ControladorLoguearUsuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.MetodosPantalla;
import sistemapagoimpuestos.View.Login.IULogin;
import sistemapagoimpuestos.classws.BuscarComprobantesImpPagolWSService;
import sistemapagoimpuestos.classws.BuscarComprobantesPagoWS;
import sistemapagoimpuestos.classws.ComprobantePago;


public class SistemaPagoImpuestos {

   
    public static void main(String[] args) {
        
        BuscarComprobantesPagoWS bcp = new BuscarComprobantesImpPagolWSService().getBuscarComprobantesImpPagolWSPort();
        List<ComprobantePago> listObj = bcp.buscarComprobantesPago();
        System.out.println(listObj);
    /*    FachadaInterna.getInstance().iniciarTransaccion();
        DatosPrueba.createOperation();
        FachadaInterna.getInstance().finalizarTransaccion();
        ControladorLoguearUsuario.getInstance().iniciar();
    */}
}
