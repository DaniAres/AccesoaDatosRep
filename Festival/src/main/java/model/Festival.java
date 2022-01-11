package model;

import java.sql.Timestamp;

public class Festival {

    private int id;
    private String nombre;
    private String descripcion;
    private Timestamp inicio;
    private Timestamp fin;
    private int aforo;
    private double precio;
    private int ventas;

    public Festival() {
    }

    public Festival(int id, String nombre, String descripcion, Timestamp inicio, Timestamp fin, int aforo, double precio, int ventas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.aforo = aforo;
        this.precio = precio;
        this.ventas = ventas;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(Timestamp inicio) {
        this.inicio = inicio;
    }

    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", aforo=" + aforo +
                ", precio=" + precio +
                ", ventas=" + ventas +
                '}';
    }
}
