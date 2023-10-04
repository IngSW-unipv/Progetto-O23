package Model;

import java.util.ArrayList;

public class Camera {
	
	private int Numero;
	private String Tipo;
	private float Prezzo;
	private int Piano;
	private int Nletti;
	private String Stato;

//Costruttore
public Camera(int numero, String tipo, float prezzo, int piano, int nletti, String stato) {
	
	this.Numero = numero;
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
return "Camera [Numero=" + Numero + ", Tipo=" + Tipo + ", Prezzo=" + Prezzo + ", Piano="
				+ Piano + ", Nletti=" + Nletti + ", Stato=" + Stato + "]";
}
	
	

}
