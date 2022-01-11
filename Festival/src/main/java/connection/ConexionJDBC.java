package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJDBC {

    private static final String BD_SERVIDOR = "jdbc:sqlserver://localhost:1433;database=";
    private static final String BD_NOMBRE = "Festival";
    private static final String BD_USUARIO = "sa";
    private static final String BD_PASSWORD = "1234";

    private static Connection conexion;

    //Constructor privado (patrón Singleton)

    private ConexionJDBC () {
        try{
            conexion = DriverManager.getConnection(BD_SERVIDOR+BD_NOMBRE, BD_USUARIO,BD_PASSWORD);
            System.out.println("Conexión con BBDD realizada");
            System.out.println("\n");

        } catch (SQLException e) {
            System.out.println("Error en la apertura de BBDD");
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion(){

        if(conexion==null) {
            new ConexionJDBC();
        }
        return conexion;
    }

    public static void cerrarConexion() {

        if(conexion !=null) {
            try{
                conexion.close();
                System.out.println("BBDD cerrada");
            } catch (SQLException e) {
                System.out.println("Error cierre de BBDD");
                e.printStackTrace();
            }
            conexion = null;
        }
    }

}
