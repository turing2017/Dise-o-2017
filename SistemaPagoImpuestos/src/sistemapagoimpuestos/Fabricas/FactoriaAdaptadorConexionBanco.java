package sistemapagoimpuestos.Fabricas;

import sistemapagoimpuestos.Adaptador.AdaptadorBanco;
import sistemapagoimpuestos.Adaptador.AdaptadorBancoImpl.AdaptadorBancoArgentino;
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
            case "Banco Argentino": 
                return new AdaptadorBancoArgentino();
            default:
                return null;
        }  
    }
}
