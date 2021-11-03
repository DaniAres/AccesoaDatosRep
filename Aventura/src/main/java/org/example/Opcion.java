package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Opcion {

    private int id;
    private String texto;
    private int resultado;

    public Opcion(int id, String texto, int resultado) {
        this.id = id;
        this.texto = texto;
        this.resultado = resultado;
    }

    public Opcion() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    @XmlAttribute
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getResultado() {
        return resultado;
    }

    @XmlAttribute
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Opciones{" +
                "id='" + id + '\'' +
                ", texto='" + texto + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
