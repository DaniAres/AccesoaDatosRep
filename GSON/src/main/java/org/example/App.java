package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
       ArrayList<AlumnoGSON> alumnos = leerJSON("C:\\Users\\FP\\Desktop\\listaAlumnos.json");
        System.out.println(alumnos);

        String json = escribirJSON(alumnos);
        System.out.println(json);

        try {

            FileWriter file = new FileWriter("C:\\Users\\FP\\Desktop\\listaAlumnos2.json");
            file.write(json);
            file.flush();
            file.close();

            //manejo error
        } catch (IOException e) {

        }
    }
    private static ArrayList<AlumnoGSON> leerJSON (String ruta) throws FileNotFoundException {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        FileReader fr = new FileReader(ruta);
        AlumnoGSON[] alumnos = gson.fromJson(fr, AlumnoGSON[].class);
        return new ArrayList<AlumnoGSON>(Arrays.asList(alumnos));
    }

    public static String escribirJSON(ArrayList<AlumnoGSON> listaAlumnos){
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    String json = gson.toJson(listaAlumnos);
    return json;
    }
}
