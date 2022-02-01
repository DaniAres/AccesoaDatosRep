package dao.festival;

import connection.ConexionORM;
import model.Festival;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * Operaciones CRUD en bases de datos SQL Server (Hibernate)
 */

public class FestivalORMDAO implements FestivalDAO{
    /**
     * Inserta un festival en base de datos
     * @param objeto festival a insertar
     * @return Identificador del festival  insertada
     * @throws Exception
     */
    @Override
    public int insertar(Festival objeto) throws Exception {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        conexion.save(objeto);
        tx.commit();
        conexion.close();

        return objeto.getId();
    }

    /**
     * Consulta un festival en base de datos
     * @param id Identificador del festival a consultar
     * @return Festival consultada
     */
    @Override
    public Festival consultar(int id) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival obj = conexion.get(Festival.class, id);
        tx.commit();
        return obj;
    }

    /**
     * Lista los festivales existentes en base de datos
     * @return lista de festivales
     */
    @Override
    public List<Festival> listar() {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Festival> lista = conexion.createQuery("from Festival", Festival.class).getResultList();
        tx.commit();
        return lista;
    }

    /**
     * Actualiza un festival en base de datos
     *
     * @param objeto Festival con valores a actualizar
     */
    @Override
    public void actualizar(Festival objeto) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival objBD = conexion.load(Festival.class, objeto.getId());
        objBD.setNombre(objeto.getNombre());
        objBD.setDescripcion(objeto.getDescripcion());
        objBD.setInicio(objeto.getInicio());
        objBD.setFin(objeto.getFin());
        objBD.setAforo(objeto.getAforo());
        objBD.setPrecio(objeto.getPrecio());
        objBD.setVentas(objeto.getVentas());
        conexion.update(objBD);
        tx.commit();
    }

    /**
     * Elimina un Festival en base de datos
     * @param id Identificador del festival a eliminar
     */
    @Override
    public void eliminar(int id) {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        Festival obj = conexion.load(Festival.class, id);
        conexion.delete(obj);
        tx.commit();
    }
}
