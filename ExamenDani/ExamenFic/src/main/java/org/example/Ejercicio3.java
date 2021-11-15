package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio3 {

    public static void main(String[] args )
    {
        leerJSON("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Ejercicio3.json");

    }

    private static void leerJSON(String ruta)  {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        FileReader fr = null;
        try {
            fr = new FileReader(ruta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GoleadorGSON[] goleadores = gson.fromJson(fr, GoleadorGSON[].class);
        System.out.println("Ha leido con éxito");
        System.out.println(goleadores);
    }



}
