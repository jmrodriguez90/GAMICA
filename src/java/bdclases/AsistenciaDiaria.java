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
@Table(name = "asistencia_diaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaDiaria.findAll", query = "SELECT a FROM AsistenciaDiaria a"),
    @NamedQuery(name = "AsistenciaDiaria.findByIdAsistenciadiaria", query = "SELECT a FROM AsistenciaDiaria a WHERE a.idAsistenciadiaria = :idAsistenciadiaria"),
    @NamedQuery(name = "AsistenciaDiaria.findByFecha", query = "SELECT a FROM AsistenciaDiaria a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AsistenciaDiaria.findByHEntrada", query = "SELECT a FROM AsistenciaDiaria a WHERE a.hEntrada = :hEntrada"),
    @NamedQuery(name = "AsistenciaDiaria.findByHSalida", query = "SELECT a FROM AsistenciaDiaria a WHERE a.hSalida = :hSalida")})
public class AsistenciaDiaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Asistencia_diaria")
    private Integer idAsistenciadiaria;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "HEntrada")
    @Temporal(TemporalType.TIME)
    private Date hEntrada;
    @Column(name = "HSalida")
    @Temporal(TemporalType.TIME)
    private Date hSalida;
    @JoinColumn(name = "_id_Colaborador", referencedColumnName = "_id_Colaborador")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JoinColumn(name = "id_Detalle_asistencia", referencedColumnName = "id_Detalle_asistencia")
    @ManyToOne
    private DetalleAsistencia idDetalleasistencia;

    public AsistenciaDiaria() {
    }

    public AsistenciaDiaria(Integer idAsistenciadiaria) {
        this.idAsistenciadiaria = idAsistenciadiaria;
    }

    public Integer getIdAsistenciadiaria() {
        return idAsistenciadiaria;
    }

    public void setIdAsistenciadiaria(Integer idAsistenciadiaria) {
        this.idAsistenciadiaria = idAsistenciadiaria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHEntrada() {
        return hEntrada;
    }

    public void setHEntrada(Date hEntrada) {
        this.hEntrada = hEntrada;
    }

    public Date getHSalida() {
        return hSalida;
    }

    public void setHSalida(Date hSalida) {
        this.hSalida = hSalida;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
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
        hash += (idAsistenciadiaria != null ? idAsistenciadiaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaDiaria)) {
            return false;
        }
        AsistenciaDiaria other = (AsistenciaDiaria) object;
        if ((this.idAsistenciadiaria == null && other.idAsistenciadiaria != null) || (this.idAsistenciadiaria != null && !this.idAsistenciadiaria.equals(other.idAsistenciadiaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.AsistenciaDiaria[ idAsistenciadiaria=" + idAsistenciadiaria + " ]";
    }
    
}
