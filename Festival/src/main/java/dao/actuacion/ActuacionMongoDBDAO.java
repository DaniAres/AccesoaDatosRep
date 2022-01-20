package dao.actuacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import connection.ConexionMongoDB;
import model.Actuacion;
import org.bson.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

/**
 * Operaciones CRUD en bases de datos Mongo para almacenar objetos, es este caso de Actuacion.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class ActuacionMongoDBDAO implements ActuacionDAO {

    //Nombre de la colección del dao en base de datos MongoDB
    private static final String COLECCION ="actuacion";

    /**
     * Parsea un objeto Actuacion en un documento BSON
     * @param objActuacion Objeto Actuacion a parsear
     * @return Documento resultado del parseo
     */
    private Document actuacionADoc(Actuacion objActuacion){

        Document objDoc = null;

        if(objActuacion!=null){
        objDoc = new Document();
        objDoc.put("id", objActuacion.getId());
        objDoc.put("idFestival", objActuacion.getIdFestival());
        objDoc.put("nombre", objActuacion.getNombre());
        objDoc.put("descripcion", objActuacion.getDescripcion());
        objDoc.put("grupo", objActuacion.getGrupo());
        objDoc.put("escenario", objActuacion.getEscenario());
        objDoc.put("inicio", objActuacion.getInicio());
        objDoc.put("fin", objActuacion.getFin());
        }
        return objDoc;
    }

    /**
     * Parsea un objeto BSON a un objeto Actuacion
     * @param objDoc Documento BSON a parsear
     * @return Actuacion resultado del parseo
     * @throws Exception
     */

    private Actuacion docAActuacion(Document objDoc){

        Actuacion objActuacion = null;
        if(objDoc!=null){
            objActuacion = new Actuacion();
            if(objDoc.getInteger("id") !=null){
                objActuacion.setId(objDoc.getInteger("id"));
            }
            objActuacion.setIdFestival(objDoc.getInteger("idFestival"));
            objActuacion.setNombre(objDoc.getString("nombre"));
            objActuacion.setDescripcion(objDoc.getString("descripcion"));
            objActuacion.setGrupo(objDoc.getString("grupo"));
            objActuacion.setEscenario(objDoc.getString("escenario"));
            objActuacion.setInicio(new Timestamp(objDoc.getDate("inicio").getTime()));
            objActuacion.setFin(new Timestamp(objDoc.getDate("fin").getTime()));
        }
        return objActuacion;
    }

    /**
     * Inserta una Actuacion en base de datos
     *
     * @param objeto Actuacion a insertar
     * @return Identificador de la Actuacion a insertar
     */
    @Override
    public int insertar(Actuacion objeto) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = actuacionADoc(objeto);
        try{
            colMongo.insertOne(documento);
            return objeto.getId();
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Consulta una Actuacion en base de datos MongoDB
     * @param id Identificador de la Actuacuin a consultar
     * @return Actuacion consultada
     */
    @Override
    public Actuacion consultar(int id) {
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = colMongo.find(eq("id", id)).first();
        return docAActuacion(documento);
    }

    /**
     * Lista las actuaciones existenten en BBDD
     * @return lista de actuaciones
     */
    @Override
    public List<Actuacion> listar() {
        List<Actuacion> resultado = new ArrayList<>();
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        List<Document> consulta = colMongo.find().into(new ArrayList<Document>());
        Actuacion actuacion = new Actuacion();
        for(int i = 0; i<consulta.size(); i++){

            actuacion = docAActuacion(consulta.get(i));
            resultado.add(actuacion);
        }
        return resultado;
    }

    /**
     * Actualiza una tarea en base de datos
     *
     * @param objeto Tarea con valores a actualizar
     */
    @Override
    public void actualizar(Actuacion objeto) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = actuacionADoc(objeto);
        try{
            colMongo.replaceOne(Filters.eq("id", objeto.getId()), documento);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Elimina una tarea en base de datos
     *
     * @param id Identificador de la Actuacion a eliminar
     */
    @Override
    public void eliminar(int id) {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        try{
            colMongo.deleteOne(Filters.eq("id", id));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
