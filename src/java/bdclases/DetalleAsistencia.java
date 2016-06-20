/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "detalle_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleAsistencia.findAll", query = "SELECT d FROM DetalleAsistencia d"),
    @NamedQuery(name = "DetalleAsistencia.findByIdDetalleasistencia", query = "SELECT d FROM DetalleAsistencia d WHERE d.idDetalleasistencia = :idDetalleasistencia"),
    @NamedQuery(name = "DetalleAsistencia.findByTipoasistencia", query = "SELECT d FROM DetalleAsistencia d WHERE d.tipoasistencia = :tipoasistencia"),
    @NamedQuery(name = "DetalleAsistencia.findByObservacion", query = "SELECT d FROM DetalleAsistencia d WHERE d.observacion = :observacion")})
public class DetalleAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Detalle_asistencia")
    private Integer idDetalleasistencia;
    @Size(max = 20)
    @Column(name = "Tipo_asistencia")
    private String tipoasistencia;
    @Size(max = 60)
    @Column(name = "Observacion")
    private String observacion;
    @OneToMany(mappedBy = "idDetalleasistencia")
    private Collection<AsistenciaDiaria> asistenciaDiariaCollection;
    @OneToMany(mappedBy = "idDetalleasistencia")
    private Collection<AsistenciaCap> asistenciaCapCollection;

    public DetalleAsistencia() {
    }

    public DetalleAsistencia(Integer idDetalleasistencia) {
        this.idDetalleasistencia = idDetalleasistencia;
    }

    public Integer getIdDetalleasistencia() {
        return idDetalleasistencia;
    }

    public void setIdDetalleasistencia(Integer idDetalleasistencia) {
        this.idDetalleasistencia = idDetalleasistencia;
    }

    public String getTipoasistencia() {
        return tipoasistencia;
    }

    public void setTipoasistencia(String tipoasistencia) {
        this.tipoasistencia = tipoasistencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<AsistenciaDiaria> getAsistenciaDiariaCollection() {
        return asistenciaDiariaCollection;
    }

    public void setAsistenciaDiariaCollection(Collection<AsistenciaDiaria> asistenciaDiariaCollection) {
        this.asistenciaDiariaCollection = asistenciaDiariaCollection;
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
        hash += (idDetalleasistencia != null ? idDetalleasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleAsistencia)) {
            return false;
        }
        DetalleAsistencia other = (DetalleAsistencia) object;
        if ((this.idDetalleasistencia == null && other.idDetalleasistencia != null) || (this.idDetalleasistencia != null && !this.idDetalleasistencia.equals(other.idDetalleasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.DetalleAsistencia[ idDetalleasistencia=" + idDetalleasistencia + " ]";
    }
    
}
