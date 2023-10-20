package Controller.prenotazione;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import View.prenotazione.PrenotazioniGUI;
import Model.PrenotazioneVE.PrenotazioniDAO;

public class PrenotazioneGUIController {
	private final PrenotazioniGUI view;

	public PrenotazioneGUIController(PrenotazioniGUI view) {
        this.view = view;
    }



public void riempitabella(ActionEvent e) throws SQLException {
	int id = view.getID();
	
	PrenotazioniDAO dao = new PrenotazioniDAO();
	
	dao.MostraLePrenotazioni(id, view.table_1);
}

public void eliminaPrenotazione(ActionEvent e, String selectedValueCol1) throws SQLException {
	int id = view.getID();
	
	PrenotazioniDAO dao = new PrenotazioniDAO();
	
	int eliminazione = dao.eliminaprenotazioneDAO(id, selectedValueCol1);
	if (eliminazione == 1) {
		JOptionPane.showMessageDialog(null, "Prenotazione eliminatata con successo");
        
	} else if(eliminazione == 0) {
		JOptionPane.showMessageDialog(null, "Non siamo riusciti a elaborare la tua richiesta. riprova piu tardi");
	} else if(eliminazione == 2) {
		JOptionPane.showMessageDialog(null, "Non hai scelto nessuna prenotazione. Per favore, riporva");

	}
}

}

