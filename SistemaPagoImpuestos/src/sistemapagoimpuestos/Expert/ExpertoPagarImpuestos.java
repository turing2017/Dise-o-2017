/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import sistemapagoimpuestos.Adaptador.AdaptadorBanco;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoCuenta;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Cliente;
import sistemapagoimpuestos.Entity.CuentaBancaria;
import sistemapagoimpuestos.Entity.DetalleOperacion;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.ParametroSistema;
import sistemapagoimpuestos.Entity.TipoCuenta;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionBanco;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionEmpresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author mvissio
 */
public class ExpertoPagarImpuestos {
    
    private AdaptadorEmpresaClaro adaptadorEmpresaClaro;
    private AdaptadorBanco adaptadorBanco;
    private TipoImpuesto tipoImpuesto;
    
        // Método para recuperar los TipoDatoItem
        public List<DTOTipoImpuesto> buscarTipoImpuestos(){
            //Busqueda de todos los TipoImpuesto (sin criterios)
            List tipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", null);
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
    
    // Método para recuperar la Empresa
    public List<DTOEmpresa> buscarEmpresas(String nombreTipoImpuesto){
            
        //Busca instancia de TipoImpuesto
        List<DTOCriterio> criterioTipoImpuesto = new ArrayList();
        criterioTipoImpuesto.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
        List ti = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTipoImpuesto);
        TipoImpuesto tipoImpuesto = (TipoImpuesto) ti.get(0);
        
        // Necesito recordar el tipo de impuesto
        setTipoImpuesto(tipoImpuesto);
        
        //Busca instancia de EmpresaTipoImpuesto, aplicando el tipo de impuesto como criterio
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        List<DTOEmpresa> lista = new ArrayList<>();
        DTOEmpresa dtoEmpresa;
        
        // Recorro los empresaTipoImpuesto, obteniendo las Empresas
        for (int i = 0; i < eti.size(); i++) {
            dtoEmpresa = new DTOEmpresa();
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eti.get(i);
            dtoEmpresa.setNombreEmpresa(empresaTipoImpuesto.getEmpresa().getNombreEmpresa());
            lista.add(dtoEmpresa);
        }     
        return lista;
    }
    
