package test;


import java.sql.SQLException;

import Model.User;
import controller.LoginController;
import dao.DBConnessione;
import dao.Gestione_Dao;
import dao.Paese_Dao;
import interfacciaGrafica.Benvenuto_Form;
import interfacciaGrafica.Login_Form;
import interfacciaGrafica.Login_Success_GUI;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*Benvenuto_Form Benvenuto_Form = new Benvenuto_Form();
		Benvenuto_Form.setVisible(true);*/
	
		
		User s = new User(null, null, null, null, 0, null, null, null, null);
		boolean a=s.login("giulia.ferraris", "password");
		System.out.println(s.toString());
		s.logout(a);
		System.out.println(s.toString());
		
		
		
		
		
		
		/*Gestione_Dao g =  new Gestione_Dao();
		System.out.println(g.OttieniParametroUser("Cognome","mario.rossi","password"));*/
		//Login_Form  loginform= new Login_Form();
		//loginform.setVisible(true);
		
		//Login_Form view = new Login_Form();

		// Crea un'istanza del modello
	      //User model = new User(null, null, null, null, 0, null, null, null, null);
        // Crea un'istanza del controller e passa vista e modello come argomenti
        //LoginController controller = new LoginController(view, model);
		
		//User U = new User(null, null, null, null, 0, null,null,null.null);
		//U.registrati("ABCDEF12G34H567I", "Mario", "Rossi", "01/01/1980", "3331234567", "mario.rossi@example.com", 1, 1, 1, "mario.rossi", "password");
	}
}		


