package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Expert.ExpertoGestionarTipoImpuesto;

public class ControladorGestionarTipoImpuesto {
    
    ExpertoGestionarTipoImpuesto experto = new ExpertoGestionarTipoImpuesto();
    
    // Metodo iniciar
    public void iniciar(){
        experto.iniciar();
    }
    
    // Metodo nuevoTipoImpuesto (crea un tipoImpuesto)
    public void nuevoTipoImpuesto(int codigoTipoImpuestoIngres, String nombreTipoImpuestoIngres, boolean esMontoEditableIngres){
        
    }
    
    public void opcionSeleccionada(String opcion){

    }
}
