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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "deduccioneses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deduccioneses.findAll", query = "SELECT d FROM Deduccioneses d"),
    @NamedQuery(name = "Deduccioneses.findByIdDeduccionesEs", query = "SELECT d FROM Deduccioneses d WHERE d.idDeduccionesEs = :idDeduccionesEs"),
    @NamedQuery(name = "Deduccioneses.findByConcepto", query = "SELECT d FROM Deduccioneses d WHERE d.concepto = :concepto"),
    @NamedQuery(name = "Deduccioneses.findByDescripcion", query = "SELECT d FROM Deduccioneses d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Deduccioneses.findByMontoUnitario", query = "SELECT d FROM Deduccioneses d WHERE d.montoUnitario = :montoUnitario")})
public class Deduccioneses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_DeduccionesEs")
    private Integer idDeduccionesEs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MontoUnitario")
    private int montoUnitario;

    public Deduccioneses() {
    }

    public Deduccioneses(Integer idDeduccionesEs) {
        this.idDeduccionesEs = idDeduccionesEs;
    }

    public Deduccioneses(Integer idDeduccionesEs, String concepto, String descripcion, int montoUnitario) {
        this.idDeduccionesEs = idDeduccionesEs;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.montoUnitario = montoUnitario;
    }

    public Integer getIdDeduccionesEs() {
        return idDeduccionesEs;
    }

    public void setIdDeduccionesEs(Integer idDeduccionesEs) {
        this.idDeduccionesEs = idDeduccionesEs;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMontoUnitario() {
        return montoUnitario;
    }

    public void setMontoUnitario(int montoUnitario) {
        this.montoUnitario = montoUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeduccionesEs != null ? idDeduccionesEs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deduccioneses)) {
            return false;
        }
        Deduccioneses other = (Deduccioneses) object;
        if ((this.idDeduccionesEs == null && other.idDeduccionesEs != null) || (this.idDeduccionesEs != null && !this.idDeduccionesEs.equals(other.idDeduccionesEs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Deduccioneses[ idDeduccionesEs=" + idDeduccionesEs + " ]";
    }
    
}
