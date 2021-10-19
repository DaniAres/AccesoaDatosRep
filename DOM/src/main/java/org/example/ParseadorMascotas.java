package org.example;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParseadorMascotas {

    public static void lecturaDom() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\DOM\\mascotas.xml");

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("mascota");

        ArrayList<Mascota> listaMascotas = new ArrayList<>();

        for (int i=0;i<nList.getLength();i++){

            Node nNode = nList.item(i);

            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element elem = (Element) nNode;
                String valorNombre = elem.getAttribute("Nombre");
                Node tipo = elem.getElementsByTagName("tipo").item(0);
                String valorTipo = tipo.getTextContent();
                Node edad = elem.getElementsByTagName("edad").item(0);
                String valorEdad = edad.getTextContent();
               Node genero = elem.getElementsByTagName("genero").item(0);
               String valorGenero=null;

               if(genero!=null){
                    valorGenero = genero.getTextContent();
               }

               Mascota mascota1 = new Mascota(valorNombre,valorTipo,valorEdad,valorGenero);

                listaMascotas.add(mascota1);
            }
        }
        for(Mascota mascota:listaMascotas){
            System.out.println(mascota.getNombre()+"\t"+ mascota.getTipo()+"\t"+ mascota.getEdad()+"\t"+ mascota.getGenero());

        }
    }
    public static void escrituraDom() throws ParserConfigurationException, IOException, SAXException, TransformerException {

        ArrayList<Mascota> listaMascotas = new ArrayList<>();

        listaMascotas.add(new Mascota("Rex", "Perro", "5", "Macho"));
        listaMascotas.add(new Mascota("Luna", "Gato", "10", "Hembra"));
        listaMascotas.add(new Mascota("Churchill", "Gato", "2", null));

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();


            Element eRaiz = doc.createElement("mascotas");
            doc.appendChild(eRaiz);
            //doc.appendChild(

                //Recorremos las mascotas
            for (Mascota obj : listaMascotas) {
                Element eMascota = doc.createElement("mascota");
                eRaiz.appendChild(eMascota);

                Attr attr = doc.createAttribute("Nombre");
                attr.setValue(obj.getNombre());
                eMascota.setAttributeNode(attr);

                //Definimos
                if (obj.getTipo() != null) {
                    Element eTipo = doc.createElement("tipo");
                    eTipo.appendChild(doc.createTextNode(obj.getTipo()));
                    eMascota.appendChild(eTipo);
                }
                if (obj.getEdad() != null) {
                    Element eEdad = doc.createElement("edad");
                    eEdad.appendChild(doc.createTextNode(obj.getEdad()));
                    eMascota.appendChild(eEdad);
                }
                if (obj.getGenero() != null) {
                    Element eGenero = doc.createElement("genero");
                    eGenero.appendChild(doc.createTextNode(obj.getGenero()));
                    eMascota.appendChild(eGenero);
                }
            }

            //Clases necesarias para finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //Para poner pretty
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}index-amount", "2");

            //Origen del DOM
            DOMSource source = new DOMSource(doc);
            //Fichero en el cual escribimos los resultados
            StreamResult result = new StreamResult(new File("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\DOM\\mascotas2.xml"));
            //Traslado el XML generado al fichero
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (DOMException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError transformerFactoryConfigurationError) {
            transformerFactoryConfigurationError.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
