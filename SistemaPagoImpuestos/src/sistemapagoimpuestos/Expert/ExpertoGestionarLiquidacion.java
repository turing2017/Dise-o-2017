/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.ExcepcionGenerica;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Controller.ControladorConsultarLiquidacion;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaItem;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.EstadoLiquidacion;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.LiquidacionEstado;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUMostrar;
import java.util.Calendar;
import sistemapagoimpuestos.Dto.DTOComision;
import sistemapagoimpuestos.Dto.DTOEstadoCalculoComision;
import sistemapagoimpuestos.Dto.DTOLiquidacionComision;
import sistemapagoimpuestos.Dto.DTOLiquidacionEstado;
import sistemapagoimpuestos.Dto.DTOOperacionComision;
import sistemapagoimpuestos.Entity.CalculoComisionEstado;
import sistemapagoimpuestos.Entity.Comision;
import sistemapagoimpuestos.Entity.EstadoCalculoComision;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Globals.GlobalVars;

/**
 *
 * @author facun
 */
public class ExpertoGestionarLiquidacion {    
    
   public void validarUsuario() throws Exception {
        if (!GlobalVars.userActive.tipoUsuario.getNombreTipoUsuario().equals("Administrador")) {
            throw new ExcepcionGenerica("Error de privilegios");
        }
    }    
    
    public void consultarLiquidacion() {

    }

    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos() {
        // Como vuelven de la DB?
        List<Object> listObject = FachadaPersistencia.getInstance().buscar("TipoImpuesto", null);
        ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = new ArrayList<DTOTipoImpuesto>();
        for (Object obj : listObject) {
            TipoImpuesto tipoImpuesto = (TipoImpuesto) obj;
            DTOTipoImpuesto dtoTipoImpuesto = new DTOTipoImpuesto();
            dtoTipoImpuesto.setCodigoDTOTipoImpuesto(tipoImpuesto.getCodigoTipoImpuesto());
            dtoTipoImpuesto.setNombreDTOTipoImpuesto(tipoImpuesto.getNombreTipoImpuesto());
            dtoTipoImpuesto.setEsMontoEditableDTOTipoImpuesto(tipoImpuesto.isEsMontoEditableTipoImpuesto());
            dtoTipoImpuesto.setFechaHoraInhabilitacionDTOTipoImpuesto(tipoImpuesto.getFechaHoraInhabilitacionTipoImpuesto());
            listDtoTipoImpuesto.add(dtoTipoImpuesto);
        }
        return listDtoTipoImpuesto;
    }

