package Model;

public class Contratti {
	private int Id_Contr;
	private String Descr_Contr;
	
	public Contratti(int id_Contr, String descr_Contr) {
		
		Id_Contr = id_Contr;
		Descr_Contr = descr_Contr;
	}

	public int getId_Contr() {
		return Id_Contr;
	}

	public void setId_Contr(int id_Contr) {
		Id_Contr = id_Contr;
	}

	public String getDescr_Contr() {
		return Descr_Contr;
	}

	public void setDescr_Contr(String descr_Contr) {
		Descr_Contr = descr_Contr;
	}
	

}
