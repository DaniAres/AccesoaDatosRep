package org.example.actuacion;

import connection.ConexionJDBC;
import connection.ConexionNeodatis;
import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionJDBCDAO;
import dao.actuacion.ActuacionNeodatisDAO;
import dao.festival.FestivalDAO;
import dao.festival.FestivalNeodatisDAO;
import model.Actuacion;
import model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de test de ActuacionNeodatisDAO.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActuacionDaoNeodatisTest {

    //Datos
    ActuacionDAO daoActuacion = new ActuacionNeodatisDAO();


    //Almacenamos el id de pruebas
    private static int idInsertado;


    //@Test
    public void t00probarConexion()
    {
        ConexionNeodatis.obtenerConexion();

        ActuacionNeodatisDAO actuacionNeodatisDaoSQLServer = new ActuacionNeodatisDAO();

        assertTrue( true );
    }


    @Test
    public void t01Insertar(){

        try {
            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertar = new Timestamp(parsedDate.getTime());

            Actuacion objeto = new Actuacion();
            objeto.setId(1);
            objeto.setIdFestival(5);
            objeto.setNombre("Reunión Aulanosa");
            objeto.setDescripcion("Reunión evaluación 2DAM");
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

    //@Test
    public void t02Consultar() {

        Actuacion objeto = daoActuacion.consultar(idInsertado);
        assertEquals("Reunión Aulanosa", objeto.getNombre());
        System.out.println("Éxito al consultar");
    }

    //@Test
    public void t03Listar() {

        List<Actuacion> lista = daoActuacion.listar();
        assertTrue(lista.size()>0);
        System.out.println("Éxito al listar");
    }

    //@Test
    public void t04ActualizarDescripcion() {

        Actuacion objeto = daoActuacion.consultar(idInsertado);
        objeto.setDescripcion("Cambio de descripción");
        daoActuacion.actualizar(objeto);

        Actuacion objetoActualizado = daoActuacion.consultar(idInsertado);
        assertEquals("Cambio de descripción", objetoActualizado.getDescripcion());

        System.out.println("Éxito al actualizar la descripción");
    }


    //@Test
    public void t05Eliminar() {

        daoActuacion.eliminar(idInsertado);
        Actuacion objeto= daoActuacion.consultar(idInsertado);
        assertNull(objeto);

        System.out.println("Éxito al eliminar");
    }

    //@Test
    public void t99CerrarConexion()
    {
        System.out.println(daoActuacion.listar().toString());
        ConexionNeodatis.cerrarConexion();
        assertTrue( true);
    }

}
