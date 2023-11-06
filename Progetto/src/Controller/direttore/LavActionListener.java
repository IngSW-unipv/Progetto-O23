package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import javax.swing.JOptionPane;

import Model.direttore.Direttore;
import Model.turni.TurniDao;
import View.direttore.LavTurniPanel;

public class LavActionListener implements ActionListener {
	private TurniDao dao;
	private LavTurniPanel view;
	private Direttore dir;
	
	public LavActionListener(TurniDao dao, LavTurniPanel view, Direttore dir){
		this.dao=dao;
		this.view=view;
		this.dir=dir;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnAg()) {
		
			dao.caricaTurni(view.table);
		
		} else if(e.getSource()==view.getBtn()){
			// prendo i campi che mi servono con gli opportuni cast
			int id_l= Integer.valueOf(view.getId_l());
			Date giorno= Date.valueOf(view.getGiorno());
			Time oraI= Time.valueOf(view.getOraI());
			Time oraF= Time.valueOf(view.getOraf());
			int id_t = 0;
			if(!checkOra(oraI, oraF)) {
			
				try {
					if(dao.turnoDuplicato(id_l, giorno, oraI, oraF)) {
						JOptionPane.showMessageDialog(null, "Errore, turno già presente");
						return;
					}
				
					id_t = dao.prossimoId();
				
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			
				dir.aggiungiTu(id_l, giorno, oraI, oraF, id_t );
				dao.caricaTurni(view.table); //aggiorno la tabella
			} else	{
				JOptionPane.showMessageDialog(null, "Orari non validi");
			}
		
		} else if(e.getSource()==view.getBtnCancella()) {
			//prendo solo l'id perchè mi serve solo la chiave della tabella per l'eliminazione
			int id_t = view.getIdT();
			dir.cancellaTu(id_t);
			JOptionPane.showMessageDialog(null, "Turno eliminato con successo!");
			dao.caricaTurni(view.table); //aggiorno la tabella
		
		} else if(e.getSource()==view.getBtnMo()) {
			// prendo i campi che mi servono con gli opportuni cast 
			int id_l= Integer.valueOf(view.getId_l());
			Date giorno= Date.valueOf(view.getGiorno());
			Time oraI= Time.valueOf(view.getOraI());
			Time oraF= Time.valueOf(view.getOraf());
			int id_t = view.getIdT();
			if(!checkOra(oraI, oraF)){
			
				try {
					if(dao.turnoDuplicato(id_l, giorno, oraI, oraF)) {
						JOptionPane.showMessageDialog(null, "Errore, turno già presente");
						return;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			dir.modificaTu(id_l, giorno, oraI, oraF, id_t);
			JOptionPane.showMessageDialog(null, "Turno modificato con successo!");
			dao.caricaTurni(view.table); //aggiorno la tabella
			
		} else {
			JOptionPane.showMessageDialog(null, "Orari non validi");
			}
		}
			
	}
// metodo per la verifica che l'ora di inizio non sia minore dell'ora fine
	public boolean checkOra(Time oraI, Time oraF) {
		
		System.out.println(""+oraI+"  "+oraF);
		if(oraF.before(oraI)) {
			
			return true;
		}
		return false;
	}

	
}
