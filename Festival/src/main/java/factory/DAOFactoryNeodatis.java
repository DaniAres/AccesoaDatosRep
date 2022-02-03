package factory;

import dao.actuacion.ActuacionDAO;
import dao.actuacion.ActuacionNeodatisDAO;

import dao.festival.FestivalDAO;
import dao.festival.FestivalNeodatisDAO;

/**
 * Clase DAOFactoryNeodatis.
 * @version 1.0, 13/01/2022
 * @author Daniel Ares Cabo (Aulanosa)
 */

public class DAOFactoryNeodatis extends DAOFactory{

    @Override
    public ActuacionDAO getActuacionDAO() {
        return new ActuacionNeodatisDAO();
    }

    @Override
    public FestivalDAO getFestivalDAO() {
        return new FestivalNeodatisDAO();
    }
}
