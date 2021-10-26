package org.example;

public class Alumno {

    private int id;
    private String nombre;
    private int edad;
    private double notaMedia;

    public Alumno() {
    }

    public Alumno(int id, String nombre, int edad, double notaMedia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", notaMedia=" + notaMedia +
                '}';
    }
}
