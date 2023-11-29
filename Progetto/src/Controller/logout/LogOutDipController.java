package Controller.logout;

import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.dipendente.Dipendenti;
import View.Benvenuto_Form;
import View.DipGUI;
import dao.Gestione_Dao;

public class LogOutDipController {

	private JOptionPane view;
	private Dipendenti model;
	private int id;

	public LogOutDipController(JOptionPane view, Dipendenti model,int id) {
		
		this.view = view;
		this.model = model;
		this.id = id;
		
	}


	public void actionPerformed(MouseEvent e) throws SQLException {
		
		if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
			Benvenuto_Form ben = new Benvenuto_Form();
			model.logout(model.getLogin());
			ben.setVisible(true);
		
		}else {
			
			DipGUI dip =new DipGUI(id, model);
			
		}
		
	}
	

}