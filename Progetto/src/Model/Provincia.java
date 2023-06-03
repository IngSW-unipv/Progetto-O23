package Model;

public class Provincia {
	private int Id_Prov;
	private String Nome_P;
	
//COSTRUTTORE
	public Provincia(int id_Prov, String nome_P) {
		this.Id_Prov = id_Prov;
		this.Nome_P = nome_P;
	}

//GETTER & SETTER
	public int getId_Prov() {
		return Id_Prov;
	}


	public void setId_Prov(int id_Prov) {
		Id_Prov = id_Prov;
	}


	public String getNome_P() {
		return Nome_P;
	}


	public void setNome_P(String nome_P) {
		Nome_P = nome_P;
	}
}

