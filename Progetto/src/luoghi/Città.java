package luoghi;

public class Citt�{
	private int Id_Citt�;
	private String Nome_C;
	
	//COSTRUTTORE
	public Citt�(int id_Citt�, String nome_C) {
		this.Id_Citt� = id_Citt�;
		this.Nome_C = nome_C;
	}

	
//GETTER & SETTER
	public void setId_Citt�(int id_Citt�) {
		Id_Citt� = id_Citt�;
	}
	public int getId_Citt�() {
		return Id_Citt�;
	}
	
	public String getNome_C() {
		return Nome_C;
	}
	public void setNome_C(String nome_C) {
		Nome_C = nome_C;
	} 
}


