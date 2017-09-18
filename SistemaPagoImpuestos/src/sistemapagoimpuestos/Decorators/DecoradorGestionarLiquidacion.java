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
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Liquidacion;
import sistemapagoimpuestos.Expert.ExpertoGestionarLiquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author facun
 */
public class DecoradorGestionarLiquidacion extends ExpertoGestionarLiquidacion {

    @Override
    public String iniciar() {
        FachadaInterna.getInstance().iniciarTransaccion();
        String tempString = super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return tempString;
    }

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
    public Liquidacion obtenerLiquidacion(String numeroLiquidacion){
        Liquidacion listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.obtenerLiquidacion(numeroLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
    
    }
    @Override
    public Liquidacion AnularLiquidacion(String nroLiquidacion){
        Liquidacion listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject= super.AnularLiquidacion(nroLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
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
    public ArrayList<DTOOperacion> buscarOperaciones(String numeroLiquidacion){
        ArrayList<DTOOperacion> listObject;
        FachadaInterna.getInstance().iniciarTransaccion();
        listObject = super.buscarOperaciones(numeroLiquidacion); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listObject;
}
    
    @Override
    public void mostrar(String numeroLiquidacion, String fechaLiquidacion, String tipoImpuesto, String empresa) {
        
        FachadaInterna.getInstance().iniciarTransaccion();
        super.mostrar(numeroLiquidacion, fechaLiquidacion, tipoImpuesto, empresa);
        FachadaInterna.getInstance().finalizarTransaccion();
    }
}