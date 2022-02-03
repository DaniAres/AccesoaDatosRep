package factory;

import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionMongoDBDAO;
import dao.festival.FestivalDAO;

/**
 * Clase DAOFactoryMongoDB.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class DAOFactoryMongoDB extends DAOFactory{

    @Override
    public ActuacionDAO getActuacionDAO() {
        return new ActuacionMongoDBDAO();
    }

    @Override
    public FestivalDAO getFestivalDAO() {
        return null;
    }
}
