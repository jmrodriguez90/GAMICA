/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores;

import bdclases.Colaborador;
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
public class ContenedorColaborador {
    Conexion conexion =new Conexion();
    
    public ContenedorColaborador(){
        conexion.conectarBD();
    }
    
    public Colaborador obtenerColaborador(int id){
         Colaborador colaborador=null;
         
        try {
           
            
            Statement statement = conexion.conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from colaborador where _id_Colaborador='"+id+"'");
            if(rs.next()){
                
                colaborador=new Colaborador(
                        rs.getInt("_id_Colaborador"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Direccion"),
                        rs.getInt("Telefono"),
                        rs.getInt("Movil"),
                        rs.getString("Genero"),
                        rs.getDate("Fec_nac"),
                        rs.getInt("id_NivelEs"),
                        rs.getInt("id_Perfil"),
                        rs.getInt("id_Familia"));
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(ContenedorColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return colaborador;
    }
    
    public List<Colaborador> obtenerColaboradores(){
         List<Colaborador> listaColaboradores=new ArrayList<Colaborador>();
         
        try {
           
            Statement statement = conexion.conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            
            //El número 9 representa el perfil del colaborador que ya no forma parte del proyecto.    
            ResultSet rs = statement.executeQuery("select * from colaborador where id_Perfil != '9'");                
            while(rs.next())
            {
                Colaborador colaborador=new Colaborador();
                // read the result set
                colaborador.setId_Colaborador(rs.getInt("_id_Colaborador"));
                colaborador.setNombre(rs.getString("Nombre"));
                colaborador.setApellidos(rs.getString("Apellidos"));
                colaborador.setDireccion(rs.getString("Direccion"));
                colaborador.setTelefono(rs.getInt("Telefono"));
                colaborador.setMovil(rs.getInt("Movil"));
                colaborador.setGenero(rs.getString("Genero"));
                colaborador.setFec_nac(rs.getDate("Fec_nac"));
                colaborador.setId_NivelEs(rs.getInt("id_NivelEs"));
                colaborador.setId_Perfil(rs.getInt("id_Perfil"));
                colaborador.setId_Familia(rs.getInt("id_Familia"));
                
                listaColaboradores.add(colaborador);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContenedorColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaColaboradores;
    }
    
    public List<Colaborador> ColaboradoresSegunPerfil(int Perfil){
         List<Colaborador> colaboradoresSegunPerfil=new ArrayList<Colaborador>();
         
        try {
           
            Statement statement = conexion.conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            
            //El número 9 representa el perfil del colaborador que ya no forma parte del proyecto.    
            ResultSet rs = statement.executeQuery("select * from colaborador where id_Perfil != '"+Perfil+"'");                
            while(rs.next())
            {
                Colaborador colaborador=new Colaborador();
                // read the result set
                colaborador.setId_Colaborador(rs.getInt("_id_Colaborador"));
                colaborador.setNombre(rs.getString("Nombre"));
                colaborador.setApellidos(rs.getString("Apellidos"));
                colaborador.setDireccion(rs.getString("Direccion"));
                colaborador.setTelefono(rs.getInt("Telefono"));
                colaborador.setMovil(rs.getInt("Movil"));
                colaborador.setGenero(rs.getString("Genero"));
                colaborador.setFec_nac(rs.getDate("Fec_nac"));
                colaborador.setId_NivelEs(rs.getInt("id_NivelEs"));
                colaborador.setId_Perfil(rs.getInt("id_Perfil"));
                colaborador.setId_Familia(rs.getInt("id_Familia"));
                
                colaboradoresSegunPerfil.add(colaborador);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContenedorColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return colaboradoresSegunPerfil;
    }
    
    public List<Colaborador> ColaboradoresSegunPerfilyGenero(int Perfil, String genero){
         List<Colaborador> colaboradoresSegunPerfilyGenero=new ArrayList<Colaborador>();
         
        try {
           
            Statement statement = conexion.conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            
            //El número 9 representa el perfil del colaborador que ya no forma parte del proyecto.    
            ResultSet rs = statement.executeQuery("select * from colaborador where id_Perfil != '"+Perfil+"' and Genero= '"+genero+"'");                
            while(rs.next())
            {
                Colaborador colaborador=new Colaborador();
                // read the result set
                colaborador.setId_Colaborador(rs.getInt("_id_Colaborador"));
                colaborador.setNombre(rs.getString("Nombre"));
                colaborador.setApellidos(rs.getString("Apellidos"));
                colaborador.setDireccion(rs.getString("Direccion"));
                colaborador.setTelefono(rs.getInt("Telefono"));
                colaborador.setMovil(rs.getInt("Movil"));
                colaborador.setGenero(rs.getString("Genero"));
                colaborador.setFec_nac(rs.getDate("Fec_nac"));
                colaborador.setId_NivelEs(rs.getInt("id_NivelEs"));
                colaborador.setId_Perfil(rs.getInt("id_Perfil"));
                colaborador.setId_Familia(rs.getInt("id_Familia"));
                
                colaboradoresSegunPerfilyGenero.add(colaborador);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContenedorColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return colaboradoresSegunPerfilyGenero;
    }
    
    public List<Colaborador> ColaboradoresSegunPerfilyNivEstudios(int Perfil, int NivEst){
         List<Colaborador> colaboradoresSegunPerfilyNivEstudios=new ArrayList<Colaborador>();
         
        try {
           
            Statement statement = conexion.conn.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            
            //El número 9 representa el perfil del colaborador que ya no forma parte del proyecto.    
            ResultSet rs = statement.executeQuery("select * from colaborador where id_Perfil != '"+Perfil+"' and id_NivelEs= '"+NivEst+"'");                
            while(rs.next())
            {
                Colaborador colaborador=new Colaborador();
                // read the result set
                colaborador.setId_Colaborador(rs.getInt("_id_Colaborador"));
                colaborador.setNombre(rs.getString("Nombre"));
                colaborador.setApellidos(rs.getString("Apellidos"));
                colaborador.setDireccion(rs.getString("Direccion"));
                colaborador.setTelefono(rs.getInt("Telefono"));
                colaborador.setMovil(rs.getInt("Movil"));
                colaborador.setGenero(rs.getString("Genero"));
                colaborador.setFec_nac(rs.getDate("Fec_nac"));
                colaborador.setId_NivelEs(rs.getInt("id_NivelEs"));
                colaborador.setId_Perfil(rs.getInt("id_Perfil"));
                colaborador.setId_Familia(rs.getInt("id_Familia"));
                
                colaboradoresSegunPerfilyNivEstudios.add(colaborador);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContenedorColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return colaboradoresSegunPerfilyNivEstudios;
    }
    
    
}
