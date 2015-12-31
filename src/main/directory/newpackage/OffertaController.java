package newpackage;

import java.util.ArrayList;

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

    public ArrayList<String[]> findAll(String typetable,String typesearch){
        if(typetable == null || typesearch == null || typetable == "" || typesearch == "" )
        {
            return null;
        }

        ArrayList<String[]> ls = OffertaDao.findAll(typetable,typesearch);
        return ls;
    }
}
