package org.example.festival;

import connection.ConexionJDBC;

import dao.festival.FestivalJDBCDAO;

import model.Festival;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Clase de test de FestivalJDBCDAO.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FestivalDaoJDBCTest {

    @Test
    public void t00probarConexion()
    {
        ConexionJDBC.obtenerConexion();

        FestivalJDBCDAO festivalDaoSQLServer = new FestivalJDBCDAO();

        assertTrue( true );
    }

    private static int idInsertado;

    @Test
    public void t01Insertar(){

        try{
            String fecha = "10/03/2022 10:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate = dateFormat.parse(fecha);
            Timestamp fecInsertarInicio = new Timestamp(parsedDate.getTime());

            String fecha2 = "11/03/2022 10:00";
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date parsedDate2 = dateFormat2.parse(fecha);
            Timestamp fecInsertarFin = new Timestamp(parsedDate.getTime());

            Festival objeto = new Festival();
            objeto.setId(1);
            objeto.setNombre("Reunión Aulanosa");
            objeto.setDescripcion("Reunión evaluación 2DAM");
            objeto.setInicio(fecInsertarInicio);
            objeto.setFin(fecInsertarFin);
            objeto.setAforo(234);
            objeto.setPrecio(new BigDecimal(7.99));
            objeto.setVentas(345);

            FestivalJDBCDAO festivalDaoSQLServer = new FestivalJDBCDAO();
            int idInsertado = festivalDaoSQLServer.insertar(objeto);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Éxito al insertar");

    }

    @Test
    public void t02Consultar(){

        FestivalJDBCDAO festivalDaoSQLServer = new FestivalJDBCDAO();

        Festival objFestival2= festivalDaoSQLServer.consultar(5);

        System.out.println("\n");

        System.out.println("Éxito al consultar");
    }


    @Test
    public void t03Listar(){

        FestivalJDBCDAO festivalDaoSQLServer = new FestivalJDBCDAO();
        List<Festival> lista2 = festivalDaoSQLServer.listar();

        for(Festival objFestival: lista2){
            System.out.println(objFestival.toString());
        }
        System.out.println("Éxito al listar");
    }

    @Test
    public void t04Actualizar(){

        FestivalJDBCDAO festivalDaoSQLServer = new FestivalJDBCDAO();

        System.out.println("\n");

        String fecha3 = "12/03/2022 10:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(fecha3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp fecInsertarInicio3 = new Timestamp(parsedDate.getTime());

        String fecha4 = "13/03/2022 10:00";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        try {
            Date parsedDate2 = dateFormat2.parse(fecha4);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp fecInsertarFin4 = new Timestamp(parsedDate.getTime());

        festivalDaoSQLServer.actualizar(new Festival(5, "España", "iuo9yseo7t", fecInsertarInicio3, fecInsertarFin4, 456, new BigDecimal(99.99), 10));

        System.out.println("\n");

        System.out.println("Se han actualizado registros");

        System.out.println("\n");

    }

    @Test
    public void t05Eliminar(){

        FestivalJDBCDAO festivalDaoSQLServer = new FestivalJDBCDAO();

        int idEliminar = 1022;
        festivalDaoSQLServer.eliminar(idEliminar);

        System.out.println("\n");

        System.out.println("Eliminado id " + idEliminar);

    }


}
