/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores;

import bdclases.AsignaturaColaborador;
import bdconexiones.Conexion;
import java.sql.Date;
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
public class ContenedorAsignaturas {
Conexion conexion =new Conexion();

public ContenedorAsignaturas(){
    conexion.conectarBD();
}

public AsignaturaColaborador ObtenerAsignatura(int id_Colaborador, int id_Escolaridad){
    AsignaturaColaborador asignatura = null;
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        
        ResultSet rs = statement.executeQuery("select * from asignatura_colaborador where _id_Colaborador='"+id_Colaborador+"' AND id_Escolaridad ='"+id_Escolaridad+"'");
        
        if(rs.next()){
            
            asignatura=new AsignaturaColaborador(
                    rs.getInt("id_Asignatura_Colaborador"),
                    rs.getDate("Fecha"),
                    rs.getInt("_id_Colaborador"),
                    rs.getInt("id_Asignatura"),
                    rs.getInt("Calif_Parcial"),
                    rs.getInt("Calif_Recup"),
                    rs.getInt("id_Resultado"),
                    rs.getInt("id_Escolaridad"));
        }        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }    
    return asignatura;
}

public List<AsignaturaColaborador> AllAsignaturas_Escolaridad(int colaborador, int id_Escolaridad){
    List<AsignaturaColaborador> listaAsignaturas=new ArrayList<AsignaturaColaborador>();
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        ResultSet rs = statement.executeQuery("select * from asignatura_colaborador where _id_Colaborador='"+colaborador+"' and id_Escolaridad ='"+id_Escolaridad+"'");
        while(rs.next())
        {
            AsignaturaColaborador asignatura =new AsignaturaColaborador();
            asignatura.setId_Asignatura_Colaborador(rs.getInt("id_Asignatura_Colaborador"));
            asignatura.setFecha(rs.getDate("Fecha"));
            asignatura.setId_Colaborador(rs.getInt("_id_Colaborador"));
            asignatura.setId_Asignatura(rs.getInt("id_Asignatura"));
            asignatura.setCalif_Parcial(rs.getInt("Calif_Parcial"));
            asignatura.setCalif_Recup(rs.getInt("Calif_Recup"));
            asignatura.setId_Resultado(rs.getInt("Id_Resultado"));
            asignatura.setId_Escolaridad(rs.getInt("Id_Escolaridad"));
            
            listaAsignaturas.add(asignatura);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }
return listaAsignaturas;    
}

public List<AsignaturaColaborador> AllAsignaturas_EscolaridadPeriodo(int colaborador, int id_Escolaridad, Date FechaMin, Date FechaMax){
    List<AsignaturaColaborador> listaAsignaturasPorPeriodo=new ArrayList<AsignaturaColaborador>();
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        ResultSet rs = statement.executeQuery("Select * from asignatura_colaborador where _id_Colaborador ='"+colaborador+"' and id_Escolaridad ='"+id_Escolaridad+"' and Fecha between '"+FechaMin+"' and '"+FechaMax+"'");
        while(rs.next())
        {
            AsignaturaColaborador asignatura =new AsignaturaColaborador();
            asignatura.setId_Asignatura_Colaborador(rs.getInt("id_Asignatura_Colaborador"));
            asignatura.setFecha(rs.getDate("Fecha"));
            asignatura.setId_Colaborador(rs.getInt("_id_Colaborador"));
            asignatura.setId_Asignatura(rs.getInt("id_Asignatura"));
            asignatura.setCalif_Parcial(rs.getInt("Calif_Parcial"));
            asignatura.setCalif_Recup(rs.getInt("Calif_Recup"));
            asignatura.setId_Resultado(rs.getInt("Id_Resultado"));
            asignatura.setId_Escolaridad(rs.getInt("Id_Escolaridad"));
            
            listaAsignaturasPorPeriodo.add(asignatura);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }
return listaAsignaturasPorPeriodo;    
}

public List<AsignaturaColaborador> AllAsigAprobPorAño(int colaborador, int id_Escolaridad, Date FechaMin, Date FechaMax, int result){
    List<AsignaturaColaborador> listaAsigAprobPorAño=new ArrayList<AsignaturaColaborador>();
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        ResultSet rs = statement.executeQuery("Select * from asignatura_colaborador where _id_Colaborador ='"+colaborador+"' and id_Escolaridad ='"+id_Escolaridad+"' and Fecha between '"+FechaMin+"' and '"+FechaMax+"' and id_Resultado= '"+result+"'");
        while(rs.next())
        {
            AsignaturaColaborador asignatura =new AsignaturaColaborador();
            asignatura.setId_Asignatura_Colaborador(rs.getInt("id_Asignatura_Colaborador"));
            asignatura.setFecha(rs.getDate("Fecha"));
            asignatura.setId_Colaborador(rs.getInt("_id_Colaborador"));
            asignatura.setId_Asignatura(rs.getInt("id_Asignatura"));
            asignatura.setCalif_Parcial(rs.getInt("Calif_Parcial"));
            asignatura.setCalif_Recup(rs.getInt("Calif_Recup"));
            asignatura.setId_Resultado(rs.getInt("Id_Resultado"));
            asignatura.setId_Escolaridad(rs.getInt("Id_Escolaridad"));
            
            listaAsigAprobPorAño.add(asignatura);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }
return listaAsigAprobPorAño;    
}

}
