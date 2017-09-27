/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaMovistar;

/**
 *
 * @author mviss
 */
public class FabricaAdaptadores {
    
    private static FabricaAdaptadores instancia;

    public FabricaAdaptadores() {
    }

    public static FabricaAdaptadores getInstancia() {
        if (instancia == null) {
            instancia = new FabricaAdaptadores();
        }
        return instancia;
    }

    public Object crearExperto(String nombreEmpresa) {
             switch (nombreEmpresa) {
           
            case "DGR": 
                return new AdaptadorEmpresaMovistar();
            case "Claro":
                return new AdaptadorEmpresaClaro();
            default:
                return null;
        }  
    }
}
