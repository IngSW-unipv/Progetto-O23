package test;


import java.sql.SQLException;

import Controller.LoginController;
import Model.User;
import View.Benvenuto_Form;
import View.Login_Form;
import View.Login_Success_GUI;
import dao.DBConnessione;
import dao.Gestione_Dao;
import dao.Paese_Dao;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*Benvenuto_Form Benvenuto_Form = new Benvenuto_Form();
		Benvenuto_Form.setVisible(true);*/
	
		
		User model = new User(null, null, null, null, 0, null, null, null, null);
		boolean a=model.login("giulia.ferraris", "password");
		System.out.println(model.toString());
		model.logout(a);
		System.out.println(model.toString());
		
		
		
		
		
		
		/*Gestione_Dao g =  new Gestione_Dao();
		System.out.println(g.OttieniParametroUser("Cognome","mario.rossi","password"));*/
		//Login_Form  loginform= new Login_Form();
		//loginform.setVisible(true);
		
		Login_Form view = new Login_Form();
		LoginController controller = new LoginController(view, model);
		
		
		
		//User U = new User(null, null, null, null, 0, null,null,null.null);
		//U.registrati("ABCDEF12G34H567I", "Mario", "Rossi", "01/01/1980", "3331234567", "mario.rossi@example.com", 1, 1, 1, "mario.rossi", "password");
	}
}		


