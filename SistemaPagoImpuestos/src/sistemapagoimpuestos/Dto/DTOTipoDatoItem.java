package sistemapagoimpuestos.Dto;

/**
 *
 * @author lunamarcos
 */
public class DTOTipoDatoItem {
    
    private int codigoTipoDatoItem;
    private String nombreTipoDatoItem;
    
    public DTOTipoDatoItem() {
    }
    
    public DTOTipoDatoItem(int codigoTipoDatoItem, String nombreTipoDatoItem) {
        this.codigoTipoDatoItem = codigoTipoDatoItem;
        this.nombreTipoDatoItem = nombreTipoDatoItem;
    }

    public void setCodigoTipoDatoItem(int codigoTipoDatoItem) {
        this.codigoTipoDatoItem = codigoTipoDatoItem;
    }

    public void setNombreTipoDatoItem(String nombreTipoDatoItem) {
        this.nombreTipoDatoItem = nombreTipoDatoItem;
    }

    public int getCodigoTipoDatoItem() {
        return codigoTipoDatoItem;
    }

    public String getNombreTipoDatoItem() {
        return nombreTipoDatoItem;
    }
    
    
}
