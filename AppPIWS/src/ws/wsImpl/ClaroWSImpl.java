/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.wsImpl;

import dao.ClaroModel;
import Entity.Claro;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author mviss
 */
@WebService(endpointInterface = "ws.ClaroWS")
public class ClaroWSImpl implements ws.ClaroWS{

    @Override
    public List<Claro> findAll() {
        ClaroModel cm = new ClaroModel();
        return cm.findAll();
    }

    @Override
    public Claro find(String id) {
        ClaroModel cm = new ClaroModel();
        return cm.find(id);
    }

    @Override
    public void create(Claro claro) {
        ClaroModel cm = new ClaroModel();
        cm.create(claro);
    }

    @Override
    public void update(Claro claro) {
        ClaroModel cm = new ClaroModel();
        cm.update(claro);
    }

    @Override
    public void delete(Claro claro) {
        ClaroModel cm = new ClaroModel();
        cm.delete(claro);
    }    

    @Override
    public boolean pagarComprobante(String codigo, double montoPagar) {
        ClaroModel cm = new ClaroModel();
        return false;
    }

    @Override
    public List<Claro> buscarComprobantesCodigo(String codigo) {
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
    
}
