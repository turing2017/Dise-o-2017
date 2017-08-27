package sistemapagoimpuestos.Controller;

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
    
    
    public void iniciar(){
        System.out.println(experto.iniciar());
        if ("Administrador".equals(experto.iniciar())){
            AdminMenu pantallaPrincipal = new AdminMenu();
            pantallaPrincipal.setVisible(true);
        }
    }
    
}
