package sistemapagoimpuestos.Dto;

public class DTOCriterio
{

    private String atributo;
    private String operacion;
    private Object valor;

    public DTOCriterio() {
    }
    
    

    public DTOCriterio(String atributo, String operacion, Object valor) {
        this.atributo = atributo;
        this.operacion = operacion;
        this.valor = valor;
    }

    
    public String getAtributo ()
    {
        return atributo;
    }

    public void setAtributo (String atributo)
    {
        this.atributo = atributo;
    }

    public String getOperacion ()
    {
        return operacion;
    }

    public void setOperacion (String operacion)
    {
        this.operacion = operacion;
    }

    public Object getValor ()
    {
        return valor;
    }

    public void setValor (Object valor)
    {
        this.valor = valor;
    }

}
