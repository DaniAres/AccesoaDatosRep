package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException, IOException {
        //System.out.println( "Hello World!" );
        ArrayList<MascotaJAXB> mascotas = leerXML("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\JAXB\\mascotas.xml");
        realizarGuardadoXML(mascotas,"C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\JAXB\\mascotasGuardado.xml");
    }

    private static ArrayList<MascotaJAXB> leerXML(String ruta) throws JAXBException {
        File file = new File(ruta);
        ArrayList<MascotaJAXB> listamascotas = new ArrayList<MascotaJAXB>();
        if(file.exists()){
            JAXBContext jaxbContext = JAXBContext.newInstance(Mascotas.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Mascotas mascotas = (Mascotas) jaxbUnmarshaller.unmarshal(file);
            listamascotas = (mascotas!=null ? mascotas.getMascotas() : new ArrayList<MascotaJAXB>());
        } else{
            System.out.println("No se ha podido leer el fichero indicado");
        }
        System.out.println(listamascotas);
        return listamascotas;
    }

    private static void realizarGuardadoXML(ArrayList<MascotaJAXB> mascotas, String ruta2) throws JAXBException, IOException {

        File file2 = new File(ruta2);
        if(!file2.exists()){
            file2.createNewFile();
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(Mascotas.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Mascotas masc1 = new Mascotas();
        masc1.setMascotas(mascotas);
        jaxbMarshaller.marshal(masc1, file2);


    }
}
