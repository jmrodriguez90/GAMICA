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

public class AsignaturaColaborador {
    
    int id_Asignatura_Colaborador;
    Date Fecha;
    int _id_Colaborador;
    int id_Asignatura;
    int Calif_Parcial;
    int Calif_Recup;
    int id_Resultado;
    int id_Escolaridad;

    public AsignaturaColaborador(int id_Asignatura_Colaborador, Date Fecha, int _id_Colaborador, int id_Asignatura, int Calif_Parcial, int Calif_Recup, int id_Resultado, int id_Escolaridad) {
        this.id_Asignatura_Colaborador = id_Asignatura_Colaborador;
        this.Fecha = Fecha;
        this._id_Colaborador = _id_Colaborador;
        this.id_Asignatura = id_Asignatura;
        this.Calif_Parcial = Calif_Parcial;
        this.Calif_Recup = Calif_Recup;
        this.id_Resultado = id_Resultado;
        this.id_Escolaridad = id_Escolaridad;
    }

    public AsignaturaColaborador() {
        
    }

    public int getId_Asignatura_Colaborador() {
        return id_Asignatura_Colaborador;
    }

    public void setId_Asignatura_Colaborador(int id_Asignatura_Colaborador) {
        this.id_Asignatura_Colaborador = id_Asignatura_Colaborador;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getId_Colaborador() {
        return _id_Colaborador;
    }

    public void setId_Colaborador(int _id_Colaborador) {
        this._id_Colaborador = _id_Colaborador;
    }

    public int getId_Asignatura() {
        return id_Asignatura;
    }

    public void setId_Asignatura(int id_Asignatura) {
        this.id_Asignatura = id_Asignatura;
    }

    public int getCalif_Parcial() {
        return Calif_Parcial;
    }

    public void setCalif_Parcial(int Calif_Parcial) {
        this.Calif_Parcial = Calif_Parcial;
    }

    public int getCalif_Recup() {
        return Calif_Recup;
    }

    public void setCalif_Recup(int Calif_Recup) {
        this.Calif_Recup = Calif_Recup;
    }

    public int getId_Resultado() {
        return id_Resultado;
    }

    public void setId_Resultado(int id_Resultado) {
        this.id_Resultado = id_Resultado;
    }

    public int getId_Escolaridad() {
        return id_Escolaridad;
    }

    public void setId_Escolaridad(int id_Escolaridad) {
        this.id_Escolaridad = id_Escolaridad;
    }

    

    
    
}
