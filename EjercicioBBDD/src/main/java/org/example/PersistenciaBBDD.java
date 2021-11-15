package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenciaBBDD {

    private Connection conexion  = null;

    private void CargarDriver () throws ClassNotFoundException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public Connection obtenerConexion() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Tienda;user=sa;password=1234";
        String usuario = "sa";
        String pass = "1234";
        if (conexion == null) {
            try {
                CargarDriver();
                conexion = DriverManager.getConnection(url, usuario, pass );
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }
        return conexion;
    }

}
