/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import java.sql.Date;

/**
 *
 * @author manuel
 */
public class Colaborador {
    int _id_Colaborador;
    String Nombre;
    String Apellidos;
    String Direccion;
    int Telefono;
    int Movil;
    String Genero;
    Date Fec_nac;
    int id_NivelEs;
    int id_Perfil;
    int id_Familia;

    public Colaborador(int _id_Colaborador, String Nombre, String Apellidos, String Direccion, int Telefono, int Movil, String Genero, Date Fec_nac, int id_NivelEs, int id_Perfil, int id_Familila) {
        this._id_Colaborador = _id_Colaborador;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Movil = Movil;
        this.Genero = Genero;
        this.Fec_nac = Fec_nac;
        this.id_NivelEs = id_NivelEs;
        this.id_Perfil = id_Perfil;
        this.id_Familia = id_Familila;
    }

    public Colaborador() {
        
    }

    public int getId_Colaborador() {
        return _id_Colaborador;
    }

    public void setId_Colaborador(int _id_Colaborador) {
        this._id_Colaborador = _id_Colaborador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getMovil() {
        return Movil;
    }

    public void setMovil(int Movil) {
        this.Movil = Movil;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Date getFec_nac() {
        return Fec_nac;
    }

    public void setFec_nac(Date Fec_nac) {
        this.Fec_nac = Fec_nac;
    }

    public int getId_NivelEs() {
        return id_NivelEs;
    }

    public void setId_NivelEs(int id_NivelEs) {
        this.id_NivelEs = id_NivelEs;
    }

    public int getId_Perfil() {
        return id_Perfil;
    }

    public void setId_Perfil(int id_Perfil) {
        this.id_Perfil = id_Perfil;
    }

    public int getId_Familia() {
        return id_Familia;
    }

    public void setId_Familia(int id_Familia) {
        this.id_Familia = id_Familia;
    }
    
}
