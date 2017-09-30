/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador;


import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;

/**
 *
 * @author mviss
 */
public class AdaptadorEmpresaDgr {
    /*
    public List<DTOComprobante> findComprobantes(String codigoComprobante){
        DgrWSImplService dgrWSImplService =
                new DgrWSImplService();
            DgrWS claroWs = dgrWSImplService.getDgrWSImplPort();
            List<> listClaro = claroWs.buscarComprobantesCodigo(codigoComprobante);
            List<DTOComprobante> dTOComprobanteList =  new ArrayList<>();
            for (Claro claro : listClaro) {
                DTOComprobante comprobante = new DTOComprobante();
                comprobante.setCodigoDTOComprobante(claro.getCodigo());
                comprobante.setFechaHoraVencimientoDTOComprobante(claro.getVencimiento().toGregorianCalendar().getTime());
                comprobante.setMontoTotalDTOComprobante(claro.getMontoTotal());
                comprobante.setAtributosAdicionalesDTOComprobante(buscarItems("Claro"));
                dTOComprobanteList.add(comprobante);
            }
        return dTOComprobanteList;
    }
    
    
    public List<DTOItem> buscarItems(String nombreEmpresa){
        List<DTOCriterio> criterioList = new ArrayList<>();
        criterioList.add(new DTOCriterio("nombreTipoDatoItem", "=", nombreEmpresa));             
        TipoDatoItem datoItem = (TipoDatoItem) FachadaPersistencia.getInstance().buscar("TipoDatoItem", criterioList).get(0);
        criterioList.clear();
        criterioList.add(new DTOCriterio("tipoDatoItem", "=", datoItem));
        List<Object> itemList = FachadaPersistencia.getInstance().buscar("Item", criterioList);
        List<DTOItem> dTOItems = new ArrayList<>();
        for(Object objec : itemList){
            dTOItems.add(new DTOItem().ConvertDto((Item) objec));
        }
        return dTOItems;
    }*/
}
