package newpackage;

import newpackage.EntityPackage.*;

import java.util.ArrayList;

/**
 * Created by Alessandro on 10/01/2016.
 */
public class CarrelloBean {
    private ArrayList<Pacchetto> packetlist;
    private ArrayList<OffertaEvento> offertaEventoArrayList;
    private ArrayList<OffertaPernotto> offertaPernottoArrayList;
    private ArrayList<OffertaTrasporto> offertaTrasportoArrayList;
    private String packetitem;
    private String offereventoitem;
    private String offerpernottoitem;
    private String offertrasportoitem;

    public CarrelloBean(){
        this.packetitem = "";
        this.offereventoitem = "";
        this.offerpernottoitem = "";
        this.offertrasportoitem = "";
        this.offertaTrasportoArrayList = new ArrayList<OffertaTrasporto>();
        this.offertaPernottoArrayList = new ArrayList<OffertaPernotto>();
        this.offertaEventoArrayList = new ArrayList<OffertaEvento>();
        this.packetlist = new ArrayList<Pacchetto>();
    }

    public ArrayList<Pacchetto> getPacketlist(){return this.packetlist;}
    public ArrayList<OffertaEvento> getOfferEventolist(){return this.offertaEventoArrayList;}
    public ArrayList<OffertaPernotto> getOfferPernottoArrayList(){return this.offertaPernottoArrayList;}
    public ArrayList<OffertaTrasporto> getOffertaTrasportoArrayList(){return this.offertaTrasportoArrayList;}
    public String getPacketitem(){return this.packetitem;}
    public String getOffereventoitem(){return this.offereventoitem;}
    public void setOffereventoitem(String newofferitem){this.offereventoitem = newofferitem;}
    public String getOfferpernottoitem(){return this.offerpernottoitem;}
    public void setOfferpernottoitem(String newofferitem){this.offerpernottoitem = newofferitem;}
    public String getOffertrasportoitem(){return this.offertrasportoitem;}
    public void setOffertrasportoitem(String newofferitem){this.offertrasportoitem = newofferitem;}
    public void setPacketitem(String newpacketitem){this.packetitem = newpacketitem;}


    public boolean carrelloempty(){
        return (this.getOffertaTrasportoArrayList().isEmpty() && this.getOfferPernottoArrayList().isEmpty() && this.getOfferEventolist().isEmpty() && this.getPacketlist().isEmpty());
    }


    public boolean addItem() {

        if (!this.packetitem.equals("")) {
            PacchettoController pc = PacchettoController.getInstance();
            Pacchetto p = pc.findByID(this.packetitem);
            if (p != null) {
                this.packetlist.add(p);
                this.packetitem = "";
                return true;
            }
            return false;
        }

        if (!this.offereventoitem.equals("") || !this.offertrasportoitem.equals("") || !this.offerpernottoitem.equals("")) {

            OffertaController oc = OffertaController.getInstance();

            if(!this.offereventoitem.equals("")) {
                Object of = oc.findByID(TipoOfferta.OffertaEvento, this.offereventoitem);

                if (of != null) {
                    this.offertaEventoArrayList.add((OffertaEvento) of);
                    this.offereventoitem = "";
                    return true;
                }
            }

            if(!this.offerpernottoitem.equals("")) {
                Object of = oc.findByID(TipoOfferta.OffertaPernotto, this.offerpernottoitem);
                if (of != null) {
                    this.offertaPernottoArrayList.add((OffertaPernotto) of);
                    this.offerpernottoitem = "";
                    return true;
                }
            }

            if(!this.offerpernottoitem.equals("")) {
                Object of = oc.findByID(TipoOfferta.OffertaTrasporto, this.offertrasportoitem);
                if (of != null) {
                    this.offertaTrasportoArrayList.add((OffertaTrasporto) of);
                    this.offertrasportoitem = "";
                    return true;
                }
            }
        }
        return false;

    }

    public boolean Pay(){
        PagamentoController pc = PagamentoController.getInstance();
        pc.Pay(this.packetlist,this.offertaEventoArrayList,this.offertaPernottoArrayList,this.offertaTrasportoArrayList);

        return this.packetlist.isEmpty() && this.offertaEventoArrayList.isEmpty() && this.offertaTrasportoArrayList.isEmpty() && this.offertaPernottoArrayList.isEmpty();

    }

}
