package code;

public class Comfort {
	
	private String id_Comfort;
	private String Tipo;
	private float Prezzo;
	
//Costruttore
	
public Comfort(String id_Comfort, String tipo, float prezzo) {
	this.id_Comfort = id_Comfort;
	this.Tipo = tipo;
	this.Prezzo = prezzo;
}


//stampa informazioni del comfort
@Override
public String toString() {
	return "Comfort [id_Comfort=" + id_Comfort + ", Tipo=" + Tipo + ", Prezzo=" + Prezzo + "]";
}
	

	
	

}
