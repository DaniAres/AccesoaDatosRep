package dao.actuacion;

import model.Actuacion;

import java.util.List;

/**
 * Interfaz Actuacion la cual nos obliga a implementar los métodos insertar, consultar, listar, actualizar y eliminar.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public interface ActuacionDAO {

    public int insertar(Actuacion objeto) throws Exception;

    public Actuacion consultar(int id);

    public List<Actuacion> listar();

    public void actualizar(Actuacion objeto);

    public void eliminar(int id);


}
