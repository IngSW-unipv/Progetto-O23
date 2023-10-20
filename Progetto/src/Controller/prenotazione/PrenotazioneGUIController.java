package Controller.prenotazione;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
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
	
	dao.eliminaprenotazioneDAO(id, selectedValueCol1);
	
}

}

