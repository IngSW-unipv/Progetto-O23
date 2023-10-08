package test;


import java.sql.SQLException;

import Controller.*;
import Model.*;
import View.*;
import dao.*;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class Test {

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {

	
		/*Benvenuto_Form b = new Benvenuto_Form();
		b.setVisible(true);*/
		
		
		//prova registrazione
		/*Registration_Form view=new Registration_Form();
		Cliente model = new Cliente(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
		RegistrazioneController controller = new RegistrazioneController(view, model); */ 
		
		//prova login
		/*Login_Form view  = new Login_Form();
		User model = new User(null, null, null, null, null, null, null, null, 0, null, null, null);
		LogController controlle = new LogController(model, view);*/
		
		
		//prova inizio prognamma
		Benvenuto_Form view = new Benvenuto_Form();
		BenvenutoController controller = new BenvenutoController(view);

	
	}
}		


