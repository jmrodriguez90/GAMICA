/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @author manuel
 */
public class Gamicategorias implements IsSerializable{
    int id_Gamicat;
    String Nombre_categoria;
    String Descripcion;

    public Gamicategorias(int id_Gamicat, String Nombre_categoria, String Descripcion) {
        this.id_Gamicat = id_Gamicat;
        this.Nombre_categoria = Nombre_categoria;
        this.Descripcion = Descripcion;
    }
    
    public Gamicategorias(){
    }

    public int getId_Gamicat() {
        return id_Gamicat;
    }

    public void setId_Gamicat(int id_Gamicat) {
        this.id_Gamicat = id_Gamicat;
    }

    public String getNombre_categoria() {
        return Nombre_categoria;
    }

    public void setNombre_categoria(String Nombre_categoria) {
        this.Nombre_categoria = Nombre_categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
}
