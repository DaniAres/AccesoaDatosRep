package org.example;

import org.example.connection.ConexionORM;
import org.example.dao.Futbolista.FutbolistaDAO;

import org.example.dao.Futbolista.FutbolistaORMDAO;
import org.example.model.Futbolista;

import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Clase de test verificar el DAO de Futbolista en HIBERNATE
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FutbolistaDaoORMTest {

    //Daos
   FutbolistaDAO daoFutbolista = new FutbolistaORMDAO();

    //Almacenamos el id de pruebas
    private static int idInsertado;

    @Test
    public void t00probarConexion(){
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
    }

    /**
     * Test insertar
     */
    @Test
    public void t01Insertar(){

        try{

            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

            Futbolista objeto = new Futbolista();
            objeto.setId(1);
            objeto.setNombre("Pepe");
            objeto.setClub("Deportivo");
            objeto.setMedia(10.9);
            objeto.setUltimo_partido(fecInsertar);

            idInsertado = daoFutbolista.insertar(objeto);
            assertTrue( idInsertado>0);
        }  catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }


    /**
     * Test listar
     */
    @Test
    public void t03Listar(){
        try {
            List<Futbolista> lista = daoFutbolista.listar();
            assertTrue(lista.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }





}
