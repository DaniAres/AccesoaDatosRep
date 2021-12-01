package org.example.dao;

import org.example.model.Alquiler;
import org.example.model.Libro;

import java.util.Date;
import java.util.List;

public interface LibroDao {

    public int insertar(Libro objeto);

    public List<Libro> listar();

    public Libro consultar(int asin);

    public int actualizar(Libro objeto);

    public void eliminar(int asin);

    public int verVistas(Libro objeto);

    public List<Alquiler> verProcedimiento(java.util.Date sqlFecha);

    public void insertarListaLibrosBatch(List <Libro> listaLibros);

    public void actualizarListaLibrosBatch(List <Libro> listaLibros);

    public void eliminarListaLibrosBatch(List <Integer> listaIDs);

}
