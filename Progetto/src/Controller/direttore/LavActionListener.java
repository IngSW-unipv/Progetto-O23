package Controller.direttore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import javax.swing.JOptionPane;

import Model.turni.TurniDao;
import View.direttore.LavTurniGUI;

public class LavActionListener implements ActionListener {
	private TurniDao dao;
	private LavTurniGUI view;
	
	public LavActionListener(TurniDao dao, LavTurniGUI view){
		this.dao=dao;
		this.view=view;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtnAg()) {
		
			dao.caricaTurni(view.table);
		
		} else if(e.getSource()==view.getBtn()){
			int id_l= Integer.valueOf(view.getId_l());
			Date giorno= Date.valueOf(view.getGiorno());
			Time oraI= Time.valueOf(view.getOraI());
			Time oraF= Time.valueOf(view.getOraf());
			int id_t = 0;
			
			try {
				if(dao.turnoDuplicato(id_l, giorno, oraI, oraF)) {
					JOptionPane.showMessageDialog(null, "Errore, turno già presente");
					return;
				}
				checkOra(oraI, oraF);
				id_t = dao.prossimoId();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			dao.aggiungiTurni(id_l, giorno, oraI, oraF, id_t );
		
		} else if(e.getSource()==view.getBtnCancella()) {
			int id_t = view.getIdT();
			dao.eliminaTurni(id_t);
			JOptionPane.showMessageDialog(null, "Turno eliminato con successo!");
			dao.caricaTurni(view.table);
		
		} else if(e.getSource()==view.getBtnMo()) {
			int id_l= Integer.valueOf(view.getId_l());
			Date giorno= Date.valueOf(view.getGiorno());
			Time oraI= Time.valueOf(view.getOraI());
			Time oraF= Time.valueOf(view.getOraf());
			int id_t = view.getIdT();
			
			
				try {
					if(dao.turnoDuplicato(id_l, giorno, oraI, oraF)) {
						JOptionPane.showMessageDialog(null, "Errore, turno già presente");
						return;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			dao.modificaTurni(id_l, giorno, oraI, oraF, id_t);
			JOptionPane.showMessageDialog(null, "Turno modificato con successo!");
		}
	}

	public void checkOra(Time oraI, Time oraF) {
		
		System.out.println(""+oraI+"  "+oraF);
		if(oraF.before(oraI)) {
			JOptionPane.showMessageDialog(null, "Orari non validi");
		}
	}

	
}
