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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByIdFamilia", query = "SELECT f FROM Familia f WHERE f.idFamilia = :idFamilia"),
    @NamedQuery(name = "Familia.findByMama", query = "SELECT f FROM Familia f WHERE f.mama = :mama"),
    @NamedQuery(name = "Familia.findByPapa", query = "SELECT f FROM Familia f WHERE f.papa = :papa"),
    @NamedQuery(name = "Familia.findByEncargado", query = "SELECT f FROM Familia f WHERE f.encargado = :encargado"),
    @NamedQuery(name = "Familia.findByTelefonofamiliar", query = "SELECT f FROM Familia f WHERE f.telefonofamiliar = :telefonofamiliar")})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Familia")
    private Integer idFamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Mama")
    private String mama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Papa")
    private String papa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Encargado")
    private String encargado;
    @Column(name = "Telefono_familiar")
    private Integer telefonofamiliar;
    @OneToMany(mappedBy = "idFamilia")
    private Collection<Hermanos> hermanosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFamilia")
    private Collection<Colaborador> colaboradorCollection;
    @JoinColumn(name = "Sit_familiar", referencedColumnName = "Sit_familiar")
    @ManyToOne(optional = false)
    private SituacionFamiliar sitfamiliar;

    public Familia() {
    }

    public Familia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Familia(Integer idFamilia, String mama, String papa, String encargado) {
        this.idFamilia = idFamilia;
        this.mama = mama;
        this.papa = papa;
        this.encargado = encargado;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getMama() {
        return mama;
    }

    public void setMama(String mama) {
        this.mama = mama;
    }

    public String getPapa() {
        return papa;
    }

    public void setPapa(String papa) {
        this.papa = papa;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Integer getTelefonofamiliar() {
        return telefonofamiliar;
    }

    public void setTelefonofamiliar(Integer telefonofamiliar) {
        this.telefonofamiliar = telefonofamiliar;
    }

    @XmlTransient
    public Collection<Hermanos> getHermanosCollection() {
        return hermanosCollection;
    }

    public void setHermanosCollection(Collection<Hermanos> hermanosCollection) {
        this.hermanosCollection = hermanosCollection;
    }

    @XmlTransient
    public Collection<Colaborador> getColaboradorCollection() {
        return colaboradorCollection;
    }

    public void setColaboradorCollection(Collection<Colaborador> colaboradorCollection) {
        this.colaboradorCollection = colaboradorCollection;
    }

    public SituacionFamiliar getSitfamiliar() {
        return sitfamiliar;
    }

    public void setSitfamiliar(SituacionFamiliar sitfamiliar) {
        this.sitfamiliar = sitfamiliar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Familia[ idFamilia=" + idFamilia + " ]";
    }
    
}
