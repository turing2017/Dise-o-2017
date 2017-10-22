/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;


import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOLiquidacionesConsultarLiquidaciones;

import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoConsultarLiquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Dario
 */
public class DecoradorConsultarLiquidacion extends ExpertoConsultarLiquidacion {
    
   @Override
   public List<DTOTipoImpuesto> obtenerTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoImpuesto> listDtos = super.obtenerTipoImpuestos(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDtos;
    }
   @Override
   public List<DTOLiquidacionesConsultarLiquidaciones> buscarLiquidacionConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta){
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOLiquidacionesConsultarLiquidaciones> listDtos = super.buscarLiquidacionConFiltro(nombreTipoImpuesto,nombreEmpresa,fechaDesde,fechaHasta);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDtos;
   }
    @Override
   public DTOLiquidacionesConsultarLiquidaciones buscardetalleLiquidacion(String numeroLiquidacion){
   FachadaInterna.getInstance().iniciarTransaccion();
   DTOLiquidacionesConsultarLiquidaciones dtoLiquidacion = super.buscardetalleLiquidacion(numeroLiquidacion);
   FachadaInterna.getInstance().finalizarTransaccion();
   return dtoLiquidacion;
   }
}
