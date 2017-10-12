package sistemapagoimpuestos.Adaptador.AdaptadorBancoImpl;

import sistemapagoimpuestos.Adaptador.AdaptadorBanco;
import ws.empresas.EmpresasWS;
import ws.empresas.EmpresasWSImplService;

/**
 *
 * @author lunamarcos
 */
public class AdaptadorBancoGalicia implements AdaptadorBanco{
    EmpresasWS empresasWs;
    public AdaptadorBancoGalicia(){
        EmpresasWSImplService wsImplService = new EmpresasWSImplService();
        empresasWs = wsImplService.getEmpresasWSImplPort();
    }
        
    public double consultarSaldo( String cbuCuenta){
        return empresasWs.obtenerSaldo( cbuCuenta);
    }
    
    public boolean debitarSaldo(String cbuCuenta, double montoADebitar){
        return empresasWs.debitarMonto(cbuCuenta, montoADebitar);
    }
}
