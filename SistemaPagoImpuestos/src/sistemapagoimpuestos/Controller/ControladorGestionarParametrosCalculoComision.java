/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import sistemapagoimpuestos.Dto.DTOParametroCalculoEditable;
import sistemapagoimpuestos.Dto.DTOParametroCalculoPeriodicidad;
import sistemapagoimpuestos.Expert.ExpertoGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarParametrosPeriodicidad.IUGestionarParametroCalculoEditable;
import sistemapagoimpuestos.View.Admin.GestionarParametrosPeriodicidad.IUGestionarParametrosCalculoPeriodicidad;
import sistemapagoimpuestos.View.Admin.GestionarParametrosPeriodicidad.IUGestionarParametrosComision;

/**
 *
 * @author Gabriel
 */
public class ControladorGestionarParametrosCalculoComision {
    
    private ExpertoGestionarParametrosCalculoComision experto = (ExpertoGestionarParametrosCalculoComision) FabricaExpertos.getInstancia().crearExperto("CU22");
    
    public ControladorGestionarParametrosCalculoComision() {
    }
    
    public void validarUsuario() {
        try {
            experto.validarUsuario();
            IUGestionarParametrosComision UIGestionarParametrosComision = new IUGestionarParametrosComision();
            UIGestionarParametrosComision.setVisible(true);
            UIGestionarParametrosComision.setLocationRelativeTo(null);
            UIGestionarParametrosComision.setTitle("Gestionar Parámetros de Cálculo de Comisión");
            
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es Administrador");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }
    
    public void modificarParametrosPeriodicidad(double mensual, double bimestral, double trimestral, double cuatrimestral, double semestral, double anual, double quincenal) {
        experto.modificarParametrosPeriodicidad(mensual, bimestral, trimestral, cuatrimestral, semestral, anual, quincenal);
    }
    
    public void modificarParametrosEditable(double montoSiEditable, double montoNoEditable) {
        experto.modificarParametrosEditable(montoSiEditable, montoNoEditable);
    }
    
    public DTOParametroCalculoPeriodicidad obtenerParametrosCalculoPeriodicidad() {
        return experto.obtenerParametrosCalculoPeriodicidad();
    }
    
    public DTOParametroCalculoEditable obtenerParametrosCalculoEditable() {
        return experto.obtenerParametrosCalculoEditable();
    }
    
    public void pantallaIUGestionarParametrosCalculoPeriodicidad() {
        IUGestionarParametrosCalculoPeriodicidad gestionarParametrosCalculoPeriodicidad = new IUGestionarParametrosCalculoPeriodicidad();
        gestionarParametrosCalculoPeriodicidad.setTitle("Gestionar Parámetros de Cálculo de Periodicidad");
                gestionarParametrosCalculoPeriodicidad.setResizable(false);
                gestionarParametrosCalculoPeriodicidad.setLocationRelativeTo(null);
                gestionarParametrosCalculoPeriodicidad.setVisible(true);
    }
    
    public void pantallaIUGestionarParametrosCalculoEditable() {
        IUGestionarParametroCalculoEditable gestionarParametrosCalculoEditable = new IUGestionarParametroCalculoEditable();
        gestionarParametrosCalculoEditable.setTitle("Gestionar Parámetros de Cálculo Editable");
                gestionarParametrosCalculoEditable.setResizable(false);
                gestionarParametrosCalculoEditable.setLocationRelativeTo(null);
                gestionarParametrosCalculoEditable.setVisible(true);
    }

}
