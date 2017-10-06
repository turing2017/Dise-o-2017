package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Adaptador.AdaptadorBanco;
import sistemapagoimpuestos.Adaptador.AdaptadorBancoImpl.AdaptadorBancoGalicia;
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
    
    public AdaptadorBanco getAdaptadorConexionBanco(ParametroSistema parametro) {
        
        String nombreBancoParametroSistema = parametro.getNombreBancoParametroSistema();
        
        switch (nombreBancoParametroSistema) {
            case "Galicia": 
                return new AdaptadorBancoGalicia();
            default:
                return null;
        }  
    }
}
