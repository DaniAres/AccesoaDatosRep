package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException {
        //meter bucle
        System.out.println( "Bienvenido a AVENTURA. Para avanzar en la historia, escriba la opción deseada y pulse ENTER." );
        ArrayList<Escena> escenas = leerXML("C:\\Users\\FP\\Desktop\\aventura.xml");
    }
    private static ArrayList<Escena> leerXML(String ruta) throws JAXBException {
        File file = new File(ruta);
        ArrayList<Escena> listaescenas = new ArrayList<Escena>();
        if(file.exists()){
            JAXBContext jaxbContext = JAXBContext.newInstance(Aventura.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Aventura aventura = (Aventura) jaxbUnmarshaller.unmarshal(file);
            listaescenas = (aventura!=null ? aventura.getEscenas() : new ArrayList<Escena>());
        } else{
            System.out.println("No se ha podido leer el fichero indicado");
        }
        System.out.println(listaescenas);
        return listaescenas;
    }

}
