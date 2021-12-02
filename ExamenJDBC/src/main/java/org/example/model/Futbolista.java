package org.example.model;

public class Futbolista {

    private int id;
    private String nombre;
    private String club;
    private int edad;

    public Futbolista() {
    }

    public Futbolista(int id, String nombre, String club, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.club = club;
        this.edad = edad;
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

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", club='" + club + '\'' +
                ", edad=" + edad +
                '}';
    }
}
