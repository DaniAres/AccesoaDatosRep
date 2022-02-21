package org.example;

import org.example.dao.Futbolista.FutbolistaDAO;
import org.example.dao.Futbolista.FutbolistaMongoDBDAO;
import org.example.dao.Futbolista.FutbolistaORMDAO;
import org.example.model.Futbolista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Clase main
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FutbolistaDAO daoFutbolistam = new FutbolistaMongoDBDAO();
        FutbolistaDAO daoFutbolista = new FutbolistaORMDAO();

        Futbolista futbolista1 = new Futbolista();

       CargarEnMongoDB();
       System.out.println("--------------------------------------------------------------");
       CargarEnSQLServer();
    }
    private static void CargarEnMongoDB(){

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File ("C:\\Users\\FP\\Desktop\\CargaBD.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }


    }


    private static void CargarEnSQLServer(){

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File ("C:\\Users\\FP\\Desktop\\CargaBD.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }


    }



}
