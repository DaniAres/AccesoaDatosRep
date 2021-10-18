package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //System.out.println( "Hello World!" );
        //ParseadorMascotas.lecturaDom();
        ParseadorMascotas.escrituraDom();

    }
}
