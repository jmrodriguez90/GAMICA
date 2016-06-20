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
@Table(name = "devoluciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devoluciones.findAll", query = "SELECT d FROM Devoluciones d"),
    @NamedQuery(name = "Devoluciones.findByIdDevoluciones", query = "SELECT d FROM Devoluciones d WHERE d.idDevoluciones = :idDevoluciones"),
    @NamedQuery(name = "Devoluciones.findByFecha", query = "SELECT d FROM Devoluciones d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Devoluciones.findByCantidad", query = "SELECT d FROM Devoluciones d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Devoluciones.findByConcepto", query = "SELECT d FROM Devoluciones d WHERE d.concepto = :concepto")})
public class Devoluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Devoluciones")
    private Integer idDevoluciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "Concepto")
    private String concepto;
    @JoinColumn(name = "id_AyudaE", referencedColumnName = "id_AyudaE")
    @ManyToOne(optional = false)
    private AyudaEconomica idAyudaE;
    @JoinColumn(name = "Encargado", referencedColumnName = "Usuario")
    @ManyToOne
    private Login encargado;

    public Devoluciones() {
    }

    public Devoluciones(Integer idDevoluciones) {
        this.idDevoluciones = idDevoluciones;
    }

    public Devoluciones(Integer idDevoluciones, Date fecha, int cantidad, String concepto) {
        this.idDevoluciones = idDevoluciones;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Integer getIdDevoluciones() {
        return idDevoluciones;
    }

    public void setIdDevoluciones(Integer idDevoluciones) {
        this.idDevoluciones = idDevoluciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public AyudaEconomica getIdAyudaE() {
        return idAyudaE;
    }

    public void setIdAyudaE(AyudaEconomica idAyudaE) {
        this.idAyudaE = idAyudaE;
    }

    public Login getEncargado() {
        return encargado;
    }

    public void setEncargado(Login encargado) {
        this.encargado = encargado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevoluciones != null ? idDevoluciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devoluciones)) {
            return false;
        }
        Devoluciones other = (Devoluciones) object;
        if ((this.idDevoluciones == null && other.idDevoluciones != null) || (this.idDevoluciones != null && !this.idDevoluciones.equals(other.idDevoluciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Devoluciones[ idDevoluciones=" + idDevoluciones + " ]";
    }
    
}
