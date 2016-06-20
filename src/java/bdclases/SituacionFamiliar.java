/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "situacion_familiar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionFamiliar.findAll", query = "SELECT s FROM SituacionFamiliar s"),
    @NamedQuery(name = "SituacionFamiliar.findBySitfamiliar", query = "SELECT s FROM SituacionFamiliar s WHERE s.sitfamiliar = :sitfamiliar"),
    @NamedQuery(name = "SituacionFamiliar.findByDescripcion", query = "SELECT s FROM SituacionFamiliar s WHERE s.descripcion = :descripcion")})
public class SituacionFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Sit_familiar")
    private Integer sitfamiliar;
    @Size(max = 30)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sitfamiliar")
    private Collection<Familia> familiaCollection;

    public SituacionFamiliar() {
    }

    public SituacionFamiliar(Integer sitfamiliar) {
        this.sitfamiliar = sitfamiliar;
    }

    public Integer getSitfamiliar() {
        return sitfamiliar;
    }

    public void setSitfamiliar(Integer sitfamiliar) {
        this.sitfamiliar = sitfamiliar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Familia> getFamiliaCollection() {
        return familiaCollection;
    }

    public void setFamiliaCollection(Collection<Familia> familiaCollection) {
        this.familiaCollection = familiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitfamiliar != null ? sitfamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionFamiliar)) {
            return false;
        }
        SituacionFamiliar other = (SituacionFamiliar) object;
        if ((this.sitfamiliar == null && other.sitfamiliar != null) || (this.sitfamiliar != null && !this.sitfamiliar.equals(other.sitfamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.SituacionFamiliar[ sitfamiliar=" + sitfamiliar + " ]";
    }
    
}
