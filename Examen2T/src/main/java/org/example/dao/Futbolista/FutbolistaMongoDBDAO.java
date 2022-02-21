package org.example.dao.Futbolista;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.connection.ConexionMongoDB;
import org.example.model.Futbolista;


import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Operaciones CRUD en bases de datos Mongo para almacenar objetos, es este caso de un Futbolista.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class FutbolistaMongoDBDAO implements FutbolistaDAO {


    //Nombre de la colección del dao en base de datos MongoDB
    private static final String COLECCION ="Futbolistas";

    /**
     * Parsea un objeto Futbolista en un documento BSON
     * @param objFutbolista Objeto Futbolista a parsear
     * @return Documento resultado del parseo
     */
    private Document futbolistaADoc(Futbolista objFutbolista){

        Document objDoc = null;

        if(objFutbolista!=null){
            objDoc = new Document();
            objDoc.put("id", objFutbolista.getId());
            objDoc.put("nombre", objFutbolista.getNombre());
            objDoc.put("club", objFutbolista.getClub());
            objDoc.put("media", objFutbolista.getMedia());
            objDoc.put("ultimo_partido", objFutbolista.getUltimo_partido());

        }
        return objDoc;
    }

    /**
     * Parsea un objeto BSON a un objeto Unidad
     * @param objDoc Documento BSON a parsear
     * @return Actuacion resultado del parseo
     * @throws Exception
     */

    private Futbolista docAFutbolista(Document objDoc){

        Futbolista objFutbolista = null;
        if(objDoc!=null){
            objFutbolista = new Futbolista();
            if(objDoc.getInteger("id") !=null){
                objFutbolista.setId(objDoc.getInteger("id"));
            }

            objFutbolista.setNombre(objDoc.getString("Nombre"));
            objFutbolista.setClub(objDoc.getString("Club"));
            //objFutbolista.setMedia(objDoc.getDouble("Media"));
            objFutbolista.setUltimo_partido(objDoc.getDate("Ultimo_Partido"));

        }
        return objFutbolista;
    }

    /**
     * Inserta un Futbolista en base de datos
     *
     * @param objeto Futbolista a insertar
     * @return Identificador del Futbolista a insertar
     */

    @Override
    public int insertar(Futbolista objeto) throws Exception {

        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        Document documento = futbolistaADoc(objeto);
        try{
            colMongo.insertOne(documento);
            return objeto.getId();
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Lista los futbolistas existenten en BBDD
     * @return lista de futbolistas
     */
    @Override
    public List<Futbolista> listar() {
        List<Futbolista> resultado = new ArrayList<>();
        MongoDatabase conexion = ConexionMongoDB.obtenerConexion();
        MongoCollection<Document> colMongo = conexion.getCollection(COLECCION);
        List<Document> consulta = colMongo.find().into(new ArrayList<Document>());
        Futbolista futbolista = new Futbolista();
        for(int i = 0; i<consulta.size(); i++){

            futbolista = docAFutbolista(consulta.get(i));
            resultado.add(futbolista);
        }
        return resultado;
    }

}
