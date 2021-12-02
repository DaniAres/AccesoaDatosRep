package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Futbolista;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FutbolistaDaoSQLServer implements FutbolistaDao{

    @Override
    public int insertar(Futbolista objetoFutbolista) {

        int id = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Connection c = null;

        try {

            String sql = "INSERT INTO Futbolista (Nombre, Club, Edad) VALUES (?,?,?) ";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setString(1, objetoFutbolista.getNombre());
            sentencia.setString(2, objetoFutbolista.getClub());
            sentencia.setInt(3, objetoFutbolista.getEdad());


            sentencia.executeUpdate();
            resultado = sentencia.getGeneratedKeys();
            resultado.next();

            id = resultado.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    public void eliminar(int id){

        PreparedStatement sentencia = null;

        try {
            String sql = "DELETE FROM Futbolista WHERE id = ?";
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
               e.printStackTrace();
            }
        }

    }


    public void actualizar(Futbolista objetoFutbolista) {

        Connection c = null;
        int registrosAfectados = 0;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);

            String sql = "UPDATE Futbolista SET ";
            sql = sql + " Nombre = ?, ";
            sql = sql + " Club = ?, ";
            sql = sql + " Edad = ? ";
            sql = sql + " WHERE id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, objetoFutbolista.getNombre());
            ps.setString(2, objetoFutbolista.getClub());
            ps.setInt(3, objetoFutbolista.getEdad());

            ps.setInt(4, objetoFutbolista.getId());
            ps.executeUpdate();

            c.commit();

            registrosAfectados = ps.getUpdateCount();

        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Futbolista consultar(int id){

        Connection c = null;
        Futbolista objeto2 = new Futbolista();
        try {
            c = ConexionSQLServer.obtenerConexion();
            String consulta = "SELECT * from Futbolista where id=?;";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objeto2.setId(rs.getInt("Id"));
                objeto2.setNombre(rs.getString("Nombre").trim());
                objeto2.setClub(rs.getString("Club"));
                objeto2.setEdad(rs.getInt("Edad"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return objeto2;
    }

    public List<Futbolista> listarVista(){

        List<Futbolista> listaFutbolista = new ArrayList<>();
        Connection c = null;
        c = ConexionSQLServer.obtenerConexion();
        try {
            String consulta = "SELECT * from  vtFutbolistasPSG;";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("Nombre:" + rs.getString("Nombre"));
            }
            s.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (c != null && !c.isClosed())
                    c.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        return listaFutbolista;
    }

    public List<Futbolista> listarSP(){

        List<Futbolista> listaFutbolista = new ArrayList<>();

        Connection c = null;
        c = ConexionSQLServer.obtenerConexion();
        ResultSet resultado = null;
        try {

            Futbolista objetoFutbolista = new Futbolista();

            String sql = "{call spFutbolistasPorClub(?)}";

            CallableStatement sentencia = c.prepareCall(sql);
            sentencia.setString(1, objetoFutbolista.getClub());
            if (!sentencia.execute()) {
                System.out.println("Sin resultados");
            } else {
                resultado = sentencia.getResultSet();
                while(resultado.next()) {

                    objetoFutbolista.setId(resultado.getInt("Id"));
                    objetoFutbolista.setNombre(resultado.getString("Nombre"));
                    objetoFutbolista.setClub(resultado.getString("Club"));
                    objetoFutbolista.setEdad(resultado.getInt("Edad"));

                    listaFutbolista.add(objetoFutbolista);
                }
                resultado.close();
                sentencia.close();
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
        return listaFutbolista;
    }

    public int insertarBatch(List<Futbolista> lista) {

        Connection c = null;
        PreparedStatement sentencia = null;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);
            String sql = "INSERT INTO Futbolista (Nombre, Club, Edad) VALUES (?,?,?) ";
            sentencia= c.prepareStatement(sql);

            for (Futbolista futbolista: lista){
                sentencia.setString(1, futbolista.getNombre());
                sentencia.setString(2, futbolista.getClub());
                sentencia.setInt(3, futbolista.getEdad());

                sentencia.addBatch();
            }
            //Ejecutar y obtener cuantos se han insertado
            int[] exitos=sentencia.executeBatch();
            c.commit();
            int registrosAfectados=0;

            for(int i=0; i <lista.size(); i++){
                registrosAfectados = registrosAfectados + exitos[i];
            }

            System.out.println("Se han insertado "+registrosAfectados+" registros");

        } catch (Exception e) {

            try {
                c.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
        } finally {

            try{
                if (sentencia!=null)sentencia.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 1;
    }

}
