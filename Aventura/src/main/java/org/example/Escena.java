package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class Escena {

    private String codigo;
    private String texto;
    private ArrayList<Opciones> opcion;

    public Escena(String codigo, String texto, ArrayList<Opciones> opcion) {
        this.codigo = codigo;
        this.texto = texto;
        this.opcion = opcion;
    }

    public Escena() {
    }

    public String getCodigo() {
        return codigo;
    }
    @XmlAttribute(name= "codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }
    @XmlElement
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<Opciones> getOpcion() {
        return opcion;
    }
    @XmlElement
    public void setOpcion(ArrayList<Opciones> opcion) {
        this.opcion = opcion;
    }

    @Override
    public String toString() {
        return "Escena{" +
                "codigo=" + codigo +
                ", texto='" + texto + '\'' +
                ", opcion=" + opcion +
                '}';
    }
}
