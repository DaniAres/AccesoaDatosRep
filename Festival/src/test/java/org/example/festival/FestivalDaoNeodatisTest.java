package org.example.festival;

import connection.ConexionNeodatis;

import dao.festival.FestivalDAO;
import dao.festival.FestivalNeodatisDAO;

import model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Clase de test de FestivalNeodatisDAO.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FestivalDaoNeodatisTest {

    //Datos
    FestivalDAO daoFestival = new FestivalNeodatisDAO();

    //Almacenamos el id de pruebas
    private static int idInsertado;


    @Test
    public void t00probarConexion()
    {
        ConexionNeodatis.obtenerConexion();

        FestivalNeodatisDAO festivalNeodatisDaoSQLServer = new FestivalNeodatisDAO();

        assertTrue( true );
    }

    @Test
    public void t01Insertar(){

        try {
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
            objeto.setAforo(235);
            objeto.setPrecio(10.99);
            objeto.setVentas(346);

            idInsertado = daoFestival.insertar(objeto);
            assertTrue( idInsertado>0);

        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Éxito al insertar");
    }



}
