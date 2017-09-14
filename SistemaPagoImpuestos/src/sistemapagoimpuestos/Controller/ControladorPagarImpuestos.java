/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoPagarImpuestos;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;

/**
 *
 * @author mvissio
 */
public class ControladorPagarImpuestos {
    
    private ExpertoPagarImpuestos experto = (ExpertoPagarImpuestos) FabricaExpertos.getInstancia().crearExperto("CU02");

    public ControladorPagarImpuestos() {
    }

    // Método para recuperar los TipoDatoItem
    public List<DTOTipoImpuesto> buscarTipoImpuestos(){
        List<DTOTipoImpuesto> listado = experto.buscarTipoImpuestos();
        return listado;
    }
}
