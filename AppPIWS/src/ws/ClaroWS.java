/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Entity.Claro;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author mviss
 */
@WebService
public interface ClaroWS {
    @WebMethod
    public List<Claro> findAll();
    
    @WebMethod
    public Claro find(String id);
//    
    @WebMethod
    public void create(Claro claro);
    @WebMethod
    public void update(Claro claro);
    
    @WebMethod
    public void delete(Claro claro);
    
    @WebMethod
    public boolean pagarComprobante(String codigo, double montoPagar);

    @WebMethod
    public List<Claro> buscarComprobantesPago(String comprobante);
    
    @WebMethod
    public List<Claro> buscarComprobantesCodigo(String codigo);
}
