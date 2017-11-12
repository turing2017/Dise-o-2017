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
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;

import sistemapagoimpuestos.Dto.DTOLiquidacionesConsultarLiquidaciones;
import sistemapagoimpuestos.Dto.DTOOperacionConsultarLiquidacion;

import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.LiquidacionEstado;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Globals.GlobalVars;
import sistemapagoimpuestos.Utils.FachadaPersistencia;


public class ExpertoConsultarLiquidacion {
    public void validarUsuario() throws Exception {
        
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Responsable Empresa Adherida")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }
    
    // Metodo iniciar
    

    public List<DTOTipoImpuesto> obtenerTipoImpuestos() {
        //Buscamos la empresa com el cuit del usuario.
        Empresa empresa = GlobalVars.userActive.getEmpresa();
        
        List<DTOCriterio> criterios = new ArrayList();
        criterios.add(new DTOCriterio("empresa", "=", empresa));
        List<Object> empresasTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
       List<DTOTipoImpuesto> dtosTipoImpuesto= new ArrayList<>();
       
        for (Object obj : empresasTipoImpuesto) {
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) obj;
            DTOTipoImpuesto dtoETI =new DTOTipoImpuesto();
                  dtoETI.setNombreDTOTipoImpuesto( empresaTI.getTipoImpuesto().getNombreTipoImpuesto()); 
            
            dtosTipoImpuesto.add(dtoETI);

        }
        
        return dtosTipoImpuesto;
    }

