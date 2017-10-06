/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTODetalleOperacion;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTORangoFecha;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Tongas
 */
public class ExpertoConsultarOperacionesBancarias {
    

    
    
    public DTOEmpresa verificarEmpresa (String cuitEmpresa){
       Empresa empresa = new Empresa();
        try {
            
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuitEmpresa);
            criterios.add(criterio1);
            DTOCriterio criterio2 = new DTOCriterio();
            criterio2.setAtributo("fechaHoraInhabilitacionEmpresa");
            criterio2.setOperacion("IS");
            criterio2.setValor(null);
            criterios.add(criterio2);
            
            empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

        } catch (IndexOutOfBoundsException exception) {
            Excepciones.getInstance().cuitNoExistente();
        }
        DTOEmpresa dtoEmpresa = null;
        dtoEmpresa.setCuitEmpresa(empresa.getCuitEmpresa());
        dtoEmpresa.setDireccionEmpresa(empresa.getDireccionEmpresa());
        dtoEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
        return dtoEmpresa;
    }
    
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerTipoImpuestosAsociados(){
        ArrayList<EmpresaTipoImpuesto> listETI = null;
        Empresa empresa = new Empresa();
        ArrayList<DTOEmpresaTipoImpuesto> listDTOETI = new ArrayList<DTOEmpresaTipoImpuesto>();
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("empresa");
        criterio1.setOperacion("=");
        criterio1.setValor(empresa);
        criterios.add(criterio1);
        List<Object> objectETI = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);

            for (Object obj : objectETI){
                EmpresaTipoImpuesto eTI = (EmpresaTipoImpuesto) obj;
                DTOEmpresaTipoImpuesto dtoETI = new DTOEmpresaTipoImpuesto();
                DTOTipoEmpresa dtoTipoEmpresa = new DTOTipoEmpresa();
                dtoTipoEmpresa.setNombreTipoEmpresa(eTI.getTipoEmpresa().getNombreTipoEmpresa());
                dtoETI.setdTOtipoEmpresa(dtoTipoEmpresa);
                DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
                dtoTipoImpuesto.setNombreDTOTipoImpuesto(eTI.getTipoImpuesto().getNombreTipoImpuesto());
                dtoETI.setdTOtipoImpuesto(dtoTipoImpuesto);
                listDTOETI.add(dtoETI);
                }
            
        return listDTOETI;
    }
    
    public ArrayList<DTOOperacion> consultarOperaciones (DTORangoFecha dtoRF){
        EmpresaTipoImpuesto eTISeleccionada = null;
        
        //Busca la empresa
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("cuitEmpresa", "=", dtoRF.getCuitEmpresa()));
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa).get(0);
        
        //Busca el TipoImpuesto
        List<DTOCriterio> criterioTI = new ArrayList();
        criterioTI.add(new DTOCriterio("nombreTipoImpuesto", "=", dtoRF.getNombreTipoImpuesto()));
        TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterioTI).get(0);
        
        //Busco el TipoEmpresa
        List<DTOCriterio> criterioTE = new ArrayList();
        criterioTE.add(new DTOCriterio("nombreTipoEmpresa", "=", dtoRF.getNombreTipoEmpresa()));
        TipoEmpresa tipoEmpresa = (TipoEmpresa) FachadaPersistencia.getInstance().buscar("TipoEmpresa", criterioTE).get(0);
        
        
        
        
        
        
        List<DTOCriterio> criterioETI = new ArrayList();
        criterioETI.add(new DTOCriterio("fechaHoraInhabilitacionEmpresaTipoImpuesto", "IS", null));
        criterioETI.add(new DTOCriterio("empresa", "=", empresa));
        criterioETI.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
        criterioETI.add(new DTOCriterio("tipoEmpresa", "=", tipoEmpresa));
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterioETI).get(0);
        
        List<DTOCriterio> criterioOperaciones = new ArrayList();
        criterioOperaciones.add(new DTOCriterio("fechaHoraOperacion", ">", dtoRF.getFechaDesde()));
        criterioOperaciones.add(new DTOCriterio("fechaHoraOperacion", "<", dtoRF.getFechaHasta()));
        criterioOperaciones.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
        List operaciones = FachadaPersistencia.getInstance().buscar("Operacion", criterioOperaciones);
        
        ArrayList<DTOOperacion> listDTOO = new ArrayList<DTOOperacion>();
        for (Object obj : operaciones){
                Operacion operacion = new Operacion();
                operacion = (Operacion) operaciones;
                DTOOperacion dtoO = null;
                dtoO.setNumeroOperacion(operacion.getNumeroOperacion());
                dtoO.setCodigoPagoElectronicoOperacion(operacion.getCodigoPagoElectrionicoOperacion());
                dtoO.setFechaHoraOperacion(operacion.getFechaHoraOperacion());
                dtoO.setImportePagadoOperacion(operacion.getImportePagadoOperacion());
                dtoO.setNroComprobanteFactura(operacion.getNroComprobanteFacturaOperacion());
                dtoO.setValorComisionOperacion(operacion.getValorComisionOperacion());
                dtoO.setLiquidadaOperacion(operacion.isLiquidadaOperacion());
                
                List<DTODetalleOperacion> listDTODO=null;
                
                for(int z = 0;operacion.getDetalleOperacionList().size() < z ; z++){
                    operacion.getDetalleOperacionList().get(z);
                    DTODetalleOperacion dtoDO = null;
                    dtoDO.setValorDetalleOperacion(operacion.getDetalleOperacionList().get(z).getValorDetalleOperacion());
                    dtoDO.setOrdenItemEmpresaTipoImpuesto(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getOrdenItemEmpresaTipoImpuesto());
                    dtoDO.setIndicaPeriodicidadItemEmpresaTipoImpuesto(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().isIndicaPeriodicidadItemEmpresaTipoImpuesto());
                    dtoDO.setFechaInhabilitacionItemEmpresaTipoImpuesto(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getFechaInhabilitacionItemEmpresaTipoImpuesto());
                    dtoDO.setCodigoItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().getCodigoItem());
                    dtoDO.setNombreItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().getNombreItem());
                    dtoDO.setLongitudItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().getLongitudItem());
                    dtoDO.setRequeridoItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().isRequeridoItem());
                    dtoDO.setFechaHoraInhabilitacionItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().getFechaHoraInhabilitacionItem());
                    dtoDO.setCodigoTipoDatoItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().getTipoDatoItem().getCodigoTipoDatoItem());
                    dtoDO.setNombreTipoDatoItem(operacion.getDetalleOperacionList().get(z).getItemEmpresaTipoImpuesto().getItem().getTipoDatoItem().getNombreTipoDatoItem());
                    listDTODO.add(dtoDO);    
                }
                dtoO.setDtoDetalleOperacion(listDTODO);
                listDTOO.add(dtoO);
                }
        return listDTOO;
    }
    
}
