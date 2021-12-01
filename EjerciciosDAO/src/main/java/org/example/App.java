package org.example;

import org.example.dao.MarcaDaoSQLServer;
import org.example.model.Marca;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        MarcaDaoSQLServer marcaDaoSQLServer = new MarcaDaoSQLServer();
        List<Marca> lista2 = marcaDaoSQLServer.listar();

        for(Marca objMarca: lista2){
           System.out.println(objMarca.toString());
        }

        System.out.println("\n");

       Marca objMarca2= marcaDaoSQLServer.consultar(9);

        System.out.println("\n");

        System.out.println(objMarca2.toString());


    }
}
