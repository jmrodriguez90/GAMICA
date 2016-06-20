/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "ayuda_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AyudaEconomica.findAll", query = "SELECT a FROM AyudaEconomica a"),
    @NamedQuery(name = "AyudaEconomica.findByIdAyudaE", query = "SELECT a FROM AyudaEconomica a WHERE a.idAyudaE = :idAyudaE"),
    @NamedQuery(name = "AyudaEconomica.findByFecelaboracion", query = "SELECT a FROM AyudaEconomica a WHERE a.fecelaboracion = :fecelaboracion"),
    @NamedQuery(name = "AyudaEconomica.findByFecentrega", query = "SELECT a FROM AyudaEconomica a WHERE a.fecentrega = :fecentrega")})
public class AyudaEconomica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_AyudaE")
    private Integer idAyudaE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fec_elaboracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecelaboracion;
    @Column(name = "Fec_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecentrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ayudaEconomica")
    private Collection<DeduccionesesColaborador> deduccionesesColaboradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAyudaE")
    private Collection<DeduccionesvarColaborador> deduccionesvarColaboradorCollection;
    @JoinColumn(name = "_id_Colaborador", referencedColumnName = "_id_Colaborador")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JoinColumn(name = "id_Retencion", referencedColumnName = "id_Retencion")
    @ManyToOne
    private Retencion idRetencion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAyudaE")
    private Collection<Devoluciones> devolucionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ayudaEconomica")
    private Collection<BeneficiosColaborador> beneficiosColaboradorCollection;

    public AyudaEconomica() {
    }

    public AyudaEconomica(Integer idAyudaE) {
        this.idAyudaE = idAyudaE;
    }

    public AyudaEconomica(Integer idAyudaE, Date fecelaboracion) {
        this.idAyudaE = idAyudaE;
        this.fecelaboracion = fecelaboracion;
    }

    public Integer getIdAyudaE() {
        return idAyudaE;
    }

    public void setIdAyudaE(Integer idAyudaE) {
        this.idAyudaE = idAyudaE;
    }

    public Date getFecelaboracion() {
        return fecelaboracion;
    }

    public void setFecelaboracion(Date fecelaboracion) {
        this.fecelaboracion = fecelaboracion;
    }

    public Date getFecentrega() {
        return fecentrega;
    }

    public void setFecentrega(Date fecentrega) {
        this.fecentrega = fecentrega;
    }

    @XmlTransient
    public Collection<DeduccionesesColaborador> getDeduccionesesColaboradorCollection() {
        return deduccionesesColaboradorCollection;
    }

    public void setDeduccionesesColaboradorCollection(Collection<DeduccionesesColaborador> deduccionesesColaboradorCollection) {
        this.deduccionesesColaboradorCollection = deduccionesesColaboradorCollection;
    }

    @XmlTransient
    public Collection<DeduccionesvarColaborador> getDeduccionesvarColaboradorCollection() {
        return deduccionesvarColaboradorCollection;
    }

    public void setDeduccionesvarColaboradorCollection(Collection<DeduccionesvarColaborador> deduccionesvarColaboradorCollection) {
        this.deduccionesvarColaboradorCollection = deduccionesvarColaboradorCollection;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Retencion getIdRetencion() {
        return idRetencion;
    }

    public void setIdRetencion(Retencion idRetencion) {
        this.idRetencion = idRetencion;
    }

    @XmlTransient
    public Collection<Devoluciones> getDevolucionesCollection() {
        return devolucionesCollection;
    }

    public void setDevolucionesCollection(Collection<Devoluciones> devolucionesCollection) {
        this.devolucionesCollection = devolucionesCollection;
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
        hash += (idAyudaE != null ? idAyudaE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AyudaEconomica)) {
            return false;
        }
        AyudaEconomica other = (AyudaEconomica) object;
        if ((this.idAyudaE == null && other.idAyudaE != null) || (this.idAyudaE != null && !this.idAyudaE.equals(other.idAyudaE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.AyudaEconomica[ idAyudaE=" + idAyudaE + " ]";
    }
    
}
