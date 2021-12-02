package org.example.model;

public class Ciudad {

    private int id;
    private String nombre;
    private String pais;
    private int poblacionONU;
    private int poblacionCENSO;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, String pais, int poblacionONU, int poblacionCENSO) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.poblacionONU = poblacionONU;
        this.poblacionCENSO = poblacionCENSO;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getPoblacionONU() {
        return poblacionONU;
    }

    public void setPoblacionONU(int poblacionONU) {
        this.poblacionONU = poblacionONU;
    }

    public int getPoblacionCENSO() {
        return poblacionCENSO;
    }

    public void setPoblacionCENSO(int poblacionCENSO) {
        this.poblacionCENSO = poblacionCENSO;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", poblacionONU=" + poblacionONU +
                ", poblacionCENSO=" + poblacionCENSO +
                '}';
    }
}
