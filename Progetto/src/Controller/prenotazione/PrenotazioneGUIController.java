package Controller.prenotazione;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import View.PrenotazioniGUI;
import dao.Gestione_Dao;

public class PrenotazioneGUIController {
	private final PrenotazioniGUI view;

	public PrenotazioneGUIController(PrenotazioniGUI view) {
        this.view = view;
    }
	
	
public void riempitabella(ActionEvent e) throws SQLException {
	int id = view.getID();
	
	Gestione_Dao dao = new Gestione_Dao();
	
	dao.MostraLePrenotazioni(id, view.table_1);
}

public void eliminaPrenotazione(ActionEvent e, String selectedValueCol1) throws SQLException {
	int id = view.getID();
	
	Gestione_Dao dao = new Gestione_Dao();
	
	dao.eliminaprenotazioneDAO(id, selectedValueCol1);
	
}

}

