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
import sistemapagoimpuestos.Dto.DTOItemComprobante;
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
            comprobante.setCodigoComprobante(claro.getCodigo());
            comprobante.setFechaHoraVencimientoComprobante(claro.getVencimiento().toGregorianCalendar().getTime());
            comprobante.setMontoTotalComprobante(claro.getMontoTotal());
            comprobante.setNumeroFactura(claro.getNroFactura());
            comprobante.setAtributosAdicionalesComprobante(buscarItems(empresaTipoImpuesto, claro));
            dTOComprobanteList.add(comprobante);
        }
        return dTOComprobanteList;

    }

    public List<DTOItemComprobante> buscarItems(EmpresaTipoImpuesto empresaTipoImpuesto, Claro claro) throws Exception {
        List<DTOCriterio> criterioList = new ArrayList<>();
        criterioList.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        List<Object> itemEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioList);
        List<DTOItemComprobante> dTOItemsComprobanteList = new ArrayList<>();
        for (Object object : itemEmpresaTipoImpuesto) {
            ItemEmpresaTipoImpuesto ieti = (ItemEmpresaTipoImpuesto) object;
            DTOItemComprobante dTOItemComprobante = new DTOItemComprobante();
            dTOItemComprobante.setItem(ieti.getItem());
            dTOItemComprobante.setOrden(ieti.getOrdenItemEmpresaTipoImpuesto());
            switch (ieti.getItem().getNombreItem()) {
                case "Nombre Servicio":
                    dTOItemComprobante.setValue(claro.getNombreServicio());
                    break;
                case "Status":
                    dTOItemComprobante.setValue(claro.getStatus());
                    break;
                case "Numero de Telefono":
                    dTOItemComprobante.setValue(claro.getNroTelefono().toString());
                    break;
                case "Monto Minimo":
                    dTOItemComprobante.setValue(claro.getMontoMinimo().toString());
                    break;
            }
            dTOItemsComprobanteList.add(dTOItemComprobante);
        }
        return dTOItemsComprobanteList;
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
