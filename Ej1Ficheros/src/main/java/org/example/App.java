package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Ejercicio2();
    }

    private static void Ejercicio1(){

        File directorio1= new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1");
        File directorio2= new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2");

        if(directorio1.exists()){
            System.out.println("EL Directorio1 ya existe con fichero1 y fichero2 dentro");
        }else{
            directorio1.mkdir();
            System.out.println("EL Directorio1 fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros");

            try {
                String rutafichero1 = "C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero1.txt";
                String rutafichero2 = "C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero2.txt";
                File fichero1 = new File(rutafichero1);
                File fichero2 = new File(rutafichero2);
                // Si el archivo no existe es creado
                if (!fichero1.exists()) {
                    fichero1.createNewFile();
                    System.out.println("EL fichero1.txt fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1");
                }

                if (!fichero2.exists()) {
                    fichero2.createNewFile();
                    System.out.println("EL fichero2.txt fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if(directorio2.exists()){
            System.out.println("EL Directorio2 ya existe con fichero1 dentro");
        }else{
            directorio2.mkdir();
            System.out.println("EL Directorio2 fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros");

            try {
                String rutafichero1 = "C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2\\fichero1.txt";

                File fichero1 = new File(rutafichero1);

                // Si el archivo no existe es creado
                if (!fichero1.exists()) {
                    fichero1.createNewFile();
                    System.out.println("EL fichero1.txt fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        try {
            String rutafichero3 = "C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\fichero3.txt";

            File fichero3 = new File(rutafichero3);

            // Si el archivo no existe es creado
            if (!fichero3.exists()) {
                fichero3.createNewFile();
                System.out.println("EL fichero3.txt fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros");
            }else{
                System.out.println("EL fichero3.txt ya existe en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String path = "C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros";

        recorrerFicheros(path);

    }

    public static void recorrerFicheros(String path){


        File root = new File(path);
        File[] list = root.listFiles();

        System.out.println("--- Entrando a función con "+path);

        if (list==null)
            return;

        for(File f:list){

            if(f.isDirectory()){
                System.out.println("Directorio -" +f.getAbsoluteFile());
                recorrerFicheros(f.getAbsolutePath());
            }
            else{
                System.out.println("Fichero - " + f.getAbsoluteFile());
            }
        }

    }


    private static void Ejercicio2(){

        //Creamos los file con la ruta de origen y de destino

        File directorio1= new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero1.txt");
        File directorio2= new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero2.txt");

        if(directorio1.exists()){

            System.out.println("EL C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero1.txt ya existe");

            //leemos de uno y escrbimos a otro
            try(
                    InputStream in = new FileInputStream(directorio1);
                    OutputStream out = new FileOutputStream(directorio2);
            )

            {
                int len = in.read();

                while (len != -1) {
                    out.write(len);
                    //lea el siguiente carácter
                    len=in.read();
                }

                in.close();
                out.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }

            //try pa que lea por consola lo escrito a machete en el fichero1.txt

            try(FileInputStream fis=new FileInputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero1.txt")){

                int valor=fis.read();
                while(valor!=-1){
                    System.out.print((char)valor);
                    valor=fis.read();
                }

            }catch(IOException e){

            }

        }else{
            System.out.println("El C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio1\\fichero1.txt no existe");
        }




    }











}
