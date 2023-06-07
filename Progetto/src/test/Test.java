package test;


import java.sql.SQLException;

import Controller.LoginController;
import Model.User;
import View.Benvenuto_Form;
import View.EliminaACC_Form;
import View.Login_Form;
import View.Login_Success_GUI;
import dao.DBConnessione;
import dao.Gestione_Dao;
import dao.Paese_Dao;

public class Test {

	public static void main(String[] args) throws SQLException {
		
	
		
<<<<<<< HEAD
		User model = new User(null, null, null, null, 0, null, null, null, null);
		
		
		Login_Form view = new Login_Form();
		LoginController controller = new LoginController(view, model);
=======
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
>>>>>>> parent of e41c93c (ordine + aggiunta commenti)
		
		

		
		
		
		
		
	}
}		


