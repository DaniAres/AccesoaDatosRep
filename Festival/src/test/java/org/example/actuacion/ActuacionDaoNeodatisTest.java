package org.example.actuacion;

import connection.ConexionJDBC;
import connection.ConexionNeodatis;
import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionJDBCDAO;
import dao.actuacion.ActuacionNeodatisDAO;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@FixMethodOrder
public class ActuacionDaoNeodatisTest {

    private static int idInsertado;

    ActuacionDAO
    @Test
    public void probarConexion()
    {
        ConexionNeodatis.obtenerConexion();

        ActuacionNeodatisDAO actuacionNeodatisDaoSQLServer = new ActuacionNeodatisDAO();

        assertTrue( true );
    }

}
