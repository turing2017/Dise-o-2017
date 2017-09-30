/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.wsImpl;

import Dao.CuentaClienteModel;
import Dao.DgrModel;
import Entity.Claro;
import Entity.CuentaCliente;
import Entity.Dgr;
import dao.ClaroModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import ws.EmpresasWS;

/**
 *
 * @author mviss
 */
@WebService(endpointInterface = "ws.EmpresasWS")
public class EmpresasWSImpl implements EmpresasWS{

    @Override
    public List<Dgr> findAllDgr() {
        return new DgrModel().findAll();
    }

    @Override
    public Dgr findForCodeDgr(String code) {
        return new DgrModel().find(code);
    }

    @Override
    public List<Claro> findAllClaro() {
        ClaroModel cm = new ClaroModel();
        return cm.findAll();
    }

    @Override
    public Claro findForCodeClaro(String code) {
        ClaroModel cm = new ClaroModel();
        return cm.find(code);
    }

    @Override
    public boolean pagarComprobanteDgr(int codigo, double montoPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dgr> buscarComprobantesCodigoDgr(int codigo) {
        DgrModel dm = new DgrModel();
        List<Dgr> listDgr = dm.findAll();
        List<Dgr> comprobantes = new ArrayList<>();
        for(Dgr dgr : listDgr){
            if(dgr.getCodigoImpuesto()==codigo){
                comprobantes.add(dgr);
            }
        }
        return comprobantes;    
    }

    @Override
    public boolean pagarComprobanteClaro(int codigo, double montoPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Claro> buscarComprobantesCodigoClaro(String codigo) {
        ClaroModel cm = new ClaroModel();
        List<Claro> listClaro = cm.findAll();
        List<Claro> comprobantes = new ArrayList<>();
        for(Claro claro : listClaro){
            if(claro.getCodigo().equals(codigo)){
                comprobantes.add(claro);
            }
        }
        return comprobantes;
    }

    @Override
    public CuentaCliente buscarCuentas(String tipoCuenta, String cbu) {
        CuentaClienteModel ccm = new CuentaClienteModel();
        List<CuentaCliente> listCuentaCliente = ccm.findAll();
        CuentaCliente cuentaCliente = new CuentaCliente();     
        for(CuentaCliente cc : listCuentaCliente){
            if(tipoCuenta.equals(cc.getTipoCuenta())&&tipoCuenta.equals(cc.getCbu())){
                cuentaCliente = cc;
                break;
            }
        }
        return cuentaCliente;
    }

    @Override
    public double debitarMonto(String cbu, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double acreditarPagoDgr(String codigo, Date vencimiento, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double acreditarPagoClaro(String codigo, Date vencimiento, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
