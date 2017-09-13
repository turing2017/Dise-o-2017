/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Decorators.DecoradorGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Decorators.DecoradorGestionarParametrosCalculoComision;
import sistemapagoimpuestos.Decorators.DecoradorGestionarItem;
import sistemapagoimpuestos.Decorators.DecoradorGestionarTipoDeCuenta;
import sistemapagoimpuestos.Decorators.DecoradorGestionarTipoImpuesto;
import sistemapagoimpuestos.Decorators.DecoradorGestionarTipoUsuario;
import sistemapagoimpuestos.Decorators.DecoradorGestionarUsuario;
import sistemapagoimpuestos.Decorators.DecoradorLoguearUsuario;
import sistemapagoimpuestos.Decorators.DecoradorPagarImpuestos;
import sistemapagoimpuestos.Decorators.DecoradorGestionarEmpresaAdherida;

/**
 *
 * @author mvissio
 */
public class FabricaExpertos {

    private static FabricaExpertos instancia;

    public FabricaExpertos() {
    }

    public static FabricaExpertos getInstancia() {
        if (instancia == null) {
            instancia = new FabricaExpertos();
        }
        return instancia;
    }

    public Object crearExperto(String casoDeUso) {
        switch (casoDeUso) {

            case "CU02":
                return new DecoradorPagarImpuestos();
            case "CU05":
                return new DecoradorGestionarTipoDeCuenta();
            case "CU13":
                return new DecoradorGestionarItem();
            case "CU14":
                return new DecoradorGestionarTipoImpuesto();
            case "CU15":
                return new DecoradorGestionarEmpresaTipoImpuesto();
            case "CU22":
                return new DecoradorGestionarParametrosCalculoComision();
            case "CU06":
                return new DecoradorGestionarTipoUsuario();
            case "CU07":
                return new DecoradorGestionarUsuario();
            case "CU08":
                return new DecoradorLoguearUsuario();
            case "CU10":
                return new DecoradorGestionarEmpresaAdherida();
            default:
                return null;
        }
    }
}
