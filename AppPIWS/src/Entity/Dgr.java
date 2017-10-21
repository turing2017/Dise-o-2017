package Entity;
// Generated 25/09/2017 11:49:31 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Dgr generated by hbm2java
 */
@Entity
@Table(name="dgr"
    ,catalog="empresas"
)
public class Dgr  implements java.io.Serializable {


     private int nroFactura;
     private Integer codigoImpuesto;
     private String nombreImpuesto;
     private Double montoPagar;
     private String status;
     private String codigoCP;
     private Date primerVencimiento;
     private Date segundoVencimiento;

    public Dgr() {
    }

    public Dgr(int nroFactura, Integer codigoImpuesto, String nombreImpuesto, Double montoPagar, String status, Date primerVencimiento, Date segundoVencimiento) {
       this.nroFactura = nroFactura;
       this.codigoImpuesto = codigoImpuesto;
       this.nombreImpuesto = nombreImpuesto;
       this.montoPagar = montoPagar;
       this.status = status;
       this.primerVencimiento = primerVencimiento;
       this.segundoVencimiento = segundoVencimiento;
    }
   
     @Id 

    
    @Column(name="nroFactura", unique=true, nullable=false)
    public int getNroFactura() {
        return this.nroFactura;
    }
    
    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    
    @Column(name="codigoImpuesto")
    public Integer getCodigoImpuesto() {
        return this.codigoImpuesto;
    }
    
    public void setCodigoImpuesto(Integer codigoImpuesto) {
        this.codigoImpuesto = codigoImpuesto;
    }

    
    @Column(name="nombreImpuesto")
    public String getNombreImpuesto() {
        return this.nombreImpuesto;
    }
    
    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    
    @Column(name="montoPagar", precision=22, scale=0)
    public Double getMontoPagar() {
        return this.montoPagar;
    }
    
    public void setMontoPagar(Double montoPagar) {
        this.montoPagar = montoPagar;
    }

    
    @Column(name="status")
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="primerVencimiento", length=19)
    public Date getPrimerVencimiento() {
        return this.primerVencimiento;
    }
    
    public void setPrimerVencimiento(Date primerVencimiento) {
        this.primerVencimiento = primerVencimiento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="segundoVencimiento", length=19)
    public Date getSegundoVencimiento() {
        return this.segundoVencimiento;
    }
    
    public void setSegundoVencimiento(Date segundoVencimiento) {
        this.segundoVencimiento = segundoVencimiento;
    }


    @Column(name="codigoCP")
    public String getCodigoCP() {
        return codigoCP;
    }

    public void setCodigoCP(String codigoCP) {
        this.codigoCP = codigoCP;
    }

}

