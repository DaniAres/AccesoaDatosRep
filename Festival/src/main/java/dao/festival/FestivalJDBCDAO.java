package dao.festival;

import connection.ConexionJDBC;

import model.Festival;


import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Operaciones CRUD en bases de datos JDBC para almacenar objetos, es este caso de Festival.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class FestivalJDBCDAO {

    public int insertar(Festival objeto){

        int id = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            String sql = "INSERT INTO festival (Nombre, Descripción, Inicio, Fin, Aforo, Precio, Ventas) VALUES (?,?,?,?,?,?,?) ";
            sentencia = ConexionJDBC.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            BigDecimal bigDecimal = new BigDecimal(objeto.getPrecio());

            sentencia.setString(1, objeto.getNombre());
            sentencia.setString(2, objeto.getDescripcion());
            sentencia.setTimestamp(3, objeto.getInicio());
            sentencia.setTimestamp(4, objeto.getFin());
            sentencia.setInt(5, objeto.getAforo());
            sentencia.setBigDecimal(6, bigDecimal);
            sentencia.setInt(7,objeto.getVentas());


            sentencia.executeUpdate();
            resultado = sentencia.getGeneratedKeys();
            resultado.next();

            id = resultado.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        }
        /*
        finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }

         */
        return id;

    }

    public List<Festival> listar() {

        List<Festival> lista = new ArrayList<>();
        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            c = ConexionJDBC.obtenerConexion();
            String consulta = "SELECT * from festival";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                Festival objeto = new Festival();

                objeto.setId(rs.getInt("ID"));
                objeto.setNombre(rs.getString("Nombre"));
                objeto.setDescripcion(rs.getString("Descripción"));
                objeto.setInicio(rs.getTimestamp("Inicio"));
                objeto.setFin(rs.getTimestamp("Fin"));
                objeto.setAforo(rs.getInt("Aforo"));
                objeto.setPrecio(rs.getDouble("Precio"));
                objeto.setVentas(rs.getInt("Ventas"));


                lista.add(objeto);
                //System.out.println("ID:" + rs.getString("ID") + " " + "Nombre:" + rs.getString("Nombre"));
            }
            rs.close();
            s.close();
        } catch (
                SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        }
        return lista;
    }

    public Festival consultar(int id) {

        {
            Connection c = null;
            Festival objeto2 = new Festival();
            try {
                //PersistenciaBBDD.CargarDriver();
                c = ConexionJDBC.obtenerConexion();
                String consulta = "SELECT * from festival where id=?;";
                PreparedStatement ps = c.prepareStatement(consulta);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    objeto2.setId(rs.getInt("ID"));
                    objeto2.setNombre(rs.getString("Nombre"));
                    objeto2.setDescripcion(rs.getString("Descripción"));
                    objeto2.setInicio(rs.getTimestamp("Inicio"));
                    objeto2.setFin(rs.getTimestamp("Fin"));
                    objeto2.setAforo(rs.getInt("Aforo"));
                    objeto2.setPrecio(rs.getDouble("Precio"));
                    objeto2.setVentas(rs.getInt("Ventas"));

                    System.out.println("Nombre:" + rs.getString("Nombre"));
                    System.out.println("Descripción:" + rs.getString("Descripción"));
                    System.out.println("Inicio:" + rs.getString("Inicio"));
                    System.out.println("Fin:" + rs.getString("Fin"));
                    System.out.println("Aforo:" + rs.getString("Aforo"));
                    System.out.println("Precio:" + rs.getString("Precio"));
                    System.out.println("Ventas:" + rs.getString("Ventas"));
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                System.out.println("Error en la ejecución de la consulta");
                e.printStackTrace();
            }

            /*
            finally {
                try {
                    if (c != null && !c.isClosed())
                        c.close();
                } catch (SQLException e) {
                    System.out.println("Error a cerrar la conexion");
                }
            }
            */

            return objeto2;
        }
    }


    public void actualizar(Festival objetoFestival) {

        Connection c = null;
        int registrosAfectados = 0;

        try {
            c = ConexionJDBC.obtenerConexion();
            c.setAutoCommit(false);

            String sql = "UPDATE Festival SET ";
            sql = sql + " Nombre = ?, ";
            sql = sql + " Descripción = ?, ";
            sql = sql + " Inicio = ?, ";
            sql = sql + " Fin = ?, ";
            sql = sql + " Aforo = ?, ";
            sql = sql + " Precio = ?, ";
            sql = sql + " Ventas = ? ";
            sql = sql + " WHERE id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, objetoFestival.getNombre());
            ps.setString(2, objetoFestival.getDescripcion());
            ps.setTimestamp(3, objetoFestival.getInicio());
            ps.setTimestamp(4, objetoFestival.getFin());
            ps.setInt(5, objetoFestival.getAforo());
            ps.setDouble(6, objetoFestival.getPrecio());
            ps.setInt(7, objetoFestival.getVentas());

            ps.setInt(8, objetoFestival.getId());
            ps.executeUpdate();

            c.commit();

            registrosAfectados = ps.getUpdateCount();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*
        finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
        */
    }

    public void eliminar(int id){

        PreparedStatement sentencia = null;

        try {
            String sql = "DELETE FROM Festival WHERE id = ?";
            sentencia = ConexionJDBC.obtenerConexion().prepareStatement(sql);

            sentencia.setInt(1, id);
            sentencia.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        finally {
            try {
                if (sentencia != null)
                    sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
        */

    }




}
