/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "detalle_capacitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCapacitacion.findAll", query = "SELECT d FROM DetalleCapacitacion d"),
    @NamedQuery(name = "DetalleCapacitacion.findByIdDetalle", query = "SELECT d FROM DetalleCapacitacion d WHERE d.idDetalle = :idDetalle")})
public class DetalleCapacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Detalle")
    private Integer idDetalle;
    @JoinColumn(name = "id_Grupo", referencedColumnName = "id_Grupo")
    @ManyToOne(optional = false)
    private GrupoCapacitacion idGrupo;
    @JoinColumn(name = "_id_Colaborador", referencedColumnName = "_id_Colaborador")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JoinColumn(name = "id_Perfil", referencedColumnName = "id_Perfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public DetalleCapacitacion() {
    }

    public DetalleCapacitacion(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public GrupoCapacitacion getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(GrupoCapacitacion idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCapacitacion)) {
            return false;
        }
        DetalleCapacitacion other = (DetalleCapacitacion) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.DetalleCapacitacion[ idDetalle=" + idDetalle + " ]";
    }
    
}
