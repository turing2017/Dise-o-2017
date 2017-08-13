/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos;

import datosPrueba.DatosPrueba;
import org.hibernate.cfg.Configuration;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Utils.HibernateUtil;
/**
 *
 * @author Markz
 */
public class SistemaPagoImpuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //  DatosPrueba dp = new DatosPrueba();
     // dp.generarDatosPrueba();
     new ControladorGestionarTipoImpuesto().iniciar();
    }
    
}
