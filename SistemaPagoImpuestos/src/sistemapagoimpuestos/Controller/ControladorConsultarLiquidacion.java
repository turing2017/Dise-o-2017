/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

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
      // Metodo iniciar
    public void iniciar(DTOUsuario usuario){
      IUConsultarLiquidacion consultarLiquidacionIU = new IUConsultarLiquidacion(usuario);
    }

    public ArrayList<DTOEmpresaTipoImpuesto> obtenerTipoImpuestos(DTOUsuario usuario) {
        return experto.obtenerTipoImpuestos(usuario);
    }

    public ArrayList<DTOLiquidacion> buscarLiquidacionConFiltro(String itemAt, String text, Date fechadesde, Date fechahasta) {
        return experto.buscarLiquidacionConFiltro(itemAt, text, fechadesde, fechahasta);
    }

}
