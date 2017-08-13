package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
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
        // Analizar si se debe crear y guardar el nuevo tipo de impuesto en este metodo,
        // o se debe llamar desde aca al experto y en el experto implementar esa funcionalidad.
        TipoImpuesto tipoImpuesto = new TipoImpuesto();
        tipoImpuesto.setNombreTipoImpuesto(nombreTipoImpuestoIngres);
        tipoImpuesto.setCodigoTipoImpuesto(codigoTipoImpuestoIngres);
        tipoImpuesto.setEsMontoEditableTipoImpuesto(esMontoEditableIngres);
        
        // Ahora se deberia guardar ...
        // CODE...
        
        
        System.out.println("Guardando en la DB: " + tipoImpuesto.getNombreTipoImpuesto());
    }
    
    // Metodo para recuperar todos los TipoImpuesto de la DB Que devuelve????
    public ArrayList<DTOTipoImpuesto> obtenerTipoImpuestos(){
        // Como vuelven de la DB?
        ArrayList<DTOTipoImpuesto> list = new ArrayList<DTOTipoImpuesto>();
        return list;
    }
    
    // Metodo para recuperar el TipoImpuesto a modificar
    public DTOTipoImpuesto obtenerTipoImpuesto(){
        // De alguna forma devuelvo el TipoImpuesto de la DB
        
        // Para probar seteo uno nuevo
        DTOTipoImpuesto dto = new DTOTipoImpuesto();
        dto.setCodigoDTOTipoImpuesto(123456);
        dto.setNombreDTOTipoImpuesto("algunNombre");
        dto.setEsMontoEditableDTOTipoImpuesto(false);
        return dto;
    }
}
