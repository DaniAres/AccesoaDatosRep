package factory;

import dao.actuacion.ActuacionDAO;
import dao.festival.FestivalDAO;
import model.Actuacion;

/**
 * Clase DAOFactory.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public abstract class DAOFactory {

    public static final int SQLSERVER = 1;
    public static final int NEODATIS = 2;
    public static final int MONGODB = 3;
    public static final int ORM = 4;

    public abstract ActuacionDAO getActuacionDAO();

    public abstract FestivalDAO getFestivalDAO();

    public static DAOFactory getDAOFactory(int bd){

        switch (bd){
            case SQLSERVER:
                return new DAOFactoryNeodatis();
            case NEODATIS:
                return new DAOFactoryNeodatis();
            case MONGODB:
                return new DAOFactoryMongoDB();
            case ORM:
                return new DAOFactoryORM();
            default:
                throw new RuntimeException("Opción no disponible");
        }

    }

}