    public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(String nombreTipoImpuesto) {

//CREA LO QUE VA A DEVOLVER
        ArrayList<DTOEmpresa> listDtoEmpresa = new ArrayList<DTOEmpresa>();

        //SI ES TODOS , BUSCA TODAS LAS EMPRESAS(otra vez xq no me andubo el this.buscarEmpresa, posiblemente por problemas de list/arraylist)
        if ("Todos".equals(nombreTipoImpuesto)) {

            List<DTOCriterio> criterioEmpresa = new ArrayList();
            criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
            List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);

            DTOEmpresa dtoEmpresa;

            for (int i = 0; i < empresas.size(); i++) {
                dtoEmpresa = new DTOEmpresa();
                Empresa empresa = (Empresa) empresas.get(i);
                String nombreEmpresa = empresa.getNombreEmpresa();
                dtoEmpresa.setNombreEmpresa(nombreEmpresa);
                listDtoEmpresa.add(dtoEmpresa);
            }

        } //SI SELECCIONO UNO BUSCA LAS EMPRESAS DE ESE TIPO IMPUESTO
        else {

            List<DTOCriterio> criterios = new ArrayList<>();

            //BUSCA TIPOIMPUESTO SELECCIONADO EN EL OTRO COMBOBOX y muestra nombre
            //BUSCA EL OBJETO TIMPO IMPUESTO
            DTOCriterio criterio2 = new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto);
            criterios.clear();
            criterios.add(criterio2);
            TipoImpuesto listTipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);

            //BUSCA LA EMPRESA QUE TENGGA EL TIMPO IMPUESTO  
            DTOCriterio criterio1 = new DTOCriterio("tipoImpuesto", "=", listTipoImpuesto);
            criterios.clear();
            criterios.add(criterio1);
            List<Object> listEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);

            for (Object obj : listEmpresaTipoImpuesto) {
                EmpresaTipoImpuesto tipoImpuesto = (EmpresaTipoImpuesto) obj;
                DTOEmpresa dtoEmpresa = new DTOEmpresa();
                dtoEmpresa.setNombreEmpresa(tipoImpuesto.getEmpresa().getNombreEmpresa());
                listDtoEmpresa.add(dtoEmpresa);
            }

        };

        return listDtoEmpresa;
    }

    public List<DTOEmpresa> buscarEmpresas() {

        //Busqueda de Empresas habilitadas
        List<DTOCriterio> criterioEmpresa = new ArrayList();
        criterioEmpresa.add(new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null));
        List empresas = FachadaPersistencia.getInstance().buscar("Empresa", criterioEmpresa);

        List<DTOEmpresa> lista = new ArrayList<>();
        DTOEmpresa dtoEmpresa;

        for (int i = 0; i < empresas.size(); i++) {
            dtoEmpresa = new DTOEmpresa();
            Empresa empresa = (Empresa) empresas.get(i);
            String nombreEmpresa = empresa.getNombreEmpresa();
            dtoEmpresa.setNombreEmpresa(nombreEmpresa);
            lista.add(dtoEmpresa);
        }
        return lista;
    }

    public ArrayList<DTOLiquidacion> obtenerLiquidacion() {
        List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", null);

        ArrayList<DTOLiquidacion> listDtoLiquidacion = new ArrayList<DTOLiquidacion>();
        for (Object obj : listLiquidacion) {
            Liquidacion liquidacion = (Liquidacion) obj;
            DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();

            dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
            dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
            dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
            dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
            dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
            dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
            // dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstado().getEstadoLiquidacion().getNombreEstadoLiquidacion());
            dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getLiquidacionEstadoList().get(liquidacion.getLiquidacionEstadoList().lastIndexOf(obj)).getEstadoLiquidacion().getNombreEstadoLiquidacion());
            listDtoLiquidacion.add(dtoLiquidacion);
        }
        return listDtoLiquidacion;
    }

    public void AprobarLiquidacion(String numeroLiquidacion) {
        //BUSCO LA LIQUIDACION
        String estadoPendiente="Pendiente";
        Date fechaActual= new Date();
        List<DTOCriterio> criterios = new ArrayList();

        DTOCriterio criterio = new DTOCriterio("numeroLiquidacion", "=", Integer.valueOf(numeroLiquidacion));
        criterios.add(criterio);
        Liquidacion liquidacion = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);

        Calendar calendario = Calendar.getInstance();

        //SETEO LA FECHA HASTA DEL ESTADO ANTERIOR
// Buscar la ultima liquidacionEstado ( la actual)
        LiquidacionEstado liquidacionEstadoultima = new LiquidacionEstado();
        for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
            if (liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado() == null) {
                liquidacionEstadoultima = liquidacion.getLiquidacionEstadoList().get(i);

            }
        }
        // si tiene estado para aprobar
