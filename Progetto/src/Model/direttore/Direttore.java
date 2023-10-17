package Model.direttore;

import java.sql.Date;
import java.sql.Time;

import Model.Turni_Lavoro;
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

	
	public void aggiuntaT(int id_l, Date giorno, Time oraI, Time oraF, int id_t) {
		TurniDao turni = new TurniDao();
		turni.aggiungiTurni(id_l, giorno, oraI, oraF, id_t);
	}
	
	public void rimuoviT(int id_t) {
		TurniDao turni = new TurniDao();
		turni.eliminaTurni(id_t);
	}
	
	public void modificaT(int id_l, Date giorno, Time oraI, Time oraF, int id_t) {
		TurniDao turni = new TurniDao();
		turni.modificaTurni(id_l, giorno, oraI, oraF, id_t);
	}
	
	

}
