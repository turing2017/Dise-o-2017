/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoConsultarLiquidacion;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Empresa.ConsultarLiquidacion.IUConsultarLiquidacion;

/**
 *
 * @author Dario
 */
public class ControladorConsultarLiquidacion {
    private static ControladorConsultarLiquidacion controladorConsultarLiquidacion;
    private ExpertoConsultarLiquidacion experto = (ExpertoConsultarLiquidacion) FabricaExpertos.getInstancia().crearExperto("CU18");

    public ControladorConsultarLiquidacion() {
    }
    
     public static ControladorConsultarLiquidacion getInstance()
    {
        if (controladorConsultarLiquidacion == null)
        {
            controladorConsultarLiquidacion = new ControladorConsultarLiquidacion();
        }
        return controladorConsultarLiquidacion;
    }
      // Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Empresa"))
        {
        IUConsultarLiquidacion pantallaPrincipal = new IUConsultarLiquidacion();
        pantallaPrincipal.setVisible(true); 
        pantallaPrincipal.setTitle("Consultar Liquidación");
        pantallaPrincipal.setLocationRelativeTo(null);
        }        
    }
public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){  
        return  experto.obtenerTipoImpuestos();
    }  
}
