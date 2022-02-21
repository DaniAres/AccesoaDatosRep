package org.example.model;

import java.sql.Timestamp;
import java.util.Date;

public class Futbolista {

    private int id;
    private String nombre;
    private String club;
    private double media;
    private Timestamp ultimo_partido;

    public Futbolista() {
    }

    public Futbolista(int id, String nombre, String club, double media, Timestamp ultimo_partido) {
        this.id = id;
        this.nombre = nombre;
        this.club = club;
        this.media = media;
        this.ultimo_partido = ultimo_partido;
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Timestamp getUltimo_partido() {
        return ultimo_partido;
    }

    public void setUltimo_partido(Date ultimo_partido) {
        this.ultimo_partido = (Timestamp) ultimo_partido;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", club='" + club + '\'' +
                ", media=" + media +
                ", ultimo_partido=" + ultimo_partido +
                '}';
    }
}
