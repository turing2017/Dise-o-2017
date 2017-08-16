/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos;

import datosPrueba.DatosPrueba;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.cfg.Configuration;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Controller.ControladorGestionarTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
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
     //new ControladorGestionarTipoImpuesto().iniciar();
     new ControladorGestionarEmpresaAdherida().iniciar();
    }
    
}
