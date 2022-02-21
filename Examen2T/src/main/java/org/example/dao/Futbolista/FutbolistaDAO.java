package org.example.dao.Futbolista;


import org.example.model.Futbolista;

import java.util.List;

/**
 * Interfaz Coste la cual nos obliga a implementar los métodos insertar y  listar.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public interface FutbolistaDAO {

    public int insertar(Futbolista objeto) throws Exception;

    public List<Futbolista> listar();


}
