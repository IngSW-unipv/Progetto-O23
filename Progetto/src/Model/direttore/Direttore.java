package Model.direttore;

import Model.User;

public class Direttore extends User{
	private int id_L;
	private float Stipendio;

//COSTRUTTORE
	public Direttore(String cf, String nome, String cognome, java.sql.Date dataDiNascita, String via, String citta, String provincia, int cap, String numTelefono,
			String email, String username, String password, int id_L, float stipendio) {
		super(cf, nome, cognome, dataDiNascita, numTelefono, via, citta, provincia, cap, email, username, password);
		this.id_L = id_L;
		Stipendio = stipendio;
	}

	
//GETTER SETTER
	public int getId_L() {
		return id_L;
	}

	public void setId_L(int id_L) {
		this.id_L = id_L;
	}

	public float getStipendio() {
		return Stipendio;
	}

	
	

	
	

}
