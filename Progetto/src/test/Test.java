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
		
	
		
		User model = new User(null, null, null, null, 0, null, null, null, null);
		
		
		Login_Form view = new Login_Form();
		LoginController controller = new LoginController(view, model);
		
		

		
		
		
		
		
	}
}		


