/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "retencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retencion.findAll", query = "SELECT r FROM Retencion r"),
    @NamedQuery(name = "Retencion.findByIdRetencion", query = "SELECT r FROM Retencion r WHERE r.idRetencion = :idRetencion"),
    @NamedQuery(name = "Retencion.findByConcepto", query = "SELECT r FROM Retencion r WHERE r.concepto = :concepto"),
    @NamedQuery(name = "Retencion.findByDescripcion", query = "SELECT r FROM Retencion r WHERE r.descripcion = :descripcion")})
public class Retencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Retencion")
    private Integer idRetencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idRetencion")
    private Collection<AyudaEconomica> ayudaEconomicaCollection;

    public Retencion() {
    }

    public Retencion(Integer idRetencion) {
        this.idRetencion = idRetencion;
    }

    public Retencion(Integer idRetencion, String concepto, String descripcion) {
        this.idRetencion = idRetencion;
        this.concepto = concepto;
        this.descripcion = descripcion;
    }

    public Integer getIdRetencion() {
        return idRetencion;
    }

    public void setIdRetencion(Integer idRetencion) {
        this.idRetencion = idRetencion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<AyudaEconomica> getAyudaEconomicaCollection() {
        return ayudaEconomicaCollection;
    }

    public void setAyudaEconomicaCollection(Collection<AyudaEconomica> ayudaEconomicaCollection) {
        this.ayudaEconomicaCollection = ayudaEconomicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetencion != null ? idRetencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retencion)) {
            return false;
        }
        Retencion other = (Retencion) object;
        if ((this.idRetencion == null && other.idRetencion != null) || (this.idRetencion != null && !this.idRetencion.equals(other.idRetencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Retencion[ idRetencion=" + idRetencion + " ]";
    }
    
}
