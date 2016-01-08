package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaTrasporto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Simone on 16/12/2015.
 */
public class OffertaTrasportoDAO extends OffertaDAO {

    @Override
    public Object getList() {
        Session s = DBResourcesManager.getSession();

        String query = "from OffertaTrasporto";
        @SuppressWarnings("unchecked")
        List<OffertaTrasporto> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }

    @Override
    public  Object findOff(String id) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaTrasporto offertaTrasporto where offertaTrasporto.trasID = '"+id+"'";
        @SuppressWarnings("unchecked")
        List<OffertaTrasporto> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte.get(0);
        else
            return null;

    }

    @Override
    public Object findtype(String type) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaTrasporto offertaTrasporto where offertaTrasporto.tipologia = '"+type+"'";
        @SuppressWarnings("unchecked")
        List<OffertaTrasporto> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }


    @Override
    public void modPrezzo(int trasID,int percent)
    {
        Session s = DBResourcesManager.getSession();
        int val;

        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            OffertaTrasporto offertaTrasporto = (OffertaTrasporto) s.get(OffertaTrasporto.class,trasID);

            val = offertaTrasporto.getPrezzo();

            offertaTrasporto.setPrezzo(val + val*percent/100);

            s.update(offertaTrasporto);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }

    }
}