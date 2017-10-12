/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Expert.ExpertoCalcularLiquidaciones;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;

/**
 *
 * @author Gabriel
 */
public class ControladorCalcularLiquidaciones {

    private ExpertoCalcularLiquidaciones experto = (ExpertoCalcularLiquidaciones) FabricaExpertos.getInstancia().crearExperto("CU03");

    public ControladorCalcularLiquidaciones() {
    }
    
    public ArrayList<DTOAccionesSistema> iniciar(ArrayList<DTOAccionesSistema> dtosAccionesSistema){
        return experto.iniciar(dtosAccionesSistema);
    }

}
