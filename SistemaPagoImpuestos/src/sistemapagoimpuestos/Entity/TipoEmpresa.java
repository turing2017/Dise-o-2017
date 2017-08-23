/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tongas
 */
@Entity
public class TipoEmpresa implements Serializable {
    
    private String nombreTipoEmpresa;
    private Date fechaHoraInhabilitacionTipoEmpresa;

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public void setFechaHoraInhabilitacionTipoEmpresa(Date fechaHoraInhabilitacionTipoEmpresa) {
        this.fechaHoraInhabilitacionTipoEmpresa = fechaHoraInhabilitacionTipoEmpresa;
    }

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public Date getFechaHoraInhabilitacionTipoEmpresa() {
        return fechaHoraInhabilitacionTipoEmpresa;
    }
    
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpresa)) {
            return false;
        }
        TipoEmpresa other = (TipoEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemapagoimpuestos.Entity.TipoEmpresa[ id=" + id + " ]";
    }
    
}
