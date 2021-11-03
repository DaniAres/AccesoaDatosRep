package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Ejercicio1 {

    public static void main( String[] args ){

        ArrayList<String> lineas = new ArrayList<String>();

        lineas.add("Hola");
        lineas.add("Adiós");
        lineas.add("Adiós");

        escribirFicUTF8(lineas, "C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Directorio1");

        leerFicUTF8("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Directorio1\\Ejercicio1.txt");
    }

    private static void escribirFicUTF8(ArrayList<String> lineas, String ruta) {

        File directorio1 = new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Directorio1");
        if(directorio1.exists()){
            System.out.println("EL Directorio1 ya existe");
        }else {
            directorio1.mkdir();
            System.out.println("EL Directorio1 fue creado en C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic");
        }


        OutputStreamWriter outwriter= null;
        FileOutputStream fileout = null;

        try {
            fileout = new FileOutputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Directorio1\\Ejercicio1.txt");
            outwriter = new OutputStreamWriter(fileout, StandardCharsets.UTF_8);

            //TODO escribir en el txt
            for(String linea :lineas){
                System.out.println(linea);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } finally {
            try {
                if (fileout!=null)fileout.close();
                if (fileout!=null)outwriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

    }

    private static void leerFicUTF8(String ruta) {

        FileInputStream filein= null;
        InputStreamReader inreader= null;

        try {
            filein = new FileInputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Directorio1\\Ejercicio1.txt");
            inreader = new InputStreamReader(filein, StandardCharsets.UTF_8);

            int caracterdecimal = inreader.read();

            while (caracterdecimal != -1) {
                char caracter = (char) caracterdecimal;
                System.out.println(caracter);
                inreader.read(new char[]{caracter});
                caracterdecimal=inreader.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (filein != null) filein.close();
                if (filein != null) inreader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
