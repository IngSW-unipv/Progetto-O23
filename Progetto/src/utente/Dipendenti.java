package utente;

import java.util.Date;

public class Dipendenti extends User{
	private int id_L;
	private float Stipendio;

//COSTRUTTORE
	
public Dipendenti(String Cf, String Nome, String Cognome, Date DataDiNasciuta, String NumTelefono, String Email,
		String Username, String Password, int id_L, float stipendio) {
	super(Cf, Nome, Cognome, DataDiNasciuta, NumTelefono, Email, Username, Password);
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

	public void setStipendio(float stipendio) {
		Stipendio = stipendio;
	}
	

	
	

}
