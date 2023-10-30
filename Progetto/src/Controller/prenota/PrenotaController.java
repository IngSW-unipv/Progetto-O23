package Controller.prenota;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import Model.prenotazione.PrenotaDAO;
import Model.prenotazione.MostraStanzeDAO;
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
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Conversione delle stringhe in oggetti LocalDate
        LocalDate dateIn = LocalDate.parse(datain, formatter);
        LocalDate dateOut = LocalDate.parse(dataout, formatter);

        // Verifica se dataout è maggiore di datain
        if (dateOut.isAfter(dateIn)) {
        	MostraStanzeDAO dao = new MostraStanzeDAO();
    		int risultato = dao.RecuperaStanzeOccupate(datain,dataout, view.table_1);
    		if(risultato == 1) {
    			JOptionPane.showMessageDialog(null, "C'è stato un errore, riprova piu tardi");
    		} else if(risultato == 2) {
    			JOptionPane.showMessageDialog(null, "Dati mancanti, per favore riprova");
    		}
        } else {
        	JOptionPane.showMessageDialog(null, "Le date inserite sono errate, per favore riprova");
        	 } 	
		
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
			} else  if (risultato == 0){
				JOptionPane.showMessageDialog(null, "prenotazione bloccata. piprova piu tardi.");               
			} else if (risultato == 2) {
				JOptionPane.showMessageDialog(null, "Dati Mancanti, riprova.");
				 
			}
	}			
}