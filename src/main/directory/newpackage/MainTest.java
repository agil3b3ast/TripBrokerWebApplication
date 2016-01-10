package newpackage;

import newpackage.DAO.OffertaEventoDAO;
import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.OffertaEvento;

import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */
public class MainTest {

    public static void main(String[] args) {
        DBResourcesManager.initHibernate();

        OffertaEvento of = new OffertaEvento();
        of.setNome("ofevent");
        of.setTipologia("Concerto");
        of.setPrezzo(69);
        of.setDataScadenza("21/08/2019");
        of.setCittà("Roma");

        OffertaEventoDAO.store(of);

        System.out.println(((List<OffertaEvento>)DAOFactory.getDAOFactory(TipoOfferta.OffertaEvento).getOffertaDAO().getList()).size());

        DBResourcesManager.shutdown();

        //OffertaDaoAnnotations.findAllOffertaEntitysA("offertaevento","Concerto");
    }
}
