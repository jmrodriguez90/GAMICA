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
@Table(name = "grado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g"),
    @NamedQuery(name = "Grado.findByIdGrado", query = "SELECT g FROM Grado g WHERE g.idGrado = :idGrado"),
    @NamedQuery(name = "Grado.findByNombre", query = "SELECT g FROM Grado g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grado.findByDescripcion", query = "SELECT g FROM Grado g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Grado.findByTotalclases", query = "SELECT g FROM Grado g WHERE g.totalclases = :totalclases")})
public class Grado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Grado")
    private Integer idGrado;
    @Size(max = 60)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 60)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Total_clases")
    private Integer totalclases;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrado")
    private Collection<Escolaridad> escolaridadCollection;

    public Grado() {
    }

    public Grado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTotalclases() {
        return totalclases;
    }

    public void setTotalclases(Integer totalclases) {
        this.totalclases = totalclases;
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
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Grado[ idGrado=" + idGrado + " ]";
    }
    
}
