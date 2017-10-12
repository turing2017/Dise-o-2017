/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Expert.ExpertoCalcularLiquidaciones;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Gabriel
 */
public class DecoradorCalcularLiquidaciones extends ExpertoCalcularLiquidaciones{

    @Override
    public ArrayList<DTOAccionesSistema> iniciar(ArrayList<DTOAccionesSistema> dtosAccionesSistema) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOAccionesSistema> dtos = super.iniciar(dtosAccionesSistema);
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtos;
    }
}
