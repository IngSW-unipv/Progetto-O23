package luoghi;

public class Citta{
	private int Id_Citta;
	private String Nome_C;
	
	//COSTRUTTORE
	public Citta(int id_Citta, String nome_C) {
		this.Id_Citta = id_Citta;
		this.Nome_C = nome_C;
	}

	
//GETTER & SETTER
	public void setId_Citta(int id_Citta) {
		Id_Citta = id_Citta;
	}
	public int getId_Citta() {
		return Id_Citta;
	}
	
	public String getNome_C() {
		return Nome_C;
	}
	public void setNome_C(String nome_C) {
		Nome_C = nome_C;
	} 
}


