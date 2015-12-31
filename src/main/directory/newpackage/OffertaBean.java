package newpackage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alessandro on 28/12/2015.
 */
public class OffertaBean {
    private String ofname;
    private String oftype;
    private String ofprice;
    private String ofdateexpired;
    private ArrayList<String[]> offerList;


    public OffertaBean(){
        this.ofname = "";
        this.oftype = "";
        this.ofprice = "";
        this.ofdateexpired = "";
    }

    public String getOfname(){return this.ofname;}
    public String getOftype(){return this.oftype;}
    public String getOfprice(){return this.ofprice;}
    public String getOfdateexpired(){return this.ofdateexpired;}
    public ArrayList<String[]> getOfferList(){return this.offerList;}

    public void setOfname(String newofname){this.ofname = newofname;}
    public void setOftype(String newoftype){this.oftype = newoftype;}
    public void setOfprice(String newofprice){this.ofprice = newofprice;}
    public void setOfdateexpired(String newofdateexpired){this.ofdateexpired = newofdateexpired;}

    public boolean selectAll(){
        if(this.oftype != null){
            this.oftype = "Concerto";
        }

        OffertaController controller = OffertaController.getInstance();
        this.offerList = controller.findAll("offertaevento",this.oftype);
        return this.offerList == null;
    }
}
