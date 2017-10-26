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
import sistemapagoimpuestos.Dto.DTOCriterio;

import sistemapagoimpuestos.Dto.DTOOperacionConsultarOperacionesBancarias;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;

import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.TipoImpuesto;

import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author vande
 */
public class ExpertoConsultarOperacionesBancarias {

    public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Responsable Empresa Adherida")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }

    // Metodo iniciar
    public String iniciar() {
        return "Empresa";
    }

    public List<DTOTipoImpuesto> obtenerTipoImpuestos() {
        //Buscamos la empresa com el cuit del usuario.
        Empresa empresa = GlobalVars.userActive.getEmpresa();

        List<DTOCriterio> criterios = new ArrayList();
        criterios.add(new DTOCriterio("empresa", "=", empresa));
        List<Object> empresasTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
        List<DTOTipoImpuesto> dtosTipoImpuesto = new ArrayList<>();

        for (Object obj : empresasTipoImpuesto) {
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) obj;
            DTOTipoImpuesto dtoETI = new DTOTipoImpuesto();
            dtoETI.setNombreDTOTipoImpuesto(empresaTI.getTipoImpuesto().getNombreTipoImpuesto());

            dtosTipoImpuesto.add(dtoETI);

        }

        return dtosTipoImpuesto;
    }

    public List<DTOOperacionConsultarOperacionesBancarias> buscarOperacionesConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta) {
        double TotalLiquidado = 0;
        ArrayList<DTOOperacionConsultarOperacionesBancarias> listDtoOperacion = new ArrayList<DTOOperacionConsultarOperacionesBancarias>();
        List<DTOCriterio> criterios = new ArrayList();
        double montoTotal = 0;
        if ("Todos".equals(nombreTipoImpuesto)) {

            //BUSCA LA EMPRESA SELECCIONADA
            DTOCriterio criterio7 = new DTOCriterio("nombreEmpresa", "=", nombreEmpresa);
            criterios.clear();
            criterios.add(criterio7);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

            //CONDICION DE LAS FECHAS
            criterios.clear();
            DTOCriterio criterio5 = new DTOCriterio("fechaHoraOperacion", ">", fechaDesde);
            DTOCriterio criterio6 = new DTOCriterio("fechaHoraOperacion", "<", fechaHasta);
            DTOCriterio criterio42 = new DTOCriterio("empresa", "=", empresa);
            criterios.add(criterio5);
            criterios.add(criterio6);
            criterios.add(criterio42);
            //Busca liquidaciones de esa empresa en estado aprobado
            List<Object> listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);
            for (Object obj : listOperacion) {
                Operacion operacion = (Operacion) obj;

                DTOOperacionConsultarOperacionesBancarias dtoOperacion = new DTOOperacionConsultarOperacionesBancarias();

                dtoOperacion.setCodigoPagoElectronicoOperacion(operacion.getCodigoPagoElectrionicoOperacion());
                dtoOperacion.setFechaHoraOperacion(operacion.getFechaHoraOperacion());
                dtoOperacion.setImportePagadoOperacion(operacion.getImportePagadoOperacion());
                dtoOperacion.setNroComprobanteFacturaOperacion(operacion.getNroComprobanteFacturaOperacion());
                dtoOperacion.setNumeroOperacion(operacion.getNumeroOperacion());
                dtoOperacion.setTipoImpuesto(operacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
                listDtoOperacion.add(dtoOperacion);
                montoTotal += operacion.getImportePagadoOperacion();
            }
        } else {
            //BUSCO TIPO IMPUESTO SELECCIONADO       
            DTOCriterio criterio = new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto);
            criterios.add(criterio);
            TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);

            //BUSCO EMPRESA SELECCIONADA
            DTOCriterio criterio1 = new DTOCriterio("nombreEmpresa", "=", nombreEmpresa);
            criterios.clear();
            criterios.add(criterio1);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

            DTOCriterio criterio4 = new DTOCriterio("empresa", "=", empresa);
            DTOCriterio criterio5 = new DTOCriterio("fechaHoraOperacion", ">", fechaDesde);
            DTOCriterio criterio6 = new DTOCriterio("fechaHoraOperacion", "<", fechaHasta);
            DTOCriterio criterio12 = new DTOCriterio("tipoImpuesto", "=", tipoImpuesto);
          
            criterios.clear();
            criterios.add(criterio4);
            criterios.add(criterio5);
            criterios.add(criterio6);
            criterios.add(criterio12);

            List<Object> listOperacion = FachadaPersistencia.getInstance().buscar("Operacion", criterios);

            //LLENO EL Operacion
            for (Object obj : listOperacion) {
                Operacion operacion = (Operacion) obj;

                DTOOperacionConsultarOperacionesBancarias dtoOperacion = new DTOOperacionConsultarOperacionesBancarias();

                dtoOperacion.setCodigoPagoElectronicoOperacion(operacion.getCodigoPagoElectrionicoOperacion());
                dtoOperacion.setFechaHoraOperacion(operacion.getFechaHoraOperacion());
                dtoOperacion.setImportePagadoOperacion(operacion.getImportePagadoOperacion());
                dtoOperacion.setNroComprobanteFacturaOperacion(operacion.getNroComprobanteFacturaOperacion());
                dtoOperacion.setNumeroOperacion(operacion.getNumeroOperacion());
                dtoOperacion.setTipoImpuesto(operacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
                listDtoOperacion.add(dtoOperacion);
                montoTotal += operacion.getImportePagadoOperacion();
            }

        }

        return listDtoOperacion;
    }

}
