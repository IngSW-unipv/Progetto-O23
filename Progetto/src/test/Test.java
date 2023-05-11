package test;


import java.sql.SQLException;

import dao.DBConnessione;
import dao.User_Dao;
import interfacciaGrafica.Benvenuto_Form;
import interfacciaGrafica_User.Login_Success_GUI;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*Benvenuto_Form Benvenuto_Form = new Benvenuto_Form();
		Benvenuto_Form.setVisible(true);*/
		
		DBConnessione d= new DBConnessione();
		
		d.connessione();
	}

}
