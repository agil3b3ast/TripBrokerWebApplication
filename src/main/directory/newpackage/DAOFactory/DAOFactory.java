package newpackage.DAOFactory;

import newpackage.DAO.OffertaDAO;
import newpackage.DAO.PacchettoDAO;
import newpackage.DAO.UtenteDAO;
import newpackage.TipoOfferta;

/**
 * Created by Simone on 23/12/2015.
 */
public  abstract class DAOFactory {

    public static DAOFactory getDAOFactory(TipoOfferta tipo) {

        switch (tipo) {
            case OffertaPernotto:
                return new OffertaPernottoDAOImpl();
            case OffertaTrasporto:
                return new OffertaTrasportoDAOImpl();
            case OffertaEvento:
                return new OffertaEventoDAOImpl();
            default:
                return null;
        }
    }

    public static PacchettoDAO getPacchettoDAO()
    {
        return new PacchettoDAO();
    }

    public static UtenteDAO getUserDAO()
    {
        return new UtenteDAO();
    }

    public abstract OffertaDAO getOffertaDAO();
}
