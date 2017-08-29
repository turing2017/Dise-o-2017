package sistemapagoimpuestos.Controller;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaTipoImpuesto.IUGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaTipoImpuesto.IUGestionarEmpresaTipoImpuestoTrifurcacion;


public class ControladorGestionarEmpresaTipoImpuesto {
    private static ControladorGestionarEmpresaTipoImpuesto controladorGestionarEmpresaTipoImpuesto;
    private ExpertoGestionarEmpresaTipoImpuesto experto = (ExpertoGestionarEmpresaTipoImpuesto) FabricaExpertos.getInstancia().crearExperto("CU15");

    public ControladorGestionarEmpresaTipoImpuesto() {
    }
    
    public static ControladorGestionarEmpresaTipoImpuesto getInstance(){
        
        if(controladorGestionarEmpresaTipoImpuesto==null){
             controladorGestionarEmpresaTipoImpuesto = new ControladorGestionarEmpresaTipoImpuesto();
        }        
        return controladorGestionarEmpresaTipoImpuesto;
    }
    
    public List<DTOTipoImpuesto> iniciar(){
        List<DTOTipoImpuesto> listado = experto.iniciar();
        return listado;
    }
    
    public List<DTOEmpresa> buscarEmpresas(){
        List<DTOEmpresa> listado = experto.buscarEmpresas();
        return listado;
    }
    
    public List ingresarDatosETI(String nombreTipoImpuesto, String nombreEmpresa){
        List resultado = experto.ingresarDatosETI(nombreTipoImpuesto, nombreEmpresa);
        IUGestionarEmpresaTipoImpuestoTrifurcacion pantallaTri = new IUGestionarEmpresaTipoImpuestoTrifurcacion(resultado);
        pantallaTri.setVisible(true);
        
        return resultado;
    }
    
}
