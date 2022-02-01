package org.example.actuacion;

import connection.ConexionORM;
import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionORMDAO;
import dao.festival.FestivalDAO;
import dao.festival.FestivalORMDAO;
import model.Actuacion;
import model.Festival;
import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de test verificar el DAO de actuacion en HIBERNATE
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActuacionDaoORMTest {

    //Daos
    ActuacionDAO daoActuacion = new ActuacionORMDAO();

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

            Actuacion objeto = new Actuacion();
            objeto.setId(1);
            objeto.setNombre("Reunión Aulanosa");
            objeto.setDescripcion("Reunión evaluación 2DAM");
            objeto.setGrupo("A");
            objeto.setEscenario("sdffd");
            objeto.setInicio(fecInsertar);
            objeto.setFin(fecInsertar);


            idInsertado = daoActuacion.insertar(objeto);
            assertTrue( idInsertado>0);
        }  catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**
     * Test de consultar
     */
    @Test
    public void t02Consultar(){

        try{
            Actuacion objeto = daoActuacion.consultar(idInsertado);
            System.out.println(objeto.toString());
            assertEquals("Reunión Aulanosa", objeto.getNombre());
        } catch (Exception e) {
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
            List<Actuacion> lista = daoActuacion.listar();
            assertTrue(lista.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**
     * Test actualizar
     */
    @Test
    public void t04ActualizarDescripcion(){

        try {
            Actuacion objeto = daoActuacion.consultar(idInsertado);
            objeto.setDescripcion("Cambio descripción");
            daoActuacion.actualizar(objeto);
            Actuacion objetoActualizado = daoActuacion.consultar(idInsertado);
            assertEquals("Cambio descripción",
                    objetoActualizado.getDescripcion());
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    /**
     * Test eliminar
     */
    @Test
    public void t05Eliminar(){

        try{
            daoActuacion.eliminar(idInsertado);
            Actuacion objeto = daoActuacion.consultar(idInsertado);
            assertNull(objeto);
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

}
