package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Model.Cliente;
import View.Benvenuto_Form;
import View.ClienteGUI;

public class LogOutCliController{
	
	private Cliente model;
	private JOptionPane view;
	
	
	
	public LogOutCliController(JOptionPane view,Cliente model) {
		
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
