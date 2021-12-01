package org.example.model;

import java.sql.Date;

public class Libro {

    private int asin;
    private String titulo;
    private Date fechaLanzamiento;
    private int autor;
    private int categoria;
    private String editorial;
    private String idioma;
    private String paginas;

    public Libro() {
    }

    public Libro(int asin, String titulo, Date fechaLanzamiento, int autor, int categoria, String editorial, String idioma, String paginas) {
        this.asin = asin;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.autor = autor;
        this.categoria = categoria;
        this.editorial = editorial;
        this.idioma = idioma;
        this.paginas = paginas;
    }

    public int getAsin() {
        return asin;
    }

    public void setAsin(int asin) {
        this.asin = asin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "asin=" + asin +
                ", titulo='" + titulo + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", autor=" + autor +
                ", categoria=" + categoria +
                ", editorial='" + editorial + '\'' +
                ", idioma='" + idioma + '\'' +
                ", paginas='" + paginas + '\'' +
                '}';
    }
}
