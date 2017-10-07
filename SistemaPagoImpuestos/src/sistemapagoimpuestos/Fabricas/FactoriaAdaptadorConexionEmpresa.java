/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Adaptador.AdaptadorEmpresa;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl.AdaptadorEmpresaClaro;
import sistemapagoimpuestos.Adaptador.AdaptadorEmpresaImpl.AdaptadorEmpresaDgr;
import sistemapagoimpuestos.Entity.Empresa;

/**
 *
 * @author mviss
 */
public class FactoriaAdaptadorConexionEmpresa {
    
    private static FactoriaAdaptadorConexionEmpresa instancia;

    public FactoriaAdaptadorConexionEmpresa() {
    }

    public static FactoriaAdaptadorConexionEmpresa getInstancia() {
        if (instancia == null) {
            instancia = new FactoriaAdaptadorConexionEmpresa();
        }
        return instancia;
    }

    public AdaptadorEmpresa getAdaptadorConexionEmpresa(Empresa empresa) {
             switch (empresa.getNombreEmpresa()) {
           
            case "DGR": 
                return new AdaptadorEmpresaDgr();
            case "Claro":
                return new AdaptadorEmpresaClaro();
            default:
                return null;
        }  
    }
}
