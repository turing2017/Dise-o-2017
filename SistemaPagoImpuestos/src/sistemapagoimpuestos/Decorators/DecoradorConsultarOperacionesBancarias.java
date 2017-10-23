/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOLiquidacionesConsultarLiquidaciones;
import sistemapagoimpuestos.Dto.DTOOperacionConsultarOperacionesBancarias;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoConsultarOperacionesBancarias;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author vande
 */
public class DecoradorConsultarOperacionesBancarias extends ExpertoConsultarOperacionesBancarias{
    @Override
   public List<DTOTipoImpuesto> obtenerTipoImpuestos() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOTipoImpuesto> listDtos = super.obtenerTipoImpuestos(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDtos;
    }
   @Override
   public List<DTOOperacionConsultarOperacionesBancarias> buscarOperacionesConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechaDesde, Date fechaHasta){
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOOperacionConsultarOperacionesBancarias> listDtos = super.buscarOperacionesConFiltro(nombreTipoImpuesto,nombreEmpresa,fechaDesde,fechaHasta);
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDtos;
   }
    
}
