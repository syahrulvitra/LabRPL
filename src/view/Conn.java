/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Conn {
    public static Connection getConnection(){
        Connection conn = null;
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/coba_mahasiswa";
        String user = "root";
        String password = "";
        
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                System.exit(0);
            }
        }
        
        return conn;
    }
}