//        if (liquidacionEstadoultima.getEstadoLiquidacion().getNombreEstadoLiquidacion().equals("Calculada")
//                || liquidacionEstadoultima.getEstadoLiquidacion().getNombreEstadoLiquidacion().equals("Recalculada")) {
            if (liquidacionEstadoultima.getEstadoLiquidacion().getNombreEstadoLiquidacion().equals(estadoPendiente)){
            liquidacionEstadoultima.setFechaHoraHastaLiquidacionEstado(fechaActual);
            FachadaPersistencia.getInstance().guardar(liquidacionEstadoultima);

            //BUSCO EL ESTADO APROBADO
            criterios.clear();
            DTOCriterio criterio1 = new DTOCriterio("nombreEstadoLiquidacion", "=", "Aprobada");
            criterios.add(criterio1);
            EstadoLiquidacion estadoLiquidacion = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);

            //CREO LA NUEVA LIQUIDACION ESTADO
            LiquidacionEstado liquidacionEstado = new LiquidacionEstado();
            liquidacionEstado.setFechaHoraDesdeLiquidacionEstado(fechaActual);
            liquidacionEstado.setEstadoLiquidacion(estadoLiquidacion);
            liquidacionEstado.setFechaHoraHastaLiquidacionEstado(null);

            //SETEO LIQUIDACION ESTADO EN LA LIQUIDACION
            FachadaPersistencia.getInstance().guardar(liquidacionEstado);
            liquidacion.getLiquidacionEstadoList().add(liquidacionEstado);
            liquidacion.setFechaHoraLiquidacion(fechaActual);
            
                for (int i = 0; i < liquidacion.getCalculoComisionList().size(); i++) {
                    System.out.println(liquidacion.getCalculoComisionList().size());
                    for (int j = 0; j < liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().size(); j++) {
                        System.out.println(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().size());
                      if (  liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraHastaCalculoComisionEstado()==null){
                          
                        liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).setFechaHoraHastaCalculoComisionEstado(fechaActual);
                        FachadaPersistencia.getInstance().guardar(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j));
                        CalculoComisionEstado calculoComisionEstado = new CalculoComisionEstado();
                        calculoComisionEstado.setFechaHoraDesdeCalculoComisionEstado(fechaActual);
                        criterios.clear();
                        criterios.add(new DTOCriterio("nombreEstadoCalculoComision", "=", "Aprobada"));
                        EstadoCalculoComision estadoCalculoComision = (EstadoCalculoComision) FachadaPersistencia.getInstance().buscar("EstadoCalculoComision", criterios).get(0);
                        calculoComisionEstado.setEstadoCalculoComision(estadoCalculoComision);
                        liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().add(calculoComisionEstado);
                    
                    
                    FachadaPersistencia.getInstance().guardar(calculoComisionEstado);
                    FachadaPersistencia.getInstance().guardar(liquidacion.getCalculoComisionList().get(i));
                    FachadaPersistencia.getInstance().guardar(liquidacion);
                    
                      }
                      break;
                    }
                }
                
            
            

        } else {
            System.out.println("no se puede Aprobar una liquidacion Ya aprobada o Anulada");
        } //Sacar mensaje por pantalla no un sout
    }

   public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta) {

        ArrayList<DTOLiquidacion> listDtoLiquidacion = new ArrayList<DTOLiquidacion>();
        List<DTOCriterio> criterios = new ArrayList();
        List<Object> listLiquidacionTodos = new ArrayList();
        
        
        if ("Todos".equals(nombreTipoImpuesto) && "Todos".equals(nombreEmpresa)) {
                criterios.add(new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde));
                criterios.add(new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta));
                listLiquidacionTodos = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
        }else{
        if ("Todos".equals(nombreTipoImpuesto)) {
                criterios.clear();    
                criterios.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresa));
                Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
                
                criterios.clear();
                criterios.add(new DTOCriterio("empresa", "=", empresa));
                List<Object> listEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);

                //CONDICION DE LAS FECHAS
                for (Object obj1 : listEmpresaTipoImpuesto) {
                        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj1;
                        criterios.clear();
                        criterios.add(new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde));
                        criterios.add(new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta));
                        criterios.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
                        List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
                                 for (Object obj : listLiquidacion) {
                                 Liquidacion liquidacion = (Liquidacion) obj;
                                 listLiquidacionTodos.add(liquidacion);
                    }
                   }
        }else{
        if ("Todos".equals(nombreEmpresa)){
                criterios.clear();
                criterios.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
                TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);

                //BUSCAR EMPRESA TIMPO IMPUESTO DE ESE IMPUESTO
                criterios.clear();
                criterios.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
                List<Object> listEmpresaTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
                
                for (Object obj1 : listEmpresaTipoImpuesto) {
                        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) obj1;
                        criterios.clear();
                        criterios.add(new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde));
                        criterios.add(new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta));
                        criterios.add(new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
                         List<Object> listLiquidacion = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
                                 for (Object obj : listLiquidacion) {
                                 Liquidacion liquidacion = (Liquidacion) obj;
                                 listLiquidacionTodos.add(liquidacion);
                }
                }
        
        }else{
                //BUSCO EMPRESA SELECCIONADA
                criterios.clear();
                criterios.add(new DTOCriterio("nombreEmpresa", "=", nombreEmpresa));
                Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
                
                criterios.clear();
                criterios.add(new DTOCriterio("nombreTipoImpuesto", "=", nombreTipoImpuesto));
                TipoImpuesto tipoImpuesto = (TipoImpuesto) FachadaPersistencia.getInstance().buscar("TipoImpuesto", criterios).get(0);                

                // BUSCO EMPRESATIPOIMPUESTO QUE CONTEGNA TIPO IMPUESTO Y EMPRESA
                criterios.clear();
                criterios.add(new DTOCriterio("tipoImpuesto", "=", tipoImpuesto));
                criterios.add(new DTOCriterio("empresa", "=", empresa));
                EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios).get(0);

                //BUSCO TODAS LAS LIQUIDACIONES QUE TENGA ESA EMPRESA TIPO IMPUESTO ENTRE LAS FECHAS
                criterios.clear();
                criterios.add( new DTOCriterio("empresaTipoImpuesto", "=", empresaTipoImpuesto));
                criterios.add( new DTOCriterio("fechaHoraLiquidacion", ">", fechaDesde));
                criterios.add( new DTOCriterio("fechaHoraLiquidacion", "<", fechaHasta));
                listLiquidacionTodos = FachadaPersistencia.getInstance().buscar("Liquidacion", criterios);
            
         }
        }
        }
        
        
        for (Object obj : listLiquidacionTodos) {
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
        
        
        return listDtoLiquidacion;
    } 
 

    public DTOLiquidacion mostrar(String numeroLiquidacion, String fechaDesde, String fechaHasta, String estado) {
        boolean flag = false;
        //Busca  esa liquidacion 
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio = new DTOCriterio("numeroLiquidacion", "=", Integer.valueOf(numeroLiquidacion));
        criterios.clear();
        criterios.add(criterio);
        Liquidacion liquidacion = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);
        DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
        dtoLiquidacion.setListOperacionComision(new ArrayList());
        dtoLiquidacion.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
        dtoLiquidacion.setFechaHoraDesdeLiquidacion(liquidacion.getFechaHoraDesdeLiquidacion());
        dtoLiquidacion.setFechaHoraHastaLiquidacion(liquidacion.getFechaHoraHastaLiquidacion());
        dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
        dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
        dtoLiquidacion.setListOperacionComision(new ArrayList());
        for (int i = 0; i < liquidacion.getCalculoComisionList().size(); i++) {
            for (int j = 0; j < liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().size(); j++) {
                
                System.out.println(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraDesdeCalculoComisionEstado()+"=="+fechaDesde+"?");
                System.out.println(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraHastaCalculoComisionEstado()+"=="+fechaHasta+"?");
                
              if(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraDesdeCalculoComisionEstado().toString().equals(fechaDesde) )
                //liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraHastaCalculoComisionEstado().toString()==(fechaHasta) )
                      {
              dtoLiquidacion.setNombreEstadoLiquidacion(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getEstadoCalculoComision().getNombreEstadoCalculoComision());
              dtoLiquidacion.setValorTotalCalculoComision(liquidacion.getCalculoComisionList().get(i).getValorTotalCalculoComision());
              
                  for (int k = 0; k < liquidacion.getCalculoComisionList().get(i).getComisionList().size(); k++) {
                      DTOOperacionComision dtoOperacionComision = new DTOOperacionComision();
                      dtoOperacionComision.setValorComision(liquidacion.getCalculoComisionList().get(i).getComisionList().get(k).getValorComision());
                      dtoOperacionComision.setFechaOperacion(liquidacion.getCalculoComisionList().get(i).getComisionList().get(k).getOperacion().getFechaHoraOperacion());
                      dtoOperacionComision.setNumeroOperacion(liquidacion.getCalculoComisionList().get(i).getComisionList().get(k).getOperacion().getNumeroOperacion());
                      dtoOperacionComision.setNroComprobanteFactura(liquidacion.getCalculoComisionList().get(i).getComisionList().get(k).getOperacion().getNroComprobanteFacturaOperacion());
                      dtoOperacionComision.setImportePagadoOperacion(liquidacion.getCalculoComisionList().get(i).getComisionList().get(k).getOperacion().getImportePagadoOperacion());
                      dtoLiquidacion.getListOperacionComision().add(dtoOperacionComision);
                  }
 
              }
            }
            
        }

        
