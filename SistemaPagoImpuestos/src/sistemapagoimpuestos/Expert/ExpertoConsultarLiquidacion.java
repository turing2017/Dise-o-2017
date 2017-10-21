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
import sistemapagoimpuestos.Dto.DTOLiquidacion;
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
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Empresa")) {
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
       List<DTOTipoImpuesto> dtosTipoImpuesto= new ArrayList<>();
       
        for (Object obj : empresasTipoImpuesto) {
            EmpresaTipoImpuesto empresaTI = (EmpresaTipoImpuesto) obj;
            DTOTipoImpuesto dtoETI =new DTOTipoImpuesto();
                  dtoETI.setNombreDTOTipoImpuesto( empresaTI.getTipoImpuesto().getNombreTipoImpuesto()); 
            
            dtosTipoImpuesto.add(dtoETI);

        }
        
        return dtosTipoImpuesto;
    }

    public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta) {

        ArrayList<DTOLiquidacion> listDtoLiquidacion = new ArrayList<DTOLiquidacion>();
        List<DTOCriterio> criterios = new ArrayList();

        if ("Todos".equals(nombreTipoImpuesto)) {
            //HACE  BUSQUEDA DE EMPRESA , TODOS LOS EMPRESA TIPO IMPUESTO DE ESA EMPRESA Y TODAS LAS LIQUIDACIONES DE TODAS ESAS EMRPESAS TIPO IMPUESTO COOMING SOON

            //BUSCA LA EMPRESA SELECCIONADA
            DTOCriterio criterio7 = new DTOCriterio("nombreEmpresa", "=", nombreEmpresa);
            criterios.clear();
            criterios.add(criterio7);
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

            //BUSCA LISTA DE EMPRESA TIPO IMPUESTOS QUE TENGAN ESA EMPRESA(no esta probado puede q falle)
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

            List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null);
            for (Object obj : listLiquidacion) {
                Liquidacion liquidacion = (Liquidacion) obj;
                for (Object obj1 : listEmpresaTipoImpuesto) {
                    EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj1;
                    if (liquidacion.getEmpresaTipoImpuesto().equals(empresaTipoImpuesto)) {

                        DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();

                        dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
                        dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
                        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
                        dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
                        dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
                        dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
                        
                       
                        Date comisionfechaDesde=null;
                        Date comisionfechaHasta=null;
                        
                        for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
                            if (liquidacion.getLiquidacionEstadoList().get(i).getEstadoLiquidacion().equals("Aprobada")){
                            comisionfechaDesde = liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraDesdeLiquidacionEstado();
                            comisionfechaHasta = liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado();
                            }
                        }
                        for (int i = 0; i < liquidacion.getComisionList().size(); i++) {
                           Date comision = liquidacion.getComisionList().get(i).getFechaCalculoComision();
                            if((comision.equals(comisionfechaDesde)||comision.after(comisionfechaDesde)) &&(comision.before(fechaHasta)||comision.equals(fechaHasta))){
                             
                                /////////HASTA ACA LLEGE<-------------------------------------------
                                System.out.println("funciona ecuals");
                            }
                        }

                        

                        

                        listDtoLiquidacion.add(dtoLiquidacion);
                    }

                }
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
                DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();

                dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
                dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
                dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
                dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
                dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
                dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());

                // Buscar la ultima liquidacionEstado ( la actual)
                LiquidacionEstado liquidacionEstado = new LiquidacionEstado();
                for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
                    if (liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado() == null) {
                        liquidacionEstado = liquidacion.getLiquidacionEstadoList().get(i);

                    }
                }

                dtoLiquidacion.setNombreEstadoLiquidacion(liquidacionEstado.getEstadoLiquidacion().getNombreEstadoLiquidacion());

                listDtoLiquidacion.add(dtoLiquidacion);
            }
        }
        return listDtoLiquidacion;
    }
}
