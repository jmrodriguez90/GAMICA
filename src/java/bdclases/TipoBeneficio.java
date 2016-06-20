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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "tipo_beneficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoBeneficio.findAll", query = "SELECT t FROM TipoBeneficio t"),
    @NamedQuery(name = "TipoBeneficio.findByTipoBeneficio", query = "SELECT t FROM TipoBeneficio t WHERE t.tipoBeneficio = :tipoBeneficio"),
    @NamedQuery(name = "TipoBeneficio.findByCategoriabeneficio", query = "SELECT t FROM TipoBeneficio t WHERE t.categoriabeneficio = :categoriabeneficio"),
    @NamedQuery(name = "TipoBeneficio.findByDescripcion", query = "SELECT t FROM TipoBeneficio t WHERE t.descripcion = :descripcion")})
public class TipoBeneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Tipo_Beneficio")
    private Integer tipoBeneficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Categoria_beneficio")
    private String categoriabeneficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBeneficio")
    private Collection<Beneficios> beneficiosCollection;

    public TipoBeneficio() {
    }

    public TipoBeneficio(Integer tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public TipoBeneficio(Integer tipoBeneficio, String categoriabeneficio, String descripcion) {
        this.tipoBeneficio = tipoBeneficio;
        this.categoriabeneficio = categoriabeneficio;
        this.descripcion = descripcion;
    }

    public Integer getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(Integer tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public String getCategoriabeneficio() {
        return categoriabeneficio;
    }

    public void setCategoriabeneficio(String categoriabeneficio) {
        this.categoriabeneficio = categoriabeneficio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Beneficios> getBeneficiosCollection() {
        return beneficiosCollection;
    }

    public void setBeneficiosCollection(Collection<Beneficios> beneficiosCollection) {
        this.beneficiosCollection = beneficiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoBeneficio != null ? tipoBeneficio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoBeneficio)) {
            return false;
        }
        TipoBeneficio other = (TipoBeneficio) object;
        if ((this.tipoBeneficio == null && other.tipoBeneficio != null) || (this.tipoBeneficio != null && !this.tipoBeneficio.equals(other.tipoBeneficio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.TipoBeneficio[ tipoBeneficio=" + tipoBeneficio + " ]";
    }
    
}
