/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import sistemapagoimpuestos.classws.BuscarComprobantesImpPagolWSService;
import sistemapagoimpuestos.classws.BuscarComprobantesPago;
import sistemapagoimpuestos.classws.BuscarComprobantesPagoWS;

/**
 *
 * @author mvissio
 */
public class ExpertoPagarImpuestos {
    //public 
    
    public void buscarComprobantePago(){
        BuscarComprobantesPagoWS bcp = new BuscarComprobantesImpPagolWSService().getBuscarComprobantesImpPagolWSPort();
        System.out.println(bcp.buscarComprobantesPago());
    }
}
