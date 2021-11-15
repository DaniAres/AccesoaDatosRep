package org.example;

import org.example.model.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

        PersistenciaBBDD conexion = new PersistenciaBBDD();
        conexion.obtenerConexion();

        CrearTablaPrueba();

        insertarJugadoresPruebaSinClave();

        Marca objmarca= new Marca(0, "Orbea");
        insertarMarcaSinClave(objmarca);
    }
    public static void CrearTablaPrueba() {
        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta="CREATE TABLE Prueba "
                    +"(DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY (DNI))";
            Statement s=c.createStatement();
            s.execute(consulta);
            s.close();

        } catch (SQLException e){
            System.out.println("Error en la ejecucion de la consulta");
            e.printStackTrace();
        } finally {
            try{
                if (c!=null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
    }

    public static void insertarJugadoresPruebaSinClave() {
        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta2="INSERT INTO PRUEBA"
                    +"(DNI,APELLIDOS,CP) VALUES"
                    +"('78978978A', 'NADAL', '15009'),"
                    +"('12345678F', 'DJOKOVIC', '15008'),"
                    +"('55544587J', 'FEDERER', '15007'),"
                    +"('88965475K', 'MURRAY', '15006');";
            Statement s=c.createStatement();
            s.executeUpdate(consulta2);
            s.close();
        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        } finally {
            try{
                if (c!=null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
    }

    private static void insertarMarcaSinClave(Marca marca) {
        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta3="INSERT INTO marcas (nombre) VALUES (?);";
            PreparedStatement ps = c.prepareStatement(consulta3);
            ps.setString(1, marca.getNombre());
            ps.executeUpdate();
            int registrosAfectados = ps.getUpdateCount();
            System.out.println("Se han actualizado "+registrosAfectados+" registros");
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        } finally {
            try {
                if (c!=null && !c.isClosed())
                    c.close();
            }  catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
    }
}
