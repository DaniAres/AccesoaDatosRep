package org.example;

import org.example.connection.ConexionSQLServer;
import org.example.dao.CiudadDao;
import org.example.dao.CiudadDaoSQLServer;
import org.example.model.Ciudad;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //ConexionSQLServer.obtenerConexion();

        /*
        CREATE TABLE [Ciudad] (
	    [Id] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	    [Nombre] [varchar](50) NOT NULL,
	    [Pais] [varchar](50) NOT NULL,
	    [PoblacionONU] int NOT NULL,
	    [PoblacionCENSO] int Not NULL
        )

        INSERT INTO Ciudad (Nombre,Pais,PoblacionONU,PoblacionCENSO) VALUES
        ('Tokio','Japón',37468000,40078055);
        INSERT INTO Ciudad (Nombre,Pais,PoblacionONU,PoblacionCENSO) VALUES
        ('Cantón','China',12638000,39264023);
        INSERT INTO Ciudad (Nombre,Pais,PoblacionONU,PoblacionCENSO) VALUES
        ('Yakarta','Indonesia',10517000,16349831);
         */


        ejercicio1();


    }
    private static void ejercicio1() {

        CiudadDao objciudadDaoSQLServer = new CiudadDaoSQLServer();

        //insertarCiudades


        int idInsertado = objciudadDaoSQLServer.insertar(new Ciudad(5,"Madrid", "España", 234234,43345));
        System.out.println("\n");
        System.out.println("Insertado id " + idInsertado);

        Ciudad objciudad = objciudadDaoSQLServer.consultar(idInsertado);
        System.out.println(objciudad.toString());

        //eliminarCiudades

        /*
        int idEliminar = 4;
        objciudadDaoSQLServer.eliminar(idEliminar);

        System.out.println("\n");

        System.out.println("Eliminado id " + idEliminar);
        */

        //actualizarCiudades

        /*
        objciudadDaoSQLServer.actualizar(new Ciudad(5,"Barcelona", "España", 234234,43345));

        System.out.println("\n");

        System.out.println("Se han actualizado registros");
         */


    }
}
