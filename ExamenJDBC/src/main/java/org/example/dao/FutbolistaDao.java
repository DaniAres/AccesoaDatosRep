package org.example.dao;

import org.example.model.Futbolista;

import java.util.List;

public interface FutbolistaDao {

    public int insertar(Futbolista objetoFutbolista);

    public void eliminar(int id);

    public void actualizar(Futbolista objetoFutbolista);

    public Futbolista consultar(int id);

    public List<Futbolista> listarVista();

    public List<Futbolista> listarSP();

    public int insertarBatch(List <Futbolista> lista);
}
