/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Entity.Claro;
import Entity.Dgr;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author mviss
 */
@WebService
public interface EmpresasWS {
    @WebMethod
    public List<Dgr> findAllDgr();
    
    @WebMethod
    public Dgr findForCodeDgr(String code);
    
    @WebMethod
    public List<Claro> findAllClaro();
    
    @WebMethod
    public Claro findForCodeClaro(String code);
    
    @WebMethod
    public boolean pagarComprobanteDgr(int codigo, double montoPagar);

    @WebMethod
    public List<Dgr> buscarComprobantesCodigoDgr(int codigo);    
    
    @WebMethod
    public boolean pagarComprobanteClaro(int codigo, double montoPagar);

    @WebMethod
    public List<Claro> buscarComprobantesCodigoClaro(String codigo);    
    
}
