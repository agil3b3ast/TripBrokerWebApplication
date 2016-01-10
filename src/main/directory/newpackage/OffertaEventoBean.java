package newpackage;

/**
 * Created by Alessandro on 08/01/2016.
 */

import newpackage.EntityPackage.OffertaEvento;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 28/12/2015.
 */
public class OffertaEventoBean extends OffertaBean{
    private String oftype;

    public OffertaEventoBean(){
        super();
        this.oftype = "";
    }

    public String getOftype(){return this.oftype;}
    public void setOftype(String newoftype){this.oftype = newoftype;}

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

        List<OffertaEvento> offlist = (List<OffertaEvento>) controller.findAll(TipoOfferta.OffertaEvento,this.oftype);
        OffertaEventoBean offbean;
        this.offerList = null;
        if(offlist != null && offlist.size()>0) {

            this.offerList = new ArrayList<OffertaBean>();
            for (OffertaEvento off : offlist) {

                offbean = new OffertaEventoBean();
                offbean.setOfdateexpired(off.getDataScadenza());
                offbean.setOfname(off.getNome());
                offbean.setOftype(off.getTipologia());
                offbean.setOfprice((off.getPrezzo()));

                this.offerList.add(offbean);
            }
        }
        return this.offerList == null;
    }


}