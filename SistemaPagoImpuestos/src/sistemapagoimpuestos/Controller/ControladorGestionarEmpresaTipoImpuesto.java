package sistemapagoimpuestos.Controller;

import java.util.List;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarEmpresaTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.GestionarEmpresaTipoImpuesto.AdminMenu;

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
        if(experto.validar().equals("Administrador")){
            AdminMenu pantallaPrincipal = new AdminMenu();
            pantallaPrincipal.setVisible(true); 
        }
        return experto.iniciar();

    }
    
}
