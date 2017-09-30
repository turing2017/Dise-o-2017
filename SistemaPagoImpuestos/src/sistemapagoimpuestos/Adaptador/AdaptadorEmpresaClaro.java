/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoDatoItem;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import ws.empresas.Claro;
import ws.empresas.EmpresasWS;
import ws.empresas.EmpresasWSImplService;

/**
 *
 * @author mviss
 */
public class AdaptadorEmpresaClaro {

    public List<DTOComprobante> findComprobantes(String tipoImpuesto, String nombreEmpresa, String codigoPagoElectronicoIngres) {
        EmpresasWSImplService wsImplService
                = new EmpresasWSImplService();
        EmpresasWS claroWs = wsImplService.getEmpresasWSImplPort();
        List<Claro> listClaro = claroWs.buscarComprobantesCodigoClaro(codigoPagoElectronicoIngres);
        List<DTOComprobante> dTOComprobanteList = new ArrayList<>();
        for (Claro claro : listClaro) {
            DTOComprobante comprobante = new DTOComprobante();
            comprobante.setCodigoDTOComprobante(claro.getCodigo());
            comprobante.setFechaHoraVencimientoDTOComprobante(claro.getVencimiento().toGregorianCalendar().getTime());
            comprobante.setMontoTotalDTOComprobante(claro.getMontoTotal());

            comprobante.setAtributosAdicionalesDTOComprobante(buscarItems(tipoImpuesto, nombreEmpresa, claro));
            dTOComprobanteList.add(comprobante);
        }
        return dTOComprobanteList;
    }

    public List<DTOItem> buscarItems(String tipoImpuesto, String nombreEmpresa, Claro claro) {
        List<DTOCriterio> criterioList = new ArrayList<>();
        criterioList.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresa));
        Empresa empresaTemp = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterioList).get(0);
        criterioList.clear();
        criterioList.add(new DTOCriterio("nombreTipoImpuesto", "=", tipoImpuesto));
        TipoImpuesto tipoImpuestoTemp = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioList).get(0);
        criterioList.clear();
        criterioList.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoTemp));
        criterioList.add(new DTOCriterio("empresa", "=", empresaTemp));
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioList).get(0);
        criterioList.clear();
        criterioList.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        List<Object> itemEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioList);
        List<DTOItem> dTOItems = new ArrayList<>();
        for (Object object : itemEmpresaTipoImpuesto) {
            ItemEmpresaTipoImpuesto ieti = (ItemEmpresaTipoImpuesto) object;
            DTOItem dTOItem = new DTOItem().ConvertDto((Item) ieti.getItem());
            dTOItems.add(dTOItem);
            switch (ieti.getOrdenItemEmpresaTipoImpuesto()) {
                case 1:
                    dTOItem.setItemVal(claro.getNombreServicio());
                    break;
                case 2:
                    dTOItem.setItemVal(claro.getStatus());
                    break;
                case 3:
                    dTOItem.setItemVal(claro.getNroTelefono().toString());
                    break;
                case 4:
                    dTOItem.setItemVal(claro.getMontoMinimo().toString());
                    break;
            }
        }
        return dTOItems;
    }
}
