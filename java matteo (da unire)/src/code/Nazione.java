package code;

public class Nazione {
	private int Id_naz;
	private String Nome_Nazione;
	private int Prefisso;
	
	
//COSTRUTTORE	
	
public Nazione(int id_naz, String nome_Nazione, int prefisso) {
		this.Id_naz = id_naz;
		this.Nome_Nazione = nome_Nazione;
		this.Prefisso = prefisso;
	}


//GETTER & SETTER	
	public int getId_naz() {
		return Id_naz;
	}
	public void setId_naz(int id_naz) {
		Id_naz = id_naz;
	}
	public String getNome_Nazione() {
		return Nome_Nazione;
	}
	public void setNome_Nazione(String nome_Nazione) {
		Nome_Nazione = nome_Nazione;
	}
	public int getPrefisso() {
		return Prefisso;
	}
	public void setPrefisso(int prefisso) {
		Prefisso = prefisso;
	}
}


