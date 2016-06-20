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
@Table(name = "hermanos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hermanos.findAll", query = "SELECT h FROM Hermanos h"),
    @NamedQuery(name = "Hermanos.findByIdHermano", query = "SELECT h FROM Hermanos h WHERE h.idHermano = :idHermano"),
    @NamedQuery(name = "Hermanos.findByNombre", query = "SELECT h FROM Hermanos h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hermanos.findByEdad", query = "SELECT h FROM Hermanos h WHERE h.edad = :edad"),
    @NamedQuery(name = "Hermanos.findByVivienda", query = "SELECT h FROM Hermanos h WHERE h.vivienda = :vivienda")})
public class Hermanos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Hermano")
    private Integer idHermano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vivienda")
    private int vivienda;
    @JoinColumn(name = "id_Familia", referencedColumnName = "id_Familia")
    @ManyToOne
    private Familia idFamilia;

    public Hermanos() {
    }

    public Hermanos(Integer idHermano) {
        this.idHermano = idHermano;
    }

    public Hermanos(Integer idHermano, String nombre, int edad, int vivienda) {
        this.idHermano = idHermano;
        this.nombre = nombre;
        this.edad = edad;
        this.vivienda = vivienda;
    }

    public Integer getIdHermano() {
        return idHermano;
    }

    public void setIdHermano(Integer idHermano) {
        this.idHermano = idHermano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getVivienda() {
        return vivienda;
    }

    public void setVivienda(int vivienda) {
        this.vivienda = vivienda;
    }

    public Familia getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Familia idFamilia) {
        this.idFamilia = idFamilia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHermano != null ? idHermano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hermanos)) {
            return false;
        }
        Hermanos other = (Hermanos) object;
        if ((this.idHermano == null && other.idHermano != null) || (this.idHermano != null && !this.idHermano.equals(other.idHermano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Hermanos[ idHermano=" + idHermano + " ]";
    }
    
}
