package dao.festival;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import connection.ConexionMongoDB;
import model.Actuacion;
import org.bson.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Operaciones CRUD en bases de datos Mongo para almacenar objetos, es este caso de Festival.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class FestivalMongoDBDAO {

    //Nombre de la colección del dao en base de datos MongoDB
    private static final String COLECCION ="festival";

    /**
     * Parsea un objeto Actuacion en un documento BSON
     * @param objFestival Objeto Festival a parsear
     * @return Documento resultado del parseo
     */

    private Document festivalADoc(Actuacion objFestival){

        Document objDoc = null;

        if(objFestival!=null){
            objDoc = new Document();
            objDoc.put("id", objFestival.getId());
            objDoc.put("nombre", objFestival.getNombre());
            objDoc.put("descripcion", objFestival.getDescripcion());
            objDoc.put("inicio", objFestival.getInicio());
            objDoc.put("fin", objFestival.getFin());
            //objDoc.put("aforo", objFestival.getAforo());
            objDoc.put("precio", objFestival.getFin());
           // objDoc.put("ventas", objFestival.getVentas());

        }
        return objDoc;
    }



}
