package org.example.dao.Futbolista;

import org.example.connection.ConexionORM;

import org.example.model.Futbolista;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Operaciones CRUD en bases de datos SQL Server (Hibernate)
 */

public class FutbolistaORMDAO implements FutbolistaDAO{
    /**
     * Inserta un Futbolista en base de datos
     * @param objeto Futbolista a insertar
     * @return Identificador del Futbolista insertada
     * @throws Exception
     */
    @Override
    public int insertar(Futbolista objeto) throws Exception {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        conexion.save(objeto);
        tx.commit();
        conexion.close();

        return objeto.getId();
    }


    /**
     * Lista los Futbolistas existentes en base de datos
     * @return lista de Futbolistas
     */
    @Override
    public List<Futbolista> listar() {
        Session conexion = ConexionORM.obtenerConexion().getCurrentSession();
        Transaction tx = conexion.beginTransaction();
        List<Futbolista> lista = conexion.createQuery("from Futbolista", Futbolista.class).getResultList();
        tx.commit();
        return lista;
    }


}
