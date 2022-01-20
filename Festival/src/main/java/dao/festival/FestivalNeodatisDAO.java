package dao.festival;

import connection.ConexionNeodatis;

import model.Festival;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.List;

/**
 * Operaciones CRUD en bases de datos Neodatis para almacenar objetos, es este caso de Festival.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class FestivalNeodatisDAO implements FestivalDAO{

    /**
     * @param objeto
     * @return
     * @throws Exception
     */

    @Override
    public int insertar(Festival objeto) throws Exception {
        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Actuacion.class, Where.equal("id", objeto.getId()));
        Objects<Festival> objects = odb.getObjects(query);
        if(objects.size()>0) { throw new Exception("Id tarea duplicado"); }
        odb.store(objeto);
        return objeto.getId();
    }

    @Override
    public Festival consultar(int id) {
        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Actuacion.class, Where.equal("id", id));
        Objects<Actuacion> objects = odb.getObjects(query);
        Actuacion obj = null;
        if(objects.size()>0) { obj=objects.getFirst(); }
        return obj;
    }

    @Override
    public List<Festival> listar() {
        return null;
    }

    @Override
    public void actualizar(Festival objeto) {

    }

    @Override
    public void eliminar(int id) {

    }
}
