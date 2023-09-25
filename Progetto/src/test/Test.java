package test;


import java.sql.SQLException;

import Controller.LoginController;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import Model.User;
import View.Benvenuto_Form;
import View.Home_Form;
import View.Login_Form;
import View.Registration_Form;
import dao.DBConnessione;
import dao.Gestione_Dao;

import Model.Turni_Lavoro;

public class Test {

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
		
	
		

		//User model = new User(null, null, null, null, null, null, null, null, 0, null, null, null);
		Gestione_Dao g =  new Gestione_Dao();
		
		g.Ottieni_Tipo("C.BIANCHI");
		Benvenuto_Form b = new Benvenuto_Form();
		b.setVisible(true);
		
		/*Turni_Lavoro tl = new Turni_Lavoro(null, null, null, 234);
		tl.GetOrarioLavoro();
		System.out.println(tl.toString());
		*/
	
		
	

        

	
	}
}		


