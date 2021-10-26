package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Opciones {

    private String id;
    private String texto;
    private String resultado;

    public Opciones(String id, String texto, String resultado) {
        this.id = id;
        this.texto = texto;
        this.resultado = resultado;
    }

    public Opciones() {
    }

    public String getId() {
        return id;
    }
    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }
    @XmlAttribute
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getResultado() {
        return resultado;
    }
    @XmlAttribute
    public void setResultado(String resultado) {
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
