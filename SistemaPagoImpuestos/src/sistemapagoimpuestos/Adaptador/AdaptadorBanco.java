package sistemapagoimpuestos.Adaptador;

/**
 *
 * @author lunamarcos
 */
public class AdaptadorBanco {
    public double consultarSaldo(String cbuCuenta){
        // Esto esta hardcodeado, deberia recuperar un saldo conectandose
        return 7890.50;
    }
    
    public boolean debitarSaldo(String cbuCuenta, double montoADebitar){
        // Esto esta hardcodeado, deberia conectarse e informar del pago
        return true;
    }
}
