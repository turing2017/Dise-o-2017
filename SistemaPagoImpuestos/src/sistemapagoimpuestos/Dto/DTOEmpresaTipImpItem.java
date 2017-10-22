/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Markz
 */
public class DTOEmpresaTipImpItem {
    private int id;
    private int codigoTI;
    private String nombreEmpresa;
    private String nombreTipoEmpresa;
    private int frecuenciaSincronizacion;
    private List<DtoItemOrden> dtoItemOrdenList;
    private String cuitEmpresa;
    private String nombreTipoImpuesto;
    
    public DTOEmpresaTipImpItem() {
    }

    public DTOEmpresaTipImpItem(String nombreTipoImpuesto, String cuitEmpresa, int id, int codigoTI, String nombreEmpresa, String nombreTipoEmpresa, int frecuenciaSincronizacion, List<DtoItemOrden> dtoItemOrdenList) {
        this.id = id;
        this.codigoTI = codigoTI;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.frecuenciaSincronizacion = frecuenciaSincronizacion;
        this.dtoItemOrdenList = dtoItemOrdenList;
        this.cuitEmpresa = cuitEmpresa;
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }

    public String getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public String getNombreTipoImpuesto() {
        return nombreTipoImpuesto;
    }

    public void setNombreTipoImpuesto(String nombreTipoImpuesto) {
        this.nombreTipoImpuesto = nombreTipoImpuesto;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoTI() {
        return codigoTI;
    }

    public void setCodigoTI(int codigoTI) {
        this.codigoTI = codigoTI;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public int getFrecuenciaSincronizacion() {
        return frecuenciaSincronizacion;
    }

    public void setFrecuenciaSincronizacion(int frecuenciaSincronizacion) {
        this.frecuenciaSincronizacion = frecuenciaSincronizacion;
    }

    public List<DtoItemOrden> getDtoItemOrdenList() {
        return dtoItemOrdenList;
    }

    public void setDtoItemOrdenList(List<DtoItemOrden> dtoItemOrdenList) {
        this.dtoItemOrdenList = dtoItemOrdenList;
    }
    
    public void addItem(DtoItemOrden dtoItemOrden){
        if(dtoItemOrdenList ==null){
            dtoItemOrdenList = new ArrayList<>();
        }
        dtoItemOrdenList.add(dtoItemOrden);
    }
    public void removeItem(String nombreItem){
        for(DtoItemOrden dtoItemOrden: dtoItemOrdenList){
                if(dtoItemOrden.getNombreItem().equals(nombreItem)){
                dtoItemOrdenList.remove(nombreItem);
                break;
            }
        }
    }
    
    
    public String concatItems() {
        String itemsConcat = null;
        int couter = 0; 
        for(DtoItemOrden dtoItemOrden : dtoItemOrdenList){
            if(couter >0){
                itemsConcat += " - " +dtoItemOrden.getNombreItem();
            }else{
                itemsConcat = dtoItemOrden.getNombreItem();
                couter++;
            }
        }
        return itemsConcat;
    }
}
