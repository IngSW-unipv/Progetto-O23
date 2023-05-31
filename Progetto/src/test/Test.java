package test;


import java.sql.SQLException;

import dao.DBConnessione;
import dao.Paese_Dao;
import dao.User_Dao;
import interfacciaGrafica.Benvenuto_Form;
import interfacciaGrafica_User.Login_Success_GUI;
import utente.User;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*Benvenuto_Form Benvenuto_Form = new Benvenuto_Form();
		Benvenuto_Form.setVisible(true);*/
	
		
		User s = new User(null, null, null, null, 0, null, null, null, null);
		s.login("mario.rossi", "1");
		s.login("mario.rossi", "password");
		s.login("anna.verdi", "password");
		s.login("anna.vvvverdi", "password");
		
		User U = new User(null, null, null, null, 0, null,null,null.null);
		U.registrati("ABCDEF12G34H567I", "Mario", "Rossi", "01/01/1980", "3331234567", "mario.rossi@example.com", 1, 1, 1, "mario.rossi", "password");
	}
}		


