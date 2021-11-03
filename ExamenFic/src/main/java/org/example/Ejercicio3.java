package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class Ejercicio3 {

    public static void main( String[] args ){

    leerJSON("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic");
    }

    private static void leerJSON(String ruta){

        ruta ="C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Corredores.json";
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Corredor> lista = mapper.readValue(new File(ruta),
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Corredor.class));

            for(Corredor m : lista){

                System.out.println(m.getNombre()+"-"+ m.getKilometros()+"-"+ m.getEtapas());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
