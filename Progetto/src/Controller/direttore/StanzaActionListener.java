package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.direttore.DirettoreDAO;
import View.direttore.StanzeGUI;

public class StanzaActionListener implements ActionListener {
	private DirettoreDAO dao;
	private StanzeGUI view;
	
	public StanzaActionListener(DirettoreDAO dao, StanzeGUI view){
		this.dao=dao;
		this.view=view;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		dao.caricaStanze(view.table);
	}
	

}
