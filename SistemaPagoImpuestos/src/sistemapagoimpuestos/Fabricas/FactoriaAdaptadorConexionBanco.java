package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Adaptador.AdaptadorBanco;
import sistemapagoimpuestos.Entity.ParametroSistema;

/**
 *
 * @author lunamarcos
 */
public class FactoriaAdaptadorConexionBanco {
    
    private static FactoriaAdaptadorConexionBanco instancia;
    
    public FactoriaAdaptadorConexionBanco(){
        
    }
    
    public static FactoriaAdaptadorConexionBanco getInstancia(){
        if (instancia == null) {
            instancia = new FactoriaAdaptadorConexionBanco();
        }
        return instancia;
    }
    
    public Object getAdaptadorConexionBanco(ParametroSistema parametro) {
        
        String nombreBancoParametroSistema = parametro.getNombreBancoParametroSistema();
        
        switch (nombreBancoParametroSistema) {
            case "Galicia": 
                return new AdaptadorBanco();
            default:
                return null;
        }  
    }
}
