/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rakuszky
 */
public class conexionMysql {
    
    Connection conectar = null;
    
    public Connection conexion(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd_java", "root", "proyectoTitulo");
            
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error de conexión" + e.getMessage());
        }
        
        return conectar;
    }
}
