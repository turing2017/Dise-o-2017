/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOParametroCalculoEditable;
import sistemapagoimpuestos.Dto.DTOParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOTipoEmpresa;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Dto.DTOTipoDatoItem;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ParametroCalculoEditable;
import sistemapagoimpuestos.Entity.ParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Entity.TipoDatoItem;

/**
 *
 * @author Markz
 */
public class ConvertDTO {

    private static ConvertDTO convertDTO;

    public static ConvertDTO getInstance() {
        if (convertDTO == null) {
            convertDTO = new ConvertDTO();
        }
        return convertDTO;
    }

    public DTOEmpresa convertEmpresa(Empresa empresa) {
        DTOEmpresa dTOEmpresa = new DTOEmpresa();
        dTOEmpresa.setCuitEmpresa(empresa.getCuitEmpresa());
        dTOEmpresa.setNombreEmpresa(empresa.getNombreEmpresa());
        dTOEmpresa.setDireccionEmpresa(empresa.getDireccionEmpresa());
        dTOEmpresa.setFechaHoraInhabilitacionEmpresa(empresa.getFechaHoraInhabilitacionEmpresa());
        return dTOEmpresa;
    }

    public DTOItem convertItem(Item item) {
        DTOItem dTOItem = new DTOItem();
        dTOItem.setCodigoItem(item.getCodigoItem());
        dTOItem.setNombreItem(item.getNombreItem());
        dTOItem.setLongitudItem(item.getLongitudItem());
        dTOItem.setRequeridoItem(item.isRequeridoItem());
        dTOItem.setFechaHoraInhabilitacionItem(item.getFechaHoraInhabilitacionItem());
        dTOItem.setDtoTipoDatoItem(convertTipoDatoItem(item.getTipoDatoItem()));
        return dTOItem;
    }

    public DTOTipoUsuario convertTipoUsuario(TipoUsuario tipoUsuario) {
        DTOTipoUsuario dtoTipoUsuario = new DTOTipoUsuario();
        dtoTipoUsuario.setNombreDTOTipoUsuario(tipoUsuario.getNombreTipoUsuario());
        dtoTipoUsuario.setFechaHoraInhabilitacionDTOTipoUsuario(tipoUsuario.getFechaHoraInhabilitacionTipoUsuario());
        return dtoTipoUsuario;
    }
    
    public DTOTipoEmpresa convertTipoEmpresa(TipoEmpresa tipoEmpresa){
        return new DTOTipoEmpresa(tipoEmpresa.getNombreTipoEmpresa(), tipoEmpresa.getfechaInhabilitacionTipoEmpresa());    
    }

    public DTOUsuario convertUsuario(Usuario usuario) {
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setNombreDTOUsuario(usuario.getNombreUsuario());
        dtoUsuario.setPasswordDTOUsuario(usuario.getPasswordUsuario());
        dtoUsuario.setFechaHoraInhabilitacionDTOUsuario(usuario.getFechaHoraInhabilitacionUsuario());
        dtoUsuario.setFechaHoraUltimoIngresoSistemaDTOUsuario(usuario.getFechaHoraUltimoIngresoSistemaUsuario());
        dtoUsuario.setTipoUsuarioDTOUsuario(usuario.tipoUsuario.getNombreTipoUsuario());
        if (usuario.getEmpresa() == null) {
            dtoUsuario.setEmpresaDTOUsuario("");
        } else {
            dtoUsuario.setEmpresaDTOUsuario(usuario.getEmpresa().getNombreEmpresa());
        }
        
        return dtoUsuario;
    }
    
    public DTOTipoDatoItem convertTipoDatoItem(TipoDatoItem tipoDatoItem){
        return new DTOTipoDatoItem(tipoDatoItem.getCodigoTipoDatoItem(), tipoDatoItem.getNombreTipoDatoItem());
    }
    
    public DTOParametroCalculoEditable convertParametroCalculoEditable(ParametroCalculoEditable parametroCE){
        DTOParametroCalculoEditable  dtoParamCE = new DTOParametroCalculoEditable();
        dtoParamCE.setSiEditablePCEditable(parametroCE.getSiEditablePCEditable());
        dtoParamCE.setNoEditablePCEditable(parametroCE.getNoEditablePCEditable());
        return dtoParamCE;
    }
    
    public DTOParametroCalculoPeriodicidad convertParametroCalculoPeriodicidad(ParametroCalculoPeriodicidad parametroCP){
        DTOParametroCalculoPeriodicidad dtoParamCP = new DTOParametroCalculoPeriodicidad();
        dtoParamCP.setAnualPCPeriodicidad(parametroCP.getAnualPCPeriodicidad());
        dtoParamCP.setBimestralPCPeriodicidad(parametroCP.getBimestralPCPeriodicidad());
        dtoParamCP.setCuatrimestralPCPeriodicidad(parametroCP.getCuatrimestralPCPeriodicidad());
        dtoParamCP.setMensualPCPeriodicidad(parametroCP.getMensualPCPeriodicidad());
        dtoParamCP.setQuincenalPCPeriodicidad(parametroCP.getQuincenalPCPeriodicidad());
        dtoParamCP.setSemestralPCPeriodicidad(parametroCP.getSemestralPCPeriodicidad());
        dtoParamCP.setTrimestralPCPeriodicidad(parametroCP.getTrimestralPCPeriodicidad());
        return dtoParamCP;
    }
   
}
