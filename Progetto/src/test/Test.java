package test;


import java.sql.SQLException;

import Controller.AcController;
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
		
	
		
		//test visualizzazione dati personale
		/*User model = new User(null, null, null, null, null, null, null, null, 0, null, "C.BIANCHI", "password");
		Gestione_Dao g =  new Gestione_Dao();
		model.login("C.BIANCHI", "password", g.Ottieni_Tipo("C.BIANCHI"));
		AcController controller = new AcController();
		controller.memorizza(model);
		controller.visualizzaDip();*/
		
		
		//test visualizzazione dati cliente
		User model = new User(null, null, null, null, null, null, null, null, 0, null, "MARCO.NERI", "password2");
		Gestione_Dao g =  new Gestione_Dao();
		model.login("MARCO.NERI", "password2", g.Ottieni_Tipo("MARCO.NERI"));
		AcController controller = new AcController();
		controller.memorizza(model);
		controller.visualizzaCl();
		
		
		
		//Benvenuto_Form b = new Benvenuto_Form();
		//b.setVisible(true);
		
		
		/*Turni_Lavoro tl = new Turni_Lavoro(null, null, null, 234);
		tl.GetOrarioLavoro();
		System.out.println(tl.toString());
		*/
	
		
	

        

	
	}
}		


