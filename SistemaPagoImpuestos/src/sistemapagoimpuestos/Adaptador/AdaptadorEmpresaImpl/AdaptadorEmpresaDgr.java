/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl;


import exceptions.ExcepcionGenerica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresa;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOComprobanteUnico;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import ws.empresas.Dgr;
import ws.empresas.EmpresasWS;
import ws.empresas.EmpresasWSImplService;

/**
 *
 * @author mviss
 */
public class AdaptadorEmpresaDgr implements AdaptadorEmpresa{
    
    EmpresasWSImplService wsImplService
                = new EmpresasWSImplService();
        EmpresasWS dgrWs;
        
        public AdaptadorEmpresaDgr(){
            dgrWs = wsImplService.getEmpresasWSImplPort();
        }

    @Override
    public List<DTOComprobante> consultarComprobantes(EmpresaTipoImpuesto empresaTipoImpuesto, String codigoPagoElectronicoIngres) throws Exception{
        List<Dgr> listDgr = dgrWs.buscarComprobantesCodigoDgr(Integer.parseInt(codigoPagoElectronicoIngres));
        List<DTOComprobante> dTOComprobanteList = new ArrayList<>();
        for (Dgr dgr : listDgr) {
            DTOComprobante comprobante = new DTOComprobante();
            comprobante.setCodigoDTOComprobante(Integer.toString(dgr.getCodigoImpuesto()));
            comprobante.setFechaHoraVencimientoDTOComprobante(dgr.getPrimerVencimiento().toGregorianCalendar().getTime());
            comprobante.setMontoTotalDTOComprobante(dgr.getMontoPagar());
            comprobante.setNumeroFactura(dgr.getNroFactura());
            comprobante.setAtributosAdicionalesDTOComprobante(buscarItems(empresaTipoImpuesto, dgr));
            dTOComprobanteList.add(comprobante);
        }
        return dTOComprobanteList;
    }

    @Override
    public DTOComprobanteUnico buscarComprobanteSeleccionado(EmpresaTipoImpuesto empresaTipoImpuesto, int nroFactura, String codigoPago) throws Exception{
        Dgr dgrComprobante = dgrWs.findForCodeDgr(Integer.toString(nroFactura));
        return new DTOComprobanteUnico(dgrComprobante.getNroFactura(),
                Integer.toString(dgrComprobante.getCodigoImpuesto()),
                dgrComprobante.getPrimerVencimiento().toGregorianCalendar().getTime(),
                dgrComprobante.getMontoPagar(),
                buscarItems(empresaTipoImpuesto, dgrComprobante));
    }

    
    
    @Override
    public void confirmarPago(Operacion operacion) throws Exception{
        if (!dgrWs.acreditarPagoDgr(Integer.toString(operacion.getNroComprobanteFacturaOperacion()), operacion.getCodigoPagoElectrionicoOperacion(), operacion.getImportePagadoOperacion())) {
            throw new ExcepcionGenerica("No se pudo confirmar el pago.");
        }
    }
    
    public List<DTOItem> buscarItems(EmpresaTipoImpuesto empresaTipoImpuesto, Dgr dgr) throws Exception{
        List<DTOCriterio> criterioList = new ArrayList<>();
        criterioList.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        List<Object> itemEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioList);
        List<DTOItem> dTOItems = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Object object : itemEmpresaTipoImpuesto) {
            ItemEmpresaTipoImpuesto ieti = (ItemEmpresaTipoImpuesto) object;
            DTOItem dTOItem = new DTOItem().ConvertDto((Item) ieti.getItem());
            dTOItems.add(dTOItem);
            switch (ieti.getItem().getNombreItem()) {
                case "Nombre Impuesto":
                    dTOItem.setItemVal(dgr.getNombreImpuesto());
                    break;
                case "Status":
                    dTOItem.setItemVal(dgr.getStatus());
                    break;
                case "Fecha Segundo Vencimiento":
                    dTOItem.setItemVal(sdf.format(dgr.getSegundoVencimiento().toGregorianCalendar().getTime()));
                    break;
            }
        }
        return dTOItems;
    }
}
