/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Expert.ExpertoConsultarLiquidacion;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Dario
 */
public class DecoradorConsultarLiquidacion extends ExpertoConsultarLiquidacion {
    
   @Override
   public ArrayList<DTOEmpresaTipoImpuesto> consultarLiquidacion(DTOUsuario usuario) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaTipoImpuesto> listDtos = super.consultarLiquidacion(usuario); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDtos;
    }
}
