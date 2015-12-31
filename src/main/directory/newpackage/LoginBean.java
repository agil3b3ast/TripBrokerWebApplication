package newpackage;

import java.util.ArrayList;
import java.util.List;

public class LoginBean {
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private ArrayList<String[]>  offerList;
	private String oftype;

	public LoginBean() {
		this.username = "";
		this.password = "";
		this.oftype = "";
		this.offerList = null;
	}

	public void setOftype(String tp){this.oftype = tp;}
	public String getOftype(){return this.oftype;}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getUsername() {
		return this.username;
	}

	public ArrayList<String[]> getofferList() {
		return this.offerList;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public String getPassword() {
		return this.password;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCognome(String cogn) {
		this.cognome = cogn;
	}

	public String getCognome() {
		return this.cognome;
	}

	public boolean validate() {
		// Controllo sintattico
		if (this.username.equals("") || this.password.equals("")) {
			return false;
		}

		LoginController controller = LoginController.getInstance();
		Utente found = controller.login(this.username, this.password);
		return  (found != null);
	}
}
