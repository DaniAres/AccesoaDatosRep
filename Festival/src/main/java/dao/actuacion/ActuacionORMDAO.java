package dao.actuacion;

import connection.ConexionORM;
import model.Actuacion;
import model.Festival;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Operaciones CRUD en bases de datos SQL Server (Hibernate)
 */

public class ActuacionORMDAO implements ActuacionDAO{
    /**
     * Inserta una actuacion en base de datos
     * @param objeto actuacion a insertar
     * @return Identificador de la actuacion insertada
     * @throws Exception
     */
    @Override
    public int insertar(Actuacion objeto) throws Exception {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        conexion.save(objeto);
        tx.commit();
        conexion.close();

        return objeto.getId();
    }

    /**
     * Consulta una actuacion en base de datos
     * @param id Identificador de la actuacion a consultar
     * @return Actuacion consultada
     */
    @Override
    public Actuacion consultar(int id) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion obj = conexion.get(Actuacion.class, id);
        tx.commit();
        return obj;
    }

    /**
     * Lista las actuaciones existentes en base de datos
     * @return lista de actuaciones
     */
    @Override
    public List<Actuacion> listar() {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Actuacion> lista = conexion.createQuery("from Actuacion", Actuacion.class).getResultList();
        tx.commit();
        return lista;
    }

    /**
     * Actualiza una actuacion en base de datos
     *
     * @param objeto Actuacion con valores a actualizar
     */
    @Override
    public void actualizar(Actuacion objeto) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion objBD = conexion.load(Actuacion.class, objeto.getId());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setGrupo(objeto.getGrupo());
        objBD.setEscenario(objeto.getEscenario());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());
        conexion.update(objBD);
        tx.commit();
    }

    /**
     * Elimina una Actuacion en base de datos
     * @param id Identificador de la actuacion a eliminar
     */
    @Override
    public void eliminar(int id) {

        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Actuacion obj = conexion.load(Actuacion.class, id);
        conexion.delete(obj);
        tx.commit();
    }
}
