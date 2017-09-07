
import fev1.dif.afip.gov.ar.FECAEAGetResponse;
import fev1.dif.afip.gov.ar.FECotizacionResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodri
 */
public class NewClass {

    private static FECAEAGetResponse fecaeaConsultar(fev1.dif.afip.gov.ar.FEAuthRequest auth, int periodo, short orden) {
        fev1.dif.afip.gov.ar.Service service = new fev1.dif.afip.gov.ar.Service();
        fev1.dif.afip.gov.ar.ServiceSoap port = service.getServiceSoap();
        return port.fecaeaConsultar(auth, periodo, orden);
    }

    private static FECotizacionResponse feParamGetCotizacion(fev1.dif.afip.gov.ar.FEAuthRequest auth, java.lang.String monId) {
        fev1.dif.afip.gov.ar.Service service = new fev1.dif.afip.gov.ar.Service();
        fev1.dif.afip.gov.ar.ServiceSoap port = service.getServiceSoap();
        return port.feParamGetCotizacion(auth, monId);
    }
    
}
