package Model.direttore;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Model.User;
import Model.dipendente.Dipendenti;

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

public void registaDip(String cf, String nome, String cognome, java.sql.Date dataNascita, String cell, String via,  String citta, String provincia, int cap, String email, 
		String username, String password, String ruolo, int stipendio) throws NoSuchAlgorithmException, SQLException {
	DirettoreDAO dir = new DirettoreDAO();
	Dipendenti dip = new Dipendenti(cf, nome, cognome, dataNascita, cell, via, citta, provincia, cap, email, username, password, ruolo, stipendio);
	dir.dip_Register(dip);
	
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
