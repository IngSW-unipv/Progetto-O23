package luoghi;

public class Città{
	private int Id_Città;
	private String Nome_C;
	
	//COSTRUTTORE
	public Città(int id_Città, String nome_C) {
		this.Id_Città = id_Città;
		this.Nome_C = nome_C;
	}

	
//GETTER & SETTER
	public void setId_Città(int id_Città) {
		Id_Città = id_Città;
	}
	public int getId_Città() {
		return Id_Città;
	}
	
	public String getNome_C() {
		return Nome_C;
	}
	public void setNome_C(String nome_C) {
		Nome_C = nome_C;
	} 
}


