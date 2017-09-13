package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.ComprobantePago;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 *
 * @author Markz
 */
@WebService
public interface BuscarComprobantesPagoWS {
    @WebMethod
    public List<ComprobantePago> buscarComprobantesPago();
}
