package Controller;

import javax.swing.JFrame;

import Model.User;
import View.AccountCl;
import View.AccountDip;

public class AcController {
	
	private String Cf;
	private String Nome;
	private String Cognome;
	private String NumTelefono; 
	private String Email;
	private String Username;
	private String Via;
	private String Citta;
	private String Provincia;
	private boolean log;

	
	public void memorizza(User u) {
		
		Cf=u.getCf();
		Nome=u.getNome();
		Cognome=u.getCognome();
		NumTelefono=u.getNumTelefono();
		Email=u.getEmail();
		Username=u.getUsername();
		Citta=u.getCitta();
		Provincia=u.getProvincia();
		
		
	}
	
	
	public void usaDip(AccountDip view) {
		view.UsField.setText(Username);
		
	}


	public String getCf() {
		return Cf;
	}

	public String getNome() {
		return Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public String getNumTelefono() {
		return NumTelefono;
	}

	public String getEmail() {
		return Email;
	}

	public String getUsername() {
		return Username;
	}

	public String getVia() {
		return Via;
	}

	public String getCitta() {
		return Citta;
	}

	public String getProvincia() {
		return Provincia;
	}
	
	
	
	
	
}
