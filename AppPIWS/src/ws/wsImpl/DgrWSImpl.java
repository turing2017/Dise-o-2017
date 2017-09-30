/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.wsImpl;

import Dao.DgrModel;
import Entity.Dgr;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import ws.DgrWS;

/**
 *
 * @author mviss
 */
@WebService(endpointInterface = "ws.DgrWS")
public class DgrWSImpl implements DgrWS{

    @Override
    public List<Dgr> findAll() {
        return new DgrModel().findAll();
    }

    @Override
    public Dgr find(String id) {
        return new DgrModel().find(id);
    }

    @Override
    public void create(Dgr dgr) {
        new DgrModel().create(dgr);
    }

    @Override
    public void update(Dgr dgr) {
        new DgrModel().update(dgr);
    }

    @Override
    public void delete(Dgr dgr) {
        new DgrModel().delete(dgr);
    }

    @Override
    public boolean pagarComprobante(int codigo, double montoPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dgr> buscarComprobantesCodigo(int codigo) {
        DgrModel dm = new DgrModel();
        List<Dgr> listDgr = dm.findAll();
        List<Dgr> comprobantes = new ArrayList<>();
        for(Dgr dgr : listDgr){
            if(dgr.getCodigoImpuesto()==codigo){
                comprobantes.add(dgr);
            }
        }
        return comprobantes;    }
    
}
