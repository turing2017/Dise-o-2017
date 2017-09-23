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
import entity.AtributoAdicional;

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
        List<AtributoAdicional> atributoAdicionalList = new ArrayList<>();
        atributoAdicionalList.add(new AtributoAdicional("atributo 1", "2.5"));
        atributoAdicionalList.add(new AtributoAdicional("atributo 2", "12.5"));
        atributoAdicionalList.add(new AtributoAdicional("iva", "21"));

        comprobantePagos.add(new ComprobantePago(null, 1, 2.4, atributoAdicionalList));
        return comprobantePagos;
    }
    
}