    public List<DTOLiquidacionesConsultarLiquidaciones> buscarLiquidacionConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta) {
        double TotalLiquidado= 0;
        List<DTOLiquidacionesConsultarLiquidaciones> listDtoLiquidacion = new ArrayList<DTOLiquidacionesConsultarLiquidaciones>();
        List<DTOCriterio> criterios = new ArrayList();

        if ("Todos".equals(nombreTipoImpuesto)) {
            //HACE  BUSQUEDA DE   TIPO IMPUESTO DE ESA EMPRESA Y TODAS LAS LIQUIDACIONES 

            //BUSCA LA EMPRESA SELECCIONADA
            
            Empresa empresa = GlobalVars.userActive.getEmpresa();

            //BUSCA LISTA DE EMPRESA TIPO IMPUESTOS QUE TENGAN ESA EMPRESA
            DTOCriterio criterio8 = new DTOCriterio("empresa", "=", empresa);
            criterios.clear();
            criterios.add(criterio8);

            List<Object> listEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);

            //CONDICION DE LAS FECHAS
            criterios.clear();
            DTOCriterio criterio5 = new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde);
            DTOCriterio criterio6 = new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta);
            criterios.add(criterio5);
            criterios.add(criterio6);
            //Busca liquidaciones de esa empresa en estado aprobado
            List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
            for (Object obj : listLiquidacion) {
                Liquidacion liquidacion = (Liquidacion) obj;
                for (Object obj1 : listEmpresaTipoImpuesto) {
                    EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj1;
                    if (liquidacion.getEmpresaTipoImpuesto().equals(empresaTipoImpuesto)) {
                        for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
                            if (liquidacion.getLiquidacionEstadoList().get(i).getEstadoLiquidacion().getNombreEstadoLiquidacion().equals("Aprobada")){
                                 DTOLiquidacionesConsultarLiquidaciones dtoLiquidacion = new DTOLiquidacionesConsultarLiquidaciones();

                                dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
                                dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
                                dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
                                dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
                                dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
                                dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
                                
                                
//                                for (int j = 0; j < liquidacion.getOperacionList().size(); j++) {
//                                  TotalLiquidado += liquidacion.getOperacionList().get(j).getValorComisionOperacion();
//                                }
//NUEVO TOTAL LIQUIDACION
                                dtoLiquidacion.setTotalLiquidado(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getValorTotalCalculoComision());
                                
                                listDtoLiquidacion.add(dtoLiquidacion);
                            }
                        }
                      //  dtoLiquidacion.set

                        

                        

                        
                    }

                }
            }
        } else {
            //BUSCO TIPO IMPUESTO SELECCIONADO       
            DTOCriterio criterio = new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto);
            criterios.add(criterio);
            TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);

            //BUSCO EMPRESA SELECCIONADA
           
            Empresa empresa = GlobalVars.userActive.getEmpresa();

            // BUSCO EMPRESATIPOIMPUESTO QUE CONTEGNA TIPO IMPUESTO Y EMPRESA
            DTOCriterio criterio2 = new DTOCriterio("tipoImpuesto", "=", tipoImpuesto);
            DTOCriterio criterio3 = new DTOCriterio("empresa", "=", empresa);
            criterios.clear();
            criterios.add(criterio2);
            criterios.add(criterio3);
            EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios).get(0);

            //BUSCO TODAS LAS LIQUIDACIONES QUE TENGA ESA EMPRESA TIPO IMPUESTO ENTRE LAS FECHAS       
            DTOCriterio criterio4 = new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto);
            DTOCriterio criterio5 = new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde);
            DTOCriterio criterio6 = new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta);
            criterios.clear();
            criterios.add(criterio4);
            criterios.add(criterio5);
            criterios.add(criterio6);
            List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);

            //LLENO EL DTOLIQUIDACION
            for (Object obj : listLiquidacion) {
                Liquidacion liquidacion = (Liquidacion) obj;
                  for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
                    if (liquidacion.getLiquidacionEstadoList().get(i).getEstadoLiquidacion().getNombreEstadoLiquidacion().equals("Aprobada")) {

                        DTOLiquidacionesConsultarLiquidaciones dtoLiquidacion = new DTOLiquidacionesConsultarLiquidaciones();

                        dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
                        dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
                        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
                        dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
                        dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
                        dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());

//                        for (int j = 0; j < liquidacion.getOperacionList().size(); j++) {
//                            TotalLiquidado += liquidacion.getOperacionList().get(j).getValorComisionOperacion();
//                        }
//                        dtoLiquidacion.setTotalLiquidado(TotalLiquidado);
//NUEVO TOTAL LIQUIDACION
                                dtoLiquidacion.setTotalLiquidado(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getValorTotalCalculoComision());


                        listDtoLiquidacion.add(dtoLiquidacion);

                    }
                }
            }
        }

                

              
                return listDtoLiquidacion;
            }
    public DTOLiquidacionesConsultarLiquidaciones buscardetalleLiquidacion(String numeroLiquidacion){
        double montoTotal=0;
        DTOLiquidacionesConsultarLiquidaciones dtoLiquidacion = new DTOLiquidacionesConsultarLiquidaciones();
         List<DTOCriterio> criterios = new ArrayList();
         
        DTOCriterio criterio = new DTOCriterio("numeroLiquidacion", "=", Integer.valueOf(numeroLiquidacion));
            criterios.add(criterio);
            Liquidacion liquidacion = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);
            dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
            dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
            dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
            dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
            dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
            dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
           List<DTOOperacionConsultarLiquidacion> listOperacionComision = new ArrayList();
            for (int i = 0; i < liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getComisionList().size(); i++) {
            DTOOperacionConsultarLiquidacion dtoOC = new DTOOperacionConsultarLiquidacion();
            
            dtoOC.setNumeroOperacion(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getComisionList().get(i).getOperacion().getNumeroOperacion());
            dtoOC.setNroComprobanteFactura(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getComisionList().get(i).getOperacion().getNroComprobanteFacturaOperacion());
            dtoOC.setImportePagadoOperacion(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getComisionList().get(i).getOperacion().getImportePagadoOperacion());
            dtoOC.setValorComision(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getComisionList().get(i).getValorComision());
            dtoOC.setFechaHoraOperacion(liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getComisionList().get(i).getOperacion().getFechaHoraOperacion());
            listOperacionComision.add(dtoOC);
            
            montoTotal +=liquidacion.getCalculoComisionList().get(liquidacion.getCalculoComisionList().size() -1).getValorTotalCalculoComision();
        }
        dtoLiquidacion.setListOperacionComision(listOperacionComision);
        dtoLiquidacion.setTotalLiquidado(montoTotal);
        return dtoLiquidacion;
                
    }
        }
        
    

