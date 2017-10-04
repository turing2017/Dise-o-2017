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
import java.text.SimpleDateFormat;
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
    public double obtenerSaldo(String cbu) {
        CuentaClienteModel ccm = new CuentaClienteModel();
        List<CuentaCliente> listCuentaCliente = ccm.findAll();
        double saldo = 0;
        for(CuentaCliente cc : listCuentaCliente){
            if(cbu.equals(cc.getCbu())
                    &&cc.isActivo()){
                saldo = cc.getMonto();
                break;
            }
        }
        return saldo;
    }

    @Override
    public boolean debitarMonto(String cbu, double monto) {
        try {
            CuentaClienteModel ccm = new CuentaClienteModel();
            CuentaCliente cc = ccm.find(cbu);
            cc.setMonto(cc.getMonto()-monto);
            ccm.update(cc);        
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean acreditarPagoDgr(String codigo, Date vencimiento, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean acreditarPagoClaro(String codigo, Date vencimiento, double monto) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ClaroModel cm = new  ClaroModel();
            List<Claro> claroList = cm.findAll();
            Claro c = new Claro();
            for (Claro claro : claroList) {
                String date1 = sdf.format(claro.getVencimiento());
                String date2 = sdf.format(vencimiento);
                if(codigo.equals(claro.getCodigo())
                        &&date1
                                .equals(date2)){
                    claro.setMontoPagado(monto);
                    c=claro;
                    break;
                }
            }
            cm.update(c);        
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
