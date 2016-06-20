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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByUsuario", query = "SELECT l FROM Login l WHERE l.usuario = :usuario"),
    @NamedQuery(name = "Login.findByContrase\u00f1a", query = "SELECT l FROM Login l WHERE l.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Login.findByCorreo", query = "SELECT l FROM Login l WHERE l.correo = :correo")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Usuario")
    private String usuario;
    @Size(max = 32)
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @OneToMany(mappedBy = "autorizacion")
    private Collection<Gamiacumulacion> gamiacumulacionCollection;
    @JoinColumn(name = "id_Perfil", referencedColumnName = "id_Perfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @JoinColumn(name = "_id_Colaborador", referencedColumnName = "_id_Colaborador")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @OneToMany(mappedBy = "usuario")
    private Collection<Bitacora> bitacoraCollection;
    @OneToMany(mappedBy = "encargado")
    private Collection<Devoluciones> devolucionesCollection;

    public Login() {
    }

    public Login(String usuario) {
        this.usuario = usuario;
    }

    public Login(String usuario, String correo) {
        this.usuario = usuario;
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Gamiacumulacion> getGamiacumulacionCollection() {
        return gamiacumulacionCollection;
    }

    public void setGamiacumulacionCollection(Collection<Gamiacumulacion> gamiacumulacionCollection) {
        this.gamiacumulacionCollection = gamiacumulacionCollection;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    @XmlTransient
    public Collection<Bitacora> getBitacoraCollection() {
        return bitacoraCollection;
    }

    public void setBitacoraCollection(Collection<Bitacora> bitacoraCollection) {
        this.bitacoraCollection = bitacoraCollection;
    }

    @XmlTransient
    public Collection<Devoluciones> getDevolucionesCollection() {
        return devolucionesCollection;
    }

    public void setDevolucionesCollection(Collection<Devoluciones> devolucionesCollection) {
        this.devolucionesCollection = devolucionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdclases.Login[ usuario=" + usuario + " ]";
    }
    
}
