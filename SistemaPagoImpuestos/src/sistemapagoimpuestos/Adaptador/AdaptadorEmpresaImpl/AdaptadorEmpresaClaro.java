/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresa;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOComprobanteUnico;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
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
public class AdaptadorEmpresaClaro implements AdaptadorEmpresa {

    EmpresasWSImplService wsImplService
            = new EmpresasWSImplService();
    EmpresasWS claroWs;

    public AdaptadorEmpresaClaro() {
        claroWs = wsImplService.getEmpresasWSImplPort();
    }

    @Override
    public List<DTOComprobante> consultarComprobantes(EmpresaTipoImpuesto empresaTipoImpuesto, String codigoPagoElectronicoIngres) throws Exception {
        List<DTOComprobante> dTOComprobanteList = new ArrayList<>();
        List<Claro> listClaro = claroWs.buscarComprobantesCodigoClaro(codigoPagoElectronicoIngres);
        for (Claro claro : listClaro) {
            DTOComprobante comprobante = new DTOComprobante();
            comprobante.setCodigoDTOComprobante(claro.getCodigo());
            comprobante.setFechaHoraVencimientoDTOComprobante(claro.getVencimiento().toGregorianCalendar().getTime());
            comprobante.setMontoTotalDTOComprobante(claro.getMontoTotal());
            comprobante.setNumeroFactura(claro.getNroFactura());
            comprobante.setAtributosAdicionalesDTOComprobante(buscarItems(empresaTipoImpuesto, claro));
            dTOComprobanteList.add(comprobante);
        }
        return dTOComprobanteList;

    }

    public List<DTOItem> buscarItems(EmpresaTipoImpuesto empresaTipoImpuesto, Claro claro) throws Exception {
        List<DTOCriterio> criterioList = new ArrayList<>();
        criterioList.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        List<Object> itemEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioList);
        List<DTOItem> dTOItems = new ArrayList<>();
        for (Object object : itemEmpresaTipoImpuesto) {
            ItemEmpresaTipoImpuesto ieti = (ItemEmpresaTipoImpuesto) object;
            DTOItem dTOItem = new DTOItem().ConvertDto((Item) ieti.getItem());
            dTOItems.add(dTOItem);
            switch (ieti.getItem().getNombreItem()) {
                case "Nombre Servicio":
                    dTOItem.setItemVal(claro.getNombreServicio());
                    break;
                case "Status":
                    dTOItem.setItemVal(claro.getStatus());
                    break;
                case "Numero de Telefono":
                    dTOItem.setItemVal(claro.getNroTelefono().toString());
                    break;
                case "Monto Minimo":
                    dTOItem.setItemVal(claro.getMontoMinimo().toString());
                    break;
            }
        }
        return dTOItems;
    }

    @Override
    public DTOComprobanteUnico buscarComprobanteSeleccionado(EmpresaTipoImpuesto empresaTipoImpuesto, int nroFactura, String codigoPago) throws Exception {
        Claro claroComprobante = claroWs.findForCodeClaro(Integer.toString(nroFactura));
        return new DTOComprobanteUnico(claroComprobante.getNroFactura(),
                claroComprobante.getCodigo(),
                claroComprobante.getVencimiento().toGregorianCalendar().getTime(),
                claroComprobante.getMontoTotal(),
                buscarItems(empresaTipoImpuesto, claroComprobante));
    }

    @Override
    public void confirmarPago(Operacion operacion) throws Exception {
        if (!claroWs.acreditarPagoClaro(Integer.toString(operacion.getNroComprobanteFacturaOperacion()), operacion.getCodigoPagoElectrionicoOperacion(), operacion.getImportePagadoOperacion()).equals("Pago Aprobado")) {
            throw new ExcepcionGenerica("No se pudo confirmar el pago.");
        }
    }
}
