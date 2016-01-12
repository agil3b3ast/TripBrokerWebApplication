package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */

import java.util.ArrayList;
import java.util.List;
import newpackage.EntityPackage.OffertaTrasporto;
/**
 * Created by Alessandro on 08/01/2016.
 */

public class OffertaTrasportoBean extends OffertaBean{
    private String oftype;
    private int ofid;
    public OffertaTrasportoBean(){
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

        List<OffertaTrasporto> offlist = (List<OffertaTrasporto>) controller.findAll(TipoOfferta.OffertaTrasporto,this.oftype);
        OffertaTrasportoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaTrasporto off : offlist) {

                offbean = new OffertaTrasportoBean();
                offbean.setOfdateexpired(off.getDataScadenza());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));
                offbean.setOfid(off.getTrasID());
                this.offerList.add(offbean);
            }
        }
        return this.offerList == null;
    }


}