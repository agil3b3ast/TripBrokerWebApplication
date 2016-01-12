package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */

import newpackage.EntityPackage.OffertaPernotto;
import java.util.ArrayList;
import java.util.List;

public class OffertaPernottoBean extends OffertaBean{
    private String oftype;
    private int ofid;

    public OffertaPernottoBean(){
        super();
        this.oftype = "";
    }

    public String getOftype(){return this.oftype;}
    public void setOftype(String newoftype){this.oftype = newoftype;}
    public int getOfid(){return this.ofid;}
    public void setOfid(int newid){this.ofid = newid;}
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
    @Override
    public boolean selectAll(){
        if(this.oftype == ""){
            //this.oftype = "Concerto";
            return false;
        }

        OffertaController controller = OffertaController.getInstance();

        List<OffertaPernotto> offlist = (List<OffertaPernotto>) controller.findAll(TipoOfferta.OffertaPernotto,this.oftype);
        OffertaPernottoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaPernotto off : offlist) {

                offbean = new OffertaPernottoBean();
                offbean.setOfdateexpired(off.getDataScadenza());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getPerID());

                this.offerList.add(offbean);
            }
        }
        return this.offerList == null;
    }


}