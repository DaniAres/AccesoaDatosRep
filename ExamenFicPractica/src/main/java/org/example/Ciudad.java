package org.example;

public class Ciudad {

    private String nombre;
    private String poblacion;
    private String comunidad;

    public Ciudad(String nombre, String poblacion, String comunidad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.comunidad = comunidad;
    }

    public Ciudad() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", comunidad='" + comunidad + '\'' +
                '}';
    }
}
