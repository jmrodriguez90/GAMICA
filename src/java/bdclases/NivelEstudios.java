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
@Table(name = "nivel_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEstudios.findAll", query = "SELECT n FROM NivelEstudios n"),
    @NamedQuery(name = "NivelEstudios.findByIdNivelEs", query = "SELECT n FROM NivelEstudios n WHERE n.idNivelEs = :idNivelEs"),
    @NamedQuery(name = "NivelEstudios.findByNivelestudios", query = "SELECT n FROM NivelEstudios n WHERE n.nivelestudios = :nivelestudios")})
public class NivelEstudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_NivelEs")
    private Integer idNivelEs;
    @Size(max = 15)
    @Column(name = "Nivel_estudios")
    private String nivelestudios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelEs")
    private Collection<Colaborador> colaboradorCollection;
    @OneToMany(mappedBy = "idNiveles")
    private Collection<Escolaridad> escolaridadCollection;

    public NivelEstudios() {
    }

    public NivelEstudios(Integer idNivelEs) {
        this.idNivelEs = idNivelEs;
    }

    public Integer getIdNivelEs() {
        return idNivelEs;
    }

    public void setIdNivelEs(Integer idNivelEs) {
        this.idNivelEs = idNivelEs;
    }

    public String getNivelestudios() {
        return nivelestudios;
    }

    public void setNivelestudios(String nivelestudios) {
        this.nivelestudios = nivelestudios;
    }

    @XmlTransient
    public Collection<Colaborador> getColaboradorCollection() {
        return colaboradorCollection;
    }

    public void setColaboradorCollection(Collection<Colaborador> colaboradorCollection) {
        this.colaboradorCollection = colaboradorCollection;
    }

    @XmlTransient
    public Collection<Escolaridad> getEscolaridadCollection() {
        return escolaridadCollection;
    }

    public void setEscolaridadCollection(Collection<Escolaridad> escolaridadCollection) {
        this.escolaridadCollection = escolaridadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelEs != null ? idNivelEs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEstudios)) {
            return false;
        }
        NivelEstudios other = (NivelEstudios) object;
        if ((this.idNivelEs == null && other.idNivelEs != null) || (this.idNivelEs != null && !this.idNivelEs.equals(other.idNivelEs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.NivelEstudios[ idNivelEs=" + idNivelEs + " ]";
    }
    
}
