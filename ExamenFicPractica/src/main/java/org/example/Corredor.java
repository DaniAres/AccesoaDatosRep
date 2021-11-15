package org.example;

public class Corredor {

    private String nombre;
    private int kilometros;
    private int etapas;

    public Corredor() {
    }

    public Corredor(String nombre, int kilometros, int etapas) {
        this.nombre = nombre;
        this.kilometros = kilometros;
        this.etapas = etapas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {
        this.etapas = etapas;
    }

    @Override
    public String toString() {
        return "Corredor{" +
                "nombre='" + nombre + '\'' +
                ", kilometros=" + kilometros +
                ", etapas=" + etapas +
                '}';
    }
}
