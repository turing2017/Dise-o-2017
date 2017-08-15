package sistemapagoimpuestos.Controller;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuesto;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoAlta;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoConsultar;
import sistemapagoimpuestos.View.Admin.IUGestionarTipoImpuestoModificar;


public class ControladorGestionarTipoImpuesto {
    
    private static ControladorGestionarTipoImpuesto controladorGestionarTipoImpuesto;

    public ControladorGestionarTipoImpuesto() {
    }
    
    public static ControladorGestionarTipoImpuesto getInstance()
    {
        if (controladorGestionarTipoImpuesto == null)
        {
            controladorGestionarTipoImpuesto = new ControladorGestionarTipoImpuesto();
        }
        return controladorGestionarTipoImpuesto;
    }
    
    
    private ExpertoGestionarTipoImpuesto experto = (ExpertoGestionarTipoImpuesto) FabricaExpertos.getInstancia().crearExperto("CU14");
    
    // Metodo iniciar
    public void iniciar(){
        if(experto.iniciar().equals("Administrador")){
        IUGestionarTipoImpuesto pantallaPrincipal = new IUGestionarTipoImpuesto();
        pantallaPrincipal.setVisible(true); 
        }        
    }
    
    // Funcion para mostrar la pantalla adecuada, en base a la opción seleccionada
    public void opcionSeleccionada(String opcion, Object object){
        switch(opcion) {
        case "Alta" :
        // Muestro pantalla de Alta
            IUGestionarTipoImpuestoAlta pantallaAlta = new IUGestionarTipoImpuestoAlta();
            pantallaAlta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaAlta.setVisible(true); // La hago visible
        break; // optional
   
        case "Modificar" :
        // Muestro pantalla de Modificación
            DTOTipoImpuesto dtoTi = obtenerTipoImpuesto((int) object);
            if(dtoTi != null){
                IUGestionarTipoImpuestoModificar pantallaModificar= new IUGestionarTipoImpuestoModificar();
                pantallaModificar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
                pantallaModificar.setVisible(true); // La hago visible
                pantallaModificar.setTextfield_nombre(dtoTi.getNombreDTOTipoImpuesto());
                pantallaModificar.setNombre_actual(dtoTi.getNombreDTOTipoImpuesto());
                pantallaModificar.setCheckbox_esEditable(dtoTi.isEsMontoEditableDTOTipoImpuesto());
                if(dtoTi.getFechaHoraInhabilitacionDTOTipoImpuesto()==null){
                    pantallaModificar.setCheckbox_Habilitar(true);
                }else{
                    pantallaModificar.setCheckbox_Habilitar(false);
                }
            }
            
        break; // optional
        
        case "Consultar" :
        // Muestro pantalla de Consultar
            ArrayList<DTOTipoImpuesto> listDtoTipoImpuesto = obtenerTipoImpuestos();
            
            String [] columnas = {"Codigo", "Nombre","Estado", "Fecha Inhabilitación"};
            DefaultTableModel dtm = new DefaultTableModel(null, columnas);
            for(DTOTipoImpuesto dtoTipoImpuesto :listDtoTipoImpuesto){
                Vector<Object> vect = new Vector<>();
                vect.add(dtoTipoImpuesto.getCodigoDTOTipoImpuesto());
                vect.add(dtoTipoImpuesto.getNombreDTOTipoImpuesto());
                vect.add(dtoTipoImpuesto.isEsMontoEditableDTOTipoImpuesto());
                vect.add(dtoTipoImpuesto.getFechaHoraInhabilitacionDTOTipoImpuesto());
                dtm.addRow(vect);
            }          
            IUGestionarTipoImpuestoConsultar pantallaConsultar= new IUGestionarTipoImpuestoConsultar();
            pantallaConsultar.getTabla_tipo_impuesto().setModel(dtm);
            pantallaConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Evito que se cierre al presionar x
            pantallaConsultar.setVisible(true); // La hago visible
            
        break; // optional
   
        // You can have any number of case statements.
        default : // Optional
        // Statements
        }
    }
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
        experto.nuevoTipoImpuesto(codigoTipoImpuestoIngres, nombreTipoImpuestoIngres, esMontoEditableIngres);
        
    }
    //Metodo para modificar TipoImpuesto
    public void modificarTipoImpuesto(String nombreTipoImpuestoIngres, String nombreActualTipoImpuesto, boolean esMontoEditableIngres, boolean habilitado){
        experto.modificarTipoImpuesto(nombreTipoImpuestoIngres, nombreActualTipoImpuesto, esMontoEditableIngres, habilitado);
        
    }
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){  
        return  experto.obtenerTipoImpuestos();
    }
    
    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(int codigo){
        return experto.obtenerTipoImpuesto(codigo);
    }
}
