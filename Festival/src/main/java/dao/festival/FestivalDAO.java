package dao.festival;


import model.Festival;

import java.util.List;

/**
 * Interfaz Festival la cual nos obliga a implementar los métodos insertar, consultar, listar, actualizar y eliminar.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public interface FestivalDAO {

    public int insertar(Festival objeto) throws Exception;

    public Festival consultar(int id);

    public List<Festival> listar();

    public void actualizar(Festival objeto);

    public void eliminar(int id);
}
