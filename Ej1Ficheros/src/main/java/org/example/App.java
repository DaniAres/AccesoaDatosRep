package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Ejercicio6();
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
                //leemos y escribimos byte a byte

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


    private static void Ejercicio3(){

        File directorio2= new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2\\fichero1.txt");
        FileInputStream in1 = null;
        try(FileInputStream in=new FileInputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2\\fichero1.txt")) {

            int valor = in.read();
            String decimales = "";
            String hexadecimales = "";
            String salChar= "";


            while (valor != -1) {
                decimales = decimales + valor + "-";

                String hexadecimal = Integer.toHexString(valor);
                hexadecimales = hexadecimales + hexadecimal + "-";
                salChar= salChar + (char) valor+ "-";
                valor = in.read();
            }

            System.out.println(decimales);
            System.out.println(hexadecimales);
            System.out.println(salChar);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void Ejercicio4(){

        FileInputStream in = null;

        try {
            in = new FileInputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\notas.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File archivoNotas = new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\notas.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(archivoNotas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        br = new BufferedReader(fr);

        String almacenNotas = "";

        try {
            almacenNotas = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String notas = "";

        while (almacenNotas != null) {
            notas = notas + almacenNotas;

            try {
                almacenNotas = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(notas);

        //Calcular nota media

        String []notas2 = notas.split("[|]");
        double media= 0.0;

        for(String nota:notas2){
            media += Double.parseDouble(nota);
        }
        media = media/notas2.length;
        System.out.println("El resultado del fichero del ejemplo sería "+media);

    }

    private static void Ejercicio5(){

         FileInputStream filein= null;
         InputStreamReader inreader= null;
         OutputStreamWriter outwriter= null;
         FileOutputStream fileout = null;

         try {
             filein= new FileInputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2\\fichero1.txt");
              inreader= new InputStreamReader(filein, StandardCharsets.UTF_8);

              fileout = new FileOutputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Directorio2\\salidacod.txt");
             outwriter= new OutputStreamWriter(fileout, StandardCharsets.ISO_8859_1);


             int caracterdecimal = inreader.read();

             while (caracterdecimal != -1) {
                 char caracter = (char) caracterdecimal;
                 System.out.println(caracter);
                 outwriter.write(caracter);
                 caracterdecimal=inreader.read();
             }
             inreader.close();
             outwriter.close();
             filein.close();
             fileout.close();


         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e2) {
             e2.printStackTrace();
         }

    }

    private static void Ejercicio6(){

        Alumno alumno1 = new Alumno("Alex", 21, 7);
        Alumno alumno2 = new Alumno("Dani", 22, 8);
        Alumno alumno3 = new Alumno("Pepe", 18, 6);

        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);


            RandomAccessFile raf = null;

            ////RandomAccessFile escritura
            try{
                raf = new RandomAccessFile("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\fichero3.txt", "rw");
                for(Alumno obj:listaAlumnos){
                    raf.writeChars(obj.getNombre());
                    raf.writeInt(obj.getEdad());
                    raf.writeDouble(obj.getnotaMedia());
                }
                //RandomAccessFile lectura
                raf.seek(2);
                byte [] bytes = new byte[50];
                raf.read(bytes);

                System.out.println(new String(bytes));

                raf.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



    }



}
