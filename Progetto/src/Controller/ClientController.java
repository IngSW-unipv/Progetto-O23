package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.PrenotaGUI;
import dao.Gestione_Dao;

public class ClientController {
	private final PrenotaGUI view;
    

	public ClientController(PrenotaGUI view) {
        this.view = view;
    }
<<<<<<< HEAD




	public void RecuperaStanze(ActionEvent e) throws SQLException {
=======
	
	public void RecuperaStanze() throws SQLException {
>>>>>>> parent of 671828e (prenotazione finita)
		//prendo le due date dalla gui e le porto nel controller
		String datain = view.getDateCheckin();
    	String dataout = view.getDateCheckout(); 
    	//done
    	
		
		
		Gestione_Dao dao = new Gestione_Dao();
		CameraController a = new CameraController();
		Camera c= new Camera(0,null,0,0,0,null);
		
		if (dao.RecuperaStanzeOccupate(datain,dataout) == 0) { 
		 System.out.println("queste sono le stanze disponibile");
			 } else {
				 System.out.println("nessuna stanza è disponibile nel periodo scelto");
			 		}
	}
	
			 public void inserisciintabella() {
			
<<<<<<< HEAD
			int risultato = dao.effettuaprenotazione(datain, dataout, selectedValueCol1, selectedValueCol3, id);
			if (risultato == 1) {
				JOptionPane.showMessageDialog(null, "prenotazione effettuata con successo! grazie!");
                
			} else {
				JOptionPane.showMessageDialog(null, "prenotazione bloccata. piprova piu tardi.");
                
			}
	}	
	public void riempitabella() {
		
	}
=======
			 }
>>>>>>> parent of 671828e (prenotazione finita)
}