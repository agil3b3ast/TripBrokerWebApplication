package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.Offerta;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by Alessandro on 08/01/2016.
 */
public abstract class OffertaDAO {

    public static void store(Offerta of) {
        Session s = DBResourcesManager.getSession();
        s.beginTransaction();
        try{
            s.save(of);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        s.getTransaction().commit();
        s.close();
    }

    public abstract Object getList();
    public abstract Object findOff(String id);
    public abstract void modPrezzo(int id, int prezzo);
    public abstract Object findtype(String type);
}