//        DTOLiquidacionComision dtoLiquidacionComision = new DTOLiquidacionComision();
//        dtoLiquidacionComision.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
//        dtoLiquidacionComision.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
//        
////        DTOLiquidacion dtoLiquidacion = new DTOLiquidacion();
////        dtoLiquidacion.setListOperacionComision(null);
////        dtoLiquidacion.setNumeroLiquidacion(Integer.valueOf(numeroLiquidacion));
//       // dtoLiquidacion.setNombreEmpresa(liquidacion.getEmpresaTipoImpuesto().getEmpresa().getNombreEmpresa());
//       // dtoLiquidacion.setNombreTipoImpuesto(liquidacion.getEmpresaTipoImpuesto().getTipoImpuesto().getNombreTipoImpuesto());
////        dtoLiquidacion.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
//
//        for (int i = 0; i < liquidacion.getCalculoComisionList().size(); i++) {
//            for (int j = 0; j < liquidacion.getCalculoComisionList().get(i).getlistCalculoComisionEstado().size(); j++) {
//                DTOEstadoCalculoComision dtoEstadoCalculoComision = new DTOEstadoCalculoComision();
//               dtoEstadoCalculoComision.setNombreEstado(liquidacion.getCalculoComisionList().get(i).getlistCalculoComisionEstado().get(j).getEstadoCalculoComision().getNombreEstadoCalculoComision());
//               dtoEstadoCalculoComision.setFechaDesdeComisionEstado(liquidacion.getCalculoComisionList().get(i).getlistCalculoComisionEstado().get(j).getFechaHoraDesdeCalculoComisionEstado());
//               dtoEstadoCalculoComision.setFechaHastaComisionEstado(liquidacion.getCalculoComisionList().get(i).getlistCalculoComisionEstado().get(j).getFechaHoraHastaCalculoComisionEstado());
//                dtoLiquidacionComision.getEstadoComisionList().add(dtoEstadoCalculoComision);
//            }
//        }
//
//     
//
//        if ("Aprobada".equals(estado) || "Anulada".equals(estado)) {
//            for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
//                if (!(liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado() == null)) {
//                    if (!liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado().before(fechaDesde) && !liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado().after(fechaDesde)) { //si es el anterior
//                        fechaDesde = liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraDesdeLiquidacionEstado();
//                        fechaHasta = liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado();
//                        System.out.println("fechadesde" + fechaDesde + " Fecha hasta:" + fechaHasta);
//                        break;
//                    }
//                }
//            }
//        }
//
//        List<DTOOperacionComision> comisionlistdto = new ArrayList<>();
//        for (Comision comision : listComision) {
//
//            boolean comisionIgualDesde = (!comision.getFechaCalculoComision().after(fechaDesde) && !comision.getFechaCalculoComision().before(fechaDesde));
//            boolean comisionMayorDesde = (comision.getFechaCalculoComision().after(fechaDesde));
//
//            if (fechaHasta == null) {
//                if (comisionIgualDesde || comisionMayorDesde) { //mayor o igual
//                    flag = true;
//                    DTOOperacionComision dtoComision = new DTOOperacionComision();
//                   
//                    dtoComision.setValorComision(comision.getValorComision());
//                    dtoComision.setFechaOperacion(comision.getOperacion().getFechaHoraOperacion());
//                    dtoComision.setNumeroOperacion(comision.getOperacion().getNumeroOperacion());
//                    dtoComision.setImportePagadoOperacion(comision.getOperacion().getImportePagadoOperacion());
//                    dtoComision.setNroComprobanteFactura(comision.getOperacion().getNroComprobanteFacturaOperacion());
//                   
//                    comisionlistdto.add(dtoComision);
//                }
//
//            } else {
//
//                System.out.println("fecha calculo comision" + comision.getFechaCalculoComision().toString());
//                System.out.println("fechadesde:" + fechaDesde);
//                System.out.println("fechaHasta:" + fechaHasta);
//
//                boolean comisionMenorHasta = (comision.getFechaCalculoComision().before(fechaHasta));
//
//                System.out.println("Entra en el rango");
//                System.out.println(((comisionIgualDesde || comisionMayorDesde) && (comisionMenorHasta)));
//
//                if ((comisionIgualDesde || comisionMayorDesde) && (comisionMenorHasta)) { // mayor igual DESDE, y menor a Hasta
//                    flag = true;
//                    DTOOperacionComision dtoComision = new DTOOperacionComision();
//                  
//                    dtoComision.setValorComision(comision.getValorComision());
//                    dtoComision.setFechaOperacion(comision.getOperacion().getFechaHoraOperacion());
//                    dtoComision.setNumeroOperacion(comision.getOperacion().getNumeroOperacion());
//                    dtoComision.setImportePagadoOperacion(comision.getOperacion().getImportePagadoOperacion());
//                    dtoComision.setNroComprobanteFactura(comision.getOperacion().getNroComprobanteFacturaOperacion());
//                    
//                    comisionlistdto.add(dtoComision);
//                }
//            }
//
//        }
//        if (flag) {
//            dtoLiquidacion.setListOperacionComision(comisionlistdto);
//        }
        return dtoLiquidacion;
    }

    public void AnularLiquidacion(String numeroLiquidacion) {
        //BUSCO LA LIQUIDACION
        String estadoPendiente="Pendiente";
        Date fechaActual= new Date();
        List<DTOCriterio> criterios = new ArrayList();

        DTOCriterio criterio = new DTOCriterio("numeroLiquidacion", "=", Integer.valueOf(numeroLiquidacion));
        criterios.add(criterio);
        Liquidacion liquidacion = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);

        Calendar calendario = Calendar.getInstance();

        //SETEO LA FECHA HASTA DEL ESTADO ANTERIOR
