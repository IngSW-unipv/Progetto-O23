package Controller.direttore;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JOptionPane;

import Model.direttore.DirettoreDAO;
import Model.direttore.TurniDao;
import View.direttore.LavTurniGUI;
import dao.Gestione_Dao;


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
				id_t = dao.prossimoId();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			dao.aggiungiTurni(id_l, giorno, oraI, oraF, id_t );
		
		} else if(e.getSource()==view.getBtnCancella()) {
			int id_t = view.getIdT();
			System.out.println("id da eliminare"+id_t);
			dao.eliminaTurni(id_t);
		
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
		}
	}

	

	
}
