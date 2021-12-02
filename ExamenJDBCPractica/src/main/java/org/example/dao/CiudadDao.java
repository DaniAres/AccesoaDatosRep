package org.example.dao;

import org.example.model.Ciudad;

public interface CiudadDao {

    public int insertar(Ciudad objetoCiudad);

    public void eliminar(int id);

    public void actualizar(Ciudad objetoCiudad);

    public Ciudad consultar(int id);
}
