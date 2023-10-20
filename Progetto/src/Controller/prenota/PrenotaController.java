package Controller.prenota;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Model.prenotazione.PrenotaDAO;
import View.prenota.PrenotaGUI;

public class PrenotaController {
	private final PrenotaGUI view;
    

	public PrenotaController(PrenotaGUI view) {
        this.view = view;
    }


	public void RecuperaStanze(ActionEvent e) throws SQLException {
		//prendo le due date dalla gui e le porto nel controller
		String datain = view.getDateCheckin();
    	String dataout = view.getDateCheckout(); 
    	//done
    	
		PrenotaDAO dao = new PrenotaDAO();
		dao.RecuperaStanzeOccupate(datain,dataout, view.table_1);
	}
	
	public void prenota(ActionEvent e, int id) throws SQLException{
			String datain = view.getDateCheckin();
    		String dataout = view.getDateCheckout();
    		String Colonna1 = view.getValore1();
    		String Colonna3 = view.getValore3();
    		PrenotaDAO dao = new PrenotaDAO();
			
			int risultato = dao.effettuaprenotazione(datain, dataout, Colonna1, Colonna3, id);
			if (risultato == 1) {
				JOptionPane.showMessageDialog(null, "prenotazione effettuata con successo! grazie!");
                
			} else {
				JOptionPane.showMessageDialog(null, "prenotazione bloccata. piprova piu tardi.");
                
			}
	}			
}