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
@Table(name = "escolaridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridad.findAll", query = "SELECT e FROM Escolaridad e"),
    @NamedQuery(name = "Escolaridad.findByIdEscolaridad", query = "SELECT e FROM Escolaridad e WHERE e.idEscolaridad = :idEscolaridad"),
    @NamedQuery(name = "Escolaridad.findByFecalta", query = "SELECT e FROM Escolaridad e WHERE e.fecalta = :fecalta"),
    @NamedQuery(name = "Escolaridad.findByFecbaja", query = "SELECT e FROM Escolaridad e WHERE e.fecbaja = :fecbaja"),
    @NamedQuery(name = "Escolaridad.findByPromedio", query = "SELECT e FROM Escolaridad e WHERE e.promedio = :promedio")})
public class Escolaridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Escolaridad")
    private Integer idEscolaridad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecalta;
    @Column(name = "Fec_baja")
    @Temporal(TemporalType.DATE)
    private Date fecbaja;
    @Column(name = "Promedio")
    private Integer promedio;
    @JoinColumn(name = "id_Institucion", referencedColumnName = "id_Institucion")
    @ManyToOne(optional = false)
    private Institucion idInstitucion;
    @JoinColumn(name = "id_Grado", referencedColumnName = "id_Grado")
    @ManyToOne(optional = false)
    private Grado idGrado;
    @JoinColumn(name = "id_Jornada", referencedColumnName = "id_Jornada")
    @ManyToOne(optional = false)
    private Jornada idJornada;
    @JoinColumn(name = "_id_Colaborador", referencedColumnName = "_id_Colaborador")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JoinColumn(name = "id_Niveles", referencedColumnName = "id_NivelEs")
    @ManyToOne
    private NivelEstudios idNiveles;
    @OneToMany(mappedBy = "idEscolaridad")
    private Collection<AsignaturaColaborador> asignaturaColaboradorCollection;

    public Escolaridad() {
    }

    public Escolaridad(Integer idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public Escolaridad(Integer idEscolaridad, Date fecalta) {
        this.idEscolaridad = idEscolaridad;
        this.fecalta = fecalta;
    }

    public Integer getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(Integer idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public Date getFecalta() {
        return fecalta;
    }

    public void setFecalta(Date fecalta) {
        this.fecalta = fecalta;
    }

    public Date getFecbaja() {
        return fecbaja;
    }

    public void setFecbaja(Date fecbaja) {
        this.fecbaja = fecbaja;
    }

    public Integer getPromedio() {
        return promedio;
    }

    public void setPromedio(Integer promedio) {
        this.promedio = promedio;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public NivelEstudios getIdNiveles() {
        return idNiveles;
    }

    public void setIdNiveles(NivelEstudios idNiveles) {
        this.idNiveles = idNiveles;
    }

    @XmlTransient
    public Collection<AsignaturaColaborador> getAsignaturaColaboradorCollection() {
        return asignaturaColaboradorCollection;
    }

    public void setAsignaturaColaboradorCollection(Collection<AsignaturaColaborador> asignaturaColaboradorCollection) {
        this.asignaturaColaboradorCollection = asignaturaColaboradorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscolaridad != null ? idEscolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridad)) {
            return false;
        }
        Escolaridad other = (Escolaridad) object;
        if ((this.idEscolaridad == null && other.idEscolaridad != null) || (this.idEscolaridad != null && !this.idEscolaridad.equals(other.idEscolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Escolaridad[ idEscolaridad=" + idEscolaridad + " ]";
    }
    
}
