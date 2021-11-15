package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.ArrayList;

public class Ejercicio2 {

    public static void main( String[] args ){

    leerXML("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Ejercicio2.xml");


    }

    private static void leerXML(String ruta){

        try{
            //Importar el XMLReader org.
            XMLReader lector = XMLReaderFactory.createXMLReader();
            ParseadorCiudadesSAX parser = new ParseadorCiudadesSAX();
            lector.setContentHandler(parser);
            InputSource fichero = new InputSource("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Ejercicio2.xml");
            lector.parse(fichero);
            ArrayList<Ciudad> lista=parser.obtenerResultado();
            System.out.println(lista);
        }catch (Exception ex){
            System.out.println("Excepcion en el procesamiento del XML");
            ex.printStackTrace();
        }
    }
}
