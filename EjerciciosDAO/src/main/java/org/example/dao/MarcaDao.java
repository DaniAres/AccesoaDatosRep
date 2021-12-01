package org.example.dao;

import org.example.model.Marca;

import java.util.List;

public interface MarcaDao {

    public List<Marca> listar();

    public Marca consultar(int id);

    public void actualizar(Marca objeto);

    public void eliminar(int id);

    public int insertar(Marca objeto);
}
