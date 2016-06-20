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
@Table(name = "capacitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c"),
    @NamedQuery(name = "Capacitacion.findByIdCapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.idCapacitacion = :idCapacitacion"),
    @NamedQuery(name = "Capacitacion.findByArea", query = "SELECT c FROM Capacitacion c WHERE c.area = :area"),
    @NamedQuery(name = "Capacitacion.findByValoreconomico", query = "SELECT c FROM Capacitacion c WHERE c.valoreconomico = :valoreconomico")})
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Capacitacion")
    private Integer idCapacitacion;
    @Size(max = 25)
    @Column(name = "Area")
    private String area;
    @Column(name = "Valor_economico")
    private Integer valoreconomico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCapacitacion")
    private Collection<GrupoCapacitacion> grupoCapacitacionCollection;

    public Capacitacion() {
    }

    public Capacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getValoreconomico() {
        return valoreconomico;
    }

    public void setValoreconomico(Integer valoreconomico) {
        this.valoreconomico = valoreconomico;
    }

    @XmlTransient
    public Collection<GrupoCapacitacion> getGrupoCapacitacionCollection() {
        return grupoCapacitacionCollection;
    }

    public void setGrupoCapacitacionCollection(Collection<GrupoCapacitacion> grupoCapacitacionCollection) {
        this.grupoCapacitacionCollection = grupoCapacitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCapacitacion != null ? idCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.idCapacitacion == null && other.idCapacitacion != null) || (this.idCapacitacion != null && !this.idCapacitacion.equals(other.idCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Capacitacion[ idCapacitacion=" + idCapacitacion + " ]";
    }
    
}
