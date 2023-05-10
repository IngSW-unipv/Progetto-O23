package utente;

public class Tipologia_Utente {
	private int Id_Tipo;
	private String Descrizione_Utente;
	
//COSTRUTTORE
	public Tipologia_Utente(int id_Tipo, String descrizione_Utente) {
	
		this.Id_Tipo = id_Tipo;
		this.Descrizione_Utente = descrizione_Utente;
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


