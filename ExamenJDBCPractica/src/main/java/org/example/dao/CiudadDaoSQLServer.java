package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Ciudad;

import java.sql.*;

public class CiudadDaoSQLServer implements CiudadDao{

    public int insertar(Ciudad objetoCiudad) {

        int id = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            String sql = "INSERT INTO Ciudad (Nombre, Pais, PoblacionONU, PoblacionCENSO) VALUES (?,?,?,?) ";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setString(1, objetoCiudad.getNombre());
            sentencia.setString(2, objetoCiudad.getPais());
            sentencia.setInt(3, objetoCiudad.getPoblacionONU());
            sentencia.setInt(4, objetoCiudad.getPoblacionCENSO());


            sentencia.executeUpdate();
            resultado = sentencia.getGeneratedKeys();
            resultado.next();

            id = resultado.getInt(1);

        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
        return id;
    }

    @Override
    public void eliminar(int id) {

        PreparedStatement sentencia = null;

        try {
            String sql = "DELETE FROM Ciudad WHERE id = ?";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql);

            sentencia.setInt(1, id);
            sentencia.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (sentencia != null)
                    sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }

    }

    public void actualizar(Ciudad objetoCiudad) {

        Connection c = null;
        int registrosAfectados = 0;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);

            String sql = "UPDATE Ciudad SET ";
            sql = sql + " Nombre = ?, ";
            sql = sql + " Pais = ?, ";
            sql = sql + " PoblacionONU = ?, ";
            sql = sql + " PoblacionCENSO = ? ";
            sql = sql + " WHERE id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, objetoCiudad.getNombre());
            ps.setString(2, objetoCiudad.getPais());
            ps.setInt(3, objetoCiudad.getPoblacionONU());
            ps.setInt(4, objetoCiudad.getPoblacionCENSO());

            ps.setInt(5, objetoCiudad.getId());
            ps.executeUpdate();

            c.commit();

            registrosAfectados = ps.getUpdateCount();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }

    }
    public Ciudad consultar(int id) {

        Connection c = null;
        Ciudad objeto2 = new Ciudad();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = ConexionSQLServer.obtenerConexion();
            String consulta = "SELECT * from Ciudad where id=?;";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objeto2.setId(rs.getInt("Id"));
                objeto2.setNombre(rs.getString("Nombre"));
                objeto2.setPais(rs.getString("Pais"));
                objeto2.setPoblacionONU(rs.getInt("PoblacionONU"));
                objeto2.setPoblacionCENSO(rs.getInt("PoblacionCENSO"));
                //System.out.println("Nombre:" + rs.getString("Nombre"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en la ejecución de la consulta");
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                System.out.println("Error a cerrar la conexion");
            }
        }
        return objeto2;


    }
}
