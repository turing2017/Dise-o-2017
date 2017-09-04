/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOItem;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;

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
        return dTOItem;
    }

    public DTOTipoUsuario convertTipoUsuario(TipoUsuario tipoUsuario) {
        DTOTipoUsuario dtoTipoUsuario = new DTOTipoUsuario();
        dtoTipoUsuario.setNombreDTOTipoUsuario(tipoUsuario.getNombreTipoUsuario());
        dtoTipoUsuario.setFechaHoraInhabilitacionDTOTipoUsuario(tipoUsuario.getFechaHoraInhabilitacionTipoUsuario());
        return dtoTipoUsuario;
    }

    public DTOUsuario convertUsuario(Usuario usuario) {
        DTOUsuario dtoUsuario = new DTOUsuario();
        dtoUsuario.setNombreDTOUsuario(usuario.getNombreUsuario());
        dtoUsuario.setPasswordDTOUsuario(usuario.getNombreUsuario());
        dtoUsuario.setFechaHoraInhabilitacionDTOUsuario(usuario.getFechaHoraInhabilitacionUsuario());
        dtoUsuario.setFechaHoraUltimoIngresoSistemaDTOUsuario(usuario.getFechaHoraUltimoIngresoSistemaUsuario());
        return dtoUsuario;
    }
}
