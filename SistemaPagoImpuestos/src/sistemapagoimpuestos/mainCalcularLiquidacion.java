/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos;

import java.util.ArrayList;
import java.util.Date;
import sistemapagoimpuestos.Controller.ControladorCalcularLiquidaciones;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;

/**
 *
 * @author mviss
 */
public class mainCalcularLiquidacion {
    public static void main(String[] args){
        ControladorCalcularLiquidaciones calcularLiquidaciones = new ControladorCalcularLiquidaciones();
        ArrayList<DTOAccionesSistema> accionesSistemas = new ArrayList<>();
        accionesSistemas = calcularLiquidaciones.iniciar(accionesSistemas);
        for (DTOAccionesSistema acciones : accionesSistemas){
            acciones.imprimirSTD();
        }
    }
}
