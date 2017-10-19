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
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOLiquidacion;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoConsultarLiquidacion;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Empresa.ConsultarLiquidacion.IUConsultarLiquidacion;


/**
 *
 * @author Dario
 */
public class ControladorConsultarLiquidacion {
 
    private ExpertoConsultarLiquidacion experto = (ExpertoConsultarLiquidacion) FabricaExpertos.getInstancia().crearExperto("CU18");

    public ControladorConsultarLiquidacion() {
    }
   
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerTipoImpuestos() {
        return experto.obtenerTipoImpuestos();
    }

    public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String itemAt, String text, Date fechadesde, Date fechahasta) {
        return experto.buscarLiquidacionConFiltro(itemAt, text, fechadesde, fechahasta);
    }

    public void validarUsuario() {
        try {
            experto.validarUsuario();
            IUConsultarLiquidacion UIConsultarLiquidacion= new IUConsultarLiquidacion();
            UIConsultarLiquidacion.setVisible(true);

        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es Administrador");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }

}
