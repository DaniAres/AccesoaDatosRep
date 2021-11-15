package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class RioJAXB {

    private String nombre;
    private String longitud;
    private String vertiente;
    private String cuenca;

    public RioJAXB(String nombre, String longitud, String vertiente, String cuenca) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.vertiente = vertiente;
        this.cuenca = cuenca;
    }

    public RioJAXB() {
    }

    public String getNombre() {
        return nombre;
    }
    @XmlAttribute(name= "Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLongitud() {
        return longitud;
    }
    @XmlAttribute(name= "Longitud")
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getVertiente() {
        return vertiente;
    }
    @XmlAttribute(name= "Vertiente")
    public void setVertiente(String vertiente) {
        this.vertiente = vertiente;
    }

    public String getCuenca() {
        return cuenca;
    }
    @XmlElement
    public void setCuenca(String cuenca) {
        this.cuenca = cuenca;
    }

    @Override
    public String toString() {
        return "RioJAXB{" +
                "nombre='" + nombre + '\'' +
                ", longitud='" + longitud + '\'' +
                ", vertiente='" + vertiente + '\'' +
                ", cuenca='" + cuenca + '\'' +
                '}';
    }
}
