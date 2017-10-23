/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Dto;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ggiorgi
 */
public class DTOAccionesSistema {

    private Integer nivel;
    private String accion;
    private String descripcionAccion;
    private Date fechaHoraAccion;

    public DTOAccionesSistema(Integer nivel, String accion, String descripcionAccion, Date fechaHoraAccion) {
        this.nivel = nivel;
        this.accion = accion;
        this.descripcionAccion = descripcionAccion;
        this.fechaHoraAccion = fechaHoraAccion;
    }

    //Getters
    public Integer getNivel() {
        return nivel;
    }

    public String getAccion() {
        return accion;
    }

    public String getDescripcionAccion() {
        return descripcionAccion;
    }

    public Date getFechaHoraAccion() {
        return fechaHoraAccion;
    }

    //Setters
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setDescripcionAccion(String descripcionAccion) {
        this.descripcionAccion = descripcionAccion;
    }

    public void setFechaHoraAccion(Date fechaHoraAccion) {
        this.fechaHoraAccion = fechaHoraAccion;
    }

    //Others
    /**
     * Imprime las acciones realizadas en el calcular liquidación
     */
    public void imprimirSTD() {

        String separador1 = "", separador2 = "";

        System.out.println();

        for (int i = 0; i <= nivel; i++) {
            separador1 += "-----";
            separador2 += "     ";
        }
        System.out.println(fechaHoraAccion + " " + separador1 + " " + accion.toUpperCase());
//        System.out.println(String.format("%"+ nivel +"s", accion.toUpperCase()));
//        System.out.println(String.format("%"+ nivel + 5 +"s", "----------"));
//        System.out.println(accion.toUpperCase());
        System.out.println(separador1);
        String[] lineasDescripcion = descripcionAccion.split("\\r?\\n");
        for (String linea : lineasDescripcion) {
//            System.out.println(String.format("%"+ nivel + 5 +"s", linea));
            if (!linea.equals("")) {
                System.out.println(separador2 + " " + linea);
            }
        }
        System.out.println(separador1);
    }

}
