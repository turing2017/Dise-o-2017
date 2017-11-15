/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import sistemapagoimpuestos.Dto.DTOAccionesSistema;

/**
 *
 * @author ggiorgi
 */
public class PrinterCalculoLiquidaciones {

    public void imprimirSTD(DTOAccionesSistema dto) {

        String separador1 = "", separador2 = "";

        System.out.println();

        for (int i = 0; i <= dto.getNivel(); i++) {
            separador1 += "-----";
            separador2 += "     ";
        }
        System.out.println(dto.getFechaHoraAccion() + " " + separador1 + " " + dto.getAccion().toUpperCase());
        System.out.println(separador1);
        String[] lineasDescripcion = dto.getDescripcionAccion().split("\\r?\\n");
        for (String linea : lineasDescripcion) {
            if (!linea.equals("")) {
                System.out.println(separador2 + " " + linea);
            }
        }
        System.out.println(separador1);
    }
}
