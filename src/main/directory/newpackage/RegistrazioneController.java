package newpackage;

import newpackage.DAO.WebClientDAO;
import newpackage.DAOFactory.DAOFactory;
import newpackage.EntityPackage.Carrello;
import newpackage.EntityPackage.User;
import newpackage.EntityPackage.WebClient;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Alessandro on 03/02/2016.
 */
public class RegistrazioneController {

    private static RegistrazioneController instance;

    public static RegistrazioneController getInstance() {
        if (instance == null)
            instance = new RegistrazioneController();
        return instance;
    }

    private RegistrazioneController() {
    }

    public String signUp(String nickname,String password,String name,String surname,String birthday){
        if(nickname == null || password == null || name == null || surname == null){
            return "";
        }

        try{
            DBResourcesManager.initHibernate();

            if(DAOFactory.getWebClientDAO().findSelectedUser(nickname,password)!=null){
                DBResourcesManager.shutdown();
                return "";
            }

            SimpleDateFormat format = new SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH);
            java.util.Date parsed = format.parse(birthday);
            java.sql.Date newdate = new java.sql.Date(parsed.getTime());

            WebClient webclient = new WebClient(nickname,password,name,surname,newdate);
            Carrello carrello = new Carrello();
            DAOFactory.getCarrelloDAO().store(carrello);

            webclient.setHasCart(carrello);
            webclient.setDataIscrizione(new Date((new java.util.Date()).getTime()));
            DAOFactory.getWebClientDAO().store(webclient);
            DBResourcesManager.shutdown();
            return webclient.getDataIscrizione().toString();
        }
        catch (java.text.ParseException e){
            System.out.println("Errore nel formato della data\n");
            e.printStackTrace();
        }
        return "";
    }
}
