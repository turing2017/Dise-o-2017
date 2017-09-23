/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.attribute.standard.Compression;
import sistemapagoimpuestos.Dto.DTOComprobante;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author mvissio
 */
public class ExpertoPagarImpuestos {
    
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
        
        String codigoComprobanteRecup = "Abc123";
        Date fechaVencimientoRecup = new Date();
        double montoTotalRecup = 234333;
        
        DTOItem dtoItem = new DTOItem("cod12344", "Llamadas", 5, true, new Date());
        dtoItem.setDtoTipoDatoItem(new DTOTipoDatoItem());
        
        List<DTOItem> listadoItems = new ArrayList<DTOItem>();
        listadoItems.add(dtoItem);
        
        // Esto va a estar re hardcodeado
        DTOComprobante dtoComprobante = new DTOComprobante();
        dtoComprobante.setCodigoDTOComprobante(codigoComprobanteRecup);
        dtoComprobante.setFechaHoraVencimientoDTOComprobante(fechaVencimientoRecup);
        dtoComprobante.setMontoTotalDTOComprobante(montoTotalRecup);
        dtoComprobante.setAtributosAdicionalesDTOComprobante(listadoItems);
        
        List<DTOComprobante> listadoComprobantes = new ArrayList<DTOComprobante>();
        return listadoComprobantes;
    }
}
