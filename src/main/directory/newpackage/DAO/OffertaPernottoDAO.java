package newpackage.DAO;

import newpackage.DBResourcesManager;
import newpackage.EntityPackage.OffertaEvento;
import newpackage.EntityPackage.OffertaPernotto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import javax.ejb.EJBTransactionRolledbackException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Simone on 16/12/2015.
 */
public class OffertaPernottoDAO extends OffertaDAO {


    @Override
    public Object getList() {
        Session s = DBResourcesManager.getSession();

        String query = "from OffertaPernotto";
        @SuppressWarnings("unchecked")
        List<OffertaPernotto> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }

    @Override
    public Object findtype(String type) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaPernotto offertaPernotto where offertaPernotto.tipologia = '"+type+"'";
        @SuppressWarnings("unchecked")
        List<OffertaPernotto> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }

    @Override
    public  Object findOff(String id) {
        Session s = DBResourcesManager.getSession();
        String query = "from OffertaPernotto offertaPernotto where offertaPernotto.perID = '"+id+"'";
        @SuppressWarnings("unchecked")
        List<OffertaPernotto> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte.get(0);
        else
            return null;

    }

    @Override
    public void modPrezzo(int perID,int percent)
    {
        Session s = DBResourcesManager.getSession();
        int val;
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            OffertaPernotto offertaPernotto = (OffertaPernotto) s.get(OffertaPernotto.class,perID);


            val = offertaPernotto.getPrezzo();

            offertaPernotto.setPrezzo(val + val*percent/100);
            s.update(offertaPernotto);
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
        OffertaPernotto offerta = (OffertaPernotto) s.get(OffertaPernotto.class , id);
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

    @Override
    public Object customSearch(List<String> ls){
        Session s = DBResourcesManager.getSession();
        String initquery = "from OffertaPernotto offertaPernotto";
        List<String> strings = new LinkedList<String>();

        /*
        ls.add(getOfcity());
        ls.add(getOfdateexpired());
        ls.add(getOfname());
        ls.add(String.valueOf(getOfprice()));
        ls.add(getOftype());
        ls.add(getNumberOfNights());
        ls.add(getStars());*/


        if (!ls.isEmpty()) {
            //sb.append(initquery).append(" where");
            initquery = initquery + " where ";
        }

        for (int i = 0; i < ls.size(); i++) {
            if (!ls.get(i).equals("") && i == 0)
                strings.add("offertaPernotto.città = '" + ls.get(i) +"'");
            //sb.append(" offertaEvento.città = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 1) {
                try {
                    System.out.println(ls.get(i));
                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
                    java.util.Date parsed = format.parse(ls.get(i));
                    java.sql.Date newdate = new java.sql.Date(parsed.getTime());
                    strings.add("offertaPernotto.dataScadenza < '" + newdate + "'");
                }
                catch(java.text.ParseException e){
                    System.out.println("Exception : ParseException");
                }
                //sb.append(" offertaEvento.dataScadenza = '").append(ls.get(i)).append("'");
            }
            //sb.append(" offertaEvento.dataScadenza = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 2)
                strings.add("offertaPernotto.nome = '" + ls.get(i) + "'");
            //sb.append(" offertaEvento.nome = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 3) {
                if(ls.get(i).equals("1"))
                    strings.add("offertaPernotto.prezzo < '100'");
                //sb.append(" offertaEvento.prezzo < '100'");
                if(ls.get(i).equals("2"))
                    strings.add("offertaPernotto.prezzo > '100' && offertaEvento.prezzo < '500'");
                //sb.append(" offertaEvento.prezzo > '100' && offertaEvento.prezzo < '500'");
                if(ls.get(i).equals("3"))
                    strings.add("offertaPernotto.prezzo > '500'");
                //sb.append(" offertaEvento.prezzo > '500'");
            }
            if (!ls.get(i).equals("") && i == 4)
                strings.add("offertaPernotto.tipologia = '" + ls.get(i) + "'");
            //sb.append(" offertaEvento.tipologia = '").append(ls.get(i)).append("'");
            if (!ls.get(i).equals("") && i == 5)
                strings.add("offertaPernotto.numeroNotti = '" + ls.get(i) + "'");
            if (!ls.get(i).equals("") && i == 6)
                strings.add("offertaPernotto.stelle = '" + ls.get(i) + "'");
        }

        String joinedstring = String.join(" and ",strings);
        System.out.println(initquery + joinedstring);
        /*
        String query = "from OffertaEvento offertaEvento";
        if(città == null && dataScadenza == null && nome == null && prezzo == null && tipologia == null){
            @SuppressWarnings("unchecked")
            List<OffertaEvento> offerte = s.createQuery(query).list();
            if(offerte.size()>0)
                return offerte;
            else
                return null;
        }
        query = query + " where ";
        if(città != null)
            query = query + "offertaEvento.città = '"+città+"' && ";
        if(dataScadenza != null)
            query = query + "offertaEvento.dataScadenza = '" + dataScadenza + "' && ";
        if(nome != null)
            query = query + "offertaEvento.nome = '"+nome+"' && ";
        if(prezzo != null)
            query = query + "offertaEvento.prezzo = '"+prezzo+"' && ";
        if(tipologia != null)
            query = query + "offertaEvento.tipologia = '"+tipologia+"'";

        @SuppressWarnings("unchecked")
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;*/
        /*
        if(!ls.isEmpty())
            query.join(" where");

        for(int i= 0; i<ls.size();i++){
            if(!ls.get(i).equals("") && i == 0)
                query.join(" && offertaPernotto.città = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 1)
                query.join(" && offertaPernotto.dataScadenza = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 2)
                query.join(" && offertaPernotto.nome = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 3)
                query.join(" && offertaPernotto.prezzo = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 4)
                query.join(" && offertaPernotto.tipologia = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 5)
                query.join(" && offertaPernotto.numeroNotti = '"+ls.get(i)+"'");
            if(!ls.get(i).equals("") && i == 6)
                query.join(" && offertaPernotto.stelle = '"+ls.get(i)+"'");
        }*/

        String query = initquery + joinedstring;
        List<OffertaEvento> offerte = s.createQuery(query).list();
        if(offerte.size()>0)
            return offerte;
        else
            return null;

    }
}
