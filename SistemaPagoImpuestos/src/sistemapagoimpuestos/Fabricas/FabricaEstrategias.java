/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Estrategias.EstrategiaCalculoComision;
import sistemapagoimpuestos.Estrategias.EstrategiaEditable;
import sistemapagoimpuestos.Estrategias.EstrategiaPeriodicidad;

/**
 *
 * @author ggiorgi
 */
public class FabricaEstrategias {
     private static FabricaEstrategias instancia;

    public FabricaEstrategias() {
    }

    public static FabricaEstrategias getInstancia() {
        if (instancia == null) {
            instancia = new FabricaEstrategias();
        }
        return instancia;
    }
    
   public EstrategiaCalculoComision obtenerEstrategia(Operacion operacion){
       
       if (operacion.getEmpresaTipoImpuesto().getTipoEmpresa().getNombreTipoEmpresa().toLowerCase().equals("servicio")) {
            return new EstrategiaPeriodicidad();
        } else {
            return new EstrategiaEditable();
        }
    }
}
