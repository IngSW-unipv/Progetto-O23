package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Camera;
import View.PrenotaGUI;
import dao.Gestione_Dao;

public class ClientController {
	private final PrenotaGUI view;
    

	public ClientController(PrenotaGUI view) {
        this.view = view;
    }
	
	public void RecuperaStanzeDisponibili() throws SQLException {
		//prendo le due date dalla gui e le porto nel controller
		String datain = view.getDateCheckin();
    	String dataout = view.getDateCheckout(); 
    	//done
    	//test da rimuovere
		System.out.println(datain + dataout); 
		//DONE
		
		
		Gestione_Dao dao = new Gestione_Dao();
		CameraController a = new CameraController();
		Camera c= new Camera(0,null,0,0,0,null);
		
		//controllo sulla disponibilità di camere
		 if (dao.RecuperaStanzeDisponibili(datain, dataout) == 0) 
			 {
			 System.out.println("stanza disponibile");
			 } else
				 System.out.println("nessuna stanza è disponibile nel periodo scelto");
	}
	
	public void inserisciintabella() {
		
		
	}
}
