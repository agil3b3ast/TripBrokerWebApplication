package newpackage;

import newpackage.EntityPackage.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 08/01/2016.
 */
public class PacchettoBean {
    private String pname;
    private int pprice;
    private boolean pstate;
    private OffertaPernottoBean pofpernotto;
    private OffertaTrasportoBean poftrasporto;
    private ArrayList<OffertaEventoBean> pofevento;
    private ArrayList<PacchettoBean> plist;
    private int id;

    public void setId(int newid){this.id = newid;}
    public int getId(){return id;}
    public String getPname(){return pname;}
    public int getPprice(){return pprice;}
    public boolean getPstate(){return pstate;}
    public OffertaPernottoBean getPofpernotto(){return pofpernotto;}
    public OffertaTrasportoBean getPoftrasporto(){return poftrasporto;}
    public ArrayList<OffertaEventoBean> getPofevento(){return pofevento;}
    public ArrayList<PacchettoBean> getPlist(){return plist;}

    public void setPlist(ArrayList<PacchettoBean> pnewlist){this.plist = pnewlist;}
    public void setPname(String newname){this.pname = newname;}
    public void setPprice(int newprice){this.pprice = newprice;}
    public void setPoftrasporto(OffertaTrasporto newoftrasporto){
        this.poftrasporto.setOftype(newoftrasporto.getTipologia());
        this.poftrasporto.setOfdateexpired(newoftrasporto.getDataScadenza());
        this.poftrasporto.setOfprice(newoftrasporto.getPrezzo());
        this.poftrasporto.setOfname(newoftrasporto.getNome());
    }
    public void setPofpernotto(OffertaPernotto newofpernotto){
        this.pofpernotto.setOftype(newofpernotto.getTipologia());
        this.pofpernotto.setOfdateexpired(newofpernotto.getDataScadenza());
        this.pofpernotto.setOfprice(newofpernotto.getPrezzo());
        this.pofpernotto.setOfname(newofpernotto.getNome());
    }
    public void setPofevento(List<OffertaEvento> loe){
        OffertaEventoBean offertaEventoBean = new OffertaEventoBean();
        for(OffertaEvento offertaEvento : loe){
            offertaEventoBean.setOfname(offertaEvento.getNome());
            offertaEventoBean.setOfdateexpired(offertaEvento.getDataScadenza());
            offertaEventoBean.setOftype(offertaEvento.getTipologia());
            offertaEventoBean.setOfprice(offertaEvento.getPrezzo());
            this.pofevento.add(offertaEventoBean);
        }
    }
    public void getPofevento(ArrayList<OffertaEventoBean> newlistofevento){this.pofevento = newlistofevento;}

    public boolean selectAll(){

        PacchettoController controller = PacchettoController.getInstance();

        List<Pacchetto> plist = controller.findAll(null);
        PacchettoBean pbean;
        this.plist = null;
        if(plist != null && plist.size()>0) {

            this.plist = new ArrayList<PacchettoBean>();
            for (Pacchetto p: plist) {

                pbean = new PacchettoBean();
                pbean.setPname(p.getNome());
                pbean.setPprice(p.getPrezzo());
                pbean.pofpernotto = new OffertaPernottoBean();
                pbean.setPofpernotto(p.getOffertaPernotto());
                pbean.poftrasporto = new OffertaTrasportoBean();
                pbean.setPoftrasporto(p.getOffertaTrasporto());
                pbean.pofevento = new ArrayList<OffertaEventoBean>();
                pbean.setPofevento(p.getOffertaEvento());
                //opb.setOfname(p.getOffertaPernotto().getNome());
                //opb.setOftype(p.getOffertaPernotto().getTipologia());
                //opb.setOfdateexpired(p.getOffertaPernotto().getDataScadenza());
                //opb.setOfprice(p.getOffertaPernotto().getPrezzo());
                //pbean.setPofpernotto(p.getOffertaPernotto());
                pbean.setId(p.getId());
                this.plist.add(pbean);
            }
        }
        return this.plist == null;
    }



}
