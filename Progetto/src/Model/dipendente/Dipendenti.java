package Model.dipendente;

import Model.User;

public class Dipendenti extends User{
	
	private String ruolo;
	private int Stipendio;

//COSTRUTTORE
	public Dipendenti(String cf, String nome, String cognome, java.sql.Date dataDiNascita,  String numCell, String via, String citta, String provincia, int cap,
			String email, String username, String password, String ruolo, int stipendio) {
		super(cf, nome, cognome, dataDiNascita, numCell, via, citta, provincia, cap, email, username, password);
		this.ruolo=ruolo;
		Stipendio = stipendio;
	}

	
//GETTER SETTER


	public int getStipendio() {
		return Stipendio;
	}

	public void setStipendio(int stipendio) {
		Stipendio = stipendio;
	}


	public String getRuolo() {
		return ruolo;
	}
	

	
	

}
