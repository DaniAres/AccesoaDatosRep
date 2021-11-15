package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ParseadorCiudadesSAX extends DefaultHandler {

    private ArrayList<Ciudad> listado;
    private Ciudad ciudad;
    private String valorElemento;

    enum tiposNodo{
        CIUDADES,
        CIUDAD,
        COMUNIDAD,
    }

    public ParseadorCiudadesSAX() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        listado = new ArrayList<Ciudad>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if(localName!=null){
            switch (tiposNodo.valueOf(localName.toUpperCase())){
                case CIUDAD:
                    ciudad = new Ciudad();
                    String nombre = attributes.getValue("Nombre");
                    String poblacion = attributes.getValue("Poblacion");
                    if(nombre!=null){
                        ciudad.setNombre(nombre);
                    }
                    if(poblacion!=null){
                        ciudad.setPoblacion(poblacion);
                    }
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(localName!=null){
            switch (tiposNodo.valueOf(localName.toUpperCase())){
                case CIUDADES:
                    break;
                case CIUDAD:
                    listado.add(ciudad);
                    break;
                case COMUNIDAD:
                    ciudad.setComunidad(valorElemento);
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //super.characters(ch, start, length);
        valorElemento = new String(ch,start,length);
    }

    public ArrayList<Ciudad> obtenerResultado() {
        return listado;
    }
}
