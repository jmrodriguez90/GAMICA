/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores;

import bdclases.Gamicategorias;
import bdconexiones.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel
 */
public class Contenedor_Gamicategorias {
    Conexion conexion =new Conexion();
    
    public Contenedor_Gamicategorias(){
        conexion.conectarBD();
    }
    
    public Gamicategorias Nombre_categoria(int id_Cat){    
    Gamicategorias Cat = null;
    
    try {        
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);        
                
        ResultSet rs = statement.executeQuery("select * from gamicategorias where id_GamiCat='"+id_Cat+"'");
        
        if(rs.next()){
            
            Cat=new Gamicategorias(
                    rs.getInt("id_GamiCat"),
                    rs.getString("Nombre_categoria"),
                    rs.getString("Descripcion"));
        }        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }    
    return Cat;
}
    
    public List<Gamicategorias> All_Categorias_Nombre() {
    List<Gamicategorias> lista_Categorias_nombre = new ArrayList<Gamicategorias>();
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        ResultSet rs = statement.executeQuery("select * from gamicategorias");
        while(rs.next())
        {
            Gamicategorias gamicat =new Gamicategorias();            
            gamicat.setId_Gamicat(rs.getInt("id_GamiCat"));
            gamicat.setNombre_categoria(rs.getString("Nombre_categoria"));
            gamicat.setDescripcion(rs.getString("Descripcion"));
            lista_Categorias_nombre.add(gamicat);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }
return lista_Categorias_nombre;
}
}
