package logout.controller;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.dipendente.Dipendenti;
import View.Benvenuto_Form;

public class LogOutDipController {

	private JOptionPane view;
	private Dipendenti model;

	public LogOutDipController(JOptionPane view, Dipendenti model) {
		
		this.view = view;
		this.model = model;
		
	}


	public void actionPerformed(MouseEvent e) {
		
		if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
			Benvenuto_Form ben = new Benvenuto_Form();
			model.logout(model.getLogin());
			ben.setVisible(true);
		
		}	
		
	}
	

}