package newpackage.DAO;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaEvento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import javax.ejb.EJBTransactionRolledbackException;
import java.util.List;

/**
 * Created by Simone on 16/12/2015.
 */
public class OffertaEventoDAO extends OffertaDAO {

    @Override
    public  Object getList() {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaEvento";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }


    @Override
    public Object findOff(String id) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaEvento offertaEvento where offertaEvento.eveID = '"+id+"'";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte.get(0);
        else
            return null;

    }

    @Override
    public Object findtype(String type) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaEvento offertaEvento where offertaEvento.tipologia = '"+type+"'";
        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }

    @Override
    public void modPrezzo(int eveID,int percent)
    {
        Session s = DBResourcesManager.getSession();
        int val;
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            OffertaEvento offertaEvento = (OffertaEvento)s.get(OffertaEvento.class,eveID);


            val = offertaEvento.getPrezzo();

            offertaEvento.setPrezzo(val + val*percent/100);
            s.update(offertaEvento);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delof(int id) throws HibernateException
    {
        Session s = DBResourcesManager.getSession();

        Transaction tx = null;
        OffertaEvento offerta = (OffertaEvento) s.get(OffertaEvento.class , id);

        try {
            tx = s.beginTransaction();
            s.delete(offerta);
            tx.commit();
        }
        /*
        catch (EJBTransactionRolledbackException e) {
            Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                System.out.println("Offerta non rimovibile, presente in un pacchetto");
                throw e;
            }
        }*/
        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            DBResourcesManager.shutdown();
        }
    }
}
