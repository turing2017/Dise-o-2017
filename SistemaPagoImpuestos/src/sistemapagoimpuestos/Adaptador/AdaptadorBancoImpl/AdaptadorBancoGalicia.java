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
    public double consultarSaldo( String cbuCuenta){
        return empresasWs.obtenerSaldo( cbuCuenta);
    }
    
    @Override
    public void debitarSaldo(String cbuCuenta, double montoADebitar){
        try {
            if(!empresasWs.debitarMonto(cbuCuenta, montoADebitar)){
                throw new ExcepcionGenerica("Error Debito");
            }
        } catch (ExcepcionGenerica e){
            Excepciones.getInstance().errorGenerico("Error: Banco Galicia", "No se pudo debitar el pago.");
        }catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error de conexion", "No se pudo realizar el debito, intente mas tarde");
        }
    }
}
