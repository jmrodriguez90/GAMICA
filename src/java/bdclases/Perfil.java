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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil"),
    @NamedQuery(name = "Perfil.findByNombreperfil", query = "SELECT p FROM Perfil p WHERE p.nombreperfil = :nombreperfil"),
    @NamedQuery(name = "Perfil.findByDetalle", query = "SELECT p FROM Perfil p WHERE p.detalle = :detalle")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Perfil")
    private Integer idPerfil;
    @Size(max = 30)
    @Column(name = "Nombre_perfil")
    private String nombreperfil;
    @Size(max = 70)
    @Column(name = "Detalle")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<ProyectoColaborador> proyectoColaboradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<Login> loginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<DetalleCapacitacion> detalleCapacitacionCollection;
    @JoinColumn(name = "id_Nivel", referencedColumnName = "id_Nivel")
    @ManyToOne(optional = false)
    private Niveles idNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<Colaborador> colaboradorCollection;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombreperfil() {
        return nombreperfil;
    }

    public void setNombreperfil(String nombreperfil) {
        this.nombreperfil = nombreperfil;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public Collection<ProyectoColaborador> getProyectoColaboradorCollection() {
        return proyectoColaboradorCollection;
    }

    public void setProyectoColaboradorCollection(Collection<ProyectoColaborador> proyectoColaboradorCollection) {
        this.proyectoColaboradorCollection = proyectoColaboradorCollection;
    }

    @XmlTransient
    public Collection<Login> getLoginCollection() {
        return loginCollection;
    }

    public void setLoginCollection(Collection<Login> loginCollection) {
        this.loginCollection = loginCollection;
    }

    @XmlTransient
    public Collection<DetalleCapacitacion> getDetalleCapacitacionCollection() {
        return detalleCapacitacionCollection;
    }

    public void setDetalleCapacitacionCollection(Collection<DetalleCapacitacion> detalleCapacitacionCollection) {
        this.detalleCapacitacionCollection = detalleCapacitacionCollection;
    }

    public Niveles getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Niveles idNivel) {
        this.idNivel = idNivel;
    }

    @XmlTransient
    public Collection<Colaborador> getColaboradorCollection() {
        return colaboradorCollection;
    }

    public void setColaboradorCollection(Collection<Colaborador> colaboradorCollection) {
        this.colaboradorCollection = colaboradorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
