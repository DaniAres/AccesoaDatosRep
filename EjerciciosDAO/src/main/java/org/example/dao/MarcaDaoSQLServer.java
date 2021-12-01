package org.example.dao;

import org.example.connection.ConexionSQLServer;
import org.example.model.Marca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaDaoSQLServer {

    public List<Marca> listar() {

        List<Marca> lista = new ArrayList<>();
        Connection c = null;

        try {
            //PersistenciaBBDD.CargarDriver();
            c = ConexionSQLServer.obtenerConexion();
            String consulta = "SELECT * from marcas";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(consulta);
            while (rs.next()) {
                Marca objeto = new Marca();
                objeto.setId(rs.getInt("ID"));
                objeto.setNombre(rs.getString("Nombre"));

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

    public Marca consultar(int id) {

        {
            Connection c = null;
            Marca objeto2 = new Marca();
            try {
                //PersistenciaBBDD.CargarDriver();
                c = ConexionSQLServer.obtenerConexion();
                String consulta = "SELECT * from marcas where id=?;";
                PreparedStatement ps = c.prepareStatement(consulta);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    objeto2.setId(rs.getInt("ID"));
                    objeto2.setNombre(rs.getString("Nombre"));
                    System.out.println("Nombre:" + rs.getString("Nombre"));
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
}
