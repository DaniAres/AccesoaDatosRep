package factory;

import dao.actuacion.ActuacionDAO;
import dao.festival.FestivalDAO;

/**
 * Clase DAOFactoryNeodatis.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class DAOFactoryNeodatis extends DAOFactory{

    @Override
    public ActuacionDAO getActuacionDAO() {
        return null;
    }

    @Override
    public FestivalDAO getFestivalDAO() {
        return null;
    }
}
