/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Adaptador;

/**
 *
 * @author Maximiliano
 */
public interface AdaptadorBanco {
    public double consultarSaldo( String cbuCuenta) throws Exception;
    public void debitarSaldo(String cbuCuenta, double montoADebitar) throws Exception;
}
