package newpackage.EntityPackage;

import newpackage.EntityPackage.User;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alessandro on 29/01/2016.
 */
@Entity
public class WebClient{
    @GeneratedValue
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    private Carrello hasCart;

    public Carrello getHasCart() {
        return hasCart;
    }

    public void setHasCart(Carrello hasCart) {
        this.hasCart = hasCart;
    }

    @Basic
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    private Date dataIscrizione;

    public Date getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(Date dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    @Basic
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    protected WebClient(){super();}

    public WebClient(String nickname,String password,String name,String surname,Date birthday){
        this.nickname = nickname;
        this.password = password;
        this.nome = name;
        this.cognome = surname;
        this.birthday = birthday;
    }

    @Basic
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    private String cognome;

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Basic
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
