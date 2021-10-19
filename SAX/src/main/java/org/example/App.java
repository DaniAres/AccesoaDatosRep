package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

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

        try{
            //Importar el XMLReader org.
            XMLReader lector = XMLReaderFactory.createXMLReader();
            ParseadorMascotasSAX parser = new ParseadorMascotasSAX();
            lector.setContentHandler(parser);
            InputSource fichero = new InputSource("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\SAX\\mascotas.xml");
            lector.parse(fichero);
            ArrayList<Mascota> lista=parser.obtenerResultado();
            System.out.println(lista);
        }catch (Exception ex){
            System.out.println("Excepcion en el procesamiento del XML");
            ex.printStackTrace();
        }
    }
}
