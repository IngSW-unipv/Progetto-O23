package code;

import java.util.ArrayList;

public class Camera {
	
	private int Numero;
	private ArrayList<Comfort> Com;
	private String Tipo;
	private float Prezzo;
	private int Piano;
	private int Nletti;
	private String Stato;

//Costruttore
public Camera(int numero, ArrayList<Comfort> com, String tipo, float prezzo, int piano, int nletti, String stato) {
	
	this.Numero = numero;
	this.Com = com;
	this.Tipo = tipo;
	this.Prezzo = prezzo;
	this.Piano = piano;
	this.Nletti = nletti;
	this.Stato = stato;
	
}
//Getter

public int getNumero() {
	return Numero;
}

public ArrayList<Comfort> getCom() {
	return Com;
}

public String getTipo() {
	return Tipo;
}
	
public float getPrezzo() {
	return Prezzo;
}
	
public int getPiano() {
	return Piano;
}
	
public int getNletti() {
	return Nletti;
}
	
public String getStato() {
	return Stato;
}


//Stampa informazioni camera
	
@Override
public String toString() {
return "Camera [Numero=" + Numero + ", Com=" + Com + ", Tipo=" + Tipo + ", Prezzo=" + Prezzo + ", Piano="
				+ Piano + ", Nletti=" + Nletti + ", Stato=" + Stato + "]";
}
	
	

}
