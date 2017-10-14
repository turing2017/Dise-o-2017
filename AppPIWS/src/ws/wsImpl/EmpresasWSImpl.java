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
public class EmpresasWSImpl implements EmpresasWS {

    @Override
    public List<Dgr> findAllDgr() {
        return new DgrModel().findAll();
    }
 
    @Override
    public List<Claro> findAllClaro() {
        ClaroModel cm = new ClaroModel();
        return cm.findAll();
    }

    @Override
    public Dgr findForCodeDgr(String code) {
        return new DgrModel().find(code);
    }


    @Override
    public Claro findForCodeClaro(String code) {
        return new ClaroModel().find(code);
    }

    
    @Override
    public List<Claro> buscarComprobantesCodigoClaro(String codigo) {
        ClaroModel cm = new ClaroModel();
        List<Claro> listClaro = cm.findAll();
        List<Claro> comprobantes = new ArrayList<>();
        for (Claro claro : listClaro) {
            if (claro.getCodigo().equals(codigo) && claro.getStatus().equals("Pendiente")) {
                comprobantes.add(claro);
            }
        }
        return comprobantes;
    }
    
    @Override
    public List<Dgr> buscarComprobantesCodigoDgr(int codigo) {
        DgrModel dm = new DgrModel();
        List<Dgr> listDgr = dm.findAll();
        List<Dgr> comprobantes = new ArrayList<>();
        for (Dgr dgr : listDgr) {
            if (dgr.getCodigoImpuesto() == codigo) {
                comprobantes.add(dgr);
            }
        }
        return comprobantes;
    }


    @Override
    public double obtenerSaldo(String cbu) {
        CuentaClienteModel ccm = new CuentaClienteModel();
        List<CuentaCliente> listCuentaCliente = ccm.findAll();
        double saldo = 0;
        for (CuentaCliente cc : listCuentaCliente) {
            if (cbu.equals(cc.getCbu())
                    && cc.isActivo()) {
                saldo = (cc.getMonto()>0)?cc.getMonto():0;
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
            cc.setMonto(cc.getMonto() - monto);
            ccm.update(cc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean acreditarPagoDgr(String nroFactura, String codigoCP, double monto) {
        try {
            DgrModel dm = new DgrModel();
            List<Dgr> dgrList = dm.findAll();
            Dgr dgr = new Dgr();
            for (Dgr dgrTemp : dgrList) {
                if (Integer.parseInt(nroFactura)==dgrTemp.getNroFactura()) {
                    dgrTemp.setMontoPagar(monto);
                    dgrTemp.setStatus("Pagado");
                    dgrTemp.setCodigoCP(codigoCP);
                    dgr = dgrTemp;
                    break;
                }
            }
            dm.update(dgr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String acreditarPagoClaro(String nroFactura, String codigoCP, double monto) {
        try {
            ClaroModel cm = new ClaroModel();
            List<Claro> claroList = cm.findAll();
            Claro c = new Claro();
            for (Claro claro : claroList) {
                if (Integer.parseInt(nroFactura)==claro.getNroFactura()) {
                    claro.setMontoPagado(monto);
                    claro.setStatus("Pagado");
                    claro.setCodigoCP(codigoCP);
                    c = claro;
                    break;
                }
            }
            cm.update(c);
            return "Pago Aprobado";
        } catch (Exception e) {
            return "Pago No Aprobado";
        }
    }

}
