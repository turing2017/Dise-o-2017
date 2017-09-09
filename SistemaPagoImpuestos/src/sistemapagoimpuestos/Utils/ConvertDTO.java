/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoDatoItem;

/**
 *
 * @author Markz
 */
public class ConvertDTO {
    private static ConvertDTO convertDTO;
    
    public static ConvertDTO getInstance(){
        if(convertDTO==null){
            convertDTO = new ConvertDTO();
        }
        return convertDTO;
    }
    
    public DTOEmpresa convertEmpresa(Empresa empresa){
        DTOEmpresa dTOEmpresa = new DTOEmpresa();
        dTOEmpresa.setCuitEmpresa(empresa.getCuitEmpresa());
        dTOEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
        dTOEmpresa.setDireccionEmpresa(empresa.getDireccionEmpresa());
        dTOEmpresa.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());
        return dTOEmpresa;
        
    }
    
    public DTOItem convertItem(Item  item){
        DTOItem dTOItem = new DTOItem();
        dTOItem.setCodigoItem(item.getCodigoItem());
        dTOItem.setNombreItem(item.getNombreItem());
        dTOItem.setLongitudItem(item.getLongitudItem());
        dTOItem.setRequeridoItem(item.isRequeridoItem());
        dTOItem.setFechaHoraInhabilitacionItem(item.getFechaHoraInhabilitacionItem());
        dTOItem.setDtoTipoDatoItem(convertTipoDatoItem(item.getTipoDatoItem()));
        return dTOItem;
        
    }
    
    public DTOTipoDatoItem convertTipoDatoItem(TipoDatoItem tipoDatoItem){
        return new DTOTipoDatoItem(tipoDatoItem.getCodigoTipoDatoItem(), tipoDatoItem.getNombreTipoDatoItem());
    }
}
