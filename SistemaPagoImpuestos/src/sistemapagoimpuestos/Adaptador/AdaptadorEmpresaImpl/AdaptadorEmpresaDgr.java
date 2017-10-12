/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl;


import java.util.List;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresa;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;

/**
 *
 * @author mviss
 */
public class AdaptadorEmpresaDgr implements AdaptadorEmpresa{

    @Override
    public List<DTOComprobante> consultarComprobantes(EmpresaTipoImpuesto empresaTipoImpuesto, String codigoPagoElectronicoIngres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean confirmarPago(String nroFactura, Integer codigoCP, double monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
