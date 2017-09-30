/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Entity.Dgr;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author mviss
 */
@WebService
public interface DgrWS {
    @WebMethod
    public List<Dgr> findAll();
    
    @WebMethod
    public Dgr find(String id);
//    
    @WebMethod
    public void create(Dgr dgr);
    @WebMethod
    public void update(Dgr dgr);
    
    @WebMethod
    public void delete(Dgr claro);
    
    @WebMethod
    public boolean pagarComprobante(int codigo, double montoPagar);

    @WebMethod
    public List<Dgr> buscarComprobantesCodigo(int codigo);
}
