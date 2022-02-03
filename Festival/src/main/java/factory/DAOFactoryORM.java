package factory;

import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionORMDAO;
import dao.festival.FestivalDAO;
import dao.festival.FestivalORMDAO;

public class DAOFactoryORM extends DAOFactory {


    @Override
    public ActuacionDAO getActuacionDAO() {
        return new ActuacionORMDAO();
    }

    @Override
    public FestivalDAO getFestivalDAO() {
        return new FestivalORMDAO();
    }
}
