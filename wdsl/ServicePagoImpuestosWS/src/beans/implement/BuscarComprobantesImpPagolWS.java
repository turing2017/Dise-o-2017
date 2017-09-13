/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.implement;

import entity.ComprobantePago;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import beans.BuscarComprobantesPagoWS;

/**
 *
 * @author Markz
 */
@Stateless
@WebService(endpointInterface = "beans.BuscarComprobantesPagoWS")
public class BuscarComprobantesImpPagolWS implements BuscarComprobantesPagoWS{

    @Override
    public List<ComprobantePago> buscarComprobantesPago() {
        List<ComprobantePago> comprobantePagos = new ArrayList<>();
        comprobantePagos.add(new ComprobantePago(null, 1, 2.4, null));
        return comprobantePagos;
    }
    
}
