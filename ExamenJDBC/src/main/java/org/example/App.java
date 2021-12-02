package org.example;

import org.example.connection.ConexionSQLServer;
import org.example.dao.FutbolistaDao;
import org.example.dao.FutbolistaDaoSQLServer;
import org.example.model.Futbolista;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        //ConexionSQLServer.obtenerConexion();

        ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
    }


    private static void ejercicio1() {

        FutbolistaDao futbolistaDaoSQLServer = new FutbolistaDaoSQLServer();

        //Insertar

        /*
        int idInsertado = futbolistaDaoSQLServer.insertar(new Futbolista(5, "Alejandro", "Real Madrid", 33));
        System.out.println("\n");
        System.out.println("Insertado asin " + idInsertado);
         */

        //Consultar

        /*
        Futbolista objFutbolista2= futbolistaDaoSQLServer.consultar(5);

        System.out.println("\n");

        System.out.println(objFutbolista2.toString());
         */


        //Actualizar

        /*
        futbolistaDaoSQLServer.actualizar(new Futbolista(5, "Raul", "Real Madrid", 35));

        System.out.println("\n");

        System.out.println("Se han actualizado registros");

         */

        //Consultar

        /*
        Futbolista objFutbolista3= futbolistaDaoSQLServer.consultar(5);

        System.out.println("\n");

        System.out.println(objFutbolista3.toString());
         */


        //Eliminar

        /*
        int idEliminar = 5;
        futbolistaDaoSQLServer.eliminar(idEliminar);

        System.out.println("\n");

        System.out.println("Eliminado id " + idEliminar);
         */

    }

    private static void ejercicio2() {

        FutbolistaDao futbolistaDaoSQLServer = new FutbolistaDaoSQLServer();

        //ImprimirVista

        List<Futbolista> listaVista = futbolistaDaoSQLServer.listarVista();
        System.out.println("\n");
        System.out.println("Vista nº: 1");

    }

    private static void ejercicio3() {

        FutbolistaDao futbolistaDaoSQLServer = new FutbolistaDaoSQLServer();


        //ImprimirProcedimiento


        List<Futbolista> futbolistas = futbolistaDaoSQLServer.listarSP();

        System.out.println("\n");

        for(Futbolista objAlquiler: futbolistas){
            System.out.println(objAlquiler.toString());
        }

        //No me hace el print por consola
    }

    private static void ejercicio4() {

        FutbolistaDao futbolistaDaoSQLServer = new FutbolistaDaoSQLServer();

        //InsertarBatch


        Futbolista objFutbolista1= new Futbolista(8, "Courtois", "Real Madrid", 29);
        Futbolista objFutbolista2= new Futbolista(9, "Casemiro", "Real Madrid", 29);
        Futbolista objFutbolista3= new Futbolista(10, "Ceballos", "Arsenal", 25);

        List<Futbolista> lista = new ArrayList<>();

        lista.add(objFutbolista1);
        lista.add(objFutbolista2);
        lista.add(objFutbolista3);

        futbolistaDaoSQLServer.insertarBatch(lista);

        System.out.println("\n");

        int idInsertado= objFutbolista1.getId();
        int idInsertado2= objFutbolista2.getId();
        int idInsertado3= objFutbolista3.getId();

        System.out.println("Insertado Id " + idInsertado);
        System.out.println("Insertado Id " + idInsertado2);
        System.out.println("Insertado Id " + idInsertado3);


    }

}
