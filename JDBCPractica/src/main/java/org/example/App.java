package org.example;

import org.example.model.Alquiler;
import org.example.dao.LibroDao;
import org.example.dao.LibroDaoSQLServer;
import org.example.model.Libro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
         //ConexionSQLServer.obtenerConexion();

        pruebaDao1();

    }

    private static void pruebaDao1() {

        LibroDao libroDaoSQLServer = new LibroDaoSQLServer();

        //Para la fecha

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = null;
        try {
            parsed = format.parse("20110210");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlFecha = new java.sql.Date(parsed.getTime());

        //Insertar
        //Inserta incremental no el asin indicado

        /*
        int asinInsertado = libroDaoSQLServer.insertar(new Libro(18,"Manu", sqlFecha, 1 , 1, "Vicens", "Gallego", "100"));
        System.out.println("\n");
        System.out.println("Insertado asin " + asinInsertado);
        */


        //Listar

        /*
        List<Libro> libros = libroDaoSQLServer.listar();

        System.out.println("\n");

        for(Libro objLibro: libros){
            System.out.println(objLibro.toString());
        }
        */


        //Consultar

        /*
        Libro objLibro2= libroDaoSQLServer.consultar(5);

        System.out.println("\n");

        System.out.println(objLibro2.toString());
        */


        //Actualizar

        /*
        int objactualizados= libroDaoSQLServer.actualizar(new Libro(12,"Manolo", sqlFecha, 1 , 1, "Vicens", "frances", "100"));

        System.out.println("\n");

        System.out.println("Se han actualizado "+objactualizados+" registros");
        */


        //Eliminar

        /*
        int asinEliminar = 17;
        libroDaoSQLServer.eliminar(asinEliminar);

        System.out.println("\n");

        System.out.println("Eliminado asin " + asinEliminar);
        */


        //Vistas

        /*
        CREATE VIEW [dbo].[vistaLibro] AS
        SELECT *
        FROM Libro;
         */

       /*
        int asinVista = libroDaoSQLServer.verVistas(new Libro(18,"Alejandro", sqlFecha, 1 , 1, "Vicens", "Gallego", "100"));

        System.out.println("\n");

        System.out.println("Vista nº: " + asinVista);
        */


        //Procedimiento almacenado

        /*
        USE [Biblioteca]
        GO

        SET ANSI_NULLS ON
        GO
        SET QUOTED_IDENTIFIER ON
        GO
        CREATE PROCEDURE fechaAlquiler (@FechaLanzamiento DATETIME)
        AS
        BEGIN

            SET NOCOUNT ON;

            SELECT *
            FROM Alquiler
            WHere FechaSalida = @FechaLanzamiento;
        END
         */

        /*
        List<Alquiler> alquileres = libroDaoSQLServer.verProcedimiento(sqlFecha);

        System.out.println("\n");

        for(Alquiler objAlquiler: alquileres){
            System.out.println(objAlquiler.toString());
        }
        */

        //Solo nos muestra el idAlquiler 7 porque es el único en el que coincide la fecha introducida arriba con los dos campos fechaSalida y fechaEntrada


        //Operaciones Batch/Ejecuciones por lotes

        //Insercion Lista modo Batch

        /*
        Libro objlibro= new Libro(18,"Juan", sqlFecha, 1 , 1, "Vicens", "Gallego", "100");
        Libro objlibro2= new Libro(19,"Manolo", sqlFecha, 1 , 1, "Vicens", "Gallego", "100");

        List<Libro> listaLibros = new ArrayList<>();

        listaLibros.add(objlibro);
        listaLibros.add(objlibro2);

        libroDaoSQLServer.insertarListaLibrosBatch(listaLibros);

        System.out.println("\n");

        int asinInsertado= objlibro.getAsin();
        int asinInsertado2= objlibro2.getAsin();
        System.out.println("Insertado ASIN " + asinInsertado);
        System.out.println("Insertado ASIN " + asinInsertado2);
        */

        //Nos imprime lo indicado arriba, aunque  el ASIN es incremental en la BBDD

        //Actualizacion Lista modo Batch

        /*
        Libro objlibro3= new Libro(40,"Diego", sqlFecha, 1 , 1, "Vicens", "Gallego", "100");
        Libro objlibro4= new Libro(41,"Diego", sqlFecha, 1 , 1, "Vicens", "Gallego", "100");

        List<Libro> listaLibros = new ArrayList<>();

        listaLibros.add(objlibro3);
        listaLibros.add(objlibro4);

        libroDaoSQLServer.actualizarListaLibrosBatch(listaLibros);

        System.out.println("\n");

        int asinActualizado3= objlibro3.getAsin();
        int asinActualizado4= objlibro4.getAsin();
        System.out.println("Actualizado ASIN " + asinActualizado3);
        System.out.println("Actualizado ASIN " + asinActualizado4);
         */

        //Eliminacion Lista modo Batch

        /*
        int asinLibro1= 44;
        int asinLibro2= 45;

        List<Integer> listaIDs = new ArrayList<>();

        listaIDs.add(asinLibro1);
        listaIDs.add(asinLibro2);

        libroDaoSQLServer.eliminarListaLibrosBatch(listaIDs);

        System.out.println("\n");

        System.out.println("Eliminado ASIN " + asinLibro1);
        System.out.println("Eliminado ASIN " + asinLibro2);

         */
    }
}
