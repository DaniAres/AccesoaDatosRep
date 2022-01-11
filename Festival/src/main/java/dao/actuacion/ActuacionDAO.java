package dao.actuacion;

import model.Actuacion;

import java.util.List;

public interface ActuacionDAO {

    public int insertar(Actuacion objeto) throws Exception;

    public Actuacion consultar(int id);

    public List<Actuacion> listar();

    public void actualizar(Actuacion objeto);

    public void eliminar(int id);


}
