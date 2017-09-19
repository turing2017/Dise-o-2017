/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOParametroCalculoEditable;
import sistemapagoimpuestos.Dto.DTOParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Entity.ParametroCalculoEditable;
import sistemapagoimpuestos.Entity.ParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Gabriel
 */
public class ExpertoGestionarParametrosCalculoComision {

    Usuario usuario = new Usuario();

    // Metodo iniciar
    public String iniciar() {
        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";
    }

    public void modificarParametrosPeriodicidad(double mensual, double bimestral, double trimestral, double cuatrimestral, double semestral, double anual, double quincenal) {
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null);
        ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
        parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
        parametrosCalculoPeriodicidad.setMensualPCPeriodicidad(mensual);
        parametrosCalculoPeriodicidad.setBimestralPCPeriodicidad(bimestral);
        parametrosCalculoPeriodicidad.setTrimestralPCPeriodicidad(trimestral);
        parametrosCalculoPeriodicidad.setCuatrimestralPCPeriodicidad(cuatrimestral);
        parametrosCalculoPeriodicidad.setQuincenalPCPeriodicidad(quincenal);
        parametrosCalculoPeriodicidad.setSemestralPCPeriodicidad(semestral);
        parametrosCalculoPeriodicidad.setAnualPCPeriodicidad(anual);
        FachadaPersistencia.getInstance().guardar(parametrosCalculoPeriodicidad);

    }

    public void modificarParametrosEditable(double montoSiEditable, double montoNoEditable) {
        ParametroCalculoEditable parametrosCalculoEditable;

        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoEditable", null);
        parametrosCalculoEditable = (ParametroCalculoEditable) parametros.get(0);
        parametrosCalculoEditable.setSiEditablePCEditable(montoSiEditable);
        parametrosCalculoEditable.setNoEditablePCEditable(montoNoEditable);

        FachadaPersistencia.getInstance().guardar(parametrosCalculoEditable);

    }

    public DTOParametroCalculoPeriodicidad obtenerParametrosCalculoPeriodicidad() {
        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoPeriodicidad", null);
        ParametroCalculoPeriodicidad parametrosCalculoPeriodicidad;
        DTOParametroCalculoPeriodicidad dtoParametroCP;
        if (parametros.isEmpty()) {
            parametrosCalculoPeriodicidad = new ParametroCalculoPeriodicidad();
            parametrosCalculoPeriodicidad.setAnualPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setBimestralPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setCuatrimestralPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setMensualPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setQuincenalPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setSemestralPCPeriodicidad(0.0);
            parametrosCalculoPeriodicidad.setTrimestralPCPeriodicidad(0.0);
            dtoParametroCP = ConvertDTO.getInstance().convertParametroCalculoPeriodicidad(parametrosCalculoPeriodicidad);
            FachadaPersistencia.getInstance().guardar(parametrosCalculoPeriodicidad);
            return dtoParametroCP;
        } else {
            parametrosCalculoPeriodicidad = (ParametroCalculoPeriodicidad) parametros.get(0);
            dtoParametroCP = ConvertDTO.getInstance().convertParametroCalculoPeriodicidad(parametrosCalculoPeriodicidad);
            return dtoParametroCP;
        }
    }

    public DTOParametroCalculoEditable obtenerParametrosCalculoEditable() {

        List<Object> parametros = FachadaPersistencia.getInstance().buscar("ParametroCalculoEditable", null);
        ParametroCalculoEditable parametrosCalculoEditable;
        DTOParametroCalculoEditable dtoParametroCE;

        if (parametros.isEmpty()) {
            parametrosCalculoEditable = new ParametroCalculoEditable();
            parametrosCalculoEditable.setSiEditablePCEditable(0.0);
            parametrosCalculoEditable.setNoEditablePCEditable(0.0);
            dtoParametroCE = ConvertDTO.getInstance().convertParametroCalculoEditable(parametrosCalculoEditable);
            FachadaPersistencia.getInstance().guardar(parametrosCalculoEditable);
            return dtoParametroCE;
        } else {
            parametrosCalculoEditable = (ParametroCalculoEditable) parametros.get(0);
            dtoParametroCE = ConvertDTO.getInstance().convertParametroCalculoEditable(parametrosCalculoEditable);
            return dtoParametroCE;
        }

    }

}
