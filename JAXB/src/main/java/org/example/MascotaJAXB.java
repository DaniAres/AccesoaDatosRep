package org.example;

import javax.xml.bind.annotation.*;

//Con esto las etiquetas salen por orden
@XmlType(propOrder={"nombre", "tipo", "edad", "genero"})
public class MascotaJAXB {

    private String nombre;
    private String tipo;
    private int edad;
    private String genero;

    public MascotaJAXB(String nombre, String tipo, int edad, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.genero = genero;
    }

    public MascotaJAXB() {
    }

    public String getNombre() {
        return nombre;
    }
    @XmlAttribute(name= "Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }
    @XmlElement
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }
    @XmlElement
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }
    @XmlElement
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "MascotaJAXB{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
