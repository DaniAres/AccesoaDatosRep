package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Alquiler;
import org.example.model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDaoSQLServer implements LibroDao {

    @Override
    public int insertar(Libro objeto) {

        int asin = 0;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            String sql = "INSERT INTO Libro (Titulo, FechaLanzamiento, Autor, Categoria, Editorial, Idioma, Paginas) VALUES (?,?,?,?,?,?,?) ";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setString(1, objeto.getTitulo());
            sentencia.setDate(2, objeto.getFechaLanzamiento());
            sentencia.setInt(3, objeto.getAutor());
            sentencia.setInt(4, objeto.getCategoria());
            sentencia.setString(5, objeto.getEditorial());
            sentencia.setString(6, objeto.getIdioma());
            sentencia.setString(7, objeto.getPaginas());

            sentencia.executeUpdate();
            resultado = sentencia.getGeneratedKeys();
            resultado.next();

            asin = resultado.getInt(1);

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
        return asin;
    }

    public List<Libro> listar() {

        List<Libro> lista = new ArrayList<>();
        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            c = ConexionSQLServer.obtenerConexion();
            String consulta = "SELECT * from Libro";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {

                Libro objeto = new Libro();

                objeto.setAsin(rs.getInt("ASIN"));
                objeto.setTitulo(rs.getString("Titulo").trim());
                objeto.setFechaLanzamiento(rs.getDate("fechaLanzamiento"));
                objeto.setAutor(rs.getInt("Autor"));
                objeto.setCategoria(rs.getInt("Categoria"));
                objeto.setEditorial(rs.getString("Editorial").trim());
                objeto.setIdioma(rs.getString("Idioma").trim());
                objeto.setPaginas(rs.getString("Paginas").trim());

                lista.add(objeto);
                //System.out.println("ASIN:" + rs.getInt("ASIN") + " " + "Titulo:" + rs.getString("Titulo")+ " " + "fechaLazamiento:" + rs.getDate("fechaLanzamiento")+ " " + "Autor:" + rs.getString("Autor")+ " " + "Categoria:" + rs.getString("Categoria")+ " " + "Editorial:" + rs.getString("Editorial")+ " " + "Idioma:" + rs.getString("Idioma")+ " " + "Paginas:" + rs.getString("Paginas"));
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

    public Libro consultar(int asin) {

        Connection c = null;
        Libro objeto2 = new Libro();
        try {
            //PersistenciaBBDD.CargarDriver();
            c = ConexionSQLServer.obtenerConexion();
            String consulta = "SELECT * from Libro where asin=?;";
            PreparedStatement ps = c.prepareStatement(consulta);
            ps.setInt(1, asin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                objeto2.setAsin(rs.getInt("ASIN"));
                objeto2.setTitulo(rs.getString("Titulo").trim());
                objeto2.setFechaLanzamiento(rs.getDate("fechaLanzamiento"));
                objeto2.setAutor(rs.getInt("Autor"));
                objeto2.setCategoria(rs.getInt("Categoria"));
                objeto2.setEditorial(rs.getString("Editorial").trim());
                objeto2.setIdioma(rs.getString("Idioma").trim());
                objeto2.setPaginas(rs.getString("Paginas").trim());
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

    public int actualizar(Libro objetolibro) {

        Connection c = null;
        int registrosAfectados = 0;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);

            String sql = "UPDATE Libro SET ";
            sql = sql + " Titulo = ?, ";
            sql = sql + " fechaLanzamiento = ?, ";
            sql = sql + " Autor = ?, ";
            sql = sql + " Categoria = ?, ";
            sql = sql + " Editorial = ?, ";
            sql = sql + " Idioma = ?, ";
            sql = sql + " Paginas = ?";
            sql = sql + " WHERE asin = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, objetolibro.getTitulo());
            ps.setDate(2, objetolibro.getFechaLanzamiento());
            ps.setInt(3, objetolibro.getAutor());
            ps.setInt(4, objetolibro.getCategoria());
            ps.setString(5, objetolibro.getEditorial());
            ps.setString(6, objetolibro.getIdioma());
            ps.setString(7, objetolibro.getPaginas());

            ps.setInt(8, objetolibro.getAsin());
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
        return registrosAfectados;
    }


    @Override
    public void eliminar(int asin) {

        PreparedStatement sentencia = null;

        try {
            String sql = "DELETE FROM Libro WHERE asin = ?";
            sentencia = ConexionSQLServer.obtenerConexion().prepareStatement(sql);

            sentencia.setInt(1, asin);
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

    public int verVistas(Libro objeto) {

        Connection c = null;
        c = ConexionSQLServer.obtenerConexion();
        try {
            //PersistenciaBBDD.CargarDriver();
            String consulta = "SELECT * from  vistaLibro;";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                System.out.println("Titulo:" + rs.getString("Titulo"));
            }
            s.close();
            s.close();
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
        return 1;
    }

    public List<Alquiler> verProcedimiento(java.util.Date sqlFecha) {

        List<Alquiler> listaAlquiler = new ArrayList<>();

        Connection c = null;
        c = ConexionSQLServer.obtenerConexion();
        ResultSet resultado = null;
        try {

            String sql = "{call fechaAlquiler(?)}";

            CallableStatement sentencia = c.prepareCall(sql);
            sentencia.setDate(1, (Date) sqlFecha);
            if (!sentencia.execute()) {
                System.out.println("Sin resultados");
            } else {
                resultado = sentencia.getResultSet();
                while(resultado.next()) {

                    Alquiler objetoAlquiler = new Alquiler();

                    objetoAlquiler.setIdAlquiler(resultado.getInt("IdAlquiler"));
                    objetoAlquiler.setIdLector(resultado.getString("IdLector"));
                    objetoAlquiler.setIdLibro(resultado.getInt("IdLibro"));
                    objetoAlquiler.setFechaSalida(resultado.getDate("FechaSalida"));
                    objetoAlquiler.setFechaEntrada(resultado.getDate("FechaEntrada"));

                    listaAlquiler.add(objetoAlquiler);

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
        return listaAlquiler;
    }


    public  void insertarListaLibrosBatch(List <Libro> listaLibros){

        Connection c = null;
        PreparedStatement sentencia = null;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);
            String sql = "INSERT INTO Libro (Titulo, FechaLanzamiento, Autor, Categoria, Editorial, Idioma, Paginas) VALUES (?,?,?,?,?,?,?) ";
            sentencia= c.prepareStatement(sql);

            for (Libro libro: listaLibros){
                sentencia.setString(1, libro.getTitulo());
                sentencia.setDate(2, libro.getFechaLanzamiento());
                sentencia.setInt(3, libro.getAutor());
                sentencia.setInt(4, libro.getCategoria());
                sentencia.setString(5, libro.getEditorial());
                sentencia.setString(6, libro.getIdioma());
                sentencia.setString(7, libro.getPaginas());
                sentencia.addBatch();
            }
            //Ejecutar y obtener cuantos se han insertado
            int[] exitos=sentencia.executeBatch();
            c.commit();
            int registrosAfectados=0;

            for(int i=0; i <listaLibros.size(); i++){
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
    }

    public void actualizarListaLibrosBatch(List <Libro> listaLibros){

        Connection c = null;
        PreparedStatement sentencia = null;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);
            String sql = "UPDATE Libro SET ";
            sql = sql + " Titulo = ? ,";
            sql = sql + " FechaLanzamiento = ? , ";
            sql = sql + " Autor = ? ,";
            sql = sql + " Categoria = ? ,";
            sql = sql + " Editorial = ? ,";
            sql = sql + " Idioma = ? ,";
            sql = sql + " Paginas = ? ";
            sql = sql + " WHERE asin = ?";
            sentencia= c.prepareStatement(sql);

            for(Libro libro: listaLibros){
            sentencia.setString(1, libro.getTitulo());
                sentencia.setDate(2, libro.getFechaLanzamiento());
                sentencia.setInt(3, libro.getAutor());
                sentencia.setInt(4, libro.getCategoria());
                sentencia.setString(5, libro.getEditorial());
                sentencia.setString(6, libro.getIdioma());
                sentencia.setString(7, libro.getPaginas());
                sentencia.setInt(8, libro.getAsin());
            sentencia.addBatch();
            }
            //Ejecutar y obtener cuantos se han insertado
            int[] exitos=sentencia.executeBatch();
            c.commit();
            int registrosAfectados=0;

            for(int i=0; i <listaLibros.size(); i++){
                registrosAfectados = registrosAfectados + exitos[i];
            }
            System.out.println("Se han actualizado "+registrosAfectados+" registros");

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
    }

    public void eliminarListaLibrosBatch(List <Integer> listaIDs) {

        Connection c = null;
        PreparedStatement sentencia = null;

        try {
            c = ConexionSQLServer.obtenerConexion();
            c.setAutoCommit(false);
            String sql = "DELETE FROM Libro WHERE asin = ?";
            sentencia= c.prepareStatement(sql);

            for(Integer asin: listaIDs){
                sentencia.setInt(1, asin);
                sentencia.addBatch();
            }
            //Ejecutar y obtener cuantos se han insertado
            int[] exitos=sentencia.executeBatch();
            c.commit();
            int registrosAfectados=0;

            for(int i=0; i <listaIDs.size(); i++){
                registrosAfectados = registrosAfectados + exitos[i];
            }
            System.out.println("Se han eliminado "+registrosAfectados+" registros");

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
    }
}