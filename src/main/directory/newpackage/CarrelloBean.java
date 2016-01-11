package newpackage;

import newpackage.EntityPackage.*;

import java.util.ArrayList;

/**
 * Created by Alessandro on 10/01/2016.
 */
public class CarrelloBean {
    private ArrayList<Pacchetto> packetlist;
    private ArrayList<newpackage.EntityPackage.Offerta> offerlist;
    private String packetitem;
    private String offeritem;

    public CarrelloBean(){
        this.packetlist = null;
        this.offerlist = null;
        this.packetitem = "";
        this.offeritem = "";
    }

    public ArrayList<Pacchetto> getPacketlist(){return this.packetlist;}
    public ArrayList<newpackage.EntityPackage.Offerta> getOfferlist(){return this.offerlist;}
    public String getPacketitem(){return this.packetitem;}
    public String getOfferitem(){return this.offeritem;}

    public boolean addItem(){

        if(this.packetitem == ""){
            if(this.offeritem == ""){
                return false;
            }
            else{
                OffertaController oc = OffertaController.getInstance();

                newpackage.EntityPackage.Offerta of = (newpackage.EntityPackage.Offerta) oc.findByID(TipoOfferta.OffertaEvento,this.offeritem);
                if(of != null){
                    this.offerlist.add(of);
                    this.offeritem = null;
                    return true;
                }
                of = (OffertaPernotto) oc.findByID(TipoOfferta.OffertaPernotto,this.offeritem);
                if(of != null){
                    this.offerlist.add(of);
                    this.offeritem = null;
                    return true;
                }
                of = (OffertaTrasporto) oc.findByID(TipoOfferta.OffertaTrasporto,this.offeritem);
                if(of != null){
                    this.offerlist.add(of);
                    this.offeritem = null;
                    return true;
                }
            }
        }

        PacchettoController pc = PacchettoController.getInstance();
        Pacchetto p = pc.findByID(this.packetitem);
        if(p != null) {
            this.packetlist.add(p);
            this.packetitem = null;
            return true;
        }
        return false;
    }

    public boolean Pay(){
        //PagamentoController(this.packetlist,this.offerlist)
        return false;
    }

}
