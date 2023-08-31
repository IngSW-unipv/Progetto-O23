package Model;

public class Mansione {
	private int Id_Mans;
	private String Descr_Mans;
	
	public Mansione(int id_Mans, String descr_Mans) {
		
		Id_Mans = id_Mans;
		Descr_Mans = descr_Mans;
	}

	public int getId_Mans() {
		return Id_Mans;
	}

	public void setId_Mans(int id_Mans) {
		Id_Mans = id_Mans;
	}

	public String getDescr_Mans() {
		return Descr_Mans;
	}

	public void setDescr_Mans(String descr_Mans) {
		Descr_Mans = descr_Mans;
	}
	
	

}
