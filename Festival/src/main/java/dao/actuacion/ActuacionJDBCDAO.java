package dao.actuacion;

import connection.ConexionJDBC;
import model.Actuacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Operaciones CRUD en bases de datos JDBC para almacenar objetos, es este caso de Actuacion.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class ActuacionJDBCDAO {

    public int insertar(Actuacion objeto){

        int id = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            String sql = "INSERT INTO actuación (idFestival, Nombre, Descripción, Grupo, Escenario, Inicio, Fin) VALUES (?,?,?,?,?,?,?) ";
            sentencia = ConexionJDBC.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setInt(1,objeto.getIdFestival());
            sentencia.setString(2, objeto.getNombre());
            sentencia.setString(3, objeto.getDescripcion());
            sentencia.setString(4, objeto.getGrupo());
            sentencia.setString(5, objeto.getEscenario());
            sentencia.setTimestamp(6, objeto.getInicio());
            sentencia.setTimestamp(7, objeto.getFin());


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


    public List<Actuacion> listar() {

        List<Actuacion> lista = new ArrayList<>();
        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            c = ConexionJDBC.obtenerConexion();
            String consulta = "SELECT * from actuación";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                Actuacion objeto = new Actuacion();
                objeto.setId(rs.getInt("ID"));
                objeto.setIdFestival(rs.getInt("IDFestival"));
                objeto.setNombre(rs.getString("Nombre"));
                objeto.setDescripcion(rs.getString("Descripción"));
                objeto.setGrupo(rs.getString("Grupo"));
                objeto.setEscenario(rs.getString("Escenario"));
                objeto.setInicio(rs.getTimestamp("Inicio"));
                objeto.setFin(rs.getTimestamp("Fin"));


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

    public Actuacion consultar(int id) {

        {
            Connection c = null;
            Actuacion objeto2 = new Actuacion();
            try {
                //PersistenciaBBDD.CargarDriver();
                c = ConexionJDBC.obtenerConexion();
                String consulta = "SELECT * from actuación where id=?;";
                PreparedStatement ps = c.prepareStatement(consulta);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    objeto2.setId(rs.getInt("ID"));
                    objeto2.setIdFestival(rs.getInt("IDFestival"));
                    objeto2.setNombre(rs.getString("Nombre"));
                    objeto2.setDescripcion(rs.getString("Descripción"));
                    objeto2.setGrupo(rs.getString("Grupo"));
                    objeto2.setEscenario(rs.getString("Escenario"));
                    objeto2.setInicio(rs.getTimestamp("Inicio"));
                    objeto2.setFin(rs.getTimestamp("Fin"));

                    System.out.println("Nombre:" + rs.getString("Nombre"));
                    System.out.println("Descripción:" + rs.getString("Descripción"));
                    System.out.println("Grupo:" + rs.getString("Grupo"));
                    System.out.println("Escenario:" + rs.getString("Escenario"));
                    System.out.println("Inicio:" + rs.getString("Inicio"));
                    System.out.println("Fin:" + rs.getString("Fin"));
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

    public void actualizar(Actuacion objetoActuacion) {

        Connection c = null;
        int registrosAfectados = 0;

        try {
            c = ConexionJDBC.obtenerConexion();


            String sql = "UPDATE Actuación SET ";
            sql = sql + " Nombre = ?, ";
            sql = sql + " Descripción = ?, ";
            sql = sql + " Grupo = ?, ";
            sql = sql + " Escenario = ?, ";
            sql = sql + " Inicio = ?, ";
            sql = sql + " Fin = ? ";
            sql = sql + " WHERE id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, objetoActuacion.getNombre());
            ps.setString(2, objetoActuacion.getDescripcion());
            ps.setString(3, objetoActuacion.getGrupo());
            ps.setString(4, objetoActuacion.getEscenario());
            ps.setTimestamp(5, objetoActuacion.getInicio());
            ps.setTimestamp(6, objetoActuacion.getFin());

            ps.setInt(7, objetoActuacion.getId());
            ps.executeUpdate();


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
            String sql = "DELETE FROM Actuación WHERE id = ?";
            sentencia = ConexionJDBC.obtenerConexion().prepareStatement(sql);

            sentencia.setInt(1, id);
            sentencia.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (sentencia != null)
                    sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }


    }

}
