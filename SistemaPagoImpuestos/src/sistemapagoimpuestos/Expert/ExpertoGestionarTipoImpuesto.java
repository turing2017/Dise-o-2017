package sistemapagoimpuestos.Expert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;

public class ExpertoGestionarTipoImpuesto {
    
    Usuario usuario = new Usuario();
    
    // Metodo iniciar
    public void iniciar(){
        TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }
    }
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
        try{
            String query = "SELECT * FROM tipo_impuestos WHERE codigoTipoImpuesto = " + codigoTipoImpuestoIngres + "AND nombreTipoImpuesto = " + nombreTipoImpuestoIngres;
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pago_impuestos?createDatabaseIfNotExist=true", "root", "root");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.first() == true){
                System.out.println("Hay instancias de TipoImpuesto existentes");
            }
            
        } catch (Exception e){
            System.out.println("Falla de conexion");
        }
        //Creacion de nueva instancia de tipo impuesto, con el seteo de datos correspondiente
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        tipoImpuesto.setCodigoTipoImpuesto(codigoTipoImpuestoIngres);
        tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
        tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);
        
        //Persistir instancia
        
    }
}
