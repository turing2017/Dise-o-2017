package sistemapagoimpuestos.Adaptador.AdaptadorBancoImpl;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
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

    @Override    
    public double consultarSaldo( String cbuCuenta) throws Exception{
        return empresasWs.obtenerSaldo( cbuCuenta);
    }
    
    @Override
    public void debitarSaldo(String cbuCuenta, double montoADebitar) throws Exception{        
        if(!empresasWs.debitarMonto(cbuCuenta, montoADebitar)){
            throw new ExcepcionGenerica("No se pudo debitar el pago.");
        }
    }
}
