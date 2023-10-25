package test;


import View.*;
import dao.Gestione_Dao;

import java.io.IOException;
import java.sql.SQLException;

import Model.direttore.DirettoreDAO;

public class Test {

	public static void main(String[] args) throws IOException{
		//prova login
		/*DirettoreDAO dao=new DirettoreDAO();
		int id;
		try {
			id = dao.generaIdU();
			System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Login_Form start = new Login_Form();
	}
		
}		


