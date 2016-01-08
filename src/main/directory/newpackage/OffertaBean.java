package newpackage;

import newpackage.EntityPackage.OffertaEvento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 28/12/2015.
 */
public class OffertaBean {
    protected String ofname;
    protected int ofprice;
    protected String ofdateexpired;
    protected ArrayList<OffertaBean> offerList;


    public OffertaBean(){
        this.ofname = "";
        this.ofprice = -1;
        this.ofdateexpired = "";
    }

    public String getOfname(){return this.ofname;}
    public int getOfprice(){return this.ofprice;}
    public String getOfdateexpired(){return this.ofdateexpired;}
    public ArrayList<OffertaBean> getOfferList(){return this.offerList;}

    public void setOfname(String newofname){this.ofname = newofname;}
    public void setOfprice(int newofprice){this.ofprice = newofprice;}
    public void setOfdateexpired(String newofdateexpired){this.ofdateexpired = newofdateexpired;}

    /*
    public boolean selectAll(){
        if(this.oftype != ""){
            this.oftype = "Concerto";
        }

        OffertaController controller = OffertaController.getInstance();

        ArrayList<Offerta> offlist = controller.findAll("offertaevento",this.oftype);
        OffertaBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (Offerta off : offlist) {

                offbean = new OffertaBean();
                offbean.setOfdateexpired(off.getOfdateexpired());
                offbean.setOfname(off.getOfname());
                offbean.setOftype(off.getOftype());
                offbean.setOfprice(off.getOfprice());

                this.offerList.add(offbean);

            }
        }
        return this.offerList == null;
    }*/

    public boolean selectAll(){

        OffertaController controller = OffertaController.getInstance();

        List<OffertaEvento> offlist = (List<OffertaEvento>) controller.findAll(TipoOfferta.OffertaEvento,null);
        OffertaBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaEvento off : offlist) {

                offbean = new OffertaBean();
                offbean.setOfdateexpired(off.getDataScadenza());
                offbean.setOfname(off.getNome());
                offbean.setOfprice((off.getPrezzo()));

                this.offerList.add(offbean);
            }
        }
        return this.offerList == null;
    }


}
