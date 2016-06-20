/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores;

import bdclases.Asignaturas;
import bdclases.Resultado;
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
public class ContenedorResultado {
    Conexion conexion =new Conexion();

    public ContenedorResultado(){
        conexion.conectarBD();
    }
    
    public Resultado tipoResultado(int idResultado){
        
        Resultado resultado=null;
        
        try {        
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);        
                
        ResultSet rs = statement.executeQuery("select * from resultado where id_Resultado='"+idResultado+"'");
        
        if(rs.next()){
            
            resultado=new Resultado(
                    rs.getInt("id_Resultado"),
                    rs.getString("Resultado"));
        }        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }    
    return resultado;
}
    
    public List<Resultado> AllResultados_Nombre(int id_Resultado){
    List<Resultado> listaResultadosNombres=new ArrayList<Resultado>();
        
    try {
        Statement statement = conexion.conn.createStatement();
        statement.setQueryTimeout(30);
        
        ResultSet rs = statement.executeQuery("select * from resultado where id_Resultado='"+id_Resultado+"'");
        while(rs.next())
        {
            Resultado resultado =new Resultado();            
            resultado.setId_Resultado(rs.getInt("Id_Resultado"));
            resultado.setResultado(rs.getString("Resultado"));            
            listaResultadosNombres.add(resultado);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ContenedorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
    }
return listaResultadosNombres;
}
}
