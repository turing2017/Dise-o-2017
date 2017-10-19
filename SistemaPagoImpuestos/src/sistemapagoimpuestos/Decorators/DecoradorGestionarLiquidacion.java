/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Dto.DTOLiquidacionEstado;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Expert.ExpertoGestionarLiquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author facun
 */
public class DecoradorGestionarLiquidacion extends ExpertoGestionarLiquidacion {

    @Override
    public void consultarLiquidacion() {

    }
    @Override
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
        ArrayList<DTOTipoImpuesto> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerTipoImpuestos(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
        
    }
@Override
    public ArrayList<DTOEmpresa> obtenerEmpresarelacionadaATipoImpuesto(String nomreTipoImpuesto){
        ArrayList<DTOEmpresa> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerEmpresarelacionadaATipoImpuesto(nomreTipoImpuesto); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
        
    }

@Override
    public List<DTOEmpresa> buscarEmpresas() {
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOEmpresa> tempString = super.buscarEmpresas(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }
    
    @Override
    public ArrayList<DTOLiquidacion> obtenerLiquidacion(){
        ArrayList<DTOLiquidacion> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerLiquidacion(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
    
    }
    
    @Override
    public void AprobarLiquidacion(String numeroLiquidacion){
        Liquidacion listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        super.AprobarLiquidacion(numeroLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        
    
    }
    @Override
    public void AnularLiquidacion(String nroLiquidacion){
        Liquidacion listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        super.AnularLiquidacion(nroLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        
    }
    @Override
    public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String nombreTipoImpuesto,String nombreEmpresa,Date fechaDesde,Date fechaHasta){
        ArrayList<DTOLiquidacion> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject = super.buscarLiquidacionConFiltro( nombreTipoImpuesto, nombreEmpresa, fechaDesde, fechaHasta); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
}
    
    


    @Override
    public DTOLiquidacion mostrar(String numeroLiquidacion, Date fechaDesde, Date fechaHasta,String estado) {

        FachadaInterna.getInstance().iniciarTransaccion();
        DTOLiquidacion dtoLiquidacion = super.mostrar(numeroLiquidacion, fechaDesde, fechaHasta,estado);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoLiquidacion;

    }
    @Override
    public List<DTOLiquidacionEstado> buscarLiquidacionEstado(String numeroLiquidacion){
    FachadaInterna.getInstance().iniciarTransaccion();
    List<DTOLiquidacionEstado> estados = super.buscarLiquidacionEstado(numeroLiquidacion);
    FachadaInterna.getInstance().finalizarTransaccion();
    return estados;
    }


}