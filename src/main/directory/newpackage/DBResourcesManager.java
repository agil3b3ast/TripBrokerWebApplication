package newpackage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBResourcesManager {

    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static void initHibernate() {
        try{
            // load hibernate configuration
            configuration = new Configuration();
            configuration.configure();

            // use JNDI to bind Hibernate configuration and datasource
          /*  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();*/
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            /*
             * Retrieve the one session factory that will manage sessions,
             * connections and transaction
             */
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException e) {
            System.out.append("** Exception in SessionFactory **");
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        sessionFactory.close();
    }

}