// Buscar la ultima liquidacionEstado ( la actual)
        LiquidacionEstado liquidacionEstadoultima = new LiquidacionEstado();
        for (int i = 0; i < liquidacion.getLiquidacionEstadoList().size(); i++) {
            if (liquidacion.getLiquidacionEstadoList().get(i).getFechaHoraHastaLiquidacionEstado() == null) {
                liquidacionEstadoultima = liquidacion.getLiquidacionEstadoList().get(i);

            }
        }
        // si tiene estado para aprobar
//        if (liquidacionEstadoultima.getEstadoLiquidacion().getNombreEstadoLiquidacion().equals("Calculada")
//                || liquidacionEstadoultima.getEstadoLiquidacion().getNombreEstadoLiquidacion().equals("Recalculada")) {
            if (liquidacionEstadoultima.getEstadoLiquidacion().getNombreEstadoLiquidacion().equals(estadoPendiente)){
            liquidacionEstadoultima.setFechaHoraHastaLiquidacionEstado(fechaActual);
            FachadaPersistencia.getInstance().guardar(liquidacionEstadoultima);

            //BUSCO EL ESTADO APROBADO
            criterios.clear();
            DTOCriterio criterio1 = new DTOCriterio("nombreEstadoLiquidacion", "=", "Anulada");
            criterios.add(criterio1);
            EstadoLiquidacion estadoLiquidacion = (EstadoLiquidacion) FachadaPersistencia.getInstance().buscar("EstadoLiquidacion", criterios).get(0);

            //CREO LA NUEVA LIQUIDACION ESTADO
            LiquidacionEstado liquidacionEstado = new LiquidacionEstado();
            liquidacionEstado.setFechaHoraDesdeLiquidacionEstado(fechaActual);
            liquidacionEstado.setEstadoLiquidacion(estadoLiquidacion);
            liquidacionEstado.setFechaHoraHastaLiquidacionEstado(null);

            //SETEO LIQUIDACION ESTADO EN LA LIQUIDACION
            FachadaPersistencia.getInstance().guardar(liquidacionEstado);
            liquidacion.getLiquidacionEstadoList().add(liquidacionEstado);
            liquidacion.setFechaHoraLiquidacion(fechaActual);
            
                for (int i = 0; i < liquidacion.getCalculoComisionList().size(); i++) {
                    for (int j = 0; j < liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().size(); j++) {
                      if (  liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraHastaCalculoComisionEstado()==null){
                      liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).setFechaHoraHastaCalculoComisionEstado(fechaActual);
                      FachadaPersistencia.getInstance().guardar(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j));
                     CalculoComisionEstado calculoComisionEstado = new CalculoComisionEstado();
                    calculoComisionEstado.setFechaHoraDesdeCalculoComisionEstado(fechaActual);
                     criterios.clear();
                    criterios.add(new DTOCriterio("nombreEstadoCalculoComision", "=", "Anulada"));
                     EstadoCalculoComision estadoCalculoComision = (EstadoCalculoComision) FachadaPersistencia.getInstance().buscar("EstadoCalculoComision", criterios).get(0);
                    calculoComisionEstado.setEstadoCalculoComision(estadoCalculoComision);
                    liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().add(calculoComisionEstado);
                    
                    
                    FachadaPersistencia.getInstance().guardar(calculoComisionEstado);
                    FachadaPersistencia.getInstance().guardar(liquidacion.getCalculoComisionList().get(i));
                    FachadaPersistencia.getInstance().guardar(liquidacion);
                      }
                      break;
                    }
                }

        } else {
            System.out.println("no se puede Anular una liquidacion Ya aprobada o Anulada");
        } //Sacar mensaje por pantalla no un sout

    }

    public DTOLiquidacionComision buscarEstadoComision(String numeroLiquidacion) {
        
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio = new DTOCriterio("numeroLiquidacion", "=", Integer.valueOf(numeroLiquidacion));
        criterios.clear();
        criterios.add(criterio);
        Liquidacion liquidacion = (Liquidacion) FachadaPersistencia.getInstance().buscar("Liquidacion", criterios).get(0);
        DTOLiquidacionComision dtoLiquidacionComision = new DTOLiquidacionComision();
        dtoLiquidacionComision.setNumeroLiquidacion(liquidacion.getNumeroLiquidacion());
        dtoLiquidacionComision.setFechaHoraLiquidacion(liquidacion.getFechaHoraLiquidacion());
        dtoLiquidacionComision.setEstadoComisionList(new ArrayList());
        for (int i = 0; i < liquidacion.getCalculoComisionList().size(); i++) {
            for (int j = 0; j < liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().size(); j++) {
                DTOEstadoCalculoComision dtoEstadoCalculoComision = new DTOEstadoCalculoComision();
               dtoEstadoCalculoComision.setNombreEstado(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getEstadoCalculoComision().getNombreEstadoCalculoComision());
               dtoEstadoCalculoComision.setFechaDesdeComisionEstado(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraDesdeCalculoComisionEstado());
               dtoEstadoCalculoComision.setFechaHastaComisionEstado(liquidacion.getCalculoComisionList().get(i).getCalculoComisionEstadoList().get(j).getFechaHoraHastaCalculoComisionEstado());
               dtoLiquidacionComision.getEstadoComisionList().add(dtoEstadoCalculoComision);
            }
        }
        return dtoLiquidacionComision;
    }

}
