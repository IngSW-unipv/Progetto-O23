package test;


import java.sql.SQLException;

import Controller.LoginController;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import Model.User;
import View.Benvenuto_Form;
import View.EliminaACC_Form;
import View.Home_Form;
import View.Login_Form;
import View.Login_Success_GUI;
import View.Registration_Form;
import dao.DBConnessione;
import dao.Gestione_Dao;
import dao.Paese_Dao;
import Model.Turni_Lavoro;

public class Test {

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		
	
		

		User model = new User(null, null, null, null, null, null, null, null, 0, null, null, null);
		
		
		Home_Form view = new Home_Form();
		//LoginController controller = new LoginController(view);
		
		/*Turni_Lavoro tl = new Turni_Lavoro(null, null, null, 234);
		tl.GetOrarioLavoro();
		System.out.println(tl.toString());
		*/
	
		
	

        

	
	}
}		