    // Recupera cuentas y saldos del cliente
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente){
        
        List<DTOCuentaBancaria> listaDTOCuentaBancaria = new ArrayList<DTOCuentaBancaria>();
        
        // Busco los parámetros del sistema
        ParametroSistema parametroSistema = (ParametroSistema) FachadaPersistencia.getInstance().buscar("ParametroSistema", null).get(0);
        // En base al parametro del sistema creo el adaptador del banco
        setAdaptadorBanco((AdaptadorBanco)FactoriaAdaptadorConexionBanco.getInstancia().getAdaptadorConexionBanco(parametroSistema));

        // Busco el Cliente por cuil
        List<DTOCriterio> criteriosCliente = new ArrayList<>();
        DTOCriterio criterioCuil = new DTOCriterio("cuilCuitCliente", "=", cuilCliente);
        criteriosCliente.add(criterioCuil);
        Cliente cliente = (Cliente)FachadaPersistencia.getInstance().buscar("Cliente", criteriosCliente).get(0);
        
        // Busco cuentas bancaria por cliente
        List<DTOCriterio> criteriosCuenta = new ArrayList<>();
        DTOCriterio criterioCliente = new DTOCriterio("cliente", "=", cliente);
        criteriosCuenta.add(criterioCliente);
        List<Object> listaCuentas = FachadaPersistencia.getInstance().buscar("CuentaBancaria", criteriosCuenta);
        
        for (Object cuenta : listaCuentas) {      
            CuentaBancaria cuentaTemp = (CuentaBancaria) cuenta;
            TipoCuenta tipoCuentaTemp = (TipoCuenta) cuentaTemp.getTipoCuenta();
            DTOTipoCuenta dtoTipoCuenta = new DTOTipoCuenta();
            dtoTipoCuenta.setNombreTipoCuenta(tipoCuentaTemp.getNombreTipoCuenta());
            DTOCuentaBancaria dtoCuentaBancariaTemp = new DTOCuentaBancaria();
            dtoCuentaBancariaTemp.setCbuCuentaBancaria(cuentaTemp.getCbuCuentaBancaria());
            dtoCuentaBancariaTemp.setTipoCuenta(dtoTipoCuenta);
            dtoCuentaBancariaTemp.setSaldoRecuperado(adaptadorBanco.consultarSaldo(cuentaTemp.getCbuCuentaBancaria())); // Consulto mediante adaptador el saldo
            listaDTOCuentaBancaria.add(dtoCuentaBancariaTemp);
        }
        return listaDTOCuentaBancaria;
    }
    
    public List<DTOComprobante> seleccionarEmpresa(String nombreEmpresaIng, String codigoPagoElectronicoIngres){
        // Busco las Empresa seleccionada
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresaIng));
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);
        Empresa empresaSeleccionada = (Empresa) empresas.get(0);
        
        // Debo recuperar el tipoImpuesto del experto recordado
        TipoImpuesto tipoImpuestoSeleccionado = getTipoImpuesto();
        
        //Busca EmpresaTipoImpuesto, aplicando la empresa como criterio y el tipo de impuesto
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoSeleccionado));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresaSeleccionada));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eti.get(0);
        
        // Obtengo el adaptador
        setAdaptadorEmpresaClaro((AdaptadorEmpresaClaro)FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(nombreEmpresaIng));
        
        // Recupero los comprobantes
        List<DTOComprobante> listadoComprobantes = adaptadorEmpresaClaro.consultarComprobantes(empresaTipoImpuesto, codigoPagoElectronicoIngres);
        
        return listadoComprobantes;
    }
    
    // Metodo para pagar el impuesto, crea la operacion
    public DTOOperacion pagarImpuesto(String cbuCuentaSeleccionada, double montoAbonado, DTOComprobante dtoComprobante, String codigoPagoIngres, String empresaSelec, String tipoImpuestoSelec){
        
        // Debito el pago
        adaptadorBanco.debitarSaldo(cbuCuentaSeleccionada, montoAbonado);
        
        // Creo la operación
        Operacion operacion = new Operacion();
        operacion.setCodigoPagoElectrionicoOperacion(codigoPagoIngres);
        operacion.setFechaHoraOperacion(new Date());
        operacion.setImportePagadoOperacion(montoAbonado);
        int nroComprobanteFactura = ThreadLocalRandom.current().nextInt(1,1000000000); // Esto se deberia recuperar del DTO, proviene del web service
        operacion.setNroComprobanteFacturaOperacion(nroComprobanteFactura);
        operacion.setNumeroOperacion(ThreadLocalRandom.current().nextInt(1,1000000000)); // es aleatorio
        operacion.setLiquidadaOperacion(false);    
        // Para setear la cuenta bancaria la busco por CBU
        List<DTOCriterio> criteriosCuenta = new ArrayList<>();
        DTOCriterio criterioCBU = new DTOCriterio("cbuCuentaBancaria", "=", cbuCuentaSeleccionada);
        criteriosCuenta.add(criterioCBU);
        List<Object> listaCuentas = FachadaPersistencia.getInstance().buscar("CuentaBancaria", criteriosCuenta);
        CuentaBancaria cuentaBancaria = (CuentaBancaria) listaCuentas.get(0);
        operacion.setCuentaBancaria(cuentaBancaria);
        // Busco la empresa que debo setearle
        List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
        DTOCriterio criterioNombre = new DTOCriterio("nombreEmpresa", "=", empresaSelec);
        criteriosEmpresa.add(criterioNombre);
        List<Object> listaEmpresas = FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa);
        Empresa empresa = (Empresa) listaEmpresas.get(0);
        operacion.setEmpresa(empresa);
        // Busco el tipo de impuesto que debo setearle
        List<DTOCriterio> criteriosTipoImpuesto = new ArrayList<>();
        DTOCriterio criterioNombreTI = new DTOCriterio("nombreTipoImpuesto", "=", tipoImpuestoSelec);
        criteriosTipoImpuesto.add(criterioNombreTI);
        List<Object> listaTipoImpuestos = FachadaPersistencia.getInstance().buscar("TipoImpuesto", criteriosTipoImpuesto);
        TipoImpuesto tipoImpuestoSeleccionado = (TipoImpuesto) listaTipoImpuestos.get(0);
        operacion.setTipoImpuesto(tipoImpuestoSeleccionado);
        //Busca EmpresaTipoImpuesto, aplicando la empresa como criterio y el tipo de impuesto
        List<DTOCriterio> criterioEmpresaTipoImpuesto = new ArrayList();
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuestoSeleccionado));
        criterioEmpresaTipoImpuesto.add(new DTOCriterio("empresa", "=", empresa));
        List eti = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioEmpresaTipoImpuesto);
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) eti.get(0);
        operacion.setEmpresaTipoImpuesto(empresaTipoImpuesto);
        // Por cada atributo adicional creo un detalle
        List<DTOItem> listadoItems = dtoComprobante.getAtributosAdicionalesDTOComprobante();
        List<DetalleOperacion> detalleOperacionList = new ArrayList<>();
        // Seteo el valor del item
        for (int i = 0; i < listadoItems.size(); i++) {
            // Creo el detalle de la operación
            DetalleOperacion detalle = new DetalleOperacion();
            String valor = listadoItems.get(i).getItemVal();
            detalle.setValorDetalleOperacion(valor);
            String nombreItem = listadoItems.get(i).getNombreItem();
            // Busco el item relacionado
            List<DTOCriterio> criterioItem = new ArrayList();
            criterioItem.add(new DTOCriterio("nombreItem", "=", nombreItem));
            List items = FachadaPersistencia.getInstance().buscar("Item", criterioItem);
            Item itemRecuperado = (Item) items.get(0);
            // Debo setearle el itemEmpresaTipoImpuesto
            List<DTOCriterio> criterioItemEmpresaTipoImpuesto = new ArrayList();
            criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("item", "=", itemRecuperado));
            criterioItemEmpresaTipoImpuesto.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
            List ieti = FachadaPersistencia.getInstance().buscar("ItemEmpresaTipoImpuesto", criterioItemEmpresaTipoImpuesto);
            ItemEmpresaTipoImpuesto itemEmpresaTipoImpuesto = (ItemEmpresaTipoImpuesto) ieti.get(0);
            detalle.setItemEmpresaTipoImpuesto(itemEmpresaTipoImpuesto);
            detalleOperacionList.add(detalle);
        }
        operacion.setDetalleOperacionList(detalleOperacionList);
        // Guardo
        FachadaPersistencia.getInstance().guardar(operacion);
        
        // Aviso del pago a la Empresa
        setAdaptadorEmpresaClaro((AdaptadorEmpresaClaro)FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(empresaSelec)); // Obtengo el adaptador
        adaptadorEmpresaClaro.confirmarPago(dtoComprobante.getCodigoDTOComprobante(), nroComprobanteFactura, montoAbonado);
        
        // Creo y devuelvo el DTOOperacion
        DTOOperacion dtoOperacion= new DTOOperacion();
        dtoOperacion.setTipoImpuesto(operacion.getTipoImpuesto());
        dtoOperacion.setEmpresa(operacion.getEmpresa());
        dtoOperacion.setNumeroOperacion(operacion.getNumeroOperacion());
        return dtoOperacion;
        
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public void setAdaptadorEmpresaClaro(AdaptadorEmpresaClaro adaptadorEmpresaClaro) {
        this.adaptadorEmpresaClaro = adaptadorEmpresaClaro;
    }

    public void setAdaptadorBanco(AdaptadorBanco adaptadorBanco) {
        this.adaptadorBanco = adaptadorBanco;
    }

    public AdaptadorBanco getAdaptadorBanco() {
        return adaptadorBanco;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public AdaptadorEmpresaClaro getAdaptadorEmpresaClaro() {
        return adaptadorEmpresaClaro;
    }   
}
