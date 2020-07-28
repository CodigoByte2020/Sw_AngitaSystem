package clases;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexión {

    public static Connection Conexión_BD() {
        try {
            Connection conexión = DriverManager.getConnection("jdbc:mysql://localhost/bd_angita", "root", "");
            return conexión;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos local: " + e);            
        }
        return (null); //*
    }
}
