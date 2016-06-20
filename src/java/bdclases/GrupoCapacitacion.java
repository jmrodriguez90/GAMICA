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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "grupo_capacitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoCapacitacion.findAll", query = "SELECT g FROM GrupoCapacitacion g"),
    @NamedQuery(name = "GrupoCapacitacion.findByIdGrupo", query = "SELECT g FROM GrupoCapacitacion g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "GrupoCapacitacion.findByEstado", query = "SELECT g FROM GrupoCapacitacion g WHERE g.estado = :estado"),
    @NamedQuery(name = "GrupoCapacitacion.findByNombregrupo", query = "SELECT g FROM GrupoCapacitacion g WHERE g.nombregrupo = :nombregrupo"),
    @NamedQuery(name = "GrupoCapacitacion.findByHinicio", query = "SELECT g FROM GrupoCapacitacion g WHERE g.hinicio = :hinicio"),
    @NamedQuery(name = "GrupoCapacitacion.findByHfin", query = "SELECT g FROM GrupoCapacitacion g WHERE g.hfin = :hfin")})
public class GrupoCapacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Grupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Nombre_grupo")
    private String nombregrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "H_inicio")
    @Temporal(TemporalType.TIME)
    private Date hinicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "H_fin")
    @Temporal(TemporalType.TIME)
    private Date hfin;
    @JoinColumn(name = "id_Capacitacion", referencedColumnName = "id_Capacitacion")
    @ManyToOne(optional = false)
    private Capacitacion idCapacitacion;
    @JoinColumn(name = "id_Dia", referencedColumnName = "id_Dia")
    @ManyToOne(optional = false)
    private Dia idDia;
    @JoinColumn(name = "id_Aula", referencedColumnName = "id_Aula")
    @ManyToOne
    private Aula idAula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private Collection<DetalleCapacitacion> detalleCapacitacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private Collection<AsistenciaCap> asistenciaCapCollection;

    public GrupoCapacitacion() {
    }

    public GrupoCapacitacion(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public GrupoCapacitacion(Integer idGrupo, int estado, String nombregrupo, Date hinicio, Date hfin) {
        this.idGrupo = idGrupo;
        this.estado = estado;
        this.nombregrupo = nombregrupo;
        this.hinicio = hinicio;
        this.hfin = hfin;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public Date getHinicio() {
        return hinicio;
    }

    public void setHinicio(Date hinicio) {
        this.hinicio = hinicio;
    }

    public Date getHfin() {
        return hfin;
    }

    public void setHfin(Date hfin) {
        this.hfin = hfin;
    }

    public Capacitacion getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Capacitacion idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Dia getIdDia() {
        return idDia;
    }

    public void setIdDia(Dia idDia) {
        this.idDia = idDia;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
    }

    @XmlTransient
    public Collection<DetalleCapacitacion> getDetalleCapacitacionCollection() {
        return detalleCapacitacionCollection;
    }

    public void setDetalleCapacitacionCollection(Collection<DetalleCapacitacion> detalleCapacitacionCollection) {
        this.detalleCapacitacionCollection = detalleCapacitacionCollection;
    }

    @XmlTransient
    public Collection<AsistenciaCap> getAsistenciaCapCollection() {
        return asistenciaCapCollection;
    }

    public void setAsistenciaCapCollection(Collection<AsistenciaCap> asistenciaCapCollection) {
        this.asistenciaCapCollection = asistenciaCapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoCapacitacion)) {
            return false;
        }
        GrupoCapacitacion other = (GrupoCapacitacion) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.GrupoCapacitacion[ idGrupo=" + idGrupo + " ]";
    }
    
}
