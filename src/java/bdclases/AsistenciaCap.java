/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "asistencia_cap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaCap.findAll", query = "SELECT a FROM AsistenciaCap a"),
    @NamedQuery(name = "AsistenciaCap.findByIdAsistenciacap", query = "SELECT a FROM AsistenciaCap a WHERE a.idAsistenciacap = :idAsistenciacap"),
    @NamedQuery(name = "AsistenciaCap.findByFecha", query = "SELECT a FROM AsistenciaCap a WHERE a.fecha = :fecha")})
public class AsistenciaCap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Asistencia_cap")
    private Integer idAsistenciacap;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "_id_Colaborador", referencedColumnName = "_id_Colaborador")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JoinColumn(name = "id_Grupo", referencedColumnName = "id_Grupo")
    @ManyToOne(optional = false)
    private GrupoCapacitacion idGrupo;
    @JoinColumn(name = "id_Detalle_asistencia", referencedColumnName = "id_Detalle_asistencia")
    @ManyToOne
    private DetalleAsistencia idDetalleasistencia;

    public AsistenciaCap() {
    }

    public AsistenciaCap(Integer idAsistenciacap) {
        this.idAsistenciacap = idAsistenciacap;
    }

    public Integer getIdAsistenciacap() {
        return idAsistenciacap;
    }

    public void setIdAsistenciacap(Integer idAsistenciacap) {
        this.idAsistenciacap = idAsistenciacap;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public GrupoCapacitacion getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(GrupoCapacitacion idGrupo) {
        this.idGrupo = idGrupo;
    }

    public DetalleAsistencia getIdDetalleasistencia() {
        return idDetalleasistencia;
    }

    public void setIdDetalleasistencia(DetalleAsistencia idDetalleasistencia) {
        this.idDetalleasistencia = idDetalleasistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistenciacap != null ? idAsistenciacap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaCap)) {
            return false;
        }
        AsistenciaCap other = (AsistenciaCap) object;
        if ((this.idAsistenciacap == null && other.idAsistenciacap != null) || (this.idAsistenciacap != null && !this.idAsistenciacap.equals(other.idAsistenciacap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.AsistenciaCap[ idAsistenciacap=" + idAsistenciacap + " ]";
    }
    
}
