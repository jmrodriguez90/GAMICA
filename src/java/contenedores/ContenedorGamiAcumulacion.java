/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores;

import bdclases.Gamiacumulacion;
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
public class ContenedorGamiAcumulacion {
    Conexion conexion =new Conexion();
    
    public ContenedorGamiAcumulacion(){
        conexion.conectarBD();
    }
    
    

    public List<Gamiacumulacion> Gami_Acumulacion_Colaborador(int colaborador) {
        List<Gamiacumulacion> listaGamiA = new ArrayList<Gamiacumulacion>();
        try {
            Statement statement = conexion.conn.createStatement();
            statement.setQueryTimeout(30);
            
            ResultSet rs = statement.executeQuery("select * from gamiacumulacion where _id_Colaborador= '"+colaborador+"'");
            
            if (rs.next()){
                Gamiacumulacion gamiacumulado = new Gamiacumulacion(
                        rs.getInt("id_Gamia"),
                        rs.getInt("_id_Colaborador"),
                        rs.getInt("id_GamiCat"),
                        rs.getInt("Cantidad"),
                        rs.getDate("Fecha"),
                        rs.getString("Justificacion"),
                        rs.getString("Autorizacion"));
                listaGamiA.add(gamiacumulado);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContenedorGamiAcumulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaGamiA;
    }
    
}
