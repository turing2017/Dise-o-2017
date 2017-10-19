/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOAccionesSistema;
import sistemapagoimpuestos.Expert.ExpertoCalcularLiquidaciones;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarLiquidacion.IUGestionarLiquidacion;

/**
 *
 * @author Gabriel
 */
public class ControladorCalcularLiquidaciones {

    private ExpertoCalcularLiquidaciones experto = (ExpertoCalcularLiquidaciones) FabricaExpertos.getInstancia().crearExperto("CU03");

      public void validadarUsuario() {
        try {
            experto.validarUsuario();
        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no es Administrador");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }
    
    public ControladorCalcularLiquidaciones() {
    }
    
    public ArrayList<DTOAccionesSistema> iniciar(ArrayList<DTOAccionesSistema> dtosAccionesSistema){
        return experto.iniciar(dtosAccionesSistema);
    }

}
