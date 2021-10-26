package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Aventura {

    private String titulo;
    private ArrayList<Escena> escenas;

    public void setEscenas(ArrayList<Escena> escenas) {
        this.escenas = escenas;
    }
    @XmlElement(name="escena")
    public ArrayList<Escena> getEscenas(){
        return this.escenas;
    }
    @XmlAttribute(name="titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
