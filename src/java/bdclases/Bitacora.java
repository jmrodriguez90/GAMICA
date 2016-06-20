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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByIdBit", query = "SELECT b FROM Bitacora b WHERE b.idBit = :idBit"),
    @NamedQuery(name = "Bitacora.findByAcontecimiento", query = "SELECT b FROM Bitacora b WHERE b.acontecimiento = :acontecimiento"),
    @NamedQuery(name = "Bitacora.findByFecha", query = "SELECT b FROM Bitacora b WHERE b.fecha = :fecha")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Bit")
    private Integer idBit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "Acontecimiento")
    private String acontecimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "Usuario", referencedColumnName = "Usuario")
    @ManyToOne
    private Login usuario;

    public Bitacora() {
    }

    public Bitacora(Integer idBit) {
        this.idBit = idBit;
    }

    public Bitacora(Integer idBit, String acontecimiento, Date fecha) {
        this.idBit = idBit;
        this.acontecimiento = acontecimiento;
        this.fecha = fecha;
    }

    public Integer getIdBit() {
        return idBit;
    }

    public void setIdBit(Integer idBit) {
        this.idBit = idBit;
    }

    public String getAcontecimiento() {
        return acontecimiento;
    }

    public void setAcontecimiento(String acontecimiento) {
        this.acontecimiento = acontecimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBit != null ? idBit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.idBit == null && other.idBit != null) || (this.idBit != null && !this.idBit.equals(other.idBit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Bitacora[ idBit=" + idBit + " ]";
    }
    
}
