/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdconexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel
 */
public class Conexion {
    public Connection conn;
    
    public Conexion() {
        conectarBD();
    }

    public void conectarBD() {
        try {
            // create a database connection
            conn = DriverManager.getConnection("jdbc:mysql://54.200.13.132:3306/gamicabd?zeroDateTimeBehavior=convertToNull", "gamiuser", "BDGami90");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectarBD() {
        if (conn != null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
