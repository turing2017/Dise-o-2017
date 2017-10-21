/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOComprobanteUnico;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOItemComprobante;
import sistemapagoimpuestos.Dto.DTOItemComprobantePantalla;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOOperacionActual;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.CuentaBancaria;
import sistemapagoimpuestos.Entity.DetalleOperacion;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.ParametroSistema;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionBanco;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionEmpresa;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author mvissio
 */
public class ExpertoPagarImpuestos {

    protected static TipoImpuesto tipoImpuestoSeleccionado;
    protected static Empresa empresaSeleccionada;

    public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Cliente")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }

    public List<DTOTipoImpuesto> buscarTipoImpuestos() throws Exception {
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("fechaHoraInhabilitacionTipoImpuesto", "IS", null));
        List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        List<DTOTipoImpuesto> lista = new ArrayList<>();
        DTOTipoImpuesto dtoTipoImpuesto;

        for (int i = 0; i < tipoImpuestos.size(); i++) {
            dtoTipoImpuesto = new DTOTipoImpuesto();
            TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestos.get(i);
            String nombreTipoImpuesto = tipoImpuesto.getNombreTipoImpuesto();
            dtoTipoImpuesto.setNombreDTOTipoImpuesto(nombreTipoImpuesto);
            lista.add(dtoTipoImpuesto);
        }
        return lista;
    }

    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto) throws Exception {
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        tipoImpuestoSeleccionado = tipoImpuesto;

        //Busca instancia de EmpresaTipoImpuesto, aplicando el tipo de impuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        List<DTOEmpresa> lista = new ArrayList<>();
        DTOEmpresa dtoEmpresa;
        for (int i = 0; i < eti.size(); i++) {
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eti.get(i);
            if (empresaTipoImpuesto.getEmpresa().getFechaHoraInhabilitacionEmpresa() == null) {
                dtoEmpresa = new DTOEmpresa();
                dtoEmpresa.setNombreEmpresa(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
                lista.add(dtoEmpresa);
            }

        }
        return lista;
    }

    public List<DTOComprobantePantalla> seleccionarEmpresa(String nombreEmpresaIng, String codigoPagoElectronicoIngres) throws Exception {
        List<DTOCriterio> criterioList = new ArrayList();
        criterioList.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresaIng));
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterioList).get(0);
        empresaSeleccionada = empresa;
        criterioList.clear();
        criterioList.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoSeleccionado));
        criterioList.add(new DTOCriterio("empresa", "=", empresaSeleccionada));
        EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioList).get(0);
        List<DTOComprobante> listadoComprobantes = FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(empresaSeleccionada).consultarComprobantes(empresaTI, codigoPagoElectronicoIngres);
        List<DTOComprobantePantalla> comprobantePantallas = new ArrayList<>();
        for (DTOComprobante dtoComprobante : listadoComprobantes) {
            DTOComprobantePantalla comprobantePantalla = new DTOComprobantePantalla(dtoComprobante.getNumeroFactura(),
                    dtoComprobante.getCodigoComprobante(),
                    dtoComprobante.getFechaHoraVencimientoComprobante(),
                    dtoComprobante.getMontoTotalComprobante());
            List<DTOItemComprobantePantalla> comprobantePantallaList = new ArrayList<>();
            for (DTOItemComprobante dtoic : dtoComprobante.getAtributosAdicionalesComprobante()) {
                comprobantePantallaList.add(new DTOItemComprobantePantalla(dtoic.getItem().getCodigoItem(),
                        dtoic.getItem().getNombreItem(),
                        dtoic.getOrden(),
                        dtoic.getValue()));
            }
            comprobantePantalla.setAtributosAdicionalesComprobante(comprobantePantallaList);
            comprobantePantallas.add(comprobantePantalla);
        }
        return comprobantePantallas;
    }

    public boolean isMontoEditable(){
        return tipoImpuestoSeleccionado.isEsMontoEditableTipoImpuesto();
    }

    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente) throws Exception {
        List<DTOCuentaBancaria> listaDTOCuentaBancaria = new ArrayList<DTOCuentaBancaria>();
        ParametroSistema parametroSistema = (ParametroSistema) FachadaPersistencia.getInstance().buscar("ParametroSistema", null).get(0);
        List<DTOCriterio> criteriosList = new ArrayList<>();
        criteriosList.add(new DTOCriterio("cliente", "=", GlobalVars.userActive.cliente));
        List<Object> listaCuentas = FachadaPersistencia.getInstance().buscar("CuentaBancaria", criteriosList);
        for (Object cuentaObject : listaCuentas) {
            CuentaBancaria cuentaTemp = (CuentaBancaria) cuentaObject;

            DTOCuentaBancaria dtoCuentaBancaria = new DTOCuentaBancaria();

            dtoCuentaBancaria.setCbuCuentaBancaria(cuentaTemp.getCbuCuentaBancaria());
            dtoCuentaBancaria.setNombreTipoCuenta(cuentaTemp.getTipoCuenta().getNombreTipoCuenta());
            dtoCuentaBancaria.setNroCuentaBancaria(cuentaTemp.getNroCuentaBancaria());
            dtoCuentaBancaria.setSaldoRecuperado(
                    FactoriaAdaptadorConexionBanco.
                            getInstancia().
                            getAdaptadorConexionBanco(parametroSistema)
                            .consultarSaldo(cuentaTemp.getCbuCuentaBancaria()));
            listaDTOCuentaBancaria.add(dtoCuentaBancaria);
        }
        if (listaDTOCuentaBancaria.size() == 0) {
            throw new ExcepcionGenerica("No se encontraron Cuentas");
        }
        return listaDTOCuentaBancaria;
    }

    public DTOOperacionActual pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, String nroFactura, String codigoPago) throws Exception {
        List<DTOCriterio> criteriosList = new ArrayList<>();
        ParametroSistema parametroSistema = (ParametroSistema) FachadaPersistencia.getInstance().buscar("ParametroSistema", null).get(0);
        FactoriaAdaptadorConexionBanco.getInstancia().getAdaptadorConexionBanco(parametroSistema).debitarSaldo(cbuCuentaSeleccionada, montoAbonado);
        criteriosList.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoSeleccionado));
        criteriosList.add(new DTOCriterio("empresa", "=", empresaSeleccionada));
        EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criteriosList).get(0);
        DTOComprobanteUnico dtoComprobanteUnico = FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(empresaSeleccionada).buscarComprobanteSeleccionado(empresaTI, Integer.parseInt(nroFactura), codigoPago);
        criteriosList.clear();
        criteriosList.add(new DTOCriterio("cbuCuentaBancaria", "=", cbuCuentaSeleccionada));
        CuentaBancaria cuentaBancaria = (CuentaBancaria) FachadaPersistencia.getInstance().buscar("CuentaBancaria", criteriosList).get(0);
        Operacion operacion = new Operacion();
        operacion.setNumeroOperacion((int) new Date().getTime()); // es aleatorio
        operacion.setCodigoPagoElectrionicoOperacion(dtoComprobanteUnico.getCodigoComprobante());
        operacion.setFechaHoraOperacion(new Date());
        operacion.setImportePagadoOperacion(montoAbonado);
        operacion.setLiquidadaOperacion(false);
        operacion.setNroComprobanteFacturaOperacion(dtoComprobanteUnico.getNumeroFactura());
        operacion.setCuentaBancaria(cuentaBancaria);
        operacion.setEmpresa(empresaSeleccionada);
        operacion.setTipoImpuesto(tipoImpuestoSeleccionado);
        operacion.setEmpresaTipoImpuesto(empresaTI);
        List<DTOItemComprobante> listadoItems = dtoComprobanteUnico.getAtributosAdicionalesDTOComprobante();
        List<DetalleOperacion> detalleOperacionList = new ArrayList<>();
        for (DTOItemComprobante dTOItemComprobante : listadoItems) {
            DetalleOperacion detalle = new DetalleOperacion();
            detalle.setValorDetalleOperacion(dTOItemComprobante.getValue());
            criteriosList.clear();
            criteriosList.add(new DTOCriterio("item", "=", dTOItemComprobante.getItem()));
            criteriosList.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTI));
            ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criteriosList).get(0);
            detalle.setItemEmpresaTipoImpuesto(itemEmpresaTipoImpuesto);
            detalleOperacionList.add(detalle);
        }
        operacion.setDetalleOperacionList(detalleOperacionList);
        FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(empresaSeleccionada).confirmarPago(operacion);
        FachadaPersistencia.getInstance().guardar(operacion);
        DTOOperacionActual dtoOperacion = new DTOOperacionActual(operacion.getNumeroOperacion(),
                operacion.getCodigoPagoElectrionicoOperacion(), 
                operacion.getFechaHoraOperacion(), 
                operacion.getImportePagadoOperacion(), 
                operacion.getNroComprobanteFacturaOperacion(),
                operacion.getEmpresa().getNombreEmpresa(), 
                operacion.getTipoImpuesto().getNombreTipoImpuesto());
        return dtoOperacion;

    }
}
