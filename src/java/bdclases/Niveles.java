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
@Table(name = "niveles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveles.findAll", query = "SELECT n FROM Niveles n"),
    @NamedQuery(name = "Niveles.findByIdNivel", query = "SELECT n FROM Niveles n WHERE n.idNivel = :idNivel"),
    @NamedQuery(name = "Niveles.findByNombrenivel", query = "SELECT n FROM Niveles n WHERE n.nombrenivel = :nombrenivel"),
    @NamedQuery(name = "Niveles.findByDescripcion", query = "SELECT n FROM Niveles n WHERE n.descripcion = :descripcion")})
public class Niveles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Nivel")
    private Integer idNivel;
    @Size(max = 15)
    @Column(name = "Nombre_nivel")
    private String nombrenivel;
    @Size(max = 40)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private Collection<Perfil> perfilCollection;

    public Niveles() {
    }

    public Niveles(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombrenivel() {
        return nombrenivel;
    }

    public void setNombrenivel(String nombrenivel) {
        this.nombrenivel = nombrenivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveles)) {
            return false;
        }
        Niveles other = (Niveles) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Niveles[ idNivel=" + idNivel + " ]";
    }
    
}
