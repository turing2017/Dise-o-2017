/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Decorators.DecoradorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Decorators.DecoradorGestionarTipoDeCuenta;
import sistemapagoimpuestos.Decorators.DecoradorGestionarTipoImpuesto;
import sistemapagoimpuestos.Decorators.DecoradorGestionarTipoUsuario;
import sistemapagoimpuestos.Decorators.DecoradorPagarImpuestos;

/**
 *
 * @author mvissio
 */
public class FabricaExpertos {
    private static FabricaExpertos instancia;

    public FabricaExpertos ()
    {
    }

    public static FabricaExpertos getInstancia ()
    {
        if (instancia == null)
        {
            instancia = new FabricaExpertos();
        }
        return instancia;
    }

    public Object crearExperto (String casoDeUso)
    {
        switch (casoDeUso)
        {
            case "CU02":
                return new DecoradorPagarImpuestos();  
            case "CU05":
                return new DecoradorGestionarTipoDeCuenta();  
            case "CU14":
                return new DecoradorGestionarTipoImpuesto();
            case "CU15":
                return new DecoradorGestionarEmpresaTipoImpuesto();
            case "CU06":
                return new DecoradorGestionarTipoUsuario();
            
            default:
                return null;
        }
    }
}
