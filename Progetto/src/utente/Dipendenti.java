package utente;

public class Dipendenti {
	private int id_L;
	private float Stipendio;

//COSTRUTTORE
	
public Dipendenti(int id_L, float stipendio) {
	this.id_L = id_L;
	this.Stipendio = stipendio;
	
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
