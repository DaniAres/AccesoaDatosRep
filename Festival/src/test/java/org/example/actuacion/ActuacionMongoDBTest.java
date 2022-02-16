package org.example.actuacion;

import com.mongodb.client.MongoDatabase;
import connection.ConexionMongoDB;
import connection.ConexionNeodatis;
import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionMongoDBDAO;
import dao.actuacion.ActuacionNeodatisDAO;
import model.Actuacion;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de test de ActuacionMongoDB.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActuacionMongoDBTest {

    //Daos
    ActuacionDAO daoActuacion = new ActuacionMongoDBDAO();

    //Almacenamos el id de pruebas
    private static int idInsertado;

    /**
     * Test probar conexion
     */
    @Test
    public void t00ProbarConexion()
    {
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        assertNotNull(conexion);
    }

    /**
     * Test insertar
     */

    @Test
    public void t01Insertar(){

        try {
            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

            Actuacion objeto = new Actuacion();
            objeto.setId(2);
            objeto.setIdFestival(5);
            objeto.setNombre("Obra Ferrol");
            objeto.setDescripcion("Rua Nova 23");
            objeto.setGrupo("dfg");
            objeto.setEscenario("patata");
            objeto.setInicio(fecInsertar);
            objeto.setFin(fecInsertar);

            idInsertado = daoActuacion.insertar(objeto);
            assertTrue( idInsertado>0);

        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Éxito al insertar");
    }


    /**
     * Test consultar
     */

    @Test
    public void t02Consultar(){

        Actuacion objeto = daoActuacion.consultar(idInsertado);
        assertEquals("Rua Nova 23", objeto.getDescripcion());

        System.out.println("Éxito al consultar");
    }

    /**
     * Test de listar
     */
    @Test
    public void t03Listar(){

        List<Actuacion> lista = daoActuacion.listar();
        assertTrue(lista.size()>0);

        System.out.println("Éxito al listar");
    }

    /**
     * Test actualizar descripcion
     */
    @Test
    public void t04ActualizarDescripcion(){

        Actuacion objeto = daoActuacion.consultar(idInsertado);
        objeto.setDescripcion("Cambio Descripción");
        daoActuacion.actualizar(objeto);

        Actuacion objetoActualizado = daoActuacion.consultar(idInsertado);
        assertEquals("Cambio Descripción", objetoActualizado.getDescripcion());

        System.out.println("Éxito al actualizar");
    }

    /**
     * Test Eliminar
     */
    @Test
    public void t05Eliminar(){

        daoActuacion.eliminar(idInsertado);

        Actuacion objeto = daoActuacion.consultar(idInsertado);
        assertNull(objeto);

        System.out.println("Éxito al eliminar");
    }

    /**
     * Test para cerrar la conexion
     */
    @Test
    public void t99CerrarConexion(){

        ConexionMongoDB.cerrarConexion();
        assertTrue(true);
        System.out.println("Éxito al cerrar la conexion");
    }

}
