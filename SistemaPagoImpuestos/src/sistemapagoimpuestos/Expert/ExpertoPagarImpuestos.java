/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOCuentaBancaria;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoCuenta;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Cliente;
import sistemapagoimpuestos.Entity.CuentaBancaria;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoCuenta;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Fabricas.FactoriaAdaptadorConexionEmpresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author mvissio
 */
public class ExpertoPagarImpuestos {
    
    private AdaptadorEmpresaClaro adaptadorEmpresaClaro;
    private EmpresaTipoImpuesto empresaTipoImpuesto;
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
    
    // Recupera los comprobantes pendientes de pago
    public List<DTOComprobante> consultarComprobantes(String codigoPagoElectronicoIngres){
        return adaptadorEmpresaClaro.consultarComprabantes(codigoPagoElectronicoIngres);
    }
    
    // Recupera cuentas y saldos del cliente
    public List<DTOCuentaBancaria> obtenerCuentas(String cuilCliente){
        
        List<DTOCuentaBancaria> listaDTOCuentaBancaria = new ArrayList<DTOCuentaBancaria>();
        
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
        
        // Necesito recordar la empresa tipo impuesto
        setEmpresaTipoImpuesto(empresaTipoImpuesto);
        
        // Obtengo el adaptador
        setAdaptadorEmpresaClaro((AdaptadorEmpresaClaro)FactoriaAdaptadorConexionEmpresa.getInstancia().getAdaptadorConexionEmpresa(nombreEmpresaIng));
        
        // Recupero los comprobantes
        List<DTOComprobante> listadoComprobantes = adaptadorEmpresaClaro.consultarComprabantes(codigoPagoElectronicoIngres);
        
        return listadoComprobantes;
    }
    
    public void seleccionarCuenta(String cbuCuentaBancariaIngres){
        
    }

    public void setEmpresaTipoImpuesto(EmpresaTipoImpuesto empresaTipoImpuesto) {
        this.empresaTipoImpuesto = empresaTipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public void setAdaptadorEmpresaClaro(AdaptadorEmpresaClaro adaptadorEmpresaClaro) {
        this.adaptadorEmpresaClaro = adaptadorEmpresaClaro;
    }

    public EmpresaTipoImpuesto getEmpresaTipoImpuesto() {
        return empresaTipoImpuesto;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public AdaptadorEmpresaClaro getAdaptadorEmpresaClaro() {
        return adaptadorEmpresaClaro;
    }   
}
