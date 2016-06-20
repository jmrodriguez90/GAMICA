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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "beneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficios.findAll", query = "SELECT b FROM Beneficios b"),
    @NamedQuery(name = "Beneficios.findByIdBeneficio", query = "SELECT b FROM Beneficios b WHERE b.idBeneficio = :idBeneficio")})
public class Beneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Beneficio")
    private Integer idBeneficio;
    @JoinColumn(name = "Tipo_Beneficio", referencedColumnName = "Tipo_Beneficio")
    @ManyToOne(optional = false)
    private TipoBeneficio tipoBeneficio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficios")
    private Collection<BeneficiosColaborador> beneficiosColaboradorCollection;

    public Beneficios() {
    }

    public Beneficios(Integer idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public Integer getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(Integer idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public TipoBeneficio getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    @XmlTransient
    public Collection<BeneficiosColaborador> getBeneficiosColaboradorCollection() {
        return beneficiosColaboradorCollection;
    }

    public void setBeneficiosColaboradorCollection(Collection<BeneficiosColaborador> beneficiosColaboradorCollection) {
        this.beneficiosColaboradorCollection = beneficiosColaboradorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBeneficio != null ? idBeneficio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficios)) {
            return false;
        }
        Beneficios other = (Beneficios) object;
        if ((this.idBeneficio == null && other.idBeneficio != null) || (this.idBeneficio != null && !this.idBeneficio.equals(other.idBeneficio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Beneficios[ idBeneficio=" + idBeneficio + " ]";
    }
    
}
