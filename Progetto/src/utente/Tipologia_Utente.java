package utente;

import java.util.Date;

public class Tipologia_Utente extends User{
	
	private int Id_Tipo;
	private String Descrizione_Utente;
	
//COSTRUTTORE

	public Tipologia_Utente(String cf, String nome, String cognome, java.sql.Date dataDiNascita, int eta,
			String numTelefono, String email, String username, String password, int id_Tipo,
			String descrizione_Utente) {
		super(cf, nome, cognome, dataDiNascita, eta, numTelefono, email, username, password);
		Id_Tipo = id_Tipo;
		Descrizione_Utente = descrizione_Utente;
	}
	

	
//GETTER E SETTER	
	public int getId_Tipo() {
		return Id_Tipo;
	}
	
	public void setId_Tipo(int id_Tipo) {
		Id_Tipo = id_Tipo;
	}
	public String getDescrizione_Utente() {
		return Descrizione_Utente;
	}
	public void setDescrizione_Utente(String descrizione_Utente) {
		Descrizione_Utente = descrizione_Utente;
	}
}


//METHODS


