package newpackage;

import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.OffertaEvento;

import java.util.List;

/**
 * Created by Alessandro on 28/12/2015.
 */
public class OffertaController {

    private static OffertaController instance;

    public static OffertaController getInstance() {
        if (instance == null)
            instance = new OffertaController();
        return instance;
    }

    private OffertaController() {
    }

    public Object findAll(TipoOfferta tipoOfferta,String typesearch){
        if(typesearch == null || typesearch == "" )
        {
            return null;
        }

        DBResourcesManager.initHibernate();

        //ArrayList<Offerta> ls = OffertaDao.findAll(typetable,typesearch);
        //List<OffertaEvento> ls = OffertaDaoAnnotations.findAllOffertaEntitysA(typetable,typesearch);

        Object ls = null;

        if(typesearch == null) {
            ls = DAOFactory.getDAOFactory(tipoOfferta).getOffertaDAO().getList();
        }
        else{
            ls = DAOFactory.getDAOFactory(tipoOfferta).getOffertaDAO().findtype(typesearch);
        }
        DBResourcesManager.shutdown();
        return ls;
    }

    public Object findByID(TipoOfferta tipoOfferta,String idtofind){
        DBResourcesManager.initHibernate();

        //ArrayList<Offerta> ls = OffertaDao.findAll(typetable,typesearch);
        //List<OffertaEvento> ls = OffertaDaoAnnotations.findAllOffertaEntitysA(typetable,typesearch);

        Object ls = null;

        ls = DAOFactory.getDAOFactory(tipoOfferta).getOffertaDAO().findOff(idtofind);
        DBResourcesManager.shutdown();
        return ls;
    }



}
