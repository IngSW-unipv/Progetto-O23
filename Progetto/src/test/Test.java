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
		
		Registration_Form view=new Registration_Form();
		Cliente model = new Cliente(null, null, null, null, null, null, null, 0, null, null, null, null, 0);
		RegistrazioneController controller = new RegistrazioneController(view, model);
		
		
	
		
	

        

	
	}
}		


