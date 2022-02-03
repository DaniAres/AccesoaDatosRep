package dao.festival;

import connection.ConexionNeodatis;

import model.Actuacion;
import model.Festival;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
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

    /**
     *  mirar insertar
     */
    @Override
    public int insertar(Festival objeto) throws Exception {
        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Festival.class, Where.equal("id", objeto.getId()));
        Objects<Festival> objects = odb.getObjects(query);
        if(objects.size()>0) { throw new Exception("Id tarea duplicado"); }
        odb.store(objeto);
        return objeto.getId();
    }

    @Override
    public Festival consultar(int id) {
        ODB odb = ConexionNeodatis.obtenerConexion();
        IQuery query = new CriteriaQuery(Festival.class, Where.equal("id", id));
        Objects<Festival> objects = odb.getObjects(query);
        Festival obj = null;
        if(objects.size()>0) { obj=objects.getFirst(); }
        return obj;
    }

    @Override
    public List<Festival> listar() {

        ODB odb = ConexionNeodatis.obtenerConexion();
        List<Festival> lista = new ArrayList<>();
        Objects<Festival> objetos = odb.getObjects(Festival.class);
        while (objetos.hasNext()){
            lista.add(objetos.next());
        }
        return lista;
    }


    @Override
    public void actualizar(Festival objeto) {

        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Festival.class, Where.equal("id", objeto.getId()));
        Objects<Festival> objects = odb.getObjects(query);
        Festival objBD = null;
        if(objects.size()>0) { objBD=objects.getFirst(); }

        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());
        objBD.setAforo(objeto.getAforo());
        objBD.setPrecio(objeto.getPrecio());
        objBD.setVentas(objeto.getVentas());

        odb.store(objBD);
    }

    @Override
    public void eliminar(int id) {

        ODB odb = ConexionNeodatis.obtenerConexion();

        IQuery query = new CriteriaQuery(Festival.class, Where.equal("id", id));
        Objects<Festival> objects = odb.getObjects(query);
        Festival obj = null;
        if(objects.size()>0) { obj=objects.getFirst(); }
        odb.delete(obj);
    }
}
