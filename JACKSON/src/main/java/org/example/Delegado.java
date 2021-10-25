package org.example;

public class Delegado extends Alumno{

    private String ciclo;
    private int curso;

    public Delegado() {
    }

    public Delegado(String nombre, int edad, double notaMedia, String ciclo, int curso) {
        super(nombre, edad, notaMedia);
        this.ciclo = ciclo;
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
