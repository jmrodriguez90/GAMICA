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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "deduccionesvar_colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeduccionesvarColaborador.findAll", query = "SELECT d FROM DeduccionesvarColaborador d"),
    @NamedQuery(name = "DeduccionesvarColaborador.findByIdDeduccionesVar", query = "SELECT d FROM DeduccionesvarColaborador d WHERE d.idDeduccionesVar = :idDeduccionesVar"),
    @NamedQuery(name = "DeduccionesvarColaborador.findByConcepto", query = "SELECT d FROM DeduccionesvarColaborador d WHERE d.concepto = :concepto"),
    @NamedQuery(name = "DeduccionesvarColaborador.findByMonto", query = "SELECT d FROM DeduccionesvarColaborador d WHERE d.monto = :monto")})
public class DeduccionesvarColaborador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_DeduccionesVar")
    private Integer idDeduccionesVar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private int monto;
    @JoinColumn(name = "id_AyudaE", referencedColumnName = "id_AyudaE")
    @ManyToOne(optional = false)
    private AyudaEconomica idAyudaE;

    public DeduccionesvarColaborador() {
    }

    public DeduccionesvarColaborador(Integer idDeduccionesVar) {
        this.idDeduccionesVar = idDeduccionesVar;
    }

    public DeduccionesvarColaborador(Integer idDeduccionesVar, String concepto, int monto) {
        this.idDeduccionesVar = idDeduccionesVar;
        this.concepto = concepto;
        this.monto = monto;
    }

    public Integer getIdDeduccionesVar() {
        return idDeduccionesVar;
    }

    public void setIdDeduccionesVar(Integer idDeduccionesVar) {
        this.idDeduccionesVar = idDeduccionesVar;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public AyudaEconomica getIdAyudaE() {
        return idAyudaE;
    }

    public void setIdAyudaE(AyudaEconomica idAyudaE) {
        this.idAyudaE = idAyudaE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeduccionesVar != null ? idDeduccionesVar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeduccionesvarColaborador)) {
            return false;
        }
        DeduccionesvarColaborador other = (DeduccionesvarColaborador) object;
        if ((this.idDeduccionesVar == null && other.idDeduccionesVar != null) || (this.idDeduccionesVar != null && !this.idDeduccionesVar.equals(other.idDeduccionesVar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.DeduccionesvarColaborador[ idDeduccionesVar=" + idDeduccionesVar + " ]";
    }
    
}
