/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores;

import bdclases.Asignaturas;
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
public class ContenedorAsignaturasNombre {
    Conexion conexion =new Conexion();

public ContenedorAsignaturasNombre(){
    conexion.conectarBD();
}
    
    public Asignaturas NombreDeAsignatura(int id_Asignatura){    
    Asignaturas asignaturas = null;        
    try {        
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);        
                
        ResultSet rs = statement.executeQuery("select * from asignaturas where id_Asignatura='"+id_Asignatura+"'");
        
        if(rs.next()){
            
            asignaturas=new Asignaturas(
                    rs.getInt("id_Asignatura"),
                    rs.getString("Nombre"));
        }        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }    
    return asignaturas;
}
    
    public List<Asignaturas> AllAsignaturas_Nombre(int id_Asignatura){
    List<Asignaturas> listaAsignaturasNombres=new ArrayList<Asignaturas>();
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        ResultSet rs = statement.executeQuery("select * from asignaturas where id_Asignatura='"+id_Asignatura+"'");
        while(rs.next())
        {
            Asignaturas asignaturas =new Asignaturas();            
            asignaturas.setId_Asignatura(rs.getInt("id_Asignatura"));
            asignaturas.setNombre(rs.getString("Nombre"));            
            listaAsignaturasNombres.add(asignaturas);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }
return listaAsignaturasNombres;
}
    
}
