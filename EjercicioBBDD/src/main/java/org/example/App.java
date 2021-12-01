package org.example;

import org.example.model.Marca;

import java.sql.*;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {

        PersistenciaBBDD conexion = new PersistenciaBBDD();
        conexion.obtenerConexion();

        //CrearTablaPrueba();

        //insertarJugadoresPruebaSinClave();

        Marca objmarca= new Marca(24, "Lays");

        //insertarMarcaSinClave(objmarca);

        //insertarMarcaConClave(objmarca);

        //insertarMarcaActualizar(objmarca);

        //MarcaBorrar(objmarca);

        //mostrarRegistrosListarMarca(objmarca);

        //consultarRegistroListarMarca(7);

        //verVistas(objmarca);

        ArrayList<Marca> listaMarcas = new ArrayList<>();

        listaMarcas.add(objmarca);

        //insertarListasTransacciones(listaMarcas);

        //actualizarListasTransacciones(objmarca);

        //eliminarListasTransacciones(17);

        //listarReposicionamiento(1, 2);

        listarUltimasCompras();
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

    private static void insertarMarcaConClave(Marca marca) throws SQLException {

        Connection c = null;

        PersistenciaBBDD conexion = new PersistenciaBBDD();
        c = conexion.obtenerConexion();

        c.setAutoCommit(false);//Inicio de la trasaccion

        String consulta= "INSERT INTO marcas (nombre) VALUES  (?)";
        PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, "11111111G");
        ps.executeUpdate();

        ResultSet rs= ps.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        System.out.println("Id generado:"+id);

        c.commit();
        ps.close();;
    }

    private static void insertarMarcaActualizar(Marca marca) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta3="UPDATE marcas set nombre =? where id=?;";
            PreparedStatement ps = c.prepareStatement(consulta3);
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
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

    private static void MarcaBorrar(Marca marca) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta3="DELETE from marcas where id=?;";
            PreparedStatement ps = c.prepareStatement(consulta3);
            //ps.setString(1, marca.getNombre());
            ps.setInt(1, marca.getId());
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

    private static void mostrarRegistrosListarMarca(Marca marca) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
           String consulta ="SELECT * from marcas";
           Statement s=c.createStatement();
           ResultSet rs=s.executeQuery(consulta);
           while(rs.next()){
               //Marca objeto = new Marca();
               System.out.println("ID:" + rs.getString("ID")+" "+"Nombre:" + rs.getString("Nombre"));
           }
           rs.close();
           s.close();
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

    private static void consultarRegistroListarMarca(int id) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta ="SELECT nombre from marcas where id=?;";
            PreparedStatement ps = c.prepareStatement(consulta);
          ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                //Marca objeto = new Marca();
                System.out.println("Nombre:" + rs.getString("Nombre"));
            }
            rs.close();
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

    private static void verVistas(Marca marca) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            String consulta ="SELECT * from  ventasEmpleado;";
            Statement s = c.createStatement();
            ResultSet rs=s.executeQuery(consulta);
            while(rs.next()){
                //Marca objeto = new Marca();
                System.out.println("Nombre:" + rs.getString("Nombre"));
            }
            s.close();
            s.close();
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

    private static void insertarListasTransacciones(ArrayList<Marca> listaMarcas) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = conexion.obtenerConexion();
            c.setAutoCommit(false);

            String consulta = "INSERT INTO marcas (nombre) VALUES (?);";
            PreparedStatement ps = c.prepareStatement(consulta);
            for(Marca marca: listaMarcas){
                ps.setString(1, marca.getNombre());
                ps.addBatch();
                System.out.println("Insertando registro " +marca.getNombre());

            }

            //Ejecutar y obtener cuantos se han insertado
            int[] exitos=ps.executeBatch();
            c.commit();
            int registrosAfectados=0;

            for(int i=0; i <listaMarcas.size(); i++){
                registrosAfectados = registrosAfectados + exitos[i];
            }
            System.out.println("Se han insertado "+registrosAfectados+" registros");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void actualizarListasTransacciones(Marca marca) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();

        try {
            c = conexion.obtenerConexion();
            c.setAutoCommit(false);

            String sql="UPDATE marcas SET ";
            sql = sql + " nombre = ? ";
            sql = sql + " WHERE id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
            ps.executeUpdate();

            c.commit();

            int registrosAfectados= ps.getUpdateCount();
            System.out.println("Se han actualizado "+registrosAfectados+" registros");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (c!=null && !c.isClosed())
                    c.close();
            }  catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
    }

    private static void eliminarListasTransacciones(int id) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();

        try {
            c = conexion.obtenerConexion();
            c.setAutoCommit(false);

            String sql="DELETE FROM marcas WHERE id = ?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            c.commit();

            int registrosAfectados= ps.getUpdateCount();
            System.out.println("Se han eliminado "+registrosAfectados+" registros");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (c!=null && !c.isClosed())
                    c.close();
            }  catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
    }

    private static void listarReposicionamiento(int secuencia, int filas) {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();
        ResultSet resultado = null;
        try {
            c = conexion.obtenerConexion();
            String sql="SELECT TOP (?) *" +
                    " FROM listaClientesPorNombre " +
                    " WHERE secuencial > ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, filas);
            ps.setInt(2, secuencia);
            resultado = ps.executeQuery();

            while (resultado.next()){
                String texto = resultado.getInt("secuencial") + "-"
                        + resultado.getInt("id") + "-"
                        + resultado.getString("nombre") + "-"
                        + resultado.getString("apellido") + "-"
                        + resultado.getString("email");

                System.out.println(texto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (c!=null && !c.isClosed())
                    c.close();
            }  catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
    }

    private static void listarUltimasCompras() {

        Connection c = null;
        PersistenciaBBDD conexion = new PersistenciaBBDD();

        ResultSet resultado = null;


        try {
            c = conexion.obtenerConexion();

            Date date = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

           String sql = "{call ultimaVentaCliente(?)}";

            CallableStatement sentencia = c.prepareCall(sql);
            sentencia.setDate(1, sqlDate);
            if(!sentencia.execute()){
                System.out.println("Sin resultados");
            } else {
                resultado = sentencia.getResultSet();
                while(resultado.next()) {
                    String texto= resultado.getString("nombre") + "-"
                            + resultado.getString("apellido") + "-"
                            + resultado.getInt("id") + "-"
                            + resultado.getString("ciudad") + "-"
                            + resultado.getDate("fecha");
                }
            }
        } catch (Exception e) {
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
