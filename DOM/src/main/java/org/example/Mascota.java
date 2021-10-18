package org.example;

public class Mascota {

    private String nobre;
    private String tipo;
    private String edad;
    private String genero;

    public Mascota(String nobre, String tipo, String edad, String genero) {
        this.nobre = nobre;
        this.tipo = tipo;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNobre() {
        return nobre;
    }

    public void setNobre(String nobre) {
        this.nobre = nobre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nobre='" + nobre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", edad='" + edad + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
