package newpackage;

import java.util.ArrayList;

/**
 * Created by Alessandro on 05/01/2016.
 */
public class Offerta {

    private String ofname;
    private String oftype;
    private String ofprice;
    private String ofdateexpired;

    public Offerta(){
        this.ofname = "";
        this.oftype = "";
        this.ofprice = "";
        this.ofdateexpired = "";
    }

    public String getOfname(){return this.ofname;}
    public String getOftype(){return this.oftype;}
    public String getOfprice(){return this.ofprice;}
    public String getOfdateexpired(){return this.ofdateexpired;}

    public void setOfname(String newofname){this.ofname = newofname;}
    public void setOftype(String newoftype){this.oftype = newoftype;}
    public void setOfprice(String newofprice){this.ofprice = newofprice;}
    public void setOfdateexpired(String newofdateexpired){this.ofdateexpired = newofdateexpired;}

}
