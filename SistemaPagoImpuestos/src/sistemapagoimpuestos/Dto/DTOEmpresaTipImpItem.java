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
    private List<String> nombreItemList;

    public DTOEmpresaTipImpItem() {
    }

    public DTOEmpresaTipImpItem(int id, int codigoTI, String nombreEmpresa, List<String> nombreItemList) {
        this.id = id;
        this.codigoTI = codigoTI;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreItemList = nombreItemList;
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

    public List<String> getNombreItemList() {
        return nombreItemList;
    }

    public void setNombreItemList(List<String> nombreItemList) {
        this.nombreItemList = nombreItemList;
    }
    
    public void addItem(String nombreItem){
        if(nombreItemList ==null){
            nombreItemList = new ArrayList<>();
        }
        nombreItemList.add(nombreItem);
    }
    public void removeItem(String nombreItem){
        nombreItemList.remove(nombreItem);
    }
    
    
    public String concatItems() {
        String itemsConcat = null;
        int couter = 0; 
        for(String item : nombreItemList){
            if(couter >0){
                itemsConcat = " - " +item;
            }else{
                itemsConcat = item;
            }
        }
        return itemsConcat;
    }
}
