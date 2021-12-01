package org.example.model;

import java.sql.Date;

public class Alquiler {

    private int idAlquiler;
    private String idLector;
    private int idLibro;
    private Date fechaSalida;
    private Date fechaEntrada;

    public Alquiler() {
    }

    public Alquiler(int idAlquiler, String idLector, int idLibro, Date fechaSalida, Date fechaEntrada) {
        this.idAlquiler = idAlquiler;
        this.idLector = idLector;
        this.idLibro = idLibro;
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getIdLector() {
        return idLector;
    }

    public void setIdLector(String idLector) {
        this.idLector = idLector;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "idAlquiler=" + idAlquiler +
                ", idLector='" + idLector + '\'' +
                ", idLibro=" + idLibro +
                ", fechaSalida=" + fechaSalida +
                ", fechaEntrada=" + fechaEntrada +
                '}';
    }
}
