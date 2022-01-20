package org.example.actuacion;

import connection.ConexionJDBC;
import dao.actuacion.ActuacionJDBCDAO;
import model.Actuacion;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Clase de test de ActuacionJDBCDAO.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ActuacionDaoJDBCTest {

    @Test
    public void t00probarConexion()
    {
        ConexionJDBC.obtenerConexion();

        ActuacionJDBCDAO actuacionDaoSQLServer = new ActuacionJDBCDAO();


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

            Actuacion objeto = new Actuacion();
            objeto.setId(1);
            objeto.setIdFestival(5);
            objeto.setNombre("Reunión Aulanosa");
            objeto.setDescripcion("Reunión evaluación 2DAM");
            objeto.setGrupo("dfg");
            objeto.setEscenario("kjh");
            objeto.setInicio(fecInsertarInicio);
            objeto.setFin(fecInsertarFin);

            ActuacionJDBCDAO actuacionDaoSQLServer = new ActuacionJDBCDAO();
            int idInsertado = actuacionDaoSQLServer.insertar(objeto);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Éxito al insertar");

    }


    @Test
    public void t02Consultar(){

        ActuacionJDBCDAO actuacionDaoSQLServer = new ActuacionJDBCDAO();

        Actuacion objActuacion2= actuacionDaoSQLServer.consultar(14);

        System.out.println("\n");

        System.out.println("Éxito al consultar");
    }


    @Test
    public void t03Listar(){

        ActuacionJDBCDAO actuacionDaoSQLServer = new ActuacionJDBCDAO();
        List<Actuacion> lista2 = actuacionDaoSQLServer.listar();

        for(Actuacion objActuacion: lista2){
            System.out.println(objActuacion.toString());
        }
        System.out.println("Éxito al listar");
    }


    @Test
    public void t04Actualizar(){

        ActuacionJDBCDAO actuacionDaoSQLServer = new ActuacionJDBCDAO();

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

        actuacionDaoSQLServer.actualizar(new Actuacion(30, 6, "España", "iuh", "fyurf", "ipugg", fecInsertarInicio3, fecInsertarFin4));

        System.out.println("\n");

        System.out.println("Se han actualizado registros");

        System.out.println("\n");

    }

    @Test
    public void t05Eliminar(){

        ActuacionJDBCDAO actuacionDaoSQLServer = new ActuacionJDBCDAO();

        int idEliminar = 1006;
        actuacionDaoSQLServer.eliminar(idEliminar);

        System.out.println("\n");

        System.out.println("Eliminado id " + idEliminar);

    }

}
