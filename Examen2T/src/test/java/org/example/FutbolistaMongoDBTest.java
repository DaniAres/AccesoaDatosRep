package org.example;

import com.mongodb.client.MongoDatabase;
import org.example.connection.ConexionMongoDB;

import org.example.dao.Futbolista.FutbolistaDAO;
import org.example.dao.Futbolista.FutbolistaMongoDBDAO;
import org.example.model.Futbolista;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de test de UnidadMongoDB.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FutbolistaMongoDBTest {

    //Daos
    FutbolistaDAO daoFutbolista = new FutbolistaMongoDBDAO();

    //Almacenamos el id de pruebas
    private static int idInsertado;

    /**
     * Test probar conexion
     */
    @Test
    public void t00ProbarConexion() {
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

            Futbolista objeto = new Futbolista();
            objeto.setId(2);
            objeto.setNombre("Pepe");
            objeto.setClub("Deportivo de la Coruña");
            objeto.setMedia(3.5);
            objeto.setUltimo_partido(fecInsertar);

            idInsertado = daoFutbolista.insertar(objeto);
            assertTrue( idInsertado>0);

        }  catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Test de listar
     */
    @Test
    public void t03Listar(){

        List<Futbolista> lista = daoFutbolista.listar();
        assertTrue(lista.size()>0);

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
