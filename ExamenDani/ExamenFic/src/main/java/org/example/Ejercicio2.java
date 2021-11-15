package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args ) throws JAXBException {
         leerXML("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\ExamenFic\\Ejercicio2.xml");
    }

    private static void leerXML(String ruta) throws JAXBException {

        File file = new File(ruta);
        ArrayList<RioJAXB> listarios = new ArrayList<RioJAXB>();
        if(file.exists()){
            JAXBContext jaxbContext = JAXBContext.newInstance(Rio.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Rio rios = (Rio) jaxbUnmarshaller.unmarshal(file);
            listarios = (rios!=null ? rios.getRios() : new ArrayList<RioJAXB>());
        } else{
            System.out.println("No se ha podido leer el fichero indicado");
        }
        System.out.println(listarios);
    }
}
