package org.example.festival;

import connection.ConexionORM;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de test verificar el DAO de festival en HIBERNATE
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FestivalDaoORMTest {

    //Daos
    FestivalDAO daoFestival = new FestivalORMDAO();

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

            Festival objeto = new Festival();
            objeto.setId(1);
            objeto.setNombre("Reunión Aulanosa");
            objeto.setDescripcion("Reunión evaluación 2DAM");
            objeto.setInicio(fecInsertar);
            objeto.setFin(fecInsertar);
            objeto.setAforo(999);
            objeto.setPrecio(new BigDecimal(88.88));
            objeto.setVentas(999);

            idInsertado = daoFestival.insertar(objeto);
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
            Festival objeto = daoFestival.consultar(idInsertado);
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
            List<Festival> lista = daoFestival.listar();
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
            Festival objeto = daoFestival.consultar(idInsertado);
            objeto.setDescripcion("Cambio descripción");
            daoFestival.actualizar(objeto);
            Festival objetoActualizado = daoFestival.consultar(idInsertado);
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
            daoFestival.eliminar(idInsertado);
            Festival objeto = daoFestival.consultar(idInsertado);
            assertNull(objeto);
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

}
