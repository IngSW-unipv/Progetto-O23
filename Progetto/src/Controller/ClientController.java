package Controller;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Camera;
import View.PrenotaGUI;
import dao.Gestione_Dao;

public class ClientController {
	private final PrenotaGUI view;
    

	public ClientController(PrenotaGUI view) {
        this.view = view;
    }


	public void RecuperaStanze(ActionEvent e) throws SQLException {
		//prendo le due date dalla gui e le porto nel controller
		String datain = view.getDateCheckin();
    	String dataout = view.getDateCheckout(); 
    	//done
    	
		Gestione_Dao dao = new Gestione_Dao();
		
		dao.RecuperaStanzeOccupate(datain,dataout, view.table_1);
	}
	
	public void prenota(ActionEvent e, String selectedValueCol1, String selectedValueCol3, int id) throws SQLException{
			String datain = view.getDateCheckin();
    		String dataout = view.getDateCheckout();
			Gestione_Dao dao = new Gestione_Dao();
			
			int risultato = dao.effettuaprenotazione(datain, dataout, selectedValueCol1, selectedValueCol3, id);
			if (risultato == 1) {
				JOptionPane.showMessageDialog(null, "prenotazione effettuata con successo! grazie!");
                
			} else {
				JOptionPane.showMessageDialog(null, "prenotazione bloccata. piprova piu tardi.");
                
			}
	}			
}