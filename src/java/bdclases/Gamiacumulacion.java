/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.sql.Date;


/**
 *
 * @author manuel
 */

public class Gamiacumulacion implements IsSerializable{
    int id_GamiA;
    int _id_Colaborador;
    int id_GamiCat;
    int Cantidad;
    java.sql.Date fecha;
    String Justificacion;
    String Autorizacion;

    public Gamiacumulacion(int id_GamiA, int _id_Colaborador, int id_GamiCat, int Cantidad, Date fecha, String Justificacion, String Autorizacion) {
        this.id_GamiA = id_GamiA;
        this._id_Colaborador = _id_Colaborador;
        this.id_GamiCat = id_GamiCat;
        this.Cantidad = Cantidad;
        this.fecha = fecha;
        this.Justificacion = Justificacion;
        this.Autorizacion = Autorizacion;
    }
    
    public Gamiacumulacion(){
    }

    public int getId_GamiA() {
        return id_GamiA;
    }

    public void setId_GamiA(int id_GamiA) {
        this.id_GamiA = id_GamiA;
    }

    public int getId_Colaborador() {
        return _id_Colaborador;
    }

    public void setId_Colaborador(int _id_Colaborador) {
        this._id_Colaborador = _id_Colaborador;
    }

    public int getId_GamiCat() {
        return id_GamiCat;
    }

    public void setId_GamiCat(int id_GamiCat) {
        this.id_GamiCat = id_GamiCat;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getJustificacion() {
        return Justificacion;
    }

    public void setJustificacion(String Justificacion) {
        this.Justificacion = Justificacion;
    }

    public String getAutorizacion() {
        return Autorizacion;
    }

    public void setAutorizacion(String Autorizacion) {
        this.Autorizacion = Autorizacion;
    }
    
    
    
    
}
