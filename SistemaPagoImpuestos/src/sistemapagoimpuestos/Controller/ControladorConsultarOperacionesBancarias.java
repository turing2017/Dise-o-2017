/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sistemapagoimpuestos.Dto.DTOOperacionConsultarOperacionesBancarias;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoConsultarOperacionesBancarias;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Empresa.ConsultarOperacionesBancarias.IUConsultarOperacionesBancarias;


/**
 *
 * @author vande
 */
public class ControladorConsultarOperacionesBancarias {
    private ExpertoConsultarOperacionesBancarias experto = (ExpertoConsultarOperacionesBancarias) FabricaExpertos.getInstancia().crearExperto("CU17");

    
   
    public List<DTOTipoImpuesto> obtenerTipoImpuestos() {
        return experto.obtenerTipoImpuestos();
    }

    public List<DTOOperacionConsultarOperacionesBancarias> buscarOperacionesConFiltro(String nombreTipoImpuesto, String nombreEmpresa, Date fechadesde, Date fechahasta) {
        return experto.buscarOperacionesConFiltro(nombreTipoImpuesto, nombreEmpresa, fechadesde, fechahasta);
    }

    public void validarUsuario() {
        try {
            experto.validarUsuario();
            IUConsultarOperacionesBancarias iUConsultarOperacionesBancarias= new IUConsultarOperacionesBancarias();
            iUConsultarOperacionesBancarias.setVisible(true);
            iUConsultarOperacionesBancarias.setLocationRelativeTo(null);
            iUConsultarOperacionesBancarias.setTitle("Consultar Operaciones Bancarias - EMPRESA");

        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no corresponde a un usuario de Empresa");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }



}

