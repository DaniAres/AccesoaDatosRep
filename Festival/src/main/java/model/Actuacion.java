package model;

import java.sql.Timestamp;

/**
 * Clase modelo de Actuacion.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */


public class Actuacion {

    private int id;
    private int idFestival;
    private String nombre;
    private String descripcion;
    private String grupo;
    private String escenario;
    private Timestamp inicio;
    private Timestamp fin;

    public Actuacion() {
    }

    public Actuacion(int id, int idFestival, String nombre, String descripcion, String grupo, String escenario, Timestamp inicio, Timestamp fin) {
        this.id = id;
        this.idFestival = idFestival;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupo = grupo;
        this.escenario = escenario;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFestival() {
        return idFestival;
    }

    public void setIdFestival(int idFestival) {
        this.idFestival = idFestival;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
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

    @Override
    public String toString() {
        return "Actuacion{" +
                "id=" + id +
                ", idFestival=" + idFestival +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", grupo='" + grupo + '\'' +
                ", escenario='" + escenario + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